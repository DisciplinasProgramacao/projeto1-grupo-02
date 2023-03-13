package app;

import java.util.Scanner;

import business.Estoque;
import business.Produto;

public class Main {
	
	public static Estoque estoque = new Estoque();
	public static int valorVendido = 0;
	public static int valorGasto = 0;
	
	public static void executaOpcao(int opcao) {
		
		Scanner scanner = new Scanner(System.in);
		
		switch (opcao) {
		case 1:
			
			System.out.println("Por favor, digite o nome do produto em estoque e a quantidade desejada para venda:");
			
			Produto vendeu = estoque.retirarEstoque(scanner.nextLine(), scanner.nextInt());
			
			if (vendeu != null) {
				System.out.println("Venda realizada com sucesso!");
				valorVendido += vendeu.getPrecoDeVenda();
			} else {
				System.out.println("Houve um erro ao realizar a venda.");
			}
			
			selectOption();
			break;
		case 2:
			
			System.out.println("Por favor, digite o nome do produto em estoque e a quantidade desejada para reestoque:");
			
			Produto reestocou = estoque.reporEstoque(scanner.nextLine(), scanner.nextInt());
			
			if (reestocou != null) {
				System.out.println("Reestoque realizado com sucesso!");
				valorGasto += reestocou.getPrecoDeCusto();
			} else {
				System.out.println("Houve um erro ao realizar o reestoque.");
			}
			
			selectOption();
			break;
		case 3:
			
			estoque.consultaEstoque();
			
			selectOption();
			break;
		case 4:
			
			System.out.println("Por favor, digite o nome do produto em estoque que deseja consultar:");
			
			boolean encoutrou = estoque.consultaProduto(scanner.nextLine());
			
			if (!encoutrou) {
				System.out.println("Produto não encontrado no estoque");	
			}
			
			selectOption();
			break;
		case 5:
			
			int valorEstoque = 0;
			
			for (Produto all : estoque.getEstoque().keySet()) {
				valorEstoque += (all.getPrecoDeCusto() * estoque.getEstoque().get(all));
			}
			
			System.out.println("Balanço Simplificado: ");
			System.out.println("Valor do Estoque: " + valorEstoque);
			System.out.println("Valor Vendido: " + valorVendido);
			System.out.println("Valor Gasto: " + valorGasto);
			
			selectOption();
			break;

		default:
			System.out.println("Operacao invalida, por favor digite uma operacao valida");
			System.out.println();
			System.out.println();
			
			selectOption();
			break;
		}
	}
	
	public static void selectOption() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("           Varejo Molejo           ");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println();
		System.out.println("Digite o numero da operacao desejada:");
		System.out.println();
		System.out.println("(1) Vender Produto");
		System.out.println("(2) Reestocar Produto");
		System.out.println("(3) Consultar Estoque");
		System.out.println("(4) Consultar Produto");
		System.out.println("(5) Exibir Balanco");
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		int opcao = 0;
		
		while (opcao < 1 || opcao > 5) {
			
			opcao = scanner.nextInt();
		
			executaOpcao(opcao);
		}
	}

	public static void main(String[] args) {

		estoque.adicionarProduto(new Produto("Shampoo", 	   5, 10), 50);
		estoque.adicionarProduto(new Produto("Condicionador",  20, 20), 25);
		estoque.adicionarProduto(new Produto("Sabonete", 	   15, 50), 30);
		estoque.adicionarProduto(new Produto("Desodorante",    30, 5), 10);
		estoque.adicionarProduto(new Produto("Pasta de Dente", 200, 10), 100);

		selectOption();
	}
}
