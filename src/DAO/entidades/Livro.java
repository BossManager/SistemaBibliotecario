package DAO.entidades;

public class Livro {
	private int id;
	private String nome;
	private String autor;
	private String descricao;
	private String ano;
	private String categoria;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public String getAutor() {
		return autor;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getAno() {
		return ano;
	}
	public String getCategoria() {
		return categoria;
	}
}
