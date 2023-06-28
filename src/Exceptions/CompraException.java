package Exceptions;

import java.sql.SQLException;

public class CompraException extends Exception {
    public CompraException(String message, SQLException e) {
        super(message);
    }

}
