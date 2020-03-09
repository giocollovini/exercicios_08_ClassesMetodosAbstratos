package entidades;

public class PessoaFisica extends Pessoa {

	public double gastosSaude;

	public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double calculaImposto () {
	
		double valorImposto = 0;
		double descontoSaude = 0;
		
		if (getGastosSaude() > 0.0) {
			
			descontoSaude += getGastosSaude() * 0.5;
		}
		
		if (super.getRendaAnual() < 20000.00) {
			valorImposto = super.getRendaAnual() * 0.15;
		}
		else {
			valorImposto = super.getRendaAnual() * 0.25;
		}
		return valorImposto - descontoSaude; 
	}
	
	@Override	
	public String dadosPessoa() {
		return super.getNome()
				+ ":  $ "
				+ String.format("%.2f", calculaImposto());
	} 
		
	
}
