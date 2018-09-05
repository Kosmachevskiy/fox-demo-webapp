package app.persistence.user;

import app.model.User;
import app.persistence.Dao;

public interface UserDao extends Dao<User> {

    UserDao INSTANCE = new InMemoryUserDao();
}
