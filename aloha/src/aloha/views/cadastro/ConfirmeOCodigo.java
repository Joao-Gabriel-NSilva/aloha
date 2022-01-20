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
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;
import aloha.views.main.ViewLogin;

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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Confirme o código!");

		// text field código
		textField = new JTextField();
		textField.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textField.setBounds(27, 212, 400, 60);
		textField.setColumns(10);
		textField.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		//textField = ViewUtil.criaTextField(20, 212, 400, 60, null, 26);
		textField.setToolTipText("Código que lhe foi enviado");
		frame.getContentPane().add(textField);
		//

		// label confirme seu código
		JLabel lblConfirmeSeuCdigo = new JLabel("Confirme seu código!");
		lblConfirmeSeuCdigo.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblConfirmeSeuCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmeSeuCdigo.setBounds(5, 50, 444, 62);
		lblConfirmeSeuCdigo.setForeground(Color.BLACK);
		//JLabel lblConfirmeSeuCdigo = ViewUtil.criaJLabel(115, 50, 260, 62, "Confirme seu código!", 30);
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
		JButton btnNoRecebeu = new JButton("Não recebeu?");
		btnNoRecebeu.setOpaque(true);
		btnNoRecebeu.setContentAreaFilled(false);
		btnNoRecebeu.setForeground(Color.BLACK);
		btnNoRecebeu.setBounds(162, 450, 130, 36);
		btnNoRecebeu.setFocusable(false);
		btnNoRecebeu.setBorderPainted(false);
		//JButton btnNoRecebeu = ViewUtil.criaBotao(165, 450, 115, 36, "Não recebeu?");
		btnNoRecebeu.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		btnNoRecebeu.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnNoRecebeu.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnNoRecebeu.setForeground(Color.BLACK);
        	}
        });
		frame.getContentPane().add(btnNoRecebeu);

		// botão avançar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setBounds(155, 400, 144, 44);
		btnAvancar.setFocusable(false);
		btnAvancar.setBorderPainted(false);
		//JButton btnAvancar = ViewUtil.criaBotao(160, 400, 140, 44, "Avançar");
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
		
//		JLabel lblBackground = new JLabel("");
//        ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/wallpaper_gradient-pink-black-linear.png"));
//        lblBackground.setIcon(imgBackground);
//        lblBackground.setBounds(0, 0, 454, 812);
//        frame.getContentPane().add(lblBackground);
	}

}
