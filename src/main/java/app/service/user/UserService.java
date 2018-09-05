package app.service.user;

import app.model.User;
import app.persistence.user.UserDao;
import app.service.ModelConverter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService implements ModelConverter<User, UserView> {

    public final static UserService INSTANCE = new UserService();
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d MMM uuuu");

    private final UserDao dao = UserDao.INSTANCE;

    public Collection<UserView> getAll() {
        return dao.getAll()
                .stream()
                .map(this::toView)
                .collect(toList());
    }

    @Override public UserView toView(User model) {
        return UserView.builder()
                .id(model.getId())
                .name(model.getUsername())
                .registered(model.getRegistered().format(DATE_FORMATTER))
                .role(model.getRole().getName())
                .build();
    }
}
