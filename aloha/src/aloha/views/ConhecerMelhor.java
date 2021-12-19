package aloha.views;

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

	public ConhecerMelhor(Usuario usuario) {
		USUARIO = usuario;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 508, 685);
		frame.setLocation(700, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// lbl 1
		JLabel lbl1 = new JLabel("Vamos nos conhecer melhor?");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Arial Narrow", Font.PLAIN, 35));
		lbl1.setBounds(42, 195, 418, 62);
		frame.getContentPane().add(lbl1);
		//
		
		// botao sim
		JButton btnSim = new JButton("Sim");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Gostos(USUARIO);
			}
		});
		btnSim.setOpaque(true);
		btnSim.setForeground(Color.BLACK);
		btnSim.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		btnSim.setContentAreaFilled(false);
		btnSim.setBorder(ViewUtil.BORDA_ROSA);
		btnSim.setBounds(42, 373, 188, 44);
		btnSim.setFocusable(false);
		frame.getContentPane().add(btnSim);
		//
		
		// botao nao
		JButton btnAgoraNao = new JButton("Agora não");
		btnAgoraNao.setOpaque(true);
		btnAgoraNao.setForeground(Color.BLACK);
		btnAgoraNao.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		btnAgoraNao.setContentAreaFilled(false);
		btnAgoraNao.setBorder(ViewUtil.BORDA_ROSA);
		btnAgoraNao.setBounds(272, 373, 188, 44);
		btnAgoraNao.setFocusable(false);
		frame.getContentPane().add(btnAgoraNao);
		//

		// botão voltar
		JLabel lblVoltar = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/botao_voltar.png"));
		lblVoltar.setIcon(img);
		lblVoltar.setBounds(0, 0, 37, 41);
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				CrieASenha.main(null);
			}
		});
		//
	}
}
