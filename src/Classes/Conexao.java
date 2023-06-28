package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection obterConexao() {
        Connection conexao = null;
        try {
            // Registra o Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Abre uma conexão
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM97320", "140394");

            System.out.println("Conectado!");

            // Tratamento de erro
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar no Banco de Dados");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("O Driver JDBC não foi encontrado!");
            e.printStackTrace();
        }

        return conexao;

    }
}
