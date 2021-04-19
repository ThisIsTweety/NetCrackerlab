package injects;

import java.io.IOException;
import java.sql.SQLException;

public class MyException extends Exception {

    public MyException(Throwable e) {
        super(e);
    }
}
