package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class Gostos {

	private JFrame frame;
	private JTextField outraFesta;
	private JTextField outraMusica;
	private JTextField outraComida;
	private static Usuario USUARIO;
	private List<ArrayList<Object>> listas = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gostos window = new Gostos();
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
	public Gostos() {
		initialize();
	}

	public Gostos(Usuario usuario) {
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

		// lbl gostos
		JLabel lbl2 = new JLabel("Quais são os seus gostos?");
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setBounds(95, 45, 311, 62);
		frame.getContentPane().add(lbl2);
		//

		// lbl Festas
		JLabel lblFestas = new JLabel("Quais são os seus estilos de festa favoritos?");
		lblFestas.setHorizontalAlignment(SwingConstants.LEFT);
		lblFestas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblFestas.setBounds(45, 114, 411, 45);
		frame.getContentPane().add(lblFestas);
		//

		// check box estilos de festa
		ArrayList<Object> listaFesta = new ArrayList<>();
		listas.add(listaFesta);
		
		JCheckBox chboxRave = ViewUtil.criaCheckBox(28, 172, 68, 23, "Rave");
		frame.getContentPane().add(chboxRave);
		listaFesta.add(chboxRave);

		JCheckBox chboxFestival = ViewUtil.criaCheckBox(124, 172, 73, 23, "Festival");
		frame.getContentPane().add(chboxFestival);
		listaFesta.add(chboxFestival);

		JCheckBox chboxShow = ViewUtil.criaCheckBox(225, 172, 59, 23, "Show");
		frame.getContentPane().add(chboxShow);
		listaFesta.add(chboxShow);

		outraFesta = ViewUtil.criaTextField(312, 171, 150, 23, "Outra", 17);
		outraFesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraFesta.setFocusable(true);
				outraFesta.setText(null);
			}
		});
		frame.getContentPane().add(outraFesta);
		listaFesta.add(outraFesta);
		//

		// lbl musicas
		JLabel lblMusicas = new JLabel("Quais são os seus estilos de música favoritos?");
		lblMusicas.setHorizontalAlignment(SwingConstants.LEFT);
		lblMusicas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblMusicas.setBounds(39, 220, 423, 45);
		frame.getContentPane().add(lblMusicas);
		//

		// chech box musicas
		ArrayList<Object> listaMusicas = new ArrayList<>();
		listas.add(listaMusicas);
		
		JCheckBox chboxRap = ViewUtil.criaCheckBox(28, 277, 59, 23, "Rap");
		frame.getContentPane().add(chboxRap);
		listaMusicas.add(chboxRap);

		JCheckBox chboxFunk = ViewUtil.criaCheckBox(125, 277, 68, 23, "Funk");
		frame.getContentPane().add(chboxFunk);
		listaMusicas.add(chboxFunk);

		JCheckBox chboxSertanejo = ViewUtil.criaCheckBox(231, 277, 85, 23, "Sertanejo");
		frame.getContentPane().add(chboxSertanejo);
		listaMusicas.add(chboxSertanejo);

		JCheckBox chboxPagode = ViewUtil.criaCheckBox(359, 277, 97, 23, "Pagode");
		frame.getContentPane().add(chboxPagode);
		listaMusicas.add(chboxPagode);

		JCheckBox chboxPop = ViewUtil.criaCheckBox(28, 317, 63, 23, "Pop");
		frame.getContentPane().add(chboxPop);
		listaMusicas.add(chboxPop);

		outraMusica = ViewUtil.criaTextField(125, 317, 191, 23, "Outra", 17);
		outraMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraMusica.setFocusable(true);
				outraMusica.setText(null);
			}
		});
		frame.getContentPane().add(outraMusica);
		listaMusicas.add(outraMusica);
		//

		// lbl bebidas
		JLabel lblBebidas = new JLabel("Quais são as suas bebidas favoritas?");
		lblBebidas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBebidas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblBebidas.setBounds(76, 365, 341, 43);
		frame.getContentPane().add(lblBebidas);
		//

		// check box bebidas
		ArrayList<Object> listaBebidas = new ArrayList<>();
		listas.add(listaBebidas);
		
		JCheckBox chboxCerveja = ViewUtil.criaCheckBox(29, 415, 85, 23, "Cerveja");
		frame.getContentPane().add(chboxCerveja);
		listaBebidas.add(chboxCerveja);

		JCheckBox chboxAlcolicas = ViewUtil.criaCheckBox(136, 415, 97, 23, "Alcólicas");
		chboxAlcolicas.setToolTipText("Bebidas alocólicas em geral. Vodka, Uísque, etc.");
		frame.getContentPane().add(chboxAlcolicas);
		listaBebidas.add(chboxAlcolicas);

		JCheckBox chboxRefrigerante = ViewUtil.criaCheckBox(255, 415, 106, 23, "Refrigerante");
		frame.getContentPane().add(chboxRefrigerante);
		listaBebidas.add(chboxRefrigerante);

		JCheckBox chboxAgua = ViewUtil.criaCheckBox(388, 415, 68, 23, "Água");
		frame.getContentPane().add(chboxAgua);
		listaBebidas.add(chboxAgua);
		//

		// lbl comidas
		JLabel lblComidas = new JLabel("Quais suas comidas favoritas?");
		lblComidas.setHorizontalAlignment(SwingConstants.LEFT);
		lblComidas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblComidas.setBounds(102, 450, 289, 39);
		frame.getContentPane().add(lblComidas);
		//

		// check box comida
		ArrayList<Object> listaComidas = new ArrayList<>();
		listas.add(listaComidas);
		
		JCheckBox chboxEspetinho = ViewUtil.criaCheckBox(29, 504, 97, 23, "Espetinho");
		frame.getContentPane().add(chboxEspetinho);
		listaComidas.add(chboxEspetinho);

		JCheckBox chboxComidaBoteco = ViewUtil.criaCheckBox(166, 504, 159, 23, "Comida de boteco");
		frame.getContentPane().add(chboxComidaBoteco);
		listaComidas.add(chboxComidaBoteco);

		JCheckBox chboxLanche = ViewUtil.criaCheckBox(359, 504, 97, 23, "Lanche");
		frame.getContentPane().add(chboxLanche);
		listaComidas.add(chboxLanche);

		JCheckBox chboxPizza = ViewUtil.criaCheckBox(28, 541, 97, 23, "Pizza");
		frame.getContentPane().add(chboxPizza);
		listaComidas.add(chboxPizza);

		outraComida = ViewUtil.criaTextField(166, 541, 159, 23, "Outra", 17);
		outraComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraComida.setFocusable(true);
				outraComida.setText(null);
			}
		});
		frame.getContentPane().add(outraComida);
		listaComidas.add(outraComida);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(35, 590, 442, 44, "Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (ArrayList<Object> lista : listas) {
					for (Object obj : lista) {
						try {
							if(((JCheckBox) obj).isSelected()) {
								USUARIO.getGostos().add(((JCheckBox) obj).getText());
							}
						} catch (ClassCastException ex) {
							if(!((JTextField) obj).getText().equals("Outra") & 
									!((JTextField) obj).getText().trim().isEmpty()) {
								USUARIO.getGostos().add(((JTextField) obj).getText());
							}
						}
					}
				}
				System.out.println(USUARIO.getGostos());
			}
		});
		frame.getContentPane().add(btnAvancar);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				ConhecerMelhor.main(null);
			}
		});
		//

	}
}
