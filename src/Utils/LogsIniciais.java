package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Application.Main;

public class LogsIniciais {
	public File arquivoRegistro = new File("C:\\Manutenção/logs", "registros.txt");
	public File arquivoTransferencia = new File("C:\\Manutenção/logs", "transferencias.txt");

	public void carregarRegistros() throws IOException {
		FileReader fReader = new FileReader(arquivoRegistro);
		BufferedReader bReader = new BufferedReader(fReader);
		String row = "";
		while ((row  = bReader.readLine()) != null) {
			Main.registros += 1;
		}
		fReader.close();
		bReader.close();
	}
	
	public void carregarRegistros2() throws IOException {
		FileReader fReader = new FileReader(arquivoTransferencia);
		BufferedReader bReader = new BufferedReader(fReader);
		String row = "";
		while ((row  = bReader.readLine()) != null) {
			Main.registros += 1;
		}
		fReader.close();
		bReader.close();
	}
}
