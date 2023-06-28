package Classes;

public class Celular {
    private Integer cd_celular;
    private Integer nr_ddi;
    private Integer nr_ddd;
    private Integer nr_celular;

    public Celular(Integer cd_celular, Integer nr_ddi, Integer nr_ddd, Integer nr_celular) {
        this.cd_celular = cd_celular;
        this.nr_ddi = nr_ddi;
        this.nr_ddd = nr_ddd;
        this.nr_celular = nr_celular;
    }

    public Integer getCd_celular() {
        return cd_celular;
    }

    public void setCd_celular(Integer cd_celular) {
        this.cd_celular = cd_celular;
    }

    public Integer getNr_ddi() {
        return nr_ddi;
    }

    public void setNr_ddi(Integer nr_ddi) {
        this.nr_ddi = nr_ddi;
    }

    public Integer getNr_ddd() {
        return nr_ddd;
    }

    public void setNr_ddd(Integer nr_ddd) {
        this.nr_ddd = nr_ddd;
    }

    public Integer getNr_celular() {
        return nr_celular;
    }

    public void setNr_celular(Integer nr_celular) {
        this.nr_celular = nr_celular;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "cd_celular=" + cd_celular +
                ", nr_ddi=" + nr_ddi +
                ", nr_ddd=" + nr_ddd +
                ", nr_celular=" + nr_celular +
                '}';
    }
}
