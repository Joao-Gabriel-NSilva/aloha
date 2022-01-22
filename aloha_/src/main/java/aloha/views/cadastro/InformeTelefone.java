package aloha.views.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.modelo.Teste;
import aloha.modelo.Usuario;
import aloha.util.ViewUtil;
import aloha.util.TarefaAtualizaLabel;

public class InformeTelefone {

	private JFrame frame;
	private JTextField textFieldTelefone;
	private JComboBox<String> comboBoxDDD;
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
					InformeTelefone window = new InformeTelefone();
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
	public InformeTelefone() {
		initialize();
	}

	public InformeTelefone(Usuario novo_usuario, JFrame frameAnterior) {
		USUARIO = novo_usuario;
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
		// frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Informe seu número!");

		// label 1
		JLabel lbl1 = new JLabel("Qual é o seu telefone?");
		lbl1.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(59, 50, 335, 62);
		lbl1.setForeground(Color.BLACK);
		// JLabel lblNewLabel = ViewUtil.criaJLabel(100, 50, 335, 62, "Qual é o seu
		// telefone?", 30);
		frame.getContentPane().add(lbl1);
		//

		// label 2 e 3
		JLabel lbl2 = new JLabel("Precisamos te enviar um código de confirmação");
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(3, 123, 447, 41);
		lbl2.setForeground(Color.BLACK);
		// JLabel lbl2 = ViewUtil.criaJLabel(30, 123, 447, 41, "Precisamos te enviar um
		// código de "
		// + "confirmação para", 20);
		frame.getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("para garantir que só você terá acesso");
		lbl3.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(3, 151, 447, 41);
		lbl3.setForeground(Color.BLACK);
		// JLabel lbl3 = ViewUtil.criaJLabel(30, 151, 447, 41, "garantir que só você
		// terá acesso á sua conta.", 20);
		frame.getContentPane().add(lbl3);

		JLabel lbl4 = new JLabel(" á sua conta.");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl4.setBounds(3, 192, 447, 41);
		frame.getContentPane().add(lbl4);
		//

		// text field telefone
		textFieldTelefone = ViewUtil.criaTextField(95, 279, 334, 60, null, 26);
		textFieldTelefone.setToolTipText("Seu número do telefone.");
		frame.getContentPane().add(textFieldTelefone);
		//

		// combo box ddd
		comboBoxDDD = new JComboBox<String>();
		comboBoxDDD.setToolTipText("DDD");
		comboBoxDDD.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		comboBoxDDD.setBounds(23, 279, 62, 60);
		comboBoxDDD.addItem("");
		frame.getContentPane().add(comboBoxDDD);

		try {
			Scanner scanner = new Scanner(new File(Teste.class.getResource("/dados/DDDs.csv").getFile()));
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Scanner linhaScanner = new Scanner(linha);
				linhaScanner.useDelimiter(";");
				String ddd = linhaScanner.next();
				comboBoxDDD.addItem(ddd);

				linhaScanner.close();
			}
			scanner.close();
		} catch (Exception e) {
		}
		//

		// botão avançar
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setOpaque(true);
		btnEnviar.setContentAreaFilled(false);
		btnEnviar.setForeground(Color.BLACK);
		btnEnviar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnEnviar.setBounds(167, 500, 120, 44);
		btnEnviar.setFocusable(false);
		btnEnviar.setBorderPainted(false);
		//JButton btnEnviar = ViewUtil.criaBotao(170, 500, 120, 44, "Enviar");
		frame.getContentPane().add(btnEnviar);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setTelefone(comboBoxDDD.getSelectedItem() + textFieldTelefone.getText());
					/*
					 * envia sms
					 */
					frame.setVisible(false);
					if (FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new ConfirmeOCodigo(USUARIO, frame);
					}
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEnviar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnEnviar.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			btnEnviar.setForeground(Color.BLACK);
        		} else {
        			btnEnviar.setForeground(Color.WHITE);
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
				InformeApelido.FRAME_SEGUINTE = frame;
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
			}
		});
		//

//		JLabel lblBackground = new JLabel("");
//		ImageIcon imgBackground = new ImageIcon(
//				this.getClass().getResource("/wallpaper_gradient-pink-black-linear.png"));
//		lblBackground.setIcon(imgBackground);
//		lblBackground.setBounds(0, 0, 465, 812);
//		frame.getContentPane().add(lblBackground);
	}
}
