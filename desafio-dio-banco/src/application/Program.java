package application;

import java.util.Scanner;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import util.SistemaCedulas;

public class Program {

	public static void main(String[] args) {

		Cliente clientes = new Cliente();

		Conta cc = new ContaCorrente(clientes);
		Conta poupanca = new ContaPoupanca(clientes);

		clientes.setNome(telaAbertura());
		
		boolean flag = true;

		do {
			System.out.println();
			switch (escolhaOpcao()) {
			case 1:
				cc.sacar(sacarValor());
				break;
			case 2:
				cc.depositar(depositarValor());
				break;
			case 3:
				cc.transferir(transferirValor(), poupanca);
				break;
			case 4:
				System.out.println();
				cc.imprimirExtrato();
				poupanca.imprimirExtrato();
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("Opção inválida, tente novamente.");
			}
		} while (flag);
		
		System.out.println("Volte sempre! Tenha um bom dia!");
	}

	public static String telaAbertura() {
		Scanner sc = new Scanner(System.in);

		System.out.println("-------------------------------");
		System.out.println("------ Caixa Eletronico -------");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.printf("Digite seu nome: ");
		String nome = sc.nextLine();
		
		return nome;
	}

	public static int escolhaOpcao() {
		Scanner sc = new Scanner(System.in);

		System.out.println("[ 1 ] Sacar");
		System.out.println("[ 2 ] Depositar");
		System.out.println("[ 3 ] Transferir");
		System.out.println("[ 4 ] Imprimir");
		System.out.println("[ 5 ] Sair");
		System.out.printf("Escolha uma opção: ");

		int escolha = sc.nextInt();

		return escolha;
	}

	public static double sacarValor() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Que valor voce quer sacar? R$ ");
		double valor = sc.nextDouble();

		SistemaCedulas.separaCedulas(valor);

		return valor;
	}

	public static double depositarValor() {
		Scanner sc = new Scanner(System.in);

		System.out.printf("Deposito R$ ");
		double valor = sc.nextDouble();

		return valor;
	}

	public static double transferirValor() {
		Scanner sc = new Scanner(System.in);

		System.out.printf("Transferir valor para poupança R$ ");
		double valor = sc.nextDouble();

		return valor;
	}
}
