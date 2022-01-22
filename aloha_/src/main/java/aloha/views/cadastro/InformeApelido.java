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
import aloha.util.TarefaAtualizaLabel;
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;
import aloha.views.main.ViewInicial;

public class InformeApelido {

	private JFrame frame;
	public static JFrame FRAME_SEGUINTE;
	public static JFrame FRAME_ANTERIOR;
	private JTextField textFieldApelido;
	private JTextField textFieldArrouba;
	private JLabel lblAloha;
	private ImageIcon sol = new ImageIcon(this.getClass().getResource("/icons/ligth_theme.png"));
	private ImageIcon lua = new ImageIcon(this.getClass().getResource("/icons/dark_theme.png"));
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

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public JTextField getTextFieldApelido() {
		return textFieldApelido;
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

		// text field apelido
		textFieldApelido = new JTextField("");
		textFieldApelido.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldApelido.setBounds(27, 230, 400, 70);
		textFieldApelido.setColumns(10);
		textFieldApelido.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		//textFieldSobrenome = ViewUtil.criaTextField(20, 403, 400, 65, "Sobrenome", 25);
		textFieldApelido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldApelido.setFocusable(true);
				if (textFieldApelido.getText().equals("Apelido")) {
					textFieldApelido.setText(null);
				}
				textFieldApelido.setForeground(Color.BLACK);
			}
		});
		textFieldApelido.setForeground(Color.GRAY);
		textFieldApelido.setToolTipText("");
		textFieldApelido.setFocusable(false);
		frame.getContentPane().add(textFieldApelido);
		//
		
		//text field @
		textFieldArrouba = new JTextField();
		textFieldArrouba.setText("@");
		textFieldArrouba.setForeground(Color.GRAY);
		textFieldArrouba.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldArrouba.setFocusable(false);
		textFieldArrouba.setColumns(10);
		textFieldArrouba.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		textFieldArrouba.setBounds(27, 427, 400, 70);
		textFieldArrouba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldArrouba.setFocusable(true);
				if (textFieldArrouba.getText().equals("@")) {
					textFieldArrouba.setText(null);
				}
				textFieldArrouba.setForeground(Color.BLACK);
			}
		});
		frame.getContentPane().add(textFieldArrouba);
		//

		// label aloha
		lblAloha = new JLabel("Aloha, novo usuário!");
		lblAloha.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblAloha.setForeground(Color.BLACK);
		lblAloha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAloha.setBounds(15, 49, 423, 62);
		//lblAloha = ViewUtil.criaJLabel(120, 49, 300, 62, null, 32);
		frame.getContentPane().add(lblAloha);

		Runnable tarefa = new TarefaAtualizaLabel(lblAloha, textFieldApelido);
		setThread(new Thread(tarefa, "Thread atualizador de label"));
		thread.start();
		//

		//lbl como ser chamado
		JLabel lblComoSerChamado = new JLabel("Como gostaria de ser chamado?");
		lblComoSerChamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblComoSerChamado.setForeground(Color.BLACK);
		lblComoSerChamado.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblComoSerChamado.setBackground(Color.BLACK);
		lblComoSerChamado.setBounds(9, 180, 435, 36);
		frame.getContentPane().add(lblComoSerChamado);
		//
		
		//lbl escolha seu @
		JLabel lblArrouba = new JLabel("Escolha seu @");
		lblArrouba.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrouba.setForeground(Color.BLACK);
		lblArrouba.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblArrouba.setBackground(Color.BLACK);
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

		InformeApelido a = this;
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario novoUsuario = new Usuario();
					novoUsuario.setApelido(textFieldApelido.getText());
					novoUsuario.setArrouba(textFieldArrouba.getText());
					
					TarefaAtualizaLabel.roda = false;
					frame.setVisible(false);

					if (FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new InformeTelefone(novoUsuario, a);
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
