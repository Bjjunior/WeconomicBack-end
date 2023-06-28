package Classes;

public class Gasto {
    private Integer t_lancamento_cd_lancamento;
    private String ds_local;

    public Gasto(Integer t_lancamento_cd_lancamento, String ds_local) {
        this.t_lancamento_cd_lancamento = t_lancamento_cd_lancamento;
        this.ds_local = ds_local;
    }

    public Integer getT_lancamento_cd_lancamento() {
        return t_lancamento_cd_lancamento;
    }

    public void setT_lancamento_cd_lancamento(Integer t_lancamento_cd_lancamento) {
        this.t_lancamento_cd_lancamento = t_lancamento_cd_lancamento;
    }

    public String getDs_local() {
        return ds_local;
    }

    public void setDs_local(String ds_local) {
        this.ds_local = ds_local;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "t_lancamento_cd_lancamento=" + t_lancamento_cd_lancamento +
                ", ds_local='" + ds_local + '\'' +
                '}';
    }
}
