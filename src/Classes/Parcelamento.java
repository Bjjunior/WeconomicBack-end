package Classes;

public class Parcelamento {
    private Integer cd_parcelamento;
    private Integer qt_parcela;

    public Parcelamento(Integer cd_parcelamento, Integer qt_parcela) {
        this.cd_parcelamento = cd_parcelamento;
        this.qt_parcela = qt_parcela;
    }

    public Integer getCd_parcelamento() {
        return cd_parcelamento;
    }

    public void setCd_parcelamento(Integer cd_parcelamento) {
        this.cd_parcelamento = cd_parcelamento;
    }

    public Integer getQt_parcela() {
        return qt_parcela;
    }

    public void setQt_parcela(Integer qt_parcela) {
        this.qt_parcela = qt_parcela;
    }

    @Override
    public String toString() {
        return "Parcelamento [cd_parcelamento=" + cd_parcelamento + ", qt_parcela=" + qt_parcela + "]";
    }
}
