package DAO.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import DAO.database.ConnectionFactory;
import DAO.entidades.Funcionario;
import java.sql.PreparedStatement;


public class FuncionarioDAO extends BaseDAO<Funcionario>{
	public ArrayList<Funcionario> funcionarios;
	public FuncionarioDAO() {
		funcionarios=getLista();
	}
	@Override
	public boolean adicionarObjeto(Funcionario objeto) {
		String sql="insert into funcionario(nome,cpf,email,endereco,idade,login,senha) values(?,?,?,?,?,?,?)";
		try {
			Connection connection=ConnectionFactory.getConnection();
			// prepared statement para inser��o
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	         stmt.setString(1,objeto.getNome());
	         stmt.setString(2,objeto.getCpf());
	         stmt.setString(3,objeto.getEmail());
	         stmt.setString(4,objeto.getEndereco());
	         stmt.setInt(5, objeto.getIdade());
	         stmt.setString(6, objeto.getLogin());
	         stmt.setString(7, objeto.getSenha());
	         stmt.execute();
	         ConnectionFactory.fechaConexao(connection, stmt);
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
		return false;
	}

	@Override
	public boolean removerObjeto(Funcionario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarObjeto(Funcionario objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	public static ArrayList<Funcionario> getLista() {
		try {
			Connection connection=ConnectionFactory.getConnection();
			ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from funcionario");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto livro
				Funcionario f = new Funcionario();
				f.setId((int)rs.getLong("id"));
				f.setNome(rs.getString("nome"));
				f.setCpf(rs.getString("cpf"));
				f.setEmail(rs.getString("email"));
				f.setEndereco(rs.getString("endereco"));
				f.setIdade((int)rs.getLong("idade"));
				f.setLogin(rs.getString("login"));
				f.setSenha(rs.getString("senha"));
				
				// adicionando o objeto � lista
				funcionarios.add(f);
			}
			ConnectionFactory.fechaConexao(connection,stmt, rs);
			return funcionarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	@Override
	public boolean pesquisarObjeto(Funcionario objeto) {
		for (Funcionario f:funcionarios) {
			if(f.getLogin().equals(objeto.getLogin()) && f.getSenha().equals(objeto.getSenha())){
				return true;
			}
		}
		return false;
	}
	public Funcionario copiaObjeto(Funcionario c) {
		for (Funcionario f:funcionarios) {
			if(f.getLogin().equals(c.getLogin()) && f.getSenha().equals(c.getSenha())){
				return f;
			}
		}
		return null;
	}

}
