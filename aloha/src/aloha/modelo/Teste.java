package aloha.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Teste {

	public static void main(String args[]) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("dados/DDDs.csv"), "UTF-8");
			
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Scanner linhaScanner = new Scanner(linha);
				linhaScanner.useDelimiter(";");
				String ddd = linhaScanner.next();
				System.out.println(ddd);

				linhaScanner.close();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
