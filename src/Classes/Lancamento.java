package Classes;

import java.sql.Date;

public class Lancamento {

    private Integer cd_lcto;
    private Integer t_conta_cd_conta;
    private Integer t_categoria_cd_categoria;
    private Date dt_lcto;
    private Double vl_lcto;
    private String tx_descricao;

    private Integer cd_conta;
    private String tp_lcto;

    public Lancamento(Integer cd_lcto, Integer t_conta_cd_conta, Integer t_categoria_cd_categoria, Date dt_lcto,
            Double vl_lcto, String tx_descricao, Integer cd_conta, String tp_lcto) {
        this.cd_lcto = cd_lcto;
        this.t_conta_cd_conta = t_conta_cd_conta;
        this.t_categoria_cd_categoria = t_categoria_cd_categoria;
        this.dt_lcto = dt_lcto;
        this.vl_lcto = vl_lcto;
        this.tx_descricao = tx_descricao;
        this.cd_conta = cd_conta;
        this.tp_lcto = tp_lcto;
    }

    public Integer getCd_lcto() {
        return cd_lcto;
    }

    public void setCd_lcto(Integer cd_lcto) {
        this.cd_lcto = cd_lcto;
    }

    public Integer getT_conta_cd_conta() {
        return t_conta_cd_conta;
    }

    public void setT_conta_cd_conta(Integer t_conta_cd_conta) {
        this.t_conta_cd_conta = t_conta_cd_conta;
    }

    public Integer getT_categoria_cd_categoria() {
        return t_categoria_cd_categoria;
    }

    public void setT_categoria_cd_categoria(Integer t_categoria_cd_categoria) {
        this.t_categoria_cd_categoria = t_categoria_cd_categoria;
    }

    public Date getDt_lcto() {
        return dt_lcto;
    }

    public void setDt_lcto(Date dt_lcto) {
        this.dt_lcto = dt_lcto;
    }

    public Double getVl_lcto() {
        return vl_lcto;
    }

    public void setVl_lcto(Double vl_lcto) {
        this.vl_lcto = vl_lcto;
    }

    public String getTx_descricao() {
        return tx_descricao;
    }

    public void setTx_descricao(String tx_descricao) {
        this.tx_descricao = tx_descricao;
    }

    public Integer getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(Integer cd_conta) {
        this.cd_conta = cd_conta;
    }

    public String getTp_lcto() {
        return tp_lcto;
    }

    public void setTp_lcto(String tp_lcto) {
        this.tp_lcto = tp_lcto;
    }

    @Override
    public String toString() {
        return "Lancamento [cd_lcto=" + cd_lcto + ", t_conta_cd_conta=" + t_conta_cd_conta
                + ", t_categoria_cd_categoria=" + t_categoria_cd_categoria + ", dt_lcto=" + dt_lcto + ", vl_lcto="
                + vl_lcto + ", tx_descricao=" + tx_descricao + ", cd_conta=" + cd_conta
                + ", tp_lcto=" + tp_lcto + "]";
    }

}
