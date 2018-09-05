package app.persistence.role;

import app.model.Role;
import app.persistence.Dao;

public interface RoleDao extends Dao<Role> {

    RoleDao INSTANCE = new InMemoryRoleDao();
}
