package Exceptions;

import java.sql.SQLException;

public class CartaoException extends Exception {
    public CartaoException(String message, SQLException e) {
        super(message);
    }

}
