package business;

public class Produto {
    private int codProduto;
    private int totalEmEstoque;
    private boolean estaAbaixoDoLimite;
    private String descricaoDoProduto;
    private float precoDeCusto;
    private float precoDeVenda;
    private float margemLucro;
    private float valorImposto;
    private int qtdAdquirida;
    private int qtdVendida;
    private float totalGasto;
    private float totalArrecadado;

    private static int contador = 1;

    public Produto(int codProduto, int totalEmEstoque, boolean estaAbaixoDoLimite, String descricaoDoProduto,
            float precoDeCusto, float precoDeVenda, float margemLucro, float valorImposto, int qtdAdquirida,
            int qtdVendida, float totalGasto, float totalArrecadado) {
        setDescricaoDoProduto(descricaoDoProduto);
        setCodProduto();
        setMargemLucro();
        setValorImposto();
        setPrecoDeVenda();
    }

    public void setDescricaoDoProduto(String descricaoDoProduto) {
        if (descricaoDoProduto.length() >= 3) {
            this.descricaoDoProduto = descricaoDoProduto;
        } else {
            this.descricaoDoProduto = "Descricao inválida!";
        }
    }

    public void setPrecoDeVenda() {
        this.precoDeVenda = this.precoDeCusto + this.margemLucro + this.valorImposto;
    }

    public void setCodProduto() {
        this.codProduto = contador++;
    }

    public void setMargemLucro() {
        this.margemLucro = (0.55f * this.precoDeCusto);
    }

    public void setValorImposto() {
        this.valorImposto = (this.precoDeCusto + this.margemLucro) * 0.18f;
    }
}
