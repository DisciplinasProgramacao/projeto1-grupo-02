package business;

public class Produto {
    private int codProduto;
    private int totalEmEstoque = 0;
    private int estoqueMinimo;
    private String descricaoDoProduto;
    private float precoDeCusto;
    private float precoDeVenda;
    private float margemLucro;
    private float valorImposto;
    private int qtdAdquirida = 0;
    private int qtdVendida = 0;
    private static float totalGasto = 0;
    private static float totalArrecadado = 0;

    private static int contador = 1;

    public Produto(String descricaoDoProduto, int estoqueMinimo, float precoDeCusto) {
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
        totalGasto += (this.precoDeCusto * qtdAdquirida);
    }

    public void venderProduto(int qtdVendida) {
        if (qtdVendida >= this.totalEmEstoque) {
            this.totalEmEstoque -= qtdVendida;
            this.qtdVendida += qtdVendida;
            totalArrecadado += (this.precoDeVenda * qtdVendida);
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

    public static float getTotalGasto() {
        return totalGasto;
    }

    public static float getTotalArrecadado() {
        return totalArrecadado;
    }
    
    public int getEstoqueMinimo() {
        return this.estoqueMinimo;
    }

}
