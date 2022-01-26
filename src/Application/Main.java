package Application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Boundary.TelaMenu;
import Boundary.TelaRegistro;
import Boundary.TelaSaida;
import Boundary.TelaTransferencia;
import Utils.LogsIniciais;
import entities.Registro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage stage;
	public static Scene scn = null;

	public static List<Registro> listaRegistros = new ArrayList<>();
	public static TelaMenu tMenu = new TelaMenu();
	public static TelaRegistro tRegistro = new TelaRegistro();
	public static TelaTransferencia tTransferencia = new TelaTransferencia();
	public static TelaSaida tSaida = new TelaSaida();
	public static LogsIniciais logs = new LogsIniciais();
	public static int registros;

	public static void main(String[] args) {
		try {
			logs.carregarRegistros();
			logs.carregarRegistros2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		stage = stg;
		stage.setTitle("Manutenção");
		mudarScene(0);
		stg.show();
	}

	public static void mudarScene(int index) {
		switch (index) {
		case 0: // tela Principal
			scn = tMenu.telaMenu();
			break;
		case 1: // tela Registro Computador
			scn = tRegistro.telaRegistro();
			break;
		case 2: // tela Transferencia
			scn = tTransferencia.telaTransferencia();
			break;
		case 3: // tela Consulta
			// scn = tConsulta.telaConsulta();
			break;
		case 4: // tela Saida computador
			scn = tSaida.telaSaida();
			break;
		}
		stage.setScene(scn);
	}
}
