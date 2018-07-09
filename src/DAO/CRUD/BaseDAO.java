package DAO.CRUD;


public abstract class BaseDAO<T> {
	public abstract boolean adicionarObjeto(T objeto);
	public abstract boolean removerObjeto(T objeto);
	public abstract boolean alterarObjeto(T objeto);
	public abstract boolean pesquisarObjeto(T objeto);
}
