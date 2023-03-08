package business;

public class Produto {
    private int codProduto; // OK
    private int totalEmEstoque = 0; // OK
    private int estoqueMinimo; // OK
    private String descricaoDoProduto; // OK
    private float precoDeCusto; // OK
    private float precoDeVenda; // OK
    private float margemLucro; // OK
    private float valorImposto; // OK
    private int qtdAdquirida = 0; // OK
    private int qtdVendida = 0; // OK
    private float totalGasto = 0; // OK
    private float totalArrecadado = 0; // OK

    private static int contador = 1;

    public Produto(String descricaoDoProduto, int estoqueMinimo,
            float precoDeCusto) {
        setEstoqueMinimo(estoqueMinimo);
        setDescricaoDoProduto(descricaoDoProduto);
        setPrecoDeCusto(precoDeCusto);
        setCodProduto();
        setMargemLucro();
        setValorImposto();
        setPrecoDeVenda();
    }

    public void adquirirProduto(int qtdAdquirida) {
        this.totalEmEstoque += qtdAdquirida;
        this.qtdAdquirida += qtdAdquirida;
        this.totalGasto += (this.precoDeCusto * qtdAdquirida);
    }

    public void venderProduto(int qtdVendida) {
        if (qtdVendida >= this.totalEmEstoque) {
            this.totalEmEstoque -= qtdVendida;
            this.qtdVendida += qtdVendida;
            this.totalArrecadado += (this.precoDeVenda * qtdVendida);
        }
        if (estaAbaixoDoMinimo()) {
            System.out.println("Cuidado, seu estoque está abaixo do mínimo!");
        }
    }

    private boolean estaAbaixoDoMinimo() {
        return this.totalEmEstoque < estoqueMinimo;
    }

    private void setDescricaoDoProduto(String descricaoDoProduto) {
        if (descricaoDoProduto.length() >= 3) {
            this.descricaoDoProduto = descricaoDoProduto;
        } else {
            this.descricaoDoProduto = "Descricao inválida!";
        }
    }

    private void setPrecoDeVenda() {
        this.precoDeVenda = this.precoDeCusto + this.margemLucro + this.valorImposto;
    }

    private void setCodProduto() {
        this.codProduto = contador++;
    }

    private void setMargemLucro() {
        this.margemLucro = (0.55f * this.precoDeCusto);
    }

    private void setValorImposto() {
        this.valorImposto = (this.precoDeCusto + this.margemLucro) * 0.18f;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public void setPrecoDeCusto(float precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public int getCodProduto() {
        return this.codProduto;
    }

    public int getTotalEmEstoque() {
        return this.totalEmEstoque;
    }

    public String getDescricaoDoProduto() {
        return this.descricaoDoProduto;
    }

    public float getPrecoDeCusto() {
        return this.precoDeCusto;
    }

    public float getPrecoDeVenda() {
        return this.precoDeVenda;
    }

    public float getMargemLucro() {
        return this.margemLucro;
    }

    public float getValorImposto() {
        return this.valorImposto;
    }

    public int getQtdAdquirida() {
        return this.qtdAdquirida;
    }

    public int getQtdVendida() {
        return this.qtdVendida;
    }

    public float getTotalGasto() {
        return this.totalGasto;
    }

    public float getTotalArrecadado() {
        return this.totalArrecadado;
    }

}
