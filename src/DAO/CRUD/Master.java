package DAO.CRUD;



public class Master {
	public LivroDAO livro;
	public LeitorDAO leitor;
	public FuncionarioDAO funcionario;
	public ExemplarDAO exemplar;
	public EmprestimoDAO emprestimo;
	public Master() {
		this.livro=new LivroDAO();
		this.leitor=new LeitorDAO();
		this.funcionario=new FuncionarioDAO();
		this.exemplar=new ExemplarDAO();
		this.emprestimo=new EmprestimoDAO();
	}
	
}
