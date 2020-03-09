package entidades;

public class PessoaJuridica extends Pessoa {
	
	private Integer NumFuncionarios;

	public PessoaJuridica(String nome, double rendaAnual, Integer numFuncionarios) {
		super(nome, rendaAnual);
		NumFuncionarios = numFuncionarios;
	}

	public Integer getNumFuncionarios() {
		return NumFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		NumFuncionarios = numFuncionarios;
	}
	
	@Override
	public double calculaImposto () {
		
		double valorImposto = 0;
				
		if (getNumFuncionarios() > 10) {
			valorImposto = super.getRendaAnual() * 0.14;
		}
		else {
			valorImposto = super.getRendaAnual() * 0.16;
		}
		return valorImposto;
	}
	
	@Override
	public String dadosPessoa() {
		return super.getNome()
				+ ":  $ "
				+ String.format("%.2f", calculaImposto());
	} 

}
