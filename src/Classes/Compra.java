package Classes;

import java.sql.Date;

public class Compra {
    private Integer cd_compra;
    private Integer t_cartao_cr_cd_cartao;
    private Integer t_parcelamento_cd_parcelamento;
    private Integer t_categoria_cd_categoria;
    private Date dt_compra;
    private Double vl_compra;
    private String tx_descricao;
    private String ds_local;
    private Integer cd_cartao;

    public Compra(Integer cd_compra, Integer t_cartao_cr_cd_cartao, Integer t_parcelamento_cd_parcelamento,
            Integer t_categoria_cd_categoria, Date dt_compra, Double vl_compra, String tx_descricao, String ds_local,
            Integer cd_cartao) {
        this.cd_compra = cd_compra;
        this.t_cartao_cr_cd_cartao = t_cartao_cr_cd_cartao;
        this.t_parcelamento_cd_parcelamento = t_parcelamento_cd_parcelamento;
        this.t_categoria_cd_categoria = t_categoria_cd_categoria;
        this.dt_compra = dt_compra;
        this.vl_compra = vl_compra;
        this.tx_descricao = tx_descricao;
        this.ds_local = ds_local;
        this.cd_cartao = cd_cartao;
    }

    public Integer getCd_compra() {
        return cd_compra;
    }

    public void setCd_compra(Integer cd_compra) {
        this.cd_compra = cd_compra;
    }

    public Integer getT_cartao_cr_cd_cartao() {
        return t_cartao_cr_cd_cartao;
    }

    public void setT_cartao_cr_cd_cartao(Integer t_cartao_cr_cd_cartao) {
        this.t_cartao_cr_cd_cartao = t_cartao_cr_cd_cartao;
    }

    public Integer getT_parcelamento_cd_parcelamento() {
        return t_parcelamento_cd_parcelamento;
    }

    public void setT_parcelamento_cd_parcelamento(Integer t_parcelamento_cd_parcelamento) {
        this.t_parcelamento_cd_parcelamento = t_parcelamento_cd_parcelamento;
    }

    public Integer getT_categoria_cd_categoria() {
        return t_categoria_cd_categoria;
    }

    public void setT_categoria_cd_categoria(Integer t_categoria_cd_categoria) {
        this.t_categoria_cd_categoria = t_categoria_cd_categoria;
    }

    public Date getDt_compra() {
        return dt_compra;
    }

    public void setDt_compra(Date dt_compra) {
        this.dt_compra = dt_compra;
    }

    public Double getVl_compra() {
        return vl_compra;
    }

    public void setVl_compra(Double vl_compra) {
        this.vl_compra = vl_compra;
    }

    public String getTx_descricao() {
        return tx_descricao;
    }

    public void setTx_descricao(String tx_descricao) {
        this.tx_descricao = tx_descricao;
    }

    public String getDs_local() {
        return ds_local;
    }

    public void setDs_local(String ds_local) {
        this.ds_local = ds_local;
    }

    public Integer getCd_cartao() {
        return cd_cartao;
    }

    public void setCd_cartao(Integer cd_cartao) {
        this.cd_cartao = cd_cartao;
    }

    @Override
    public String toString() {
        return "Compra [cd_compra=" + cd_compra + ", t_cartao_cr_cd_cartao=" + t_cartao_cr_cd_cartao
                + ", t_parcelamento_cd_parcelamento=" + t_parcelamento_cd_parcelamento + ", t_categoria_cd_categoria="
                + t_categoria_cd_categoria + ", dt_compra=" + dt_compra + ", vl_compra=" + vl_compra + ", tx_descricao="
                + tx_descricao + ", ds_local=" + ds_local + ", cd_cartao=" + cd_cartao
                + "]";
    }
}
