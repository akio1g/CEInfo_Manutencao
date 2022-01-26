package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Application.Main;
import Utils.Alerts;
import entities.Registro;
import javafx.scene.control.Alert.AlertType;

public class TelaRegistroController {
	File arq = new File("C:\\Manutenção/logs", "registros.txt");
	
	public void salvar(Registro r) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(arq,true));
		String conteudo = r.toString();
		bWriter.append(conteudo+"\n");
		bWriter.close();
		Main.registros += 1;
		Main.listaRegistros.add(r);
		Alerts.showAlert(null, null, "Registro Salvo!", AlertType.INFORMATION);
		Main.mudarScene(0);
	}
}
