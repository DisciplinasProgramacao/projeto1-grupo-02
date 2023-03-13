package business;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
	
	private Map<Produto, Integer> produtos;

	private float valorTotal = 0; 
	private int qtdTotalProdutos = 0; 

	
	public Estoque() {
		produtos = new HashMap<>();
	}


	/* 
	 * Calcula o valor total dos produtos presentes no estoque.
	 */
	public float calcularValorTotal(){
		produtos.forEach((key, value) -> valorTotal =+ key.getPrecoDeVenda());
		return valorTotal;
	}

	
	/* 
	 * Calcula a quantidade produtos presentes no estoque.
	 */
	public int qtdTotalProdutos(){
		produtos.forEach((key, value) -> qtdTotalProdutos++);
		return qtdTotalProdutos;
	}

	/* 
	 * Adiciona um novo produto ao estoque. Como parâmetros, apresenta o produto 
	 * a ser adicionado e a quantidade deste prouduto a ser adquirida.
	 */
	public void adicionarProduto(Produto produtoAdicionado, int qtdAdquirida){
		produtoAdicionado.adquirirProduto(qtdAdquirida);
		produtos.put(produtoAdicionado, qtdAdquirida);
	}

	/* 
	 * Remove um produto de estoque. O produto a ser removido é especificado no parâmetro.  
	 */
	public void removerProduto(Produto produtoRemovido) throws Exception{
		if (produtos.containsKey(produtoRemovido)){
			produtos.remove(produtoRemovido);
			System.out.println("Produto removido: " + produtoRemovido.getDescricaoDoProduto());
		} else {
			throw new NullPointerException();
		}
		
	};
	
	/* Repõe um produto no estoque. Como parâmetros, apresenta o produto a ser reposto 
	 * e a quantidade deste produto a ser adicionada ao estoque.
	 */
	public Produto reporEstoque(String produtoReposto, int qtd) {
		if (qtd > 0) {
			
			Produto p = null;
			
			for (Produto produto : produtos.keySet()) {
				if (produto.getDescricaoDoProduto().equals(produtoReposto)) {
					p = produto;
				}
			}
			
			if (p == null) {
				return null;
			}
			
			getEstoque().put(p, getEstoque().get(p) == null ? qtd : getEstoque().get(p) + qtd);
			return p;
		}
		
		return null;
	}
	
	/* Remove do estoque uma quantidade especificada de determinado produto.
	 * O produto a ser decrescido e a quantidade a ser removida é definida nos parâmetros.
	 */
	
	public Produto retirarEstoque(String produtoRetirado, int qtd) { 
		if (qtd > 0) {
			
			Produto p = null;
			
			for (Produto produto : produtos.keySet()) {
				if (produto.getDescricaoDoProduto().equals(produtoRetirado)) {
					p = produto;
				}
			}
			
			if (p == null || getEstoque().get(p) == null || getEstoque().get(p) == 0) {
				return null;
			}
			
			getEstoque().put(p, getEstoque().get(p) - qtd >= 0 ? getEstoque().get(p) - qtd : 0);
			return p;
		}
		
		return null;
	}
	
	/* Alerta, no console, caso algum produto esteja em quantidade inferior àquela especificada
	 * como mínima no atributo produto.estoqueMinimo
	 */
	public void produtosAbaixoMinimo() {
		System.out.println("Produtos abaixo do estoque minimo: ");
		for (Produto p : produtos.keySet()) {
			if (getEstoque().get(p) < p.getEstoqueMinimo() || getEstoque().get(p) == null) {
				System.out.println(p.getDescricaoDoProduto());
			}
		}
	}
	
	public boolean consultaProduto(String produtoConsultado) {
		
		Produto produto = null;
		
		for (Produto all : produtos.keySet()) {
			if (all.getDescricaoDoProduto().equals(produtoConsultado)) {
				produto = all;
			}
		}
		
		if (produto == null) {
			return false;
		}
		
		System.out.println();
		System.out.println("Produto Consultado:");
		System.out.println();
		System.out.println("Codigo: " + produto.getCodProduto());
		System.out.println("Nome: " + produto.getDescricaoDoProduto());
		System.out.println("Estoque Atual: " + produtos.get(produto));
		System.out.println("Estoque Min: " + produto.getEstoqueMinimo());
		System.out.println("Preco de Custo: " + produto.getPrecoDeCusto());
		System.out.println();
		
		return true;
	}
	
	public void consultaEstoque() {
		System.out.println("Estoque: ");
		System.out.println("Codigo - Nome - Estoque Min - Preco de Custo");
		System.out.println();
		
		for (Produto all : produtos.keySet()) {
			System.out.println(all.getCodProduto() + " | " + all.getDescricaoDoProduto() + " | " + all.getEstoqueMinimo() + " | " + all.getPrecoDeCusto());
		}
		System.out.println();
	}

	/* Retorna o objeto produtos, contendo todos os produtos presentes no estoque e suas 
	 * respectivas quantidades 
	 */
	public Map<Produto, Integer> getEstoque() {
		return produtos;
	}
	
}
