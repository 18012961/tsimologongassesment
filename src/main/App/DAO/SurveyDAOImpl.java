package main.App.DAO;

import main.App.Connectivity.DatabaseConnectivitySingleton;
import main.App.Entity.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

public class SurveyDAOImpl implements SurveydbDAO {

	DatabaseConnectivitySingleton connection;
	Optional<Collection<User>> users = Optional.of(new ArrayList<>());

	public SurveyDAOImpl(){
		try {
			this.connection = DatabaseConnectivitySingleton.getInstance();
			this.users = Optional.of(getAll());
		} catch (SQLException e) {
			System.out.println("Failed to establish database connection: "+e.getMessage());
		}
	}

	@Override
	public void save(User t) {

		String sqlInsert = "INSERT INTO user_info " +
				"(first_name, surname, date, age, favourite_food, contact_number, " +
				"eat_out, watch_movies, watch_tv, listen_to_radio" +
				") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		User user = Objects.requireNonNull(t, "User values should not be null");


		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);

			users.get().add(t);
			statement.setString(1, user.getFirst_name());
			statement.setString(2, user.getSurname());
//			statement.setString(3, user.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			statement.setDate(3, Date.valueOf(user.getDate()));
			statement.setInt(4, user.getAge());
			statement.setString(5, user.getFavourite_food());
			statement.setString(6, user.getContact_number());
			statement.setInt(7, user.getEat_out());
			statement.setInt(8, user.getWatch_movies());
			statement.setInt(9, user.getWatch_tv());
			statement.setInt(10, user.getListen_to_radio());
			
			if(statement.execute()) {
				ResultSet result = statement.getGeneratedKeys();
				if(result.next()) {
					int generatedId = result.getInt(1);
				}
				
			}

		} catch (SQLException e) {
			System.out.println("Error while executing statement: "+e.getMessage());
		}
	}

	@Override
	public Optional get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Collection<User> getAll(){
		
		String sqlSelect = "SELECT * FROM user_info";
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sqlSelect);
			
			while(result.next()) {
				Optional<User> user = Optional.of(new User(
						result.getString("surname"),
						result.getString("first_name"),
						result.getString("date"),
						result.getInt("age"),
						result.getString("favourite_food"),
						result.getString("contact_number"),
						result.getInt("eat_out"),
						result.getInt("watch_movies"),
						result.getInt("watch_tv"),
						result.getInt("listen_to_radio")));

				users.get().add(user.get());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users.get();
	}
	
	public int getTotalNumberOfSurveys() {
		return users.map( u -> u.size()).orElse(0);
	}
	
	public double getAverageAge() {
		int sum = users.get().stream().flatMapToInt( a -> IntStream.of(a.getAge())).sum();
		return sum/getTotalNumberOfSurveys();
	}
	
	public int getOldPersonToParticipate() {
		return users.get().stream().flatMapToInt( a -> IntStream.of(a.getAge())).max().getAsInt();
	}
	
	public int getYoungPersonToParticipate() {
		return users.get().stream().flatMapToInt( a -> IntStream.of(a.getAge())).min().getAsInt();
	}
	
	public double getPeopleWhoLikePizza() {
		Double total = Double.valueOf(users.get()
				.stream()
				.filter(e -> e.getFavourite_food().equals("Pizza"))
				.count());
		return  total/getTotalNumberOfSurveys() * 100;
	}
	
	public double getPeopleWhoLikePasta() {
		return users.get()
				.stream()
				.filter(e -> e.getFavourite_food().equals("Pasta"))
				.count()/getTotalNumberOfSurveys() * 100;
	}
	
	public double getPeopleWhoLikePapa_n_Wors() {
		System.out.print(users.get()
				.stream()
				.filter(e -> e.getFavourite_food().equals("Pap and Wors"))
				.count());
		return users.get()
				.stream()
				.filter(e -> e.getFavourite_food().equals("Pap and Wors"))
				.count()/getTotalNumberOfSurveys();
	}
	
	public double getPeopleLikeToEatOut() {
		return users.get()
				.stream()
				.flatMapToInt( a -> IntStream.of(a.getEat_out()))
				.sum()/getTotalNumberOfSurveys();
	}
	
	public double getPeopleLikeToWatchMovies() {
		return users.get()
				.stream()
				.flatMapToInt( a -> IntStream.of(a.getWatch_movies()))
				.sum()/getTotalNumberOfSurveys();
	}
	
	public double getPeopleLikeToWatchTV() {
		return users.get()
				.stream()
				.flatMapToInt( a -> IntStream.of(a.getWatch_tv()))
				.sum()/getTotalNumberOfSurveys();
	}

	public double getPeopleLikeListenToRadio() {
		return users.get()
				.stream()
				.flatMapToInt( a -> IntStream.of(a.getListen_to_radio()))
				.sum()/getTotalNumberOfSurveys();
	}
}
