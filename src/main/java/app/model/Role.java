package app.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import java.util.Collection;

@Value
@Builder
@Wither
public class Role {

    private long id;

    private String name;

    private Collection<Permission> permissions;
}
