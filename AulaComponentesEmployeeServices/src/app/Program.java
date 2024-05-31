package app;

import services.TaxService;
import services.PensionService;
import services.SalaryService;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Salário bruto: ");
		double grossSalary = sc.nextDouble();
		
		//instanciando o objeto employee (Objeto de dados, ou objeto de domínio)
		Employee employee = new Employee(name, grossSalary);
		
		//usando os componentes:
		
		//instanciando as dependências:
		TaxService taxService = new TaxService();
		PensionService pensionService = new PensionService();
		
		//instanciando componente que recebe as injeções de dependência, e passando objetos para o construtor:
		SalaryService salaryService = new SalaryService(taxService, pensionService);
		
		double netSalary = salaryService.netSalary(employee);
		
		
		System.out.printf("Salário líquido: %.2f%n", netSalary);
		
		sc.close();
	}
}
