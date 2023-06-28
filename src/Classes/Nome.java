package Classes;

public class Nome {
    private int cd_nome;
    private String ds_primeiro_nome;
    private String ds_sobrenome;
    private String ds_apelido;

    public Nome(int cd_nome, String ds_primeiro_nome, String ds_sobrenome, String ds_apelido) {
        this.cd_nome = cd_nome;
        this.ds_primeiro_nome = ds_primeiro_nome;
        this.ds_sobrenome = ds_sobrenome;
        this.ds_apelido = ds_apelido;
    }

    public int getCd_nome() {
        return cd_nome;
    }

    public void setCd_nome(int cd_nome) {
        this.cd_nome = cd_nome;
    }

    public String getDs_primeiro_nome() {
        return ds_primeiro_nome;
    }

    public void setDs_primeiro_nome(String ds_primeiro_nome) {
        this.ds_primeiro_nome = ds_primeiro_nome;
    }

    public String getDs_sobrenome() {
        return ds_sobrenome;
    }

    public void setDs_sobrenome(String ds_sobrenome) {
        this.ds_sobrenome = ds_sobrenome;
    }

    public String getDs_apelido() {
        return ds_apelido;
    }

    public void setDs_apelido(String ds_apelido) {
        this.ds_apelido = ds_apelido;
    }

    @Override
    public String toString() {
        return "Nome [cd_nome=" + cd_nome + ", ds_primeiro_nome=" + ds_primeiro_nome + ", ds_sobrenome=" + ds_sobrenome
                + ", ds_apelido=" + ds_apelido + "]";
    }
}
