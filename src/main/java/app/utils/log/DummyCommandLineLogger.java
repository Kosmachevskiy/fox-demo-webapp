package app.utils.log;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class DummyCommandLineLogger implements Logger {

    private Class clazz;

    @Override public void log(String message) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " " + message);
    }

    public static Logger createFor(Class aClass){
        return new DummyCommandLineLogger(aClass);
    }
}
