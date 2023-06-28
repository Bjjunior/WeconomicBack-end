package Classes;

abstract class movimentacaoConta extends Conta {

    public movimentacaoConta(Integer numConta, Double saldo) {
        super(numConta, numConta, numConta, nm_conta, saldo);
    }

    // Adiciona o valor ao saldo
    public Double deposita(Double valor) {
        return this.vl_saldo += valor;
    }

    // Retira o valor da conta, fazendo um check ao valor do saldo
    public Double saca(Double valor) {
        if (this.vl_saldo > valor) {
            return this.vl_saldo - valor;
        } else {
            return this.vl_saldo;
        }

    }
}
