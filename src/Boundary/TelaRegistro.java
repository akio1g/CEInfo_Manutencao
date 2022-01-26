package Boundary;

import java.io.IOException;
import java.time.LocalDate;

import Application.Main;
import Controller.TelaRegistroController;
import entities.Equipamentos;
import entities.Registro;
import entities.Unidades;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaRegistro {
	TelaRegistroController trController = new TelaRegistroController();
	
	Label lblCodigo = new Label("Código:");
	Label lblNumSerie = new Label("Número de Série:");
	Label lblUnidade = new Label("Unidade:");
	Label lblEquipamento = new Label("Equipamento:");
	Label lblDataChegada = new Label("Data de Chegada:");
	Label lblDefeito = new Label("Defeito:");
	TextField tfCodigo = new TextField();
	TextField tfNumSerie = new TextField();
	ComboBox<Unidades> cbUnidade = new ComboBox<>();
	ComboBox<Equipamentos> cbEquipamento = new ComboBox<>();
	DatePicker dataChegada = new DatePicker(LocalDate.now());
	TextArea defeito = new TextArea();
	Button btSalvar = new Button("Salvar");
	Button btVoltar = new Button("Voltar");
	
	public Scene telaRegistro() {
		VBox telaPrincipal = new VBox();
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 = new HBox();
		HBox hb6 = new HBox(7);
		hb1.setPrefSize(600,50);
		hb1.getChildren().addAll(lblCodigo,tfCodigo,lblNumSerie,tfNumSerie);
		hb1.setPadding(new Insets(25,0,40,0));
		lblCodigo.setPadding(new Insets(5,10,0,10));
		tfCodigo.setPrefSize(79, 25);
		lblNumSerie.setPrefSize(125,25);
		lblNumSerie.setPadding(new Insets(5,10,0,10));
		tfNumSerie.setPrefSize(145,25);
		tfCodigo.setEditable(false);
		tfCodigo.setText(Integer.toString(Main.registros+1));
		
		hb2.setPrefSize(600, 50);
		hb2.getChildren().addAll(lblUnidade, cbUnidade);
		lblUnidade.setPadding(new Insets(5,10,0,0));
		cbUnidade.setPrefSize(286, 25);
		hb2.setPadding(new Insets(0,0,0,10));
		
		
		hb3.setPrefSize(600,48);
		hb3.setPadding(new Insets(0,0,0,10));
		hb3.getChildren().addAll(lblEquipamento, cbEquipamento);
		lblEquipamento.setPadding(new Insets(5,10,0,0));
		cbEquipamento.setPrefSize(286,25);
		
		hb4.setPrefSize(600,48);
		hb4.setPadding(new Insets(0,0,0,10));
		hb4.getChildren().addAll(lblDataChegada, dataChegada);
		lblDataChegada.setPadding(new Insets(5,10,0,0));
		
		hb5.setPrefSize(580,84);
		hb5.setPadding(new Insets(0,0,0,10));
		hb5.getChildren().addAll(lblDefeito, defeito);
		lblDefeito.setPadding(new Insets(5,10,0,0));
		defeito.setPrefSize(448,58);
		
		hb6.setPrefSize(580,48);
		hb6.getChildren().addAll(btSalvar, btVoltar);
		btSalvar.setPrefSize(66,25);
		btVoltar.setPrefSize(66,25);
		hb6.setPadding(new Insets(30,0,0,10));
		
		telaPrincipal.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,hb6);
		
		adicionarBotoes();
		adicionarComboBox();
		
		Scene scn = new Scene(telaPrincipal,580,400);
		return scn;
	}
	
	private void adicionarBotoes() {
		btSalvar.setOnAction((e) -> {
			try {
				trController.salvar(guardarRegistro());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Main.mudarScene(0);
		});
		btVoltar.setOnAction((e) -> Main.mudarScene(0));
	}
	
	public Registro guardarRegistro() {
		Registro r = new Registro();
		
		r.setCodigo(Integer.parseInt(tfCodigo.getText()));
		r.setNumSerie(tfNumSerie.getText());
		r.setUnidade(cbUnidade.getValue());
		r.setEquipamento(cbEquipamento.getValue());
		r.setDataEntrada(dataChegada.getValue());
		r.setDefeito(defeito.getText());
		r.setDataSaida(null);
		r.setServicoRealizado(null);
		r.setObs(null);
		
		return r;
	}
	
	
	
	private void adicionarComboBox() {
		cbUnidade.getItems().addAll(Unidades.values());
		cbEquipamento.getItems().addAll(Equipamentos.values());
	}
}
