package app.service.role;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder
public class RoleView {

    private long id;

    private String name;

    private Collection<String> permissions;
}
