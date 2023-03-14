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
    private float totalGasto = 0;
    private float totalArrecadado = 0;

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



    /*
     * Adquire/compra um produto, adiciona o produto no estoque.
     */
    public void adquirirProduto(int qtdAdquirida) {
        this.totalEmEstoque += qtdAdquirida;
        this.qtdAdquirida += qtdAdquirida;
        this.totalGasto += (this.precoDeCusto * qtdAdquirida);
    }

    /*
     * Vende o produto se a quantidade que for vender for menor ou igual à quantidade em estoque
     * calcula o total arrecadado de venda de cada produto
     */
    public void venderProduto(int qtdVendida) {
        if (qtdVendida <= this.totalEmEstoque) {
            this.totalEmEstoque -= qtdVendida;
            this.qtdVendida += qtdVendida;
            this.totalArrecadado += (this.precoDeVenda * qtdVendida);
        }
        if (estaAbaixoDoMinimo()) {
            System.out.println("Cuidado, seu estoque está abaixo do mínimo!");
        }
    }
    /*
     * retorna verdadeiro se o total em estoque for menor que o estoque minimo
     */
    private boolean estaAbaixoDoMinimo() {
        return this.totalEmEstoque < estoqueMinimo;
    }
    /*
     * recebe uma descrição de produto e checa se a descrição tem pelo menos 3 caracteres
     */
    private void setDescricaoDoProduto(String descricaoDoProduto) {
        if (descricaoDoProduto.length() >= 3) {
            this.descricaoDoProduto = descricaoDoProduto;
        } else {
            this.descricaoDoProduto = "Descricao inválida!";
        }
    }
    /*
     * calcula o preço de venda do produto de acordo com as regras de negócio solicitadas:
     * o preço de venda = preço de custo + margem de lucro + valor do imposto
     */
    private void setPrecoDeVenda() {
        this.precoDeVenda = this.precoDeCusto + this.margemLucro + this.valorImposto;
    }
    /*
     * cria um código de produto único para cada produto que recebe um contador estático
     */
    private void setCodProduto() {
        this.codProduto = contador++;
    }
    /*
     * calcula a margem de lucro do produto de acordo com a regra de negócio:
     * margem de lucro = 55% do preço de custo
     */
    private void setMargemLucro() {
        this.margemLucro = (0.55f * this.precoDeCusto);
    }
    /*
     * calcula o valor de imposto do produto de acordo com a regra de negócio:
     * valor do imposto = 18% do (preço de custo + margem de lucro) 
     */
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
    
    public int getEstoqueMinimo() {
        return this.estoqueMinimo;
    }

}
