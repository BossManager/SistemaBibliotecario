package DAO.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import DAO.database.ConnectionFactory;
import DAO.entidades.Livro;

public class LivroDAO extends BaseDAO<Livro>{
	private ArrayList<Livro> livros;
	public LivroDAO() {
		livros=this.getLista();
	}
	@Override
	public boolean adicionarObjeto(Livro objeto) {
		String sql="insert into livro(nome,autor,ano,categoria,descricao) values(?,?,?,?,?)";
		try {
			Connection connection=ConnectionFactory.getConnection();
			// prepared statement para inser��o
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	         stmt.setString(1,objeto.getNome());
	         stmt.setString(2,objeto.getAutor());
	         stmt.setString(3,objeto.getAno());
	         stmt.setString(4,objeto.getCategoria());
	         stmt.setString(5, objeto.getDescricao());
	         stmt.execute();
	         ConnectionFactory.fechaConexao(connection, stmt);
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
		return true;
	}

	@Override
	public boolean removerObjeto(Livro objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarObjeto(Livro objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	public static ArrayList<Livro> getLista() {
		try {
			Connection connection = ConnectionFactory.getConnection();
			ArrayList<Livro> livros = new ArrayList<Livro>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from livro");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Livro livro = new Livro();
				livro.setId((int)rs.getLong("id"));
				livro.setNome(rs.getString("nome"));
				livro.setAutor(rs.getString("autor"));
				livro.setAno(rs.getString("ano"));
				livro.setDescricao(rs.getString("descricao"));
				livro.setCategoria(rs.getString("categoria"));
				
				// adicionando o objeto � lista
				livros.add(livro);
			}
			ConnectionFactory.fechaConexao(connection, stmt, rs);
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	@Override
	public boolean pesquisarObjeto(Livro objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	public static ArrayList<Livro> getResult(String query){
		try {
			Connection connection = ConnectionFactory.getConnection();
			ArrayList<Livro> livros = new ArrayList<Livro>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Livro livro = new Livro();
				livro.setId((int)rs.getLong("id"));
				livro.setNome(rs.getString("nome"));
				livro.setAutor(rs.getString("autor"));
				livro.setAno(rs.getString("ano"));
				livro.setDescricao(rs.getString("descricao"));
				livro.setCategoria(rs.getString("categoria"));
				
				// adicionando o objeto � lista
				livros.add(livro);
			}
			ConnectionFactory.fechaConexao(connection, stmt, rs);
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
