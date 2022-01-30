package aloha.DAO;

import java.awt.Color;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import aloha.modelo.Usuario;

public class Configuracoes {

	private Usuario usuarioConectado = null;
	private Color corAtualFundo = Color.WHITE;
	private Color corAtualLetras = Color.BLACK;

	public Configuracoes() {
		JSONParser parser = new JSONParser();
		JSONObject objJson;

		try {
			objJson = (JSONObject) parser.parse(new FileReader("src/main/resources/dados/configs.json"));

			this.corAtualFundo = objJson.get("corAtualFundo").equals("white") ? Color.WHITE : Color.DARK_GRAY;
			this.corAtualLetras = objJson.get("corAtualLetras").equals("white") ? Color.WHITE : Color.BLACK;
			this.usuarioConectado = objJson.get("usuarioConectado") != "null"
					? UsuarioDAO.achaUsuarioPorPK((String) objJson.get("usuarioConectado")) : null;

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
	
	public Configuracoes(Usuario usuario) {
		setUsuarioConectado(usuario);
	}

	public Usuario getUsuarioConectado() {
		return usuarioConectado;
	}

	public void setUsuarioConectado(Usuario usuario) {
		this.usuarioConectado = usuario;
		salvarConfigs();
	}

	public Color getCorAtualFundo() {
		return corAtualFundo;
	}

	public void setCorAtualFundo(Color cor) {
		corAtualFundo = cor;
		salvarConfigs();
	}

	public Color getCorAtualLetras() {
		return corAtualLetras;
	}

	public void setCorAtualLetras(Color cor) {
		corAtualLetras = cor;
		salvarConfigs();
	}

	@SuppressWarnings("unchecked")
	public void salvarConfigs() {
		JSONObject objJson = new JSONObject();

		String corFundo = getCorAtualFundo().equals(Color.WHITE) ? "white" : "darkGray";
		String corLetras = getCorAtualLetras().equals(Color.WHITE) ? "white" : "black";
		String usuarioConec = getUsuarioConectado() == null ? "null" : getUsuarioConectado().getArrouba();

		objJson.put("corAtualFundo", corFundo);
		objJson.put("corAtualLetras", corLetras);
		objJson.put("usuarioConectado", usuarioConec);

		try (FileWriter writer = new FileWriter("src/main/resources/dados/configs.json")) {
			try (PrintWriter pw = new PrintWriter(writer, true)) {
				pw.print(objJson.toJSONString());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
