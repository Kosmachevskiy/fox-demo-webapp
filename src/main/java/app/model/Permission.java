package app.model;

import java.util.Arrays;
import java.util.Collection;

public enum Permission {

    READ, WRITE, COMMENT;

    public static Collection<Permission> all(){
        return Arrays.asList(Permission.values());
    }
}
