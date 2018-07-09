package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Board extends JPanel {
	private JPanel inter;
	private JLabel plogin,psenha,icone;
	private JTextField tlogin,tsenha;
	private JButton loginButton;
	public Board(){
		initBoard();
	}
	
	public JPanel getInter() {
		return inter;
	}

	public JLabel getPlogin() {
		return plogin;
	}

	public JLabel getPsenha() {
		return psenha;
	}

	public JLabel getIcone() {
		return icone;
	}

	public JTextField getTlogin() {
		return tlogin;
	}

	public JTextField getTsenha() {
		return tsenha;
	}

	public ImageIcon getFundo() {
		return fundo;
	}

	private void initBoard(){
		setLayout(null);

		inter=new JPanel();
		inter.setLayout(null);
		inter.setBounds(200, 100, 400, 250);
		TitledBorder border=new TitledBorder(BorderFactory.createTitledBorder(""));
		border.setBorder(new LineBorder(Color.black, 1));
		inter.setBorder(border);

		Font small=new Font("Helvetica",Font.BOLD,20);
		FontMetrics fm=getFontMetrics(small);
		icone=new JLabel("Login");
		icone.setFont(small);
		icone.setBounds(170, 10, 100, 50);
		inter.add(icone);

		tlogin=new JTextField();
		tlogin.setBounds(140, 80, 150, 20);
		inter.add(tlogin);

		tsenha=new JPasswordField();
		tsenha.setBounds(140, 110, 150, 20);
		inter.add(tsenha);

		plogin=new JLabel("Usuario:");
		plogin.setBounds(70, 80, 70, 20);
		inter.add(plogin);

		psenha=new JLabel("Senha:");
		psenha.setBounds(70, 110, 50, 20);
		inter.add(psenha);
		loginButton=new JButton("Logar");
		loginButton.setBounds(130, 150, 140, 50);
		loginButton.setIcon(new ImageIcon(getClass().getResource("Male.png")));
		inter.add(loginButton);
		add(inter);

	}
	public JButton getLoginButton() {
		return loginButton;
	}
	ImageIcon fundo=new ImageIcon(getClass().getResource("biblioteca.jpg"));
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g.create();
		g2d.drawImage(fundo.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g2d.dispose();
	}
	/*
	public void actionPerformed(ActionEvent e) {
		JPanel trocar=null;
		if(e.getSource()==loginButton){
			String login=tlogin.getText();
			String senha=tsenha.getText();
			/*
			try {
				MessageDigest m;
				m = MessageDigest.getInstance("MD5");
				m.update(login.getBytes(), 0, login.length());
				BigInteger login1 = new BigInteger(1, m.digest());
				login = String.format("%1$032X", login1);
				
				m.reset(); // <---- Reseta antes de fazer o password
				m.update(senha.getBytes(), 0, senha.length());
				BigInteger password1 = new BigInteger(1, m.digest());
				senha = String.format("%1$032X", password1);
				
				System.out.println(login);
				System.out.println(senha);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			trocar=new BoardIntermed();
			
		}else {
			trocar=new Board();
		}
		
      
	}
	*/
}
