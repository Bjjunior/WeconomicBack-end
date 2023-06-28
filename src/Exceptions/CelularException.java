package Exceptions;

import java.sql.SQLException;

public class CelularException extends Exception {
    public CelularException(String message, SQLException e) {
        super(message);
    }

}
