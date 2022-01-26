package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Application.Main;
import Utils.Alerts;
import entities.RegistroTransferencia;
import javafx.scene.control.Alert.AlertType;

public class TelaTransferenciaController {
	File arq = new File("C:\\Manutenção/logs", "transferencias.txt");
	
	public void salvar(RegistroTransferencia r) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(arq,true));
		String conteudo = r.toString();
		bWriter.append(conteudo+"\n");
		bWriter.close();
		Main.registros += 1;
		Alerts.showAlert(null, null, "Registro Salvo!", AlertType.INFORMATION);
		Main.mudarScene(0);
	}
}
