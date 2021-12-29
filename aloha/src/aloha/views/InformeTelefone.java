package aloha.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;
import aloha.util.TarefaAtualizaLabel;

public class InformeTelefone {

	private JFrame frame;
	private JTextField textFieldTelefone;
	private JComboBox<String> comboBoxDDD;
	private static Usuario USUARIO;
	private static InformeNome FRAME_ANTERIOR;

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

	public InformeTelefone(Usuario novo_usuario, InformeNome frameAnterior) {
		USUARIO = novo_usuario;
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Informe seu número!");

		// label 1
		JLabel lblNewLabel = ViewUtil.criaJLabel(100, 50, 335, 62, "Qual é o seu telefone?", 30);
		frame.getContentPane().add(lblNewLabel);
		//

		// label 2 e 3
		JLabel lbl2 = ViewUtil.criaJLabel(30, 123, 447, 41, "Precisamos te enviar um código de "
				+ "confirmação para", 20);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = ViewUtil.criaJLabel(30, 151, 447, 41, "garantir que só você terá acesso á sua conta.", 20);
		frame.getContentPane().add(lbl3);
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
		JButton btnEnviar = ViewUtil.criaBotao(170, 500, 120, 44, "Enviar");
		frame.getContentPane().add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setTelefone(comboBoxDDD.getSelectedItem() + textFieldTelefone.getText());
					/*
					 * envia sms
					 */
					frame.setVisible(false);
					new ConfirmeOCodigo(USUARIO, frame);
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
				Runnable tarefa = new TarefaAtualizaLabel(FRAME_ANTERIOR.getLblAloha(), FRAME_ANTERIOR.getTextFieldNome());
				TarefaAtualizaLabel.roda = true;
				FRAME_ANTERIOR.setThread(new Thread(tarefa, "Thread atualizador de label"));
				FRAME_ANTERIOR.getThread().start();
				FRAME_ANTERIOR.getFrame().setVisible(true);
			}
		});
		//
	}
}
