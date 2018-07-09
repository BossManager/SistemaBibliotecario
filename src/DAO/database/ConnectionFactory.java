package DAO.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        try{

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?useTimezone=true&serverTimezone=UTC", "root", "123456789");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void fechaConexao(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            System.out.println("N�o foi poss�vel fechar a conex�o com o banco de dados " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection conn, PreparedStatement stmt) {

        try {
            if (conn != null) {
                fechaConexao(conn);
            }
            if (stmt != null) {
                stmt.close();
            }

        } catch (Exception e) {
            System.out.println("N�o foi poss�vel fechar o statement " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {

        try {
            if (conn != null || stmt != null) {
                fechaConexao(conn, stmt);
            }
            if (rs != null) {
                rs.close();
            }

        } catch (Exception e) {
            System.out.println("N�o foi poss�vel fechar o ResultSet " + e.getMessage());
        }
    }

    public static void fechaConexao(PreparedStatement stmt, ResultSet rs) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }

        } catch (Exception e) {
            System.out.println("N�o foi poss�vel fechar o ResultSet " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
        System.out.println("Conexao bem sucedida");
        ConnectionFactory.fechaConexao(con);
    }
}
