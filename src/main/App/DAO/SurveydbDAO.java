package main.App.DAO;

import main.App.Entity.User;

import java.util.Optional;
import java.util.Collection;

public interface SurveydbDAO<T, I> {
	void save(User t);
	Optional<T> get(int id);
	Collection<User> getAll();
}
