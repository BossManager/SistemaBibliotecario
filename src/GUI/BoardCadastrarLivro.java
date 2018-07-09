package GUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class BoardCadastrarLivro extends JPanel{
	private JButton cadastrar;
	private JTextField tnome,tautor,tdescricao,tano,tcategoria;
	private JFormattedTextField texemplares;
	private JLabel lnome,lautor,ldescricao,lano,lcategoria,lexemplares;
	public BoardCadastrarLivro() {
		initBoard();

	}
	private void initBoard() {
		setLayout(null);
		setSize(800,500);
		setBorder(BorderFactory.createTitledBorder("Cadastro de cliente"));
		//nome
		lnome=new JLabel("Nome:");
		tnome=new JTextField();
		tnome.setBounds(150, 50, 300, 20);
		lnome.setBounds(100, 50, 50, 20);
		//cpf
		lautor=new JLabel("Autor:");
		lautor.setBounds(100, 100, 50, 20);
		tautor=new JTextField();
		tautor.setBounds(150,100,300,20);
		//email
		ldescricao=new JLabel("Descricao:");
		ldescricao.setBounds(100, 150, 50, 20);
		tdescricao=new JTextField();
		tdescricao.setBounds(150, 150, 300, 20);
		//endereco
		lano=new JLabel("Ano:");
		tano=new JTextField();
		lano.setBounds(80	,200, 80, 20);
		tano.setBounds(150, 200, 300, 20);
		//idade
		lcategoria=new JLabel("Categoria:");
		tcategoria=new JTextField();
		lcategoria.setBounds(80	,250, 80, 20);
		tcategoria.setBounds(150, 250, 300, 20);
		//login
		lexemplares=new JLabel("Numero de exemplares:");
		texemplares=new JFormattedTextField(Mascara("##"));
		lexemplares.setBounds(80,300, 140, 20);
		texemplares.setBounds(220, 300, 300, 20);
		
		//botao
		cadastrar=new JButton("Cadastrar");
		cadastrar.setBounds(195, 420, 180, 30);
		add(lcategoria);
		add(tcategoria);
		
		add(cadastrar);
		add(lexemplares);
		add(texemplares);
		add(lautor);
		add(tautor);
		add(lano);
		add(tano);
		add(tdescricao);
		add(ldescricao);
		add(lnome);
		add(tnome);

	}
	
	public JTextField getTnome() {
		return tnome;
	}
	public JTextField getTautor() {
		return tautor;
	}
	public JTextField getTdescricao() {
		return tdescricao;
	}
	public JTextField getTano() {
		return tano;
	}
	public JTextField getTcategoria() {
		return tcategoria;
	}
	public JFormattedTextField getTexemplares() {
		return texemplares;
	}
	public JLabel getLnome() {
		return lnome;
	}
	public JLabel getLautor() {
		return lautor;
	}
	public JLabel getLdescricao() {
		return ldescricao;
	}
	public JLabel getLano() {
		return lano;
	}
	public JLabel getLcategoria() {
		return lcategoria;
	}
	public JLabel getLexemplares() {
		return lexemplares;
	}
	public JButton getCadastrar() {
		return cadastrar;
	}
	public MaskFormatter Mascara(String Mascara){
		MaskFormatter F_Mascara = new MaskFormatter();
		try{
			F_Mascara.setMask(Mascara); //Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
		}
		catch (Exception excecao) {
			excecao.printStackTrace();
		} 
		return F_Mascara;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame janela=new JFrame();
				janela.add(new BoardCadastrarLivro());
				janela.setSize(800, 500);
				janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				janela.setResizable(false);
				janela.setVisible(true);

			}
		});
	}
}
