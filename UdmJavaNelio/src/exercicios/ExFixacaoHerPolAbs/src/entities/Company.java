package entities;

public class Company extends TaxPayer {

	private Integer numeroDeFuncionarios;
	
	public Company() {
		super();
	}
	
	public Company(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public Double pagarImposto() {
		if(this.numeroDeFuncionarios > 10) {
			valorPagoImposto = this.rendaAnual * 0.14;
		}else {
			valorPagoImposto = this.rendaAnual * 0.16;			
		}
		
		return valorPagoImposto;
	}

	protected Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	protected void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

}
