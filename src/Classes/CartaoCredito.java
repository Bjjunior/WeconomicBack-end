package Classes;

import java.sql.Date;

public class CartaoCredito {
    private Integer cd_cartao;
    private Integer tconta_cdconta;
    private Integer cd_parcelamento;
    private String nm_cartao;
    private Date dt_venc;
    private Date dt_fechamento;
    private Double vl_limite;
    private Integer cd_conta;

    public CartaoCredito(Integer cd_cartao, Integer tconta_cdconta, Integer cd_parcelamento, String nm_cartao,
            Date dtVenc, Date dtFechamento, Double vl_limite, Integer cd_conta) {
        this.cd_cartao = cd_cartao;
        this.tconta_cdconta = tconta_cdconta;
        this.cd_parcelamento = cd_parcelamento;
        this.nm_cartao = nm_cartao;
        this.dt_venc = dtVenc;
        this.dt_fechamento = dtFechamento;
        this.vl_limite = vl_limite;
        this.cd_conta = cd_conta;
    }

    public CartaoCredito(Integer cdCartao, Integer tconta_cdconta2, Integer cdParcelamento, String nmCartao,
            java.util.Date dtVenc, java.util.Date dtFechamento, Double vlLimite, Integer cdConta) {
    }

    public Integer getCd_cartao() {
        return cd_cartao;
    }

    public void setCd_cartao(Integer cd_cartao) {
        this.cd_cartao = cd_cartao;
    }

    public Integer getTconta_cdconta() {
        return tconta_cdconta;
    }

    public void setTconta_cdconta(Integer tconta_cdconta) {
        this.tconta_cdconta = tconta_cdconta;
    }

    public Integer getCd_parcelamento() {
        return cd_parcelamento;
    }

    public void setCd_parcelamento(Integer cd_parcelamento) {
        this.cd_parcelamento = cd_parcelamento;
    }

    public String getNm_cartao() {
        return nm_cartao;
    }

    public void setNm_cartao(String nm_cartao) {
        this.nm_cartao = nm_cartao;
    }

    public Date getDt_venc() {
        return dt_venc;
    }

    public void setDt_venc(Date dt_venc) {
        this.dt_venc = dt_venc;
    }

    public Date getDt_fechamento() {
        return dt_fechamento;
    }

    public void setDt_fechamento(Date dt_fechamento) {
        this.dt_fechamento = dt_fechamento;
    }

    public Double getVl_limite() {
        return vl_limite;
    }

    public void setVl_limite(Double vl_limite) {
        this.vl_limite = vl_limite;
    }

    public Integer getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(Integer cd_conta) {
        this.cd_conta = cd_conta;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" +
                "cd_cartao=" + cd_cartao +
                ", tconta_cdconta=" + tconta_cdconta +
                ", cd_parcelamento=" + cd_parcelamento +
                ", nm_cartao='" + nm_cartao + '\'' +
                ", dt_venc=" + dt_venc +
                ", dt_fechamento=" + dt_fechamento +
                ", vl_limite=" + vl_limite +
                ", cd_conta=" + cd_conta +
                '}';
    }
}
