package aloha.views;

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

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class InformeTelefone {

	private JFrame frame;
	private JTextField textFieldTelefone;
	private JComboBox<String> comboBoxDDD;
	private static Usuario USUARIO;

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

	public InformeTelefone(Usuario novo_usuario) {
		USUARIO = novo_usuario;
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

		// label 1
		JLabel lblNewLabel = new JLabel("Qual é o seu telefone?");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 50, 335, 62);
		frame.getContentPane().add(lblNewLabel);
		//

		// label 2 e 3
		JLabel lbl2 = new JLabel("Precisamos te enviar um código de "
				+ "confirmação para garantir");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl2.setBounds(22, 123, 447, 41);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("que só você terá acesso á sua conta.");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl3.setBounds(22, 151, 447, 41);
		frame.getContentPane().add(lbl3);
		//
		
		// text field telefone
		textFieldTelefone = new JTextField();
		textFieldTelefone.setToolTipText("Número do telefone.");
		textFieldTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBorder(ViewUtil.BORDA_ROSA);
		textFieldTelefone.setBounds(95, 279, 374, 44);
		frame.getContentPane().add(textFieldTelefone);
		//
		
		// combo box ddd
		comboBoxDDD = new JComboBox<String>();
		comboBoxDDD.setToolTipText("DDD");
		comboBoxDDD.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		comboBoxDDD.setBorder(ViewUtil.BORDA_ROSA);
		comboBoxDDD.setBounds(23, 279, 62, 44);
		comboBoxDDD.addItem("");
		frame.getContentPane().add(comboBoxDDD);
		
		try {
			Scanner scanner = new Scanner(new File("dados/DDDs.csv"), "UTF-8");
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
		JButton btnEnviar = ViewUtil.criaBotao(22, 385, 447, 44, "Enviar");
		frame.getContentPane().add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setTelefone(comboBoxDDD.getSelectedItem() + textFieldTelefone.getText());
					/*
					 * envia sms
					 */
					frame.setVisible(false);
					new ConfirmeOCodigo(USUARIO);
				} catch(RuntimeException ex) {
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
				InformeNome.main(null);
			}
		});
		//
	}
}
