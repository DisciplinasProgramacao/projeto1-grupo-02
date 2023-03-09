package business;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstoqueTest {
	
	Estoque estoque;
	Produto produto1, produto2;
	
    @BeforeEach
    public void prepare() {
    	estoque = new Estoque();

    	produto1 = new Produto("Shampoo", 5, 100);
		produto2 = new Produto("Livro", 100, 20);

		estoque.adicionarProduto(produto2, 50);
    }

	@Test
	void tentaCalcularValorTotalDoEstoque(){
		assertEquals(36.58F, estoque.calcularValorTotal());
	}

	@Test
	void tentaCalcularQtdTotalDeProdutos(){
		assertEquals(1, estoque.qtdTotalProdutos());
	}

	@Test
	void tentaAdicionarProduto(){
		Produto produto3 = new Produto("Caixa", 10, 5);
		estoque.adicionarProduto(produto3, 1);
		assertEquals(2, estoque.qtdTotalProdutos());
	}

	@Test
	void tentaRemoverProdutoExistente() throws Exception{
		estoque.removerProduto(produto2);
		assertEquals(0, estoque.qtdTotalProdutos(), "Remoção de produto existente no estoque");
	}


	@Test
	void tentaRemoverProdutoInexistente(){
		assertThrows(NullPointerException.class, () -> estoque.removerProduto(produto1));
	}

	@Test
	void tentaReporEstoqueComValorNegativo() {
		estoque.reporEstoque(produto1, -5);
		assertEquals(null, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaReporEstoqueComValorZero() {
		estoque.reporEstoque(produto1, 0);
		assertEquals(null, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaReporEstoqueComValorPositivo() {
		estoque.reporEstoque(produto1, 5);
		assertEquals(5, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaReporEstoqueComValorPrevio() {
		estoque.reporEstoque(produto1, 5);
		estoque.reporEstoque(produto1, 5);
		assertEquals(10, estoque.getEstoque().get(produto1));
	}
	
	// Retiradas
	
	@Test
	void tentaRetirarEstoqueComValorNegativo() {
		estoque.reporEstoque(produto1, 100);
		estoque.retirarEstoque(produto1, -5);
		assertEquals(100, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaRetirarEstoqueComValorZero() {
		estoque.reporEstoque(produto1, 100);
		estoque.reporEstoque(produto1, 0);
		assertEquals(100, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaRetirarEstoqueComValorPositivo() {
		estoque.reporEstoque(produto1, 100);
		estoque.retirarEstoque(produto1, 5);
		assertEquals(95, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaRetirarEstoqueMaisDoQuePossivel() {
		estoque.reporEstoque(produto1, 100);
		estoque.retirarEstoque(produto1, 150);
		assertEquals(0, estoque.getEstoque().get(produto1));
	}
}
