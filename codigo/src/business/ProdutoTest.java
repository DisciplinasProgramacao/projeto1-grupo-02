package business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TESTES:
 * 	Criando o produto:
 		- O codigo do produto deve ser gerado adicionando 1 ao codigo do produto criado anteriormente ✅
 		- O valor do lucro deve ser calculado com 0.55 * Preco de custo ✅
 		- O valor de imposto deve ser calculado com 0.18 * (preco de custo + lucro) ✅
    Deve ser possivel adicionar ou vender produtos do estoque
        - Ao ser adicionado o estoque e valor gasto sap atualizados ✅
        - Ao ser vendido o estoque e valor adquirido sao atualizados ✅
        
        
 * 
 * 
 */


class ProdutoTest {

	Produto meuProduto;
	Produto meuNovoProduto;
	
	@BeforeEach
	public void prepare() {
		meuProduto = new Produto("Descricao do produto", 2, 20);
		meuNovoProduto = new Produto("Segundo produto", 15, 30);
		meuProduto.adquirirProduto(10);
		
	}
	
	@Test
	public void confereCodigoDeProduto() {
		assertEquals(1, meuProduto.getCodProduto());
		assertEquals(2, meuNovoProduto.getCodProduto());
	}
	
	@Test
	public void confereMargemDeLucro() {
		assertEquals(11, meuProduto.getMargemLucro());
	}
	
	@Test
	public void confereValorImposto() {
		assertEquals(5.58, meuProduto.getValorImposto());
	}
	
	@Test
	public void confereAdquirirProdutos() {
		assertEquals(10, meuProduto.getTotalEmEstoque());
		assertEquals(10, meuProduto.getQtdAdquirida());
		assertEquals(200, meuProduto.getTotalGasto());
	}
	
	@Test
	public void confereVenderProdutos() {
		meuProduto.venderProduto(8);
		assertEquals(2, meuProduto.getTotalEmEstoque());
		assertEquals(8, meuProduto.getQtdVendida());
		assertEquals(292.64, meuProduto.getTotalArrecadado());
	}
 
}
