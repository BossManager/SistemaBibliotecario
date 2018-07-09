package DAO.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import DAO.database.ConnectionFactory;
import DAO.entidades.Leitor;

public class LeitorDAO extends BaseDAO<Leitor>{
	public ArrayList<Leitor> leitores;
	public LeitorDAO() {
		leitores=this.getLista();
	}
	@Override
	public boolean adicionarObjeto(Leitor objeto) {
		String sql="insert into leitor(nome,cpf,email,endereco,idade) values(?,?,?,?,?)";
		try {
			Connection connection=ConnectionFactory.getConnection();
			// prepared statement para inser��o
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	         stmt.setString(1,objeto.getNome());
	         stmt.setString(2,objeto.getCpf());
	         stmt.setString(3,objeto.getEmail());
	         stmt.setString(4,objeto.getEndereco());
	         stmt.setInt(5, objeto.getIdade());
	         stmt.execute();
	         ConnectionFactory.fechaConexao(connection, stmt);
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
		return true;
	}

	@Override
	public boolean removerObjeto(Leitor objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarObjeto(Leitor objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean pesquisarObjeto(Leitor objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	public static ArrayList<Leitor> getLista() {
		try {
			Connection connection = ConnectionFactory.getConnection();
			ArrayList<Leitor> leitores = new ArrayList<Leitor>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from leitor");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Leitor l=new Leitor();
				l.setId((int)rs.getLong("id"));
				l.setNome(rs.getString("nome"));
				l.setCpf(rs.getString("cpf"));
				l.setEmail(rs.getString("email"));
				l.setEndereco(rs.getString("endereco"));
				// adicionando o objeto � lista
				leitores.add(l);
			}
			ConnectionFactory.fechaConexao(connection, stmt, rs);
			return leitores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
