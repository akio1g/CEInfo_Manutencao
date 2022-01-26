package Boundary;

import java.io.IOException;
import java.time.LocalDate;

import Application.Main;
import Controller.TelaTransferenciaController;
import entities.Equipamentos;
import entities.RegistroTransferencia;
import entities.Unidades;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaTransferencia {
	TelaTransferenciaController ttController = new TelaTransferenciaController();
	Label lblUnidade = new Label("Unidade Transferida:");
	ComboBox<Unidades> cbUnidade = new ComboBox<>();
	Label lblDataSaida = new Label("Data de Saída:");
	DatePicker dtSaida = new DatePicker(LocalDate.now());
	Label lblEquipamento = new Label("Equipamento:");
	ComboBox<Equipamentos> cbEquipamento = new ComboBox<>();
	Label lblNumSerie = new Label("Número de Série");
	TextField tfNumSerie = new TextField();
	Button btSalvar = new Button("Salvar");
	Button btVoltar = new Button("Voltar");

	public Scene telaTransferencia() {

		VBox telaPrincipal = new VBox(10);
		HBox hb1 = new HBox(10);
		HBox hb2 = new HBox(10);
		HBox hb3 = new HBox(10);
		HBox hb4 = new HBox(10);
		HBox hb5 = new HBox(7);
		
		telaPrincipal.setPadding(new Insets(10, 10, 10, 10));

		hb1.getChildren().addAll(lblUnidade, cbUnidade);
		cbUnidade.setPrefSize(300, 20);
		lblUnidade.setPadding(new Insets(5, 0, 0, 0));

		hb2.setPadding(new Insets(30, 0, 0, 0));
		hb2.getChildren().addAll(lblDataSaida, dtSaida);
		lblDataSaida.setPadding(new Insets(5, 0, 0, 0));

		hb3.getChildren().addAll(lblEquipamento, cbEquipamento);
		cbEquipamento.setPrefSize(300, 20);
		lblEquipamento.setPadding(new Insets(5, 0, 0, 0));

		hb4.getChildren().addAll(lblNumSerie, tfNumSerie);
		lblNumSerie.setPadding(new Insets(5, 0, 0, 0));

		hb5.setPadding(new Insets(20, 0, 0, 0));
		hb5.getChildren().addAll(btSalvar, btVoltar);

		telaPrincipal.getChildren().addAll(hb1, hb2, hb3, hb4, hb5);

		adicionarComboBox();
		adicionarBotoes();

		Scene scn = new Scene(telaPrincipal, 500, 250);
		return scn;
	}
	
	private void adicionarBotoes() {
		btSalvar.setOnAction((e) -> {
			try {
				ttController.salvar(guardarRegistro());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Main.mudarScene(0);
		});
		btVoltar.setOnAction((e) -> Main.mudarScene(0));
	}
	
	public RegistroTransferencia guardarRegistro() {
		RegistroTransferencia rt = new RegistroTransferencia();
		
		rt.setCodigo(Main.registros+1);
		rt.setNumSerie(tfNumSerie.getText());
		rt.setUnidade(cbUnidade.getValue());
		rt.setEquipamento(cbEquipamento.getValue());
		rt.setDataSaida(dtSaida.getValue());
		
		return rt;
	}
	
	private void adicionarComboBox() {
		cbUnidade.getItems().addAll(Unidades.values());
		cbEquipamento.getItems().addAll(Equipamentos.values());
	}
	
}
