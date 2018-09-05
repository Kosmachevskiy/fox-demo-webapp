package app.service.role;

import app.model.Role;
import app.persistence.role.RoleDao;
import app.service.ModelConverter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleService implements ModelConverter<Role, RoleView> {

    public final static RoleService INSTANCE = new RoleService();
    private final RoleDao dao = RoleDao.INSTANCE;

    public Collection<RoleView> getAll() {
        return dao.getAll()
                .stream()
                .map(this::toView)
                .collect(toList());
    }

    @Override public RoleView toView(Role model) {
        return RoleView
                .builder()
                .id(model.getId())
                .name(model.getName())
                .permissions(model
                        .getPermissions()
                        .stream()
                        .map(permission -> permission.name().toLowerCase())
                        .collect(toList()))
                .build();
    }
}
