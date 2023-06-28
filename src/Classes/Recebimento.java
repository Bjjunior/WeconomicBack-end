package Classes;

public class Recebimento {
    private Integer t_lancamento_cd_lcto;
    private String ds_origem;

    public Recebimento(Integer t_lancamento_cd_lcto, String ds_origem) {
        this.t_lancamento_cd_lcto = t_lancamento_cd_lcto;
        this.ds_origem = ds_origem;
    }

    public Integer getT_lancamento_cd_lcto() {
        return t_lancamento_cd_lcto;
    }

    public void setT_lancamento_cd_lcto(Integer t_lancamento_cd_lcto) {
        this.t_lancamento_cd_lcto = t_lancamento_cd_lcto;
    }

    public String getDs_origem() {
        return ds_origem;
    }

    public void setDs_origem(String ds_origem) {
        this.ds_origem = ds_origem;
    }

    @Override
    public String toString() {
        return "Recebimento [T_LANCAMENTO_CD_LCTO=" + t_lancamento_cd_lcto + ", DS_ORIGEM=" + ds_origem + "]";
    }
}
