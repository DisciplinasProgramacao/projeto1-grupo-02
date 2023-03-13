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
	public void reporEstoque(Produto produtoReposto, int qtd) {
		if (qtd > 0) {
			getEstoque().put(produtoReposto, getEstoque().get(produtoReposto) == null ? qtd : getEstoque().get(produtoReposto) + qtd);
		}
	}
	
	/* Remove do estoque uma quantidade especificada de determinado produto.
	 * O produto a ser decrescido e a quantidade a ser removida é definida nos parâmetros.
	 */
	public void retirarEstoque(Produto produtoRetirado, int qtd) { 
		if (qtd > 0) {
			if (getEstoque().get(produtoRetirado) == null || getEstoque().get(produtoRetirado) == 0) {
				return;
			}
			
			getEstoque().put(produtoRetirado, getEstoque().get(produtoRetirado) - qtd >= 0 ? getEstoque().get(produtoRetirado) - qtd : 0);
		}
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

	/* Retorna o objeto produtos, contendo todos os produtos presentes no estoque e suas 
	 * respectivas quantidades 
	 */
	public Map<Produto, Integer> getEstoque() {
		return produtos;
	}
	
}
