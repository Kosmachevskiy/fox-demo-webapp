package app.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import java.time.LocalDate;

@Builder
@Value
@Wither
public class User {

    private long id;

    private String username;

    private LocalDate registered;

    private Role role;
}
