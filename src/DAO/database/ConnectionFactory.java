package fbd.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/sistemaprincipal?autoReconnect=true&useSSL=false", "root", "123456789");
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
	public static void fechaConexao( PreparedStatement stmt, ResultSet rs){
		try {
			if( stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}


		} catch (Exception e) {
			System.out.println("N�o foi poss�vel fechar o ResultSet " + e.getMessage());
		}
	}
}
