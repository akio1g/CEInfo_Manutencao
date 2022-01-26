package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import Application.Main;
import Utils.Alerts;
import entities.Registro;
import javafx.scene.control.Alert.AlertType;

public class TelaSaidaController {
// arrumar tudo ensap orara
	
	public File arqSaida = new File("C:\\Manutenção/logs", "registros.txt");

	public void salvar(int codigo, LocalDate dataSaida, String servRealizado, String obs) throws IOException {

		for (Registro r : Main.listaRegistros) {
			if (r.getCodigo() == codigo) {
				r.setDataSaida(dataSaida);
				r.setServicoRealizado(servRealizado);
				r.setObs(obs);
				System.out.println(r.toString());
			}
		}
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(arqSaida));
		for (Registro rs : Main.listaRegistros) {
			String conteudo = rs.toString();
			bWriter.append(conteudo + "\n");
		}
		bWriter.close();
		Alerts.showAlert(null, null, "Registro Salvo!", AlertType.INFORMATION);
		Main.mudarScene(0);
	}

	public void pesquisar(String numSerie) throws IOException {
		boolean opc = false;
		FileReader fReader = new FileReader(arqSaida);
		BufferedReader bReader = new BufferedReader(fReader);
		String row = "";
		while ((row = bReader.readLine()) != null) {
			String[] linhaSeparada = row.split(",");
			if (numSerie.equals(linhaSeparada[1]) && linhaSeparada[6].equals(null)) {
				opc = true;
			}
		}

		if (!opc) {
			Alerts.showAlert(null, null, "Número de Série não encontrado", AlertType.ERROR);
		}
		fReader.close();
		bReader.close();
	}

}
