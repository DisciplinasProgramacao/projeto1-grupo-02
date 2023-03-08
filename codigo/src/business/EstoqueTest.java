package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstoqueTest {
	
	Estoque estoque;
	Produto produto;
	
    @BeforeEach
    public void prepare() {
    	estoque = new Estoque();
    	produto = new Produto("Shampoo", 5, 100);
    }

	@Test
	void tentaReporEstoqueComValorNegativo() {
		estoque.reporEstoque(produto, -5);
		assertEquals(null, estoque.getEstoque().get(produto));
	}
	
	@Test
	void tentaReporEstoqueComValorZero() {
		estoque.reporEstoque(produto, 0);
		assertEquals(null, estoque.getEstoque().get(produto));
	}
	
	@Test
	void tentaReporEstoqueComValorPositivo() {
		estoque.reporEstoque(produto, 5);
		assertEquals(5, estoque.getEstoque().get(produto));
	}
	
	@Test
	void tentaReporEstoqueComValorPrevio() {
		estoque.reporEstoque(produto, 5);
		estoque.reporEstoque(produto, 5);
		assertEquals(10, estoque.getEstoque().get(produto));
	}
	
	// Retiradas
	
	@Test
	void tentaRetirarEstoqueComValorNegativo() {
		estoque.reporEstoque(produto, 100);
		estoque.retirarEstoque(produto, -5);
		assertEquals(100, estoque.getEstoque().get(produto));
	}
	
	@Test
	void tentaRetirarEstoqueComValorZero() {
		estoque.reporEstoque(produto, 100);
		estoque.reporEstoque(produto, 0);
		assertEquals(100, estoque.getEstoque().get(produto));
	}
	
	@Test
	void tentaRetirarEstoqueComValorPositivo() {
		estoque.reporEstoque(produto, 100);
		estoque.retirarEstoque(produto, 5);
		assertEquals(95, estoque.getEstoque().get(produto));
	}
	
	@Test
	void tentaRetirarEstoqueMaisDoQuePossivel() {
		estoque.reporEstoque(produto, 100);
		estoque.retirarEstoque(produto, 150);
		assertEquals(0, estoque.getEstoque().get(produto));
	}
}
