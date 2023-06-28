package Classes;

public class Conta {

    private Integer cd_conta;
    private Integer t_usuario_cd_usuario;
    private Integer t_tipo_conta_cd_tipo_conta;
    protected static String nm_conta;
    protected Double vl_saldo;

    public Conta(Integer cd_conta, Integer t_usuario_cd_usuario, Integer t_tipo_conta_cd_tipo_conta, String nm_conta,
            Double vl_saldo) {
        this.cd_conta = cd_conta;
        this.t_usuario_cd_usuario = t_usuario_cd_usuario;
        this.t_tipo_conta_cd_tipo_conta = t_tipo_conta_cd_tipo_conta;
        Conta.nm_conta = nm_conta;
        this.vl_saldo = vl_saldo;
    }

    public Integer getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(Integer cd_conta) {
        this.cd_conta = cd_conta;
    }

    public Integer getT_usuario_cd_usuario() {
        return t_usuario_cd_usuario;
    }

    public void setT_usuario_cd_usuario(Integer t_usuario_cd_usuario) {
        this.t_usuario_cd_usuario = t_usuario_cd_usuario;
    }

    public Integer getT_tipo_conta_cd_tipo_conta() {
        return t_tipo_conta_cd_tipo_conta;
    }

    public void setT_tipo_conta_cd_tipo_conta(Integer t_tipo_conta_cd_tipo_conta) {
        this.t_tipo_conta_cd_tipo_conta = t_tipo_conta_cd_tipo_conta;
    }

    public String getNm_conta() {
        return nm_conta;
    }

    public void setNm_conta(String nm_conta) {
        Conta.nm_conta = nm_conta;
    }

    public Double getVl_saldo() {
        return vl_saldo;
    }

    public void setVl_saldo(Double vl_saldo) {
        this.vl_saldo = vl_saldo;
    }

    @Override
    public String toString() {
        return "Conta [cd_conta=" + cd_conta + ", t_usuario_cd_usuario=" + t_usuario_cd_usuario
                + ", t_tipo_conta_cd_tipo_conta=" + t_tipo_conta_cd_tipo_conta + ", nm_conta=" + nm_conta
                + ", vl_saldo=" + vl_saldo + "]";
    }

}
