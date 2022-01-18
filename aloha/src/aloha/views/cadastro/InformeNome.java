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
import aloha.util.ViewUtil;
import aloha.views.main.ViewInicial;
import aloha.util.TarefaAtualizaLabel;
import aloha.util.TextBubbleBorder;

public class InformeNome {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JLabel lblAloha;
	private ImageIcon sol = new ImageIcon(this.getClass().getResource("/ligth_theme.png"));
	private ImageIcon lua = new ImageIcon(this.getClass().getResource("/dark_theme.png"));
	private Thread thread;
	public static JFrame FRAME_SEGUINTE;
	public static JFrame FRAME_ANTERIOR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeNome window = new InformeNome();
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
	public InformeNome() {
		initialize();
	}
	
	public InformeNome(JFrame frameAnterior) {
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JLabel getLblAloha() {
		return lblAloha;
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

		// text fied nome
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldNome.setText("Primeiro nome");
		textFieldNome.setBounds(27, 312, 400, 65);
		textFieldNome.setColumns(10);
		textFieldNome.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		//textFieldNome = ViewUtil.criaTextField(20, 312, 400, 65, "Primeiro nome", 25);
		textFieldNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setFocusable(true);
				if (textFieldNome.getText().equals("Primeiro nome")) {
					textFieldNome.setText(null);
				}
				textFieldNome.setForeground(Color.BLACK);
			}
		});
		textFieldNome.setForeground(Color.GRAY);
		textFieldNome.setToolTipText("Primeiro nome");
		textFieldNome.setFocusable(false);
		frame.getContentPane().add(textFieldNome);
		//

		// text field sobrenome
		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldSobrenome.setText("Sobrenome");
		textFieldSobrenome.setBounds(27, 403, 400, 65);
		textFieldSobrenome.setColumns(10);
		textFieldSobrenome.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		//textFieldSobrenome = ViewUtil.criaTextField(20, 403, 400, 65, "Sobrenome", 25);
		textFieldSobrenome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldSobrenome.setFocusable(true);
				if (textFieldSobrenome.getText().equals("Sobrenome")) {
					textFieldSobrenome.setText(null);
				}
				textFieldSobrenome.setForeground(Color.BLACK);
			}
		});
		textFieldSobrenome.setForeground(Color.GRAY);
		textFieldSobrenome.setToolTipText("Sobrenome");
		textFieldSobrenome.setFocusable(false);
		frame.getContentPane().add(textFieldSobrenome);
		//

		// label 1
		lblAloha = new JLabel("Aloha, novo usuário!");
		lblAloha.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblAloha.setForeground(Color.BLACK);
		lblAloha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAloha.setBounds(15, 49, 423, 62);
		//lblAloha = ViewUtil.criaJLabel(120, 49, 300, 62, null, 32);
		frame.getContentPane().add(lblAloha);

		Runnable tarefa = new TarefaAtualizaLabel(lblAloha, textFieldNome);
		setThread(new Thread(tarefa, "Thread atualizador de label"));
		thread.start();
		//

		// label 2
		JLabel lblInformeSeuNome = new JLabel("Informe seu nome verdadeiro. Não utilize");
		lblInformeSeuNome.setBackground(Color.BLACK);
		lblInformeSeuNome.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblInformeSeuNome.setForeground(Color.BLACK);
		lblInformeSeuNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeSeuNome.setBounds(9, 169, 435, 36);
		//JLabel lblInformeSeuNome = ViewUtil.criaJLabel(45, 169, 400, 36, "Informe seu nome verdadeiro. Não utilize o",
		//		25);
		frame.getContentPane().add(lblInformeSeuNome);

		JLabel lblInformeSeuNome2 = new JLabel("o nome de terceiros.");
		lblInformeSeuNome2.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblInformeSeuNome2.setForeground(Color.BLACK);
		lblInformeSeuNome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeSeuNome2.setBounds(9, 200, 435, 36);
		//JLabel lblInformeSeuNome2 = ViewUtil.criaJLabel(45, 200, 400, 36, "nome de terceiros.", 25);
		frame.getContentPane().add(lblInformeSeuNome2);
		//

		// botão avançar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAvancar.setBounds(157, 550, 140, 44);
		btnAvancar.setFocusable(false);
		btnAvancar.setBorderPainted(false);
		//JButton btnAvancar = ViewUtil.criaBotao(160, 550, 140, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		InformeNome a = this;
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario novo_usuario = new Usuario();
					novo_usuario.setPrimeiroNome(textFieldNome.getText());
					novo_usuario.setSobrenome(textFieldSobrenome.getText());

					frame.setVisible(false);
					TarefaAtualizaLabel.roda = false;

					if (FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new InformeTelefone(novo_usuario, a);
					}
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
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
		
//		JLabel lblBackground = new JLabel("");
//        ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/wallpaper_gradient-pink-black-linear.png"));
//        lblBackground.setIcon(imgBackground);
//        lblBackground.setBounds(0, 0, 454, 812);
//        frame.getContentPane().add(lblBackground);
	}
}
