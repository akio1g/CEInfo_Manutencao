package Boundary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import Application.Main;
import Controller.TelaSaidaController;
import Utils.Alerts;
import entities.Equipamentos;
import entities.Registro;
import entities.Unidades;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaSaida {
	TelaSaidaController tsController = new TelaSaidaController();
	Label lblNumSerie = new Label("Número de Série: ");
	TextField tfNumSerie = new TextField();
	Button btPesquisar = new Button("Pesquisar");
	Label lblDataSaida = new Label("Data de saída:");
	DatePicker dpData = new DatePicker(LocalDate.now());
	Label lblServico = new Label("Serviço Realizado:");
	TextArea taServico = new TextArea();
	Label lblObservacao = new Label("Observação:");
	TextArea taObservacao = new TextArea();
	Button btSalvar = new Button("Salvar");
	Button btVoltar = new Button("Voltar");
	// COLOCAR UM ALERTA PERGUNTANDO SE DESEJA IMPRIMIR AO CLICAR NO BOTAO SALVAR
	
	public Scene telaSaida() {
		VBox tPrincipal = new VBox(10);
		HBox hb1 = new HBox(7);
		HBox hb2 = new HBox(7);
		HBox hb3 = new HBox(7);
		HBox hb4 = new HBox(7);
		HBox hb5 = new HBox(7);
		hb1.getChildren().addAll(lblNumSerie,tfNumSerie,btPesquisar);
		hb2.getChildren().addAll(lblDataSaida, dpData);
		hb3.getChildren().addAll(lblServico,taServico);
		hb4.getChildren().addAll(lblObservacao, taObservacao);
		hb5.getChildren().addAll(btSalvar, btVoltar);
		hb5.setPadding(new Insets(10,0,0,450));
		
		tPrincipal.getChildren().addAll(hb1,hb2,hb3,hb4,hb5);
		tPrincipal.setPadding(new Insets(10,10,10,10));
		
		adicionarBotoes();
		
		Scene scn = new Scene(tPrincipal,600,350);
		return scn;
	}
	
	private void adicionarBotoes() {
		btPesquisar.setOnAction((e) -> {
			try {
				tsController.pesquisar(tfNumSerie.getText());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		btSalvar.setOnAction((e) -> {
			try {
				tsController.salvar(Main.registros+1, dpData.getValue(), taServico.getText(), taObservacao.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btVoltar.setOnAction((e) -> Main.mudarScene(0));
	}
	
	public int guardarRegistro(String numSerie) {
		int codigoRegistro = 0;
		for (Registro p: Main.listaRegistros) {
			if (p.getNumSerie() == numSerie && p.getDataSaida() == null) {
				codigoRegistro = p.getCodigo();
			}
		}
		return codigoRegistro;
	}
	
}
