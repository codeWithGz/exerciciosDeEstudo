package entities;

public abstract class TaxPayer {
	 
	 protected String nome;
	 protected Double rendaAnual;
	 protected Double valorPagoImposto = 0.0;
	 
	 public TaxPayer() {
	 }

	 public TaxPayer(String nome, Double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}
	 
	protected abstract Double pagarImposto();

	public String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected Double getRendaAnual() {
		return rendaAnual;
	}

	protected void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " $ " + String.format("%.2f", this.pagarImposto()) ;
	}
}
