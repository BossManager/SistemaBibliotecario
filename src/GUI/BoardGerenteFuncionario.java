package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.CRUD.FuncionarioDAO;
import DAO.entidades.Funcionario;
import ferramentas.Tools;

public class BoardGerenteFuncionario extends JPanel{
	public JButton adicionar,excluir,alterar,voltar;
	public JButton getVoltar() {
		return voltar;
	}
	public JPanel tabela;
	public JTable tab;
	public JScrollPane barra;
	public JButton getAdicionar() {
		return adicionar;
	}
	public JButton getExcluir() {
		return excluir;
	}
	public JButton getAlterar() {
		return alterar;
	}
	public JPanel getTabela() {
		return tabela;
	}
	public JTable getTab() {
		return tab;
	}
	public JScrollPane getBarra() {
		return barra;
	}
	public BoardGerenteFuncionario() {
		initUI();
	}
	private void initUI() {
		setLayout(null);
		setSize(new Dimension(800, 500));
		tabela=new JPanel();
		tabela.setLayout(new GridLayout(1, 1));
		tabela.setBorder(BorderFactory.createTitledBorder("Lista de Funcionarios"));
		tabela.setBounds(0, 0, 790, 250);
		adicionar=new JButton("Adicionar");
		adicionar.setBounds(180, 280, 100, 40);
		add(adicionar);
		excluir=new JButton("Excluir");
		excluir.setBounds(300, 280, 100, 40);
		add(excluir);
		alterar=new JButton("Alterar");
		alterar.setBounds(420, 280, 100, 40);
		add(alterar);
		voltar=new JButton("Voltar");
		voltar.setBounds(300, 330, 100, 40);
		add(voltar);
		ArrayList<Funcionario> leitores=FuncionarioDAO.getLista();
		String []colunas= {"id","nome","cpf","email","idade","endereco"};
		Object [][] objetos= Tools.getListObjectsFuncionario(leitores, 6);
		tab=new JTable(objetos,colunas);
		barra=new JScrollPane(tab);
		tabela.add(barra);
		
		add(tabela);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame janela=new JFrame();
				janela.add(new BoardGerenteFuncionario());
				janela.setSize(800, 500);
				janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				janela.setResizable(false);
				janela.setVisible(true);
				
			}
		});
	}
}
