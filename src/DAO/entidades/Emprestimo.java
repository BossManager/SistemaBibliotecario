package DAO.entidades;

public class Emprestimo {
	private int id;
	private int id_funcionario_e;
	private int id_funcionario_d;
	private int id_exemplar;
	private int id_leitor;
	private String dataemprestimo;
	private String datadevolucao;
	private double multa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_funcionario_e() {
		return id_funcionario_e;
	}
	public void setId_funcionario_e(int id_funcionario_e) {
		this.id_funcionario_e = id_funcionario_e;
	}
	public int getId_funcionario_d() {
		return id_funcionario_d;
	}
	public void setId_funcionario_d(int id_funcionario_d) {
		this.id_funcionario_d = id_funcionario_d;
	}
	public int getId_exemplar() {
		return id_exemplar;
	}
	public void setId_exemplar(int id_exemplar) {
		this.id_exemplar = id_exemplar;
	}
	public int getId_leitor() {
		return id_leitor;
	}
	public void setId_leitor(int id_leitor) {
		this.id_leitor = id_leitor;
	}
	public String getDataemprestimo() {
		return dataemprestimo;
	}
	public void setDataemprestimo(String dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}
	public String getDatadevolucao() {
		return datadevolucao;
	}
	public void setDatadevolucao(String datadevolucao) {
		this.datadevolucao = datadevolucao;
	}
	public double getMulta() {
		return multa;
	}
	public void setMulta(double multa) {
		this.multa = multa;
	}
	
	
}
