package business;

public class Produto {
    private int codProduto;  //OK
    private int totalEmEstoque;
    private boolean estaAbaixoDoLimite;
    private int estoqueMinimo;
    private String descricaoDoProduto;  //OK
    private float precoDeCusto;
    private float precoDeVenda;  //OK
    private float margemLucro;  //OK
    private float valorImposto;  //OK
    private int qtdAdquirida = 0;
    private int qtdVendida = 0;
    private float totalGasto;
    private float totalArrecadado = 0;

    private static int contador = 1;

    public Produto(int codProduto, int totalEmEstoque, int estoqueMinimo, String descricaoDoProduto,
            float precoDeCusto, float valorImposto, float totalGasto) {
        setDescricaoDoProduto(descricaoDoProduto);
        setCodProduto();
        setMargemLucro();
        setValorImposto();
        setPrecoDeVenda();
    }

    public float adquirirProduto(int qtdAdquirida){

    }

    public float venderProduto(int qtdVendida){
        
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

    public void setEstoqueMinimo(int estoqueMinimo){
        this.estoqueMinimo = estoqueMinimo;
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
