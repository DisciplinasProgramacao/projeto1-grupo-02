package business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {

    Produto meuProduto;

    @BeforeEach
    public void prepare() {
        meuProduto = new Produto(20, 60, false, "Descricao do produto", (float) 20.00, (float) 40.00, (float) 15.00,
                (float) 5.00, 10, 5, (float) 100.00, (float) 60.00);
    }

    @Test
    public void validaDescricaoErrado() {
        meuProduto.setDescricaoDoProduto("d");
        assertEquals("d", meuProduto.getDescricaoDoProduto());
    }

    @Test
    public void validaDescricaoCerto() {
        meuProduto.setDescricaoDoProduto("Descricao valida");
        assertEquals("Descricao valida", meuProduto.getDescricaoDoProduto());
    }

    @Test
    public void conferePrecoDeVenda() {
        meuProduto.setPrecoDeVenda();
        assertEquals(40.0, meuProduto.getPrecoDeVenda());
    }

    @Test
    public void verificaMargemDeLucro() {
        meuProduto.setMargemLucro();
        assertEquals(11, meuProduto.getMargemLucro());
    }

    @Test
    public void verificaValorImposto() {
        meuProduto.setValorImposto();
        assertEquals(4.5, meuProduto.getValorImposto());
    }

}
