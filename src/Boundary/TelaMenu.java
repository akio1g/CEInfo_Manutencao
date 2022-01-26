package Boundary;

import Application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TelaMenu {
	Label titulo = new Label("MANUTENÇÃO");
	Button btRegistroEntrada = new Button("Registrar Entrada de computador");
	Button btTransferencia = new Button("Transferência de Unidade");
	Button btConsulta = new Button("Consultar Computadores");
	Button btRegistroSaida = new Button("Registrar Saída");
	Insets ins = new Insets(20,10,0,0);
	
	public Scene telaMenu() {		

		VBox pPrincipal = new VBox(50);
		VBox pBotoes = new VBox();
		titulo.setFont(Font.font(24.0));
		btRegistroEntrada.setPrefHeight(37.0);
		btRegistroEntrada.setPrefWidth(300.0);
		btTransferencia.setPrefHeight(37.0);
		btTransferencia.setPrefWidth(300.0);
		btConsulta.setPrefHeight(37.0);
		btConsulta.setPrefWidth(300.0);
		btRegistroSaida.setPrefHeight(37.0);
		btRegistroSaida.setPrefWidth(300.0);
		VBox.setMargin(btRegistroEntrada, ins);
		VBox.setMargin(btTransferencia, ins);
		VBox.setMargin(btConsulta, ins);
		VBox.setMargin(btRegistroSaida, ins);
		
		pBotoes.setAlignment(Pos.CENTER);
		pBotoes.getChildren().addAll(btRegistroEntrada, btTransferencia, btConsulta, btRegistroSaida);
		
		pPrincipal.setAlignment(Pos.CENTER);
		pPrincipal.getChildren().addAll(titulo,pBotoes);
		
		adicionarBotoes();
		
		Scene scn = new Scene(pPrincipal, 400,500);
		return scn;
	}
	
	private void adicionarBotoes() {
		btRegistroEntrada.setOnAction((e) -> Main.mudarScene(1));
		btTransferencia.setOnAction((e) -> Main.mudarScene(2));
		btConsulta.setOnAction((e) -> Main.mudarScene(3));
		btRegistroSaida.setOnAction((e) -> Main.mudarScene(4));
	}
}
