package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in); // final é utilizado para mostrar que nunca será
																// modificado
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		int opcao;

		criarContasTeste();

		while (true) {

			System.out.println(Cores.TEXT_PURPLE_BOLD + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("           Banco SantAndressa                ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("      1 - Criar Conta                        ");
			System.out.println("      2 - Listar todos as Contas             ");
			System.out.println("      3 - Buscar Conta por Numero            ");
			System.out.println("      4 - Atualizar Dados da Conta           ");
			System.out.println("      5 - Apagar Conta                       ");
			System.out.println("      6 - Sacar                              ");
			System.out.println("      7 - Depositar                          ");
			System.out.println("      8 - Transferir Valores Entre Contas    ");
			System.out.println("      0 - Sair                               ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("Entre com a opção desejada:                  ");
			System.out.println("                                             " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 8");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE_BOLD
						+ "\nBanco SantAndressa - Mais que um banco, um parceiro de confiança." + Cores.TEXT_RESET);
				sobre();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED + "Criar Conta\n" + Cores.TEXT_RESET);

				cadastrarConta();

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED + "Listar Contas\n" + Cores.TEXT_RESET);

				listarContas();

				keyPress();
				break;
			case 3:
				System.out.println(
						Cores.TEXT_PURPLE_UNDERLINED + "Consultar dados da Conta - por número\n" + Cores.TEXT_RESET);

				procurarContaPorNumero();

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED + "Atualizar dados da Conta\n" + Cores.TEXT_RESET);

				atualizarConta();
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED + "Apagar a Conta\n" + Cores.TEXT_RESET);

				deletarConta();

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED + "Saque\n" + Cores.TEXT_RESET);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED + "Depósito\n" + Cores.TEXT_RESET);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED + "Tranferência entre Contas\n" + Cores.TEXT_RESET);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida!" + Cores.TEXT_RESET);

				keyPress();
				break;

			}
		}
	}

	public static void sobre() {

		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\n*~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~*~*~*");
		System.out.println("Projeto Desenvolvido por ");
		System.out.println("Andressa Regina Funes - andressafunes92@gmail.com");
		System.out.println("https://github.com/andressafunes");
		System.out.println("*~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~*" + Cores.TEXT_RESET);

	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPrecione Enter para continuar...");
		leia.nextLine();
	}

	public static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController
				.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 2, 1, "Marcia Ondarco", 1000000.00f, 10));

	}

	private static void listarContas() {
		contaController.listarTodas();
	}

	private static void cadastrarConta() {

		System.out.print("Digite o número da agência: ");
		int agencia = leia.nextInt();

		System.out.print("Digite o nome do titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.print("Digite o tipo da conta (1 -CC | 2- CP): ");
		int tipo = leia.nextInt();

		System.out.print("Digite o saldo inicial: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.print("Digite o limite inicial: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.print("Digite o dia do aniversario da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED_BOLD + "Tipo de conta inválido!" + Cores.TEXT_RESET);
		}
	}

	private static void procurarContaPorNumero() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		contaController.procurarPorNumero(numero);
	}

	private static void deletarConta() {
		System.out.print("Digite o número da conta que deseja deletar: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) { // Confirmar se o numero da conta existe

			System.out.println("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {// Verifica a opção se deseja deletar
				contaController.deletar(numero);
			} else {

				System.out.println("\nOperação cancelada!");

			}
		} else { // Else da verificação da existencia do numero da conta
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}

	private static void atualizarConta() {
		
		System.out.print("Digite o número da conta que deseja atualizar: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) {
			
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			System.out.printf("A agência atual é %d \nNova agência (Precione Enter para manter o valor atual): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada); // Ação de if ternario ? = Se / e : = senão

			System.out.printf("O nome do titular atual é %s\nNovo titular (Precione Enter para manter o valor atual): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada; 

			System.out.printf("O saldo atual %.2f\nNovo saldo (Precione Enter para manter o valor atual): ", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);

			switch (tipo) {
			case 1 -> {
				
				float limite = ((ContaCorrente) conta).getLimite(); // Transforma conta em conta correte (casth)
				
				System.out.printf("O limite atual é %.2f\nNovo limite (Enter para manter o valor atual): ", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			}
			case 2 -> {
				
				int aniversario = ((ContaPoupanca) conta).getAniversario();
				
				System.out.printf("O dia do aniversario da conta é %d\\nNovo aniversario (Enter para manter o valor atual):  ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
			}
			default -> System.out.println(Cores.TEXT_RED_BOLD + "Tipo de conta inválido!" + Cores.TEXT_RESET);
			}
			
		}else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		
	}

	}
}