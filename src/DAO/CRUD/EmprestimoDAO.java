package DAO.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import DAO.database.ConnectionFactory;
import DAO.entidades.Emprestimo;
import ferramentas.Tools;


public class EmprestimoDAO extends BaseDAO<Emprestimo>{
	private ArrayList<Emprestimo> emprestimos;
	public EmprestimoDAO() {
		emprestimos=getLista();
	}

	@Override
	public boolean adicionarObjeto(Emprestimo objeto) {
		String sql = "insert into emprestimo " +
	             "(id_funcionario_e,id_funcionario_d,id_exemplar,id_leitor,data_e,data_d)" +
	             " values(?,?,?,?,?,?)";
	 
	     try {
	         Connection connection=ConnectionFactory.getConnection();
			// prepared statement para inser��o
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	 
	         // seta os valores
	         stmt.setInt(1,objeto.getId_funcionario_e());
	         stmt.setInt(2,objeto.getId_funcionario_d());
	         stmt.setInt(3,objeto.getId_exemplar());
	         stmt.setInt(4,objeto.getId_leitor());
	         stmt.setString(5, objeto.getDataemprestimo());
	         stmt.setString(6, Tools.adicionaDataDevol(objeto.getDataemprestimo()));
	         // executa
	         stmt.execute();
	         ConnectionFactory.fechaConexao(connection, stmt);
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	     return true;
	}

	@Override
	public boolean removerObjeto(Emprestimo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarObjeto(Emprestimo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	private ArrayList<Emprestimo> getLista() {
		try {
			Connection connection=ConnectionFactory.getConnection();
			ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from emprestimo");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Emprestimo e=new Emprestimo();
				
				// adicionando o objeto � lista
				emprestimos.add(e);
			}
			ConnectionFactory.fechaConexao(connection,stmt, rs);
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean pesquisarObjeto(Emprestimo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	public Emprestimo copiarObjeto(int livro_id, int leitor_id) {
		String sql="select e.id,e.id_funcionario_e,e.id_funcionario_d,e.data_e,e.data_d,e.id_exemplar,e.id_leitor,e.multa from emprestimo as e,exemplar as ex where e.id_leitor=? and ex.id_livro=? and ex.id=e.id_exemplar";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, leitor_id);
			stmt.setLong(2, livro_id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Emprestimo mm=new Emprestimo();
				mm.setId((int)rs.getLong("id"));
				mm.setId_funcionario_e((int)rs.getLong("id_funcionario_e"));
				mm.setId_funcionario_d((int)rs.getLong("id_funcionario_d"));
				mm.setDataemprestimo(rs.getString("data_e"));
				mm.setDatadevolucao(rs.getString("data_d"));
				mm.setId_exemplar((int)rs.getLong("id_exemplar"));
				mm.setId_leitor((int)rs.getLong("id_leitor"));
				mm.setMulta((float)rs.getFloat("multa"));
				return mm;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void alterarObjetoFuncionarioD(Emprestimo m) {
		String sql = "update emprestimo set id_funcionario_d=? where id=?";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, m.getId_funcionario_d());
			stmt.setLong(2, m.getId());
			stmt.execute();
	        ConnectionFactory.fechaConexao(connection, stmt);
		}catch (SQLException o) {
			 throw new RuntimeException(o);
		}
		
	}


}
