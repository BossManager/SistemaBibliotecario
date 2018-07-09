package GUI;

import java.awt.Event;
import java.awt.EventQueue;
import java.text.Format;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class BoardCadastrarLeitor extends JPanel {
	private JButton cadastrar;
	private JTextField tnome,temail,tendereco,tidade;
	private JLabel lnome,lcpf,lemail,lendereco,lidade;
	private JFormattedTextField tcpf;
	public BoardCadastrarLeitor() {
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
		lcpf=new JLabel("CPF:");
		lcpf.setBounds(100, 100, 50, 20);
		tcpf=new JFormattedTextField(Mascara("###.###.###-##"));
		tcpf.setBounds(150,100,300,20);
		//email
		lemail=new JLabel("Email:");
		lemail.setBounds(100, 150, 50, 20);
		temail=new JTextField();
		temail.setBounds(150, 150, 300, 20);
		//endereco
		lendereco=new JLabel("Endereco:");
		tendereco=new JTextField();
		lendereco.setBounds(80	,200, 80, 20);
		tendereco.setBounds(150, 200, 300, 20);
		//idade
		lidade=new JLabel("Idade:");
		tidade=new JFormattedTextField(Mascara("###"));
		lidade.setBounds(80	,250, 80, 20);
		tidade.setBounds(150, 250, 300, 20);
		//botao
		cadastrar=new JButton("Cadastrar");
		cadastrar.setBounds(195, 300, 180, 30);
		add(cadastrar);
		add(lidade);
		add(tidade);
		add(lendereco);
		add(tendereco);
		add(lemail);
		add(temail);
		add(tcpf);
		add(lcpf);
		add(lnome);
		add(tnome);
		
	}
	 public JTextField getTnome() {
		return tnome;
	}
	public void setTnome(JTextField tnome) {
		this.tnome = tnome;
	}
	public JTextField getTemail() {
		return temail;
	}
	public void setTemail(JTextField temail) {
		this.temail = temail;
	}
	public JTextField getTendereco() {
		return tendereco;
	}
	public void setTendereco(JTextField tendereco) {
		this.tendereco = tendereco;
	}
	public JTextField getTidade() {
		return tidade;
	}
	public void setTidade(JTextField tidade) {
		this.tidade = tidade;
	}
	public JFormattedTextField getTcpf() {
		return tcpf;
	}
	public void setTcpf(JFormattedTextField tcpf) {
		this.tcpf = tcpf;
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
				janela.add(new BoardCadastrarLeitor());
				janela.setSize(800, 500);
				janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				janela.setResizable(false);
				janela.setVisible(true);
				
			}
		});
	}
}
