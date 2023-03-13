package business;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/* CASOS DE TESTE 
 *
 * 1. Adição de produto:
 * 		- Deve adicionar produto válido	✔
 *		- Não deve permitir a adição de produto já existente ✔
 * 2. Remoção e retirada de produto:	
 *		- Deve remover do estoque produto existente ✔
 *  	- Ao tentar remover produto não existente no estoque, deve lançar exceção ✔
 *  	- Não deve remover do estoque valor superior à quantidade existente de um produto ✔
 * 3. Reposição de produto:
 * 		- Não deve repor produto no estoque com valores que não sejam inteiros positivos ✔
 * 		- Deve repor quantidade válida de produto existente no estoque ✔
 *
 */


class EstoqueTest {
	
	Estoque estoque;
	Produto produto1, produto2;
	
    @BeforeEach
    public void prepare() {
    	estoque = new Estoque();

    	produto1 = new Produto("Shampoo", 5, 100);
		produto2 = new Produto("Sabonete", 100, 20);

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
		Produto produto3 = new Produto("Sabonete", 10, 5);
		estoque.adicionarProduto(produto3, 1);
		assertEquals(2, estoque.qtdTotalProdutos());
	}

	@Test
	void tentaAdicionarProdutoJaExistente(){
		estoque.adicionarProduto(produto2, 1);
		assertEquals(1, estoque.qtdTotalProdutos());
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
		estoque.reporEstoque("Shampoo", -5);
		assertEquals(null, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaReporEstoqueComValorZero() {
		estoque.reporEstoque("Shampoo", 0);
		assertEquals(null, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaReporEstoqueComValorPositivo() {
		estoque.reporEstoque("Shampoo", 5);
		assertEquals(5, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaReporEstoqueComValorPrevio() {
		estoque.reporEstoque("Shampoo", 5);
		estoque.reporEstoque("Shampoo", 5);
		assertEquals(10, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaRetirarEstoqueComValorNegativo() {
		estoque.reporEstoque("Shampoo", 100);
		estoque.retirarEstoque("Shampoo", -5);
		assertEquals(100, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaRetirarEstoqueComValorZero() {
		estoque.reporEstoque("Shampoo", 100);
		estoque.reporEstoque("Shampoo", 0);
		assertEquals(100, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaRetirarEstoqueComValorPositivo() {
		estoque.reporEstoque("Shampoo", 100);
		estoque.retirarEstoque("Shampoo", 5);
		assertEquals(95, estoque.getEstoque().get(produto1));
	}
	
	@Test
	void tentaRetirarEstoqueMaisDoQuePossivel() {
		estoque.reporEstoque("Shampoo", 100);
		estoque.retirarEstoque("Shampoo", 150);
		assertEquals(0, estoque.getEstoque().get(produto1));
	}
}
