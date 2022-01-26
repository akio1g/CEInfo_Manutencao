package entities;

public enum Equipamentos {
	ComputadorCompleto(1),Gabinete(2), Monitor(3),GabineteEPeriferico(4),Periferico(5),GabineteEMonitor(6);

	private int valor;
	Equipamentos(int i) {
		this.valor = i;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
