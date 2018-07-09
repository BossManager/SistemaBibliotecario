package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardIntermed extends JPanel{
	private JButton emprestar,devolver,cadastrar,adicionar,adicionar2;
	public JButton getEmprestar() {
		return emprestar;
	}
	public JButton getDevolver() {
		return devolver;
	}
	public JButton getCadastrar() {
		return cadastrar;
	}
	public JButton getAdicionar() {
		return adicionar;
	}
	public JButton getAdicionar2() {
		return adicionar2;
	}
	public BoardIntermed(){
		initBoard();
	}
	private void initBoard() {
		setLayout(null);
		setSize(new Dimension(800, 500));
		
		emprestar=new JButton("Realizar Emprestimo");
		emprestar.setBounds(100, 80, 170, 50);
		add(emprestar);
		
		devolver=new JButton("Realizar Devolu��o");
		devolver.setBounds(100, 150, 170, 50);
		add(devolver);
		
		cadastrar=new JButton("Gerenciar Leitores");
		cadastrar.setBounds(100, 220, 170, 50);
		add(cadastrar);
		
		adicionar=new JButton("Gerenciar Funcionarios");
		adicionar.setBounds(300, 80, 170, 50);
		add(adicionar);
		
		adicionar2=new JButton("Gerenciar Livros");
		adicionar2.setBounds(300, 150, 170, 50);
		add(adicionar2);
		
		
	}
	
}
