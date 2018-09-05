package app.persistence.role;

import app.model.Role;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

class InMemoryRoleDao implements RoleDao {

    private final AtomicLong idSequence = new AtomicLong(1L);
    private final Map<Long, Role> storage = new HashMap<>();

    @Override public Collection<Role> getAll() {
        return storage.values();
    }

    @Override public Role save(Role role) {
        role = role.withId(idSequence.getAndIncrement());
        storage.put(role.getId(), role);
        return role;
    }
}
