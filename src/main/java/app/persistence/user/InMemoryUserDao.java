package app.persistence.user;

import app.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

class InMemoryUserDao implements UserDao {

    private final AtomicLong idSequence = new AtomicLong(1L);
    private final Map<Long, User> storage = new HashMap<>();

    @Override public Collection<User> getAll() {
        return storage.values();
    }

    @Override public User save(User user) {
        user = user.withId(idSequence.getAndIncrement());
        storage.put(user.getId(), user);
        return user;
    }
}
