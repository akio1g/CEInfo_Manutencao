package entities;

import java.time.LocalDate;

public class RegistroTransferencia {

	private int codigo;
	private String numSerie;
	private Equipamentos equipamento;
	private Unidades unidade;
	private LocalDate dataSaida;
	
	public RegistroTransferencia() {
	
	}
	
	public RegistroTransferencia(int codigo, String numSerie, Equipamentos equipamento, Unidades unidade,
			LocalDate dataSaida) {
		super();
		this.codigo = codigo;
		this.numSerie = numSerie;
		this.equipamento = equipamento;
		this.unidade = unidade;
		this.dataSaida = dataSaida;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public Equipamentos getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamentos equipamento) {
		this.equipamento = equipamento;
	}

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	@Override
	public String toString() {
		return codigo + "," + numSerie + "," + equipamento
				+ "," + unidade + "," + dataSaida;
	}
	
	
}
