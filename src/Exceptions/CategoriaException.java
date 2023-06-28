package Exceptions;

import java.sql.SQLException;

public class CategoriaException extends Exception {
    public CategoriaException(String message, SQLException e) {
        super(message);
    }

}
