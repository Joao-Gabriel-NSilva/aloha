package aloha.views.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.IconTextField;
import aloha.util.TarefaAtualizaLabel;
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;
import aloha.util.Icones;
import aloha.views.main.ViewInicial;

public class InformeApelido {

	private JFrame frame;
	private Icones icones = new Icones();
	public static JFrame FRAME_SEGUINTE;
	public static JFrame FRAME_ANTERIOR;
	private JTextField textFieldApelido;
	private IconTextField textFieldArrouba;
	private JLabel lblAloha;
	private ImageIcon sol = icones.getImgLightTheme();
	private ImageIcon lua = icones.getImgDarkTheme();
	private Thread thread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeApelido window = new InformeApelido();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InformeApelido() {
		initialize();
	}
	
	public InformeApelido(JFrame frameAnterior) {
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Bem vindo!");
		
		// label aloha
		lblAloha = new JLabel("Aloha, novo usuário!");
		lblAloha.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblAloha.setForeground(Color.BLACK);
		lblAloha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAloha.setBounds(15, 49, 423, 62);
		//lblAloha = ViewUtil.criaJLabel(120, 49, 300, 62, null, 32);
		frame.getContentPane().add(lblAloha);
		//

		// text field apelido
		textFieldApelido = new JTextField("");
		textFieldApelido.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldApelido.setBounds(27, 230, 400, 70);
		textFieldApelido.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		//textFieldSobrenome = ViewUtil.criaTextField(20, 403, 400, 65, "Sobrenome", 25);
		textFieldApelido.setToolTipText("Nome pela qual quer ser chamado.");
		TarefaAtualizaLabel tarefa = new TarefaAtualizaLabel(lblAloha, textFieldApelido);
		textFieldApelido.setFocusable(false);
		textFieldApelido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textFieldApelido.setFocusable(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(thread == null) {
					tarefa.ativa();
					thread = new Thread(tarefa, "Thread atualizador de label");
					thread.start();
				}
			}
		});
		frame.getContentPane().add(textFieldApelido);
		//
		
		//text field @
		textFieldArrouba = new IconTextField();
		textFieldArrouba.setIcon(icones.getImgArrouba());
		textFieldArrouba.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldArrouba.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		textFieldArrouba.setBounds(27, 427, 400, 70);
		textFieldArrouba.setFocusable(false);
		textFieldArrouba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textFieldArrouba.setFocusable(true);
			}
		});
		frame.getContentPane().add(textFieldArrouba);
		//

		//lbl como ser chamado
		JLabel lblComoSerChamado = new JLabel("Como gostaria de ser chamado?");
		lblComoSerChamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblComoSerChamado.setForeground(Color.BLACK);
		lblComoSerChamado.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblComoSerChamado.setBounds(9, 180, 435, 36);
		frame.getContentPane().add(lblComoSerChamado);
		//
		
		//lbl escolha seu @
		JLabel lblArrouba = new JLabel("Escolha seu @");
		lblArrouba.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrouba.setForeground(Color.BLACK);
		lblArrouba.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblArrouba.setBounds(9, 377, 435, 36);
		frame.getContentPane().add(lblArrouba);
		//

		// botão avançar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAvancar.setBounds(157, 555, 140, 44);
		btnAvancar.setFocusable(false);
		btnAvancar.setBorderPainted(false);
		//JButton btnAvancar = ViewUtil.criaBotao(160, 550, 140, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario novoUsuario = new Usuario();
					novoUsuario.setApelido(textFieldApelido.getText());
					novoUsuario.setArrouba(textFieldArrouba.getText());
					
					tarefa.desativa();
					thread = null;
					frame.setVisible(false);

					if (FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new InformeTelefone(novoUsuario, frame);
					}
				} catch (RuntimeException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAvancar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnAvancar.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			btnAvancar.setForeground(Color.BLACK);
        		} else {
        			btnAvancar.setForeground(Color.WHITE);
        		}
        	}
        });
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar();
		frame.getContentPane().add(lblVoltar);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				ViewInicial.FRAME_CADASTRO = frame;
			}
		});
		//

		// lbl tema
		JLabel lblTema = ViewUtil.criaJLabel(410, 0, 37, 41, null, 0);
		lblTema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblTema.getIcon().equals(lua)) {
					lblTema.setIcon(sol);
					ViewUtil.setLightTheme(frame);
				} else {
					lblTema.setIcon(lua);
					ViewUtil.setDarkTheme(frame);
				}
			}
		});
		lblTema.setIcon(sol);
		frame.getContentPane().add(lblTema);
		//
	}
}
