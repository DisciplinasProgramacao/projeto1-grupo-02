package business;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
	
	private Map<Produto, Integer> produtos;

	// TODO: adicionar os seguintes atributos ao diagrama
	private float valorTotal = 0; 
	private int qtdTotalProdutos = 0; 

	
	public Estoque() {
		produtos = new HashMap<>();
	}

	public float calcularValorTotal(){
		produtos.forEach((key, value) -> valorTotal =+ key.getPrecoDeVenda());
		return valorTotal;
	}

	public int qtdTotalProdutos(){
		produtos.forEach((key, value) -> qtdTotalProdutos++);
		return qtdTotalProdutos;
	}

	// TODO: Alterar no diagrama de Estoque os parâmetros do método
	public void adicionarProduto(Produto produtoAdicionado, int qtdAdquirida){
		produtoAdicionado.adquirirProduto(qtdAdquirida);
		produtos.put(produtoAdicionado, qtdAdquirida);
	}

	public void removerProduto(Produto produtoRemovido) throws Exception{
		if (produtos.containsKey(produtoRemovido)){
			produtos.remove(produtoRemovido);
			System.out.println("Produto removido: " + produtoRemovido.getDescricaoDoProduto());
		} else {
			throw new NullPointerException();
		}
		
	};
	
	public void reporEstoque(Produto produtoReposto, int qtd) {
		if (qtd > 0) {
			getEstoque().put(produtoReposto, getEstoque().get(produtoReposto) == null ? qtd : getEstoque().get(produtoReposto) + qtd);
		}
	}
	
	public void retirarEstoque(Produto produtoRetirado, int qtd) { 
		if (qtd > 0) {
			if (getEstoque().get(produtoRetirado) == null || getEstoque().get(produtoRetirado) == 0) {
				return;
			}
			
			getEstoque().put(produtoRetirado, getEstoque().get(produtoRetirado) - qtd >= 0 ? getEstoque().get(produtoRetirado) - qtd : 0);
		}
	}
	
	public void produtosAbaixoMinimo() {
		System.out.println("Produtos abaixo do estoque minimo: ");
		for (Produto p : produtos.keySet()) {
			if (getEstoque().get(p) < p.getEstoqueMinimo() || getEstoque().get(p) == null) {
				System.out.println(p.getDescricaoDoProduto());
			}
		}
	}

	public Map<Produto, Integer> getEstoque() {
		return produtos;
	}
	
}
