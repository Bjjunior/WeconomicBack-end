package Classes;

public class TipoConta {
    private Integer cd_tipo_conta;
    private String ds_tipo_conta;

    public TipoConta(Integer cd_tipo_conta, String ds_tipo_conta) {
        this.cd_tipo_conta = cd_tipo_conta;
        this.ds_tipo_conta = ds_tipo_conta;
    }

    public Integer getCd_tipo_conta() {
        return cd_tipo_conta;
    }

    public void setCd_tipo_conta(Integer cd_tipo_conta) {
        this.cd_tipo_conta = cd_tipo_conta;
    }

    public String getDs_tipo_conta() {
        return ds_tipo_conta;
    }

    public void setDs_tipo_conta(String ds_tipo_conta) {
        this.ds_tipo_conta = ds_tipo_conta;
    }

    @Override
    public String toString() {
        return "TipoConta [cd_tipo_conta=" + cd_tipo_conta + ", ds_tipo_conta=" + ds_tipo_conta + "]";
    }
}
