package main.App.Entity;

public class User {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFavourite_food() {
		return favourite_food;
	}

	public void setFavourite_food(String favourite_food) {
		this.favourite_food = favourite_food;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public Integer getEat_out() {
		return eat_out;
	}

	public void setEat_out(Integer eat_out) {
		this.eat_out = eat_out;
	}

	public Integer getWatch_movies() {
		return watch_movies;
	}

	public void setWatch_movies(Integer watch_movies) {
		this.watch_movies = watch_movies;
	}

	public Integer getWatch_tv() {
		return watch_tv;
	}

	public void setWatch_tv(Integer watch_tv) {
		this.watch_tv = watch_tv;
	}

	public Integer getListen_to_radio() {
		return listen_to_radio;
	}

	public void setListen_to_radio(Integer listen_to_radio) {
		this.listen_to_radio = listen_to_radio;
	}

	private Integer id;
	private String surname;
	private String first_name;
	private String date;
	private Integer age;
	private String favourite_food;
	private String contact_number;

	
	private Integer eat_out;
	private Integer watch_movies;
	private Integer watch_tv;
	private Integer listen_to_radio;
	
	public User(
	String surname,
	String first_name,
	String date,
	Integer age,
	String favourite_food,
	String contact_number,
	Integer eat_out,
	Integer watch_movies,
	Integer watch_tv,
	Integer listen_to_radio) {
		this.surname = surname;
		this.first_name = first_name;
		this.date = date;
		this.age = age;
		this.favourite_food = favourite_food;
		this.contact_number = contact_number;
		this.eat_out = eat_out;
		this.watch_movies = watch_movies; 
		this.watch_tv = watch_tv;
		this.listen_to_radio = listen_to_radio;
		
	}
}
