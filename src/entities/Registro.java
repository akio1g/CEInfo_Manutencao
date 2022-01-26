package entities;

import java.time.LocalDate;

public class Registro {
	private int codigo;
	private String numSerie;
	private Unidades unidade;
	private Equipamentos equipamento;
	private LocalDate dataEntrada;
	private String defeito;
	private LocalDate dataSaida;
	private String servicoRealizado;
	private String obs;
	
	public Registro(int codigo, String numSerie, Unidades unidade, Equipamentos equipamento, LocalDate dataEntrada,
			String defeito, LocalDate dataSaida, String servicoRealizado, String obs) {
		super();
		this.codigo = codigo;
		this.numSerie = numSerie;
		this.unidade = unidade;
		this.equipamento = equipamento;
		this.dataEntrada = dataEntrada;
		this.defeito = defeito;
		this.dataSaida = dataSaida;
		this.servicoRealizado = servicoRealizado;
		this.obs = obs;
	}

	public Registro() {}

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

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

	public Equipamentos getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamentos equipamento) {
		this.equipamento = equipamento;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}


	@Override
	public String toString() {
		return codigo + "," + numSerie + "," + unidade + ","
				+ equipamento + "," + dataEntrada + "," + defeito + "," + dataSaida
				+ "," + servicoRealizado + "," + obs;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getServicoRealizado() {
		return servicoRealizado;
	}

	public void setServicoRealizado(String servicoRealizado) {
		this.servicoRealizado = servicoRealizado;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
}
