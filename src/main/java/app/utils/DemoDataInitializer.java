package app.utils;

import app.model.Permission;
import app.model.Role;
import app.model.User;
import app.persistence.role.RoleDao;
import app.persistence.user.UserDao;
import app.utils.log.DummyCommandLineLogger;
import app.utils.log.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDate;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class DemoDataInitializer implements ServletContextListener {

    private static final Logger LOGGER = DummyCommandLineLogger.createFor(DemoDataInitializer.class);

    private RoleDao roleDao = RoleDao.INSTANCE;
    private UserDao userDao = UserDao.INSTANCE;

    @Override public void contextInitialized(ServletContextEvent sce) {
        LOGGER.log("Webapp started");
        populateStorage();
    }

    @Override public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.log("Close application");
    }

    private void populateStorage() {

        LOGGER.log("Populate storage");

        /*Roles*/
        Role guest = roleDao.save(Role
                .builder()
                .name("GUEST")
                .permissions(singletonList(Permission.READ))
                .build());
        Role user = roleDao.save(Role
                .builder()
                .name("USER")
                .permissions(asList(Permission.READ, Permission.COMMENT))
                .build());
        Role admin = roleDao.save(Role
                .builder()
                .name("ADMIN")
                .permissions(Permission.all())
                .build());

        /*Users*/
        userDao.save(User
                .builder()
                .username("Some Guest")
                .role(guest)
                .registered(LocalDate.of(1990, 12, 31))
                .build());
        userDao.save(User
                .builder()
                .username("Common User")
                .role(user)
                .registered(LocalDate.of(2049, 6, 1))
                .build());
        userDao.save(User
                .builder()
                .username("Crazy User")
                .role(user)
                .registered(LocalDate.of(6666, 6, 6))
                .build());
        userDao.save(User
                .builder()
                .username("Ultra Admin")
                .role(admin)
                .registered(LocalDate.of(2018, 9, 1))
                .build());
    }
}
