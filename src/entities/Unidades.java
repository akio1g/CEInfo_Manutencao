package entities;

public enum Unidades {
	StsPE(1),UbsNobrega(2027070),UbsJardimNordeste(2042827),CeccoNobrega(2027445),UbsAeCarvalho(2786729),UbsVillalobo(2786753),
	UbsNicolau(2787806),UbsAnchieta(4049926),UbsArthurAlvim(2752328),CapsInfantilPenha(6387640),CeoPenha(3382613),UbsPatriarca(2786923),
	UbsMaringa(7270941),UbsAricanduva(2788721),UbsGuilhermina(2788969),UbsVilaMatilde(2789043),AmaEngGoulart(6143180),Cangaiba(2752204),
	ChacaraCruzeiroDoSul(6194990),VilaSilvia(6592899),UbsJSaoFrancisco(2787776),AmaMauricePate(5268125),CapsADPenha(3304566),
	CapsVilaMatilde(2029626),CerPenha(7641974),DstAidsPenha(2027313),HoraCerta(2751933),SuvisPenha(2815508),UbsTrindade(2787032),EsperancaCassioBittencourt(2788861),
	EsperancaEmilioSantiago(2788888),VilaGranada(2788926),UbsEngGoulart(2752220);

	private int cnes;
	
	Unidades(int i){
		this.cnes = i;
	}

	public int getCnes() {
		return cnes;
	}

	public void setCnes(int cnes) {
		this.cnes = cnes;
	}
	
}
