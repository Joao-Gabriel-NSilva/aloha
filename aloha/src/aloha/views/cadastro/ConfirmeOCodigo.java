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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class ConfirmeOCodigo {

	private JFrame frame;
	private JTextField textField;
	private static Usuario USUARIO;
	private static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmeOCodigo window = new ConfirmeOCodigo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public ConfirmeOCodigo() {
		initialize();
	}

	public ConfirmeOCodigo(Usuario usuario, JFrame frameAnterior) {
		USUARIO = usuario;
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() {
		frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Confirme o código!");

		// text field código
		textField = ViewUtil.criaTextField(20, 212, 400, 60, null, 26);
		textField.setToolTipText("Código que lhe foi enviado");
		frame.getContentPane().add(textField);
		//

		// label confirme seu código
		JLabel lblConfirmeSeuCdigo = ViewUtil.criaJLabel(115, 50, 260, 62, "Confirme seu código!", 30);
		frame.getContentPane().add(lblConfirmeSeuCdigo);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				InformeTelefone.FRAME_SEGUINTE = frame;
			}
		});
		//

		// botão não recebeu
		JButton btnNoRecebeu = ViewUtil.criaBotao(165, 450, 115, 36, "Não recebeu?");
		btnNoRecebeu.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		frame.getContentPane().add(btnNoRecebeu);

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(160, 400, 140, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * confirma o código
					 */

					frame.setVisible(false);
					if(FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new InformeEmail(USUARIO, frame);
					}
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//
	}

}
