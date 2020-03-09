package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class ProgramClassesMetodosAbstratos {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		
		double totalPagamentos = 0;
		
		List<Pessoa> list = new ArrayList<>();
		
		
		System.out.println("Programa para ler os dados de N contribuintes (pessoa física ou jurídica)"); 
		System.out.println("mostrar o valor do imposto pago por cada um e o total de imposto arrecadado.");
		System.out.println("Os dados de pessoa física são: NOME, RENDA ANUAL E GASTOS COM SAUDE."); 		
		System.out.println("Os dados de pessoa jurídica são: NOME, RENDA ANUAL E NUMERO FUNCIONARIOS."); 
		System.out.println("As regras para cálculo de imposto são as seguintes:");
		System.out.println("PESSOA FÍSICA: renda menor que 20000.00 - 15% de imposto. Maior que 20000.00 - 25% de imposto.");
		System.out.println("Se a pessoa teve gastos com saúde, 50% do gasto é abatido no imposto.");
		System.out.println("PESSOA JURÍDICA: 16% de imposto. Se empresa tem mais de 10 funcionários, 14% de imposto.");
		
		System.out.println("");
		
		
		System.out.print("Entre com o número de Contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			
			System.out.println("Contribuinte #" + i + " dados:");
			System.out.print("Individual ou Compania (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			double rendaAnual = sc.nextDouble();
			
			if  (ch == 'i') {
				System.out.print("Gastos com Saúde: "); 
				double valorSaude = sc.nextDouble();	
				list.add(new PessoaFisica(nome, rendaAnual, valorSaude));
			}
			else {
				System.out.print("Numero de Funcionários: ");
				Integer numFuncionarios = sc.nextInt();	
				list.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
			}
			
		}
		
		System.out.println();
		System.out.println("VALORES PAGOS:");
		for (Pessoa pess : list) { 		
			
			totalPagamentos += pess.calculaImposto();
			
			System.out.println(pess.dadosPessoa()); 	
		}
		
		System.out.println("");
		System.out.println("TOTAL DE VALORES PAGOS: $ " + String.format("%.2f", totalPagamentos));
		
		sc.close();
	}
}