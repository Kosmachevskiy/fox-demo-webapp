package app.service.user;

import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Builder
@Value
public class UserView {

    private long id;

    private String name;

    private String registered;

    private String role;
}
