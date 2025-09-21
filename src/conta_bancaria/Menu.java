package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
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
					
			opcao = leia.nextInt();
			
		if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE_BOLD +"Banco SantAndressa - Mais que um banco, um parceiro de confiança."+ Cores.TEXT_RESET);
				sobre();
				System.exit(0);
			}
					
		switch(opcao) {
				
			case 1:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Criar Conta\n\n"+ Cores.TEXT_RESET);
				
				break;

			case 2:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Listar Contas\n\n"+ Cores.TEXT_RESET);
				
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Consultar dados da Conta - por número\n\n"+ Cores.TEXT_RESET);
				
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Atualizar dados da Conta\n\n"+ Cores.TEXT_RESET);
				
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Apagar a Conta\n\n"+ Cores.TEXT_RESET);
				
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Saque\n\n"+ Cores.TEXT_RESET);
				
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Depósito\n\n"+ Cores.TEXT_RESET);
				
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_UNDERLINED +"Tranferência entre Contas\n\n"+ Cores.TEXT_RESET);
				
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD +"Opção Inválida!" + Cores.TEXT_RESET);
											
			}
		
			leia.close();

	}
	
	public static void sobre() {
		
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"\n*~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~*~*~*");
		System.out.println("Projeto Desenvolvido por ");
		System.out.println("Andressa Regina Funes - andressafunes92@gmail.com");
		System.out.println("https://github.com/andressafunes");
		System.out.println("*~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~**~*~*"+ Cores.TEXT_RESET);
		
	}
}