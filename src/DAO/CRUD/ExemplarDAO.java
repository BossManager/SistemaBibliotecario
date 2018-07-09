package DAO.CRUD;

import java.util.ArrayList;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.database.ConnectionFactory;
import DAO.entidades.Emprestimo;
import DAO.entidades.Exemplar;

public class ExemplarDAO extends BaseDAO<Exemplar>{
	
	private ArrayList<Exemplar> exemplares;
	public ExemplarDAO() {
		exemplares=getLista();
	}
	@Override
	public boolean adicionarObjeto(Exemplar objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerObjeto(Exemplar objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarObjeto(Exemplar objeto) {
		String sql = "update exemplar set estado=1 where id=?";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, objeto.getId());
			stmt.execute();
	        ConnectionFactory.fechaConexao(connection, stmt);
		}catch (SQLException e) {
			 throw new RuntimeException(e);
		}
		return true;
	}
	public void alterarObjetoEstado(Emprestimo e) {
		String sql = "update exemplar set estado=0 where id=?";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, e.getId_exemplar());
			stmt.execute();
	        ConnectionFactory.fechaConexao(connection, stmt);
		}catch (SQLException o) {
			 throw new RuntimeException(o);
		}
	}
	@Override
	public boolean pesquisarObjeto(Exemplar objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	public void adicionarExemplar(Emprestimo emp) {
		
		for (Exemplar exemplar : exemplares) {
			if(exemplar.getId_livro()==emp.getId_exemplar() && exemplar.getEstado()==0) {
				emp.setId_exemplar(exemplar.getId());
				alterarObjeto(exemplar);
				return;
			}
		}
		
	}
	private ArrayList<Exemplar> getLista() {
		try {
			ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from exemplar");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Exemplar exemplar = new Exemplar();
				exemplar.setId((int)rs.getLong("id"));
				exemplar.setId_livro((int)rs.getLong("id_livro"));
				exemplar.setEstado((int)rs.getLong("estado"));
				
				// adicionando o objeto � lista
				exemplares.add(exemplar);
			}
			ConnectionFactory.fechaConexao(connection, stmt, rs);
			return exemplares;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public void adicionarNumeroExemplar(int id_elivro,int quantidade) {
		String sql="insert into exemplar(id_livro,estado) values(?,?)";
		try {
			Connection connection=ConnectionFactory.getConnection();
			// prepared statement para inser��o
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	         stmt.setInt(1,id_elivro);
	         stmt.setInt(2,0);
	         while(quantidade>0) {
	        	 stmt.execute();
	        	 quantidade--;
	         }
	         ConnectionFactory.fechaConexao(connection, stmt);
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
		
	}

}
