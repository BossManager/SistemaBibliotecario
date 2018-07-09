package ferramentas;

import java.util.ArrayList;

import DAO.entidades.Funcionario;
import DAO.entidades.Leitor;
import DAO.entidades.Livro;

public class Tools {

	public static Object[][] getListObjects(ArrayList<Livro> disponivel,int colunas) {
		Object [][]novo=new Object[disponivel.size()][7];
		int i=0;
		for (Livro l:disponivel) {
			Object []n= {Integer.toString(l.getId()),l.getNome(),l.getAutor(),l.getDescricao(),l.getAno(),l.getCategoria()};
			novo[i]=n;
			i++;
		}
		return novo;
	}
	public static Object[][] getListObjectsLeitor(ArrayList<Leitor> disponivel,int colunas) {
		Object [][]novo=new Object[disponivel.size()][7];
		int i=0;
		for (Leitor l:disponivel) {
			Object []n= {Integer.toString(l.getId()),l.getNome(),l.getCpf(),l.getEmail(),Integer.toString(l.getIdade()),l.getEndereco()};
			novo[i]=n;
			i++;
		}
		return novo;
	}
	public static String adicionaDataDevol(String dataemprestimo) {
		String dia=dataemprestimo.substring(0, 2);
		String mes=dataemprestimo.substring(3, 5);
		String ano=dataemprestimo.substring(6, 10);
		int a=Integer.parseInt(ano);
		int m=Integer.parseInt(mes);
		m++;
		if(m>12) {
			a=Integer.parseInt(ano)+1;
			mes="01";
		}else {
			if(m<10) {
				mes="0"+Integer.toString(m);
				
			}else {
				mes=Integer.toString(m);
			}
			
		}
		return dia+"/"+mes+"/"+Integer.toString(a);
			
		
	}
	public static Object[][] getListObjectsFuncionario(ArrayList<Funcionario> leitores, int o) {
		Object [][]novo=new Object[leitores.size()][7];
		int i=0;
		for (Funcionario l:leitores) {
			Object []n= {Integer.toString(l.getId()),l.getNome(),l.getCpf(),l.getEmail(),Integer.toString(l.getIdade()),l.getEndereco()};
			novo[i]=n;
			i++;
		}
		return novo;
	}

}
