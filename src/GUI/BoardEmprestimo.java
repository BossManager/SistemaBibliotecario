package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.CRUD.LeitorDAO;
import DAO.CRUD.LivroDAO;
import DAO.entidades.Leitor;
import DAO.entidades.Livro;
import ferramentas.Tools;

public class BoardEmprestimo extends JPanel{
	public JTable getTabela() {
		return tabela;
	}
	public JTable getTabela2() {
		return tabela2;
	}
	public JScrollPane getBarra() {
		return barra;
	}
	public JScrollPane getBarra2() {
		return barra2;
	}
	public JPanel getPainel1() {
		return painel1;
	}
	public JPanel getPainel2() {
		return painel2;
	}
	public JButton getRealizarE() {
		return realizarE;
	}
	public JButton getVoltar() {
		return voltar;
	}
	private JTable tabela,tabela2;
	private JScrollPane barra,barra2;
	private JPanel painel1,painel2;
	private JButton realizarE,voltar;
	public BoardEmprestimo() {
		initBoard();
	}
	private void initBoard() {
		setLayout(null);
		setSize(new Dimension(800, 500));
		painel1=new JPanel();
		painel1.setLayout(new GridLayout(1, 1));
		painel1.setBorder(BorderFactory.createTitledBorder("Lista de Livros"));
		painel1.setBounds(0, 0, 790, 125);
		painel2=new JPanel();
		painel2.setLayout(new GridLayout(1, 1));
		painel2.setBorder(BorderFactory.createTitledBorder("Lista de Leitores"));
		painel2.setBounds(0, 125, 790, 125);
		String []colunas= {"id","nome","autor","descricao","ano","categoria"};
		//livros disponiveis
		String query="select distinct L.id,L.nome,L.autor,L.ano,L.categoria,L.descricao from livro as L,exemplar as E where L.id=E.id_livro and E.estado=0;";
		ArrayList<Livro> disponivel=LivroDAO.getResult(query);
		
		Object [][] objetos= Tools.getListObjects(disponivel,6);
		tabela=new JTable(objetos,colunas);
		tabela.setEnabled(false);
		barra=new JScrollPane(tabela);
		
		String []colunas2= {"id","nome","cpf","email","idade","endereco"};
		ArrayList<Leitor> leitores=LeitorDAO.getLista();
		Object [][] objetos2= Tools.getListObjectsLeitor(leitores, 6);
		tabela2=new JTable(objetos2,colunas2);
		barra2=new JScrollPane(tabela2);
		tabela2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				tabela.setEnabled(!lsm.isSelectionEmpty());
				String query="select distinct L.id,L.nome,L.autor,L.ano,L.categoria,L.descricao from livro as L,exemplar as E where L.id=E.id_livro and E.estado=0;";
				ArrayList<Livro> disponivel=LivroDAO.getResult(query);
				tabela=new JTable(objetos,colunas);
				barra=new JScrollPane(tabela);
				painel1.removeAll();
				painel1.repaint();
				painel1.add(barra);
				painel1.revalidate();
			}
		});
		painel1.add(barra);
		painel2.add(barra2);
		
		realizarE=new JButton("Realizar Emprestimo");
		realizarE.setBounds(195, 300, 180, 30);
		voltar=new JButton("retornar");
		voltar.setBounds(390, 300, 180, 30);
		this.add(voltar);
		this.add(realizarE);
		this.add(painel1);
		this.add(painel2);

	}
	public static void main(String[] args) {
		JFrame j=new JFrame();
		j.getContentPane().add(new BoardEmprestimo());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(800, 500);
		j.setVisible(true);

	}
}
