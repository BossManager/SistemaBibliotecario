package GUI;

import javax.swing.JFrame;


import java.awt.*;

public class Janela  extends JFrame{
	public Janela() {
		iniciarIU();
	}
	private void iniciarIU() {
		add(new PainelLogin());
		setSize(750, 800);
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Janela tela=new Janela();
				tela.setVisible(true);
				
			}
		});
	}
}
