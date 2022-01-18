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
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class ConhecerMelhor {

	private JFrame frame;
	private static Usuario USUARIO;
	private static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConhecerMelhor window = new ConhecerMelhor();
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
	public ConhecerMelhor() {
		initialize();
	}

	public ConhecerMelhor(Usuario usuario, JFrame frameAnterior) {
		USUARIO = usuario;
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
		frame.setTitle("Vamos nos conhecer melhor?");

		// lbl 1
		JLabel lbl1 = new JLabel("Vamos nos conhecer melhor?");
		lbl1.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(10, 142, 434, 62);
		lbl1.setForeground(Color.BLACK);
		//JLabel lbl1 = ViewUtil.criaJLabel(50, 195, 418, 62, "Vamos nos conhecer melhor?", 30);
		frame.getContentPane().add(lbl1);
		//
		
		// botao sim
		JButton btnSim = new JButton("Sim");
		btnSim.setOpaque(true);
		btnSim.setContentAreaFilled(false);
		btnSim.setForeground(Color.BLACK);
		btnSim.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnSim.setBounds(295, 455, 90, 44);
		btnSim.setFocusable(false);
		btnSim.setBorderPainted(false);
		//JButton btnSim = ViewUtil.criaBotao(60, 373, 90, 44, "Sim");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				if(FRAME_SEGUINTE != null) {
					FRAME_SEGUINTE.setVisible(true);
				} else {
					new Gostos(USUARIO, frame);
				}
			}
		});
		btnSim.setFocusable(false);
		frame.getContentPane().add(btnSim);
		//
		
		// botao nao
		JButton btnAgoraNao = new JButton("Agora não");
		btnAgoraNao.setOpaque(true);
		btnAgoraNao.setContentAreaFilled(false);
		btnAgoraNao.setForeground(Color.BLACK);
		btnAgoraNao.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAgoraNao.setBounds(69, 455, 157, 44);
		btnAgoraNao.setFocusable(false);
		btnAgoraNao.setBorderPainted(false);

		//JButton btnAgoraNao = ViewUtil.criaBotao(220, 373, 170, 44, "Agora não");
		btnAgoraNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario.salvaCadastro(USUARIO);
			}
		});
		btnAgoraNao.setFocusable(false);
		frame.getContentPane().add(btnAgoraNao);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				CrieASenha.FRAME_SEGUINTE = frame;
			}
		});
		//
		
//		JLabel lblBackground = new JLabel("");
//        ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/wallpaper_gradient-pink-black-linear.png"));
//        lblBackground.setIcon(imgBackground);
//        lblBackground.setBounds(0, 0, 444, 802);
//        frame.getContentPane().add(lblBackground);
	}
}
