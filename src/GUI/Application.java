package GUI;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import DAO.CRUD.Master;
import DAO.entidades.Emprestimo;
import DAO.entidades.Funcionario;
import DAO.entidades.Leitor;
import DAO.entidades.Livro;


public class Application extends JFrame{
	private final int WIDTH=800;
	private final int HEIGHT=500;
	private Board painel1;
	private BoardIntermed painel2;
	private BoardEmprestimo painel3;
	private BoardDevolver painel4;
	private BoardGerenteCliente painel5;
	private BoardCadastrarLeitor painel51;
	private BoardGerenteFuncionario painel6;
	private BoardCadastrarFuncionario painel61;
	private BoardGerenteLivro painel7;
	private BoardCadastrarLivro painel71;
	public static Master mestre;
	public static Funcionario online;
	public Application(){
		initUI();
	}
	private void initUI(){
		setPanels();
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setTitle("Sistema de Biblioteca");
		setLocationRelativeTo(null);
		mestre=new Master();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanels() {
		//paineis
		painel1=new Board();
		painel2=new BoardIntermed();
		painel3=new BoardEmprestimo();
		painel4=new BoardDevolver();
		painel5=new BoardGerenteCliente();
		painel51=new BoardCadastrarLeitor();
		painel6=new BoardGerenteFuncionario();
		painel61=new BoardCadastrarFuncionario();
		painel7=new BoardGerenteLivro();
		painel71=new BoardCadastrarLivro();
		//tratadores de a��es
		BtLoginListener bt=new BtLoginListener(); 
		painel1.getLoginButton().addActionListener(bt);
		Painel2Listener re=new Painel2Listener();
		painel2.getEmprestar().addActionListener(re);
		painel2.getDevolver().addActionListener(re);
		painel2.getCadastrar().addActionListener(re);
		painel2.getAdicionar().addActionListener(re);
		painel2.getAdicionar2().addActionListener(re);
		Painel3Listener pu=new Painel3Listener();
		painel3.getRealizarE().addActionListener(pu);
		painel3.getVoltar().addActionListener(pu);
		Painel4Listener dr=new Painel4Listener();
		painel4.getRealizarE().addActionListener(dr);
		painel4.getVoltar().addActionListener(dr);
		Painel5Listener po=new Painel5Listener();
		painel5.getAdicionar().addActionListener(po);
		painel5.getExcluir().addActionListener(po);
		painel5.getAlterar().addActionListener(po);
		Painel51Listener p51=new Painel51Listener();
		painel51.getCadastrar().addActionListener(p51);
		Painel6Listener p6=new Painel6Listener();
		painel6.getAdicionar().addActionListener(p6);
		painel6.getExcluir().addActionListener(p6);
		painel6.getAlterar().addActionListener(p6);
		painel6.getVoltar().addActionListener(p6);
		Painel61Listener p61=new Painel61Listener();
		painel61.getCadastrar().addActionListener(p61);
		Painel7Listener p7=new Painel7Listener();
		painel7.getAdicionar().addActionListener(p7);
		painel7.getExcluir().addActionListener(p7);
		painel7.getAlterar().addActionListener(p7);
		painel7.getVoltar().addActionListener(p7);
		Painel71Listener p71=new Painel71Listener();
		painel71.getCadastrar().addActionListener(p71);
		getContentPane().add( painel1 );
		 try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	 } catch (Exception ex) {
	            ex.printStackTrace();
	 }
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				Application tv=new Application();
				tv.setVisible(true);

			}
		});
	}
	private class BtLoginListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if ( e.getSource() == painel1.getLoginButton()) {
				Funcionario f=new Funcionario();
				f.setLogin(painel1.getTlogin().getText());
				f.setSenha(painel1.getTsenha().getText());
				if(mestre.funcionario.pesquisarObjeto(f)) {
					online=mestre.funcionario.copiaObjeto(f);
					panelTrocar = painel2;
					getContentPane().removeAll();
					getContentPane().add( panelTrocar );
					revalidate();
					repaint();					
				}else {
					JOptionPane.showMessageDialog(null, "Usuario/senha incorreto.");
				}
			}
			
			
		}
		
	}
	//Painel intermediario
	private class Painel2Listener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if ( e.getSource() == painel2.getEmprestar()) {
				panelTrocar = painel3;
			}else if(e.getSource()==painel2.getDevolver()){
				panelTrocar=painel4;
			}else if(e.getSource()==painel2.getCadastrar()){
				panelTrocar=painel5;
			}else if(e.getSource()==painel2.getAdicionar()) {
				panelTrocar=painel6;
			}else if(e.getSource()==painel2.getAdicionar2()) {
				panelTrocar=painel7;
			}
			getContentPane().removeAll();
			getContentPane().add( panelTrocar );
			revalidate();
			repaint();
			
		}
		
	}
	private class Painel3Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel3.getRealizarE()) {
				int t1linhaSelecionada = -1;
				int t2linhaSelecionada = -1;
				t1linhaSelecionada = painel3.getTabela().getSelectedRow();
				t2linhaSelecionada = painel3.getTabela2().getSelectedRow();
				if(t1linhaSelecionada>=0 && t2linhaSelecionada>=0) {
					Emprestimo emp=new Emprestimo();
					//esse id_e vai ter id do livro e depois sera capturado um exemplar daquele livro vago
					int id_e=Integer.parseInt(painel3.getTabela().getValueAt(t1linhaSelecionada,0).toString());
					emp.setId_exemplar(id_e);
					int id_l=Integer.parseInt(painel3.getTabela2().getValueAt(t2linhaSelecionada,0).toString());
					emp.setId_leitor(id_l);
					emp.setId_funcionario_e(online.getId());
					Date data = new Date();
					SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
					emp.setDataemprestimo(formatador.format(data));
					mestre.exemplar.adicionarExemplar(emp);
					emp.setId_funcionario_d(2);
					mestre.emprestimo.adicionarObjeto(emp);
					JOptionPane.showMessageDialog(null, "Emprestimo cadastrado");
				}else {
					JOptionPane.showMessageDialog(null, "� neces�rio selecionar uma linha em cada tabela.");
				}
			}else {
				panelTrocar = painel2;
				getContentPane().removeAll();
				getContentPane().add( panelTrocar );
				revalidate();
				repaint();
			}
			
		}
		
	}
	private class Painel4Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel4.getRealizarE()) {
				int t1linhaSelecionada = -1;
				int t2linhaSelecionada = -1;
				t1linhaSelecionada = painel4.getTabela().getSelectedRow();
				t2linhaSelecionada = painel4.getTabela2().getSelectedRow();
				if(t1linhaSelecionada>=0 && t2linhaSelecionada>=0) {
					int livro_id=Integer.parseInt(painel4.getTabela().getValueAt(t1linhaSelecionada,0).toString());
					int leitor_id=Integer.parseInt(painel4.getTabela2().getValueAt(t2linhaSelecionada,0).toString());
					Emprestimo m=mestre.emprestimo.copiarObjeto(livro_id,leitor_id);
					m.setId_funcionario_d(online.getId());
					mestre.exemplar.alterarObjetoEstado(m);
					mestre.emprestimo.alterarObjetoFuncionarioD(m);
					JOptionPane.showMessageDialog(null, "Livro devolvido");
				}
					
			}else {
				panelTrocar = painel2;
				getContentPane().removeAll();
				getContentPane().add( panelTrocar );
				revalidate();
				repaint();
			}
			
		}
		
	}
	private class Painel5Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel5.getAdicionar()) {
				panelTrocar=painel51;
			}else if(e.getSource()==painel5.getExcluir()){
				
			}else if(e.getSource()==painel5.getAlterar()) {
				int linhaselecionada=-1;
				linhaselecionada=painel5.getTab().getSelectedRow();
				if(linhaselecionada>=0) {
					
					
				}
				/*
				painel51.getTnome().setText(painel5.getTab().getValueAt(linhaselecionada, 0).toString());
				painel51.getTemail().setText();
				painel51.getTcpf().setText();
				painel51.getTendereco().setText();
				painel51.getTidade().setText();
				*/
			}else {
				panelTrocar = painel2;
			}
			getContentPane().removeAll();
			getContentPane().add( panelTrocar );
			revalidate();
			repaint();
			
		}
		
	}
	private class Painel51Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel51.getCadastrar()) {
				Leitor leitor=new Leitor();
				leitor.setNome(painel51.getTnome().getText());
				leitor.setCpf(painel51.getTcpf().getText());
				leitor.setEmail(painel51.getTemail().getText());
				leitor.setEndereco(painel51.getTendereco().getText());
				leitor.setIdade(25);
				mestre.leitor.adicionarObjeto(leitor);
				JOptionPane.showMessageDialog(null, "Leitor cadastrado");
				panelTrocar=painel5;
			}
			getContentPane().removeAll();
			getContentPane().add( panelTrocar );
			revalidate();
			repaint();
			
		}
		
	}
	private class Painel6Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel6.getAdicionar()) {
				panelTrocar=painel61;
			}else if(e.getSource()==painel6.getExcluir()){
				
			}else if(e.getSource()==painel6.getAlterar()) {
				int linhaselecionada=-1;
				linhaselecionada=painel6.getTab().getSelectedRow();
				if(linhaselecionada>=0) {
					
					
				}
				/*
				painel51.getTnome().setText(painel5.getTab().getValueAt(linhaselecionada, 0).toString());
				painel51.getTemail().setText();
				painel51.getTcpf().setText();
				painel51.getTendereco().setText();
				painel51.getTidade().setText();
				*/
			}else {
				panelTrocar = painel2;
			}
			getContentPane().removeAll();
			getContentPane().add( panelTrocar );
			revalidate();
			repaint();
			
		}
		
	}
	private class Painel61Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel61.getCadastrar()) {
				Funcionario leitor=new Funcionario();
				leitor.setNome(painel61.getTnome().getText());
				leitor.setCpf(painel61.getTcpf().getText());
				leitor.setEmail(painel61.getTemail().getText());
				leitor.setEndereco(painel61.getTendereco().getText());
				leitor.setIdade(25);
				leitor.setLogin(painel61.getTlogin().getText());
				leitor.setSenha(painel61.getTsenha().getText());
				mestre.funcionario.adicionarObjeto(leitor);
				JOptionPane.showMessageDialog(null, "Funcionario cadastrado");
				panelTrocar=painel6;
			}
			getContentPane().removeAll();
			getContentPane().add( panelTrocar );
			revalidate();
			repaint();
			
		}
		
	}
	private class Painel7Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel7.getAdicionar()) {
				panelTrocar=painel71;
			}else if(e.getSource()==painel7.getExcluir()){
				
			}else if(e.getSource()==painel7.getAlterar()) {
				int linhaselecionada=-1;
				linhaselecionada=painel7.getTab().getSelectedRow();
				if(linhaselecionada>=0) {
					
					
				}
				/*
				painel51.getTnome().setText(painel5.getTab().getValueAt(linhaselecionada, 0).toString());
				painel51.getTemail().setText();
				painel51.getTcpf().setText();
				painel51.getTendereco().setText();
				painel51.getTidade().setText();
				*/
			}else {
				panelTrocar = painel2;
			}
			getContentPane().removeAll();
			getContentPane().add( panelTrocar );
			revalidate();
			repaint();
			
		}
		
	}
	private class Painel71Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panelTrocar = null;
			if(e.getSource()==painel71.getCadastrar()) {
				Livro leitor=new Livro();
				leitor.setNome(painel71.getTnome().getText());
				leitor.setAno(painel71.getTano().getText());
				leitor.setAutor(painel71.getTautor().getText());
				leitor.setCategoria(painel71.getTcategoria().getText());
				leitor.setDescricao(painel71.getTdescricao().getText());
				Integer exemplares=Integer.parseInt((String) painel71.getTexemplares().getValue());
				System.out.println(exemplares);
				//mestre.livro.adicionarObjeto(leitor);
				//mestre.exemplar.adicionarNumeroExemplar(mestre.livro.getLista().size()+1,Integer.parseInt(exemplares));
				JOptionPane.showMessageDialog(null, "Livro cadastrado");
				panelTrocar=painel7;
			}
			getContentPane().removeAll();
			getContentPane().add( panelTrocar );
			revalidate();
			repaint();
			
		}
		
	}
}
