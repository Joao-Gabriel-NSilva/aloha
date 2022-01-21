package aloha.views.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import aloha.modelo.Usuario;
import aloha.util.TarefaAtualizaLabel;
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;

public class InformeNomeENascimento {

	private JFrame frame;
	private JTextField textFieldNome;
	private JButton btnAvancar;
	public static JFrame FRAME_SEGUINTE;
	public static InformeApelido FRAME_ANTERIOR;
	private static Usuario USUARIO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeNomeENascimento window = new InformeNomeENascimento();
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
	public InformeNomeENascimento() {
		initialize();
	}

	public InformeNomeENascimento(Usuario usuario, InformeApelido ia) {
		this.USUARIO = usuario;
		FRAME_ANTERIOR = ia;
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
		frame.setTitle("Nome e data de nascimento");

		// label nome
		JLabel lblInformeSeuNome = new JLabel("Informe seu nome verdadeiro. Não utilize");
		lblInformeSeuNome.setBackground(Color.BLACK);
		lblInformeSeuNome.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblInformeSeuNome.setForeground(Color.BLACK);
		lblInformeSeuNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeSeuNome.setBounds(10, 180, 435, 36);
		// JLabel lblInformeSeuNome = ViewUtil.criaJLabel(45, 169, 400, 36, "Informe seu
		// nome verdadeiro. Não utilize o",
		// 25);
		frame.getContentPane().add(lblInformeSeuNome);

		JLabel lblInformeSeuNome2 = new JLabel("o nome de terceiros.");
		lblInformeSeuNome2.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblInformeSeuNome2.setForeground(Color.BLACK);
		lblInformeSeuNome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeSeuNome2.setBounds(10, 211, 435, 36);
		// JLabel lblInformeSeuNome2 = ViewUtil.criaJLabel(45, 200, 400, 36, "nome de
		// terceiros.", 25);
		frame.getContentPane().add(lblInformeSeuNome2);
		//

		// text fied nome
		textFieldNome = new JTextField("Nome e sobrenome");
		textFieldNome.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldNome.setBounds(28, 261, 400, 70);
		textFieldNome.setColumns(10);
		textFieldNome.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		// textFieldNome = ViewUtil.criaTextField(20, 312, 400, 65, "Primeiro nome",
		// 25);
		textFieldNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setFocusable(true);
				if (textFieldNome.getText().equals("Nome e sobrenome")) {
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

		// lbl data de nascimento
		JLabel lblInformeData = new JLabel("Informe usa data de nascimento.");
		lblInformeData.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeData.setForeground(Color.BLACK);
		lblInformeData.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblInformeData.setBackground(Color.BLACK);
		lblInformeData.setBounds(10, 394, 435, 36);
		frame.getContentPane().add(lblInformeData);
		//
		
		// calendario
		JDateChooser calendario = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		calendario.setDate(new Date());
		calendario.setBounds(38, 469, 376, 70);
		calendario.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		calendario.setLocale(new Locale("pt", "br"));
		calendario.setSelectableDateRange(new Date("01/01/1950"), new Date());
		calendario.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		calendario.setBackground(Color.WHITE);
		calendario.getDateEditor().getUiComponent().setToolTipText("dia/mês/ano");
		calendario.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				((JTextFieldDateEditor) e.getSource()).selectAll();
			}
		});
		frame.getContentPane().add(calendario);
		//

		// botão avançar
		btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAvancar.setBounds(157, 655, 140, 44);
		btnAvancar.setFocusable(false);
		btnAvancar.setBorderPainted(false);
		// JButton btnAvancar = ViewUtil.criaBotao(160, 550, 140, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setNome(textFieldNome.getText());
					
					String dataFormatada = new SimpleDateFormat("dd-MM-yyyy").format(calendario.getDate());
					DateFormat df = DateFormat.getInstance();
					
					try {
						USUARIO.setDataDeNascimento(df.parse(dataFormatada));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					frame.setVisible(false);

					if (FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new InformeTelefone(USUARIO, frame);
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
				if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
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
				InformeApelido.FRAME_SEGUINTE = frame;
				frame.setVisible(false);

				Runnable tarefa = new TarefaAtualizaLabel(FRAME_ANTERIOR.getLblAloha(),
						FRAME_ANTERIOR.getTextFieldApelido());
				TarefaAtualizaLabel.roda = true;
				FRAME_ANTERIOR.setThread(new Thread(tarefa, "Thread atualizador de label"));
				FRAME_ANTERIOR.getThread().start();
				FRAME_ANTERIOR.getFrame().setVisible(true);
			}
		});
		//
	}
}
