package aloha.views.cadastro;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Vamos nos conhecer melhor?");

		// lbl 1
		JLabel lbl1 = ViewUtil.criaJLabel(50, 195, 418, 62, "Vamos nos conhecer melhor?", 30);
		frame.getContentPane().add(lbl1);
		//
		
		// botao sim
		JButton btnSim = ViewUtil.criaBotao(60, 373, 90, 44, "Sim");
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
		JButton btnAgoraNao = ViewUtil.criaBotao(220, 373, 170, 44, "Agora não");
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
	}
}
