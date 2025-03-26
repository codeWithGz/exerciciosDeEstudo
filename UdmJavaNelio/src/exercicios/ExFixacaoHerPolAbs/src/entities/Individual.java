package entities;

public class Individual extends TaxPayer{

	private Double gastosComSaude;
	
	
	
	public Individual() {
		super();
	}
	
	public Individual(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}


	@Override
	public Double pagarImposto() {
		if (this.rendaAnual < 20000.00) {
			valorPagoImposto += this.rendaAnual * 0.15;
		}else {
			valorPagoImposto += this.rendaAnual * 0.25;
		}
		
		if(this.gastosComSaude > 0) {
			valorPagoImposto -= this.gastosComSaude * 0.5;
		}
		
		return valorPagoImposto;
	}


	
	

}
