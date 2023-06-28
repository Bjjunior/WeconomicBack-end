package Classes;

import java.sql.Date;

public class Usuario {
    private Integer cd_usuario;
    private Integer t_nome_cd_nome;
    private Integer t_celular_cd_celular;
    private String ds_email;
    private String ds_senha;
    private Date dt_nasc;

    public Usuario(Integer cd_usuario, Integer t_nome_cd_nome, Integer t_celular_cd_celular, String ds_email,
            String ds_senha, Date dt_nasc) {
        this.cd_usuario = cd_usuario;
        this.t_nome_cd_nome = t_nome_cd_nome;
        this.t_celular_cd_celular = t_celular_cd_celular;
        this.ds_email = ds_email;
        this.ds_senha = ds_senha;
        this.dt_nasc = dt_nasc;
    }

    public Integer getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(Integer cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Integer getT_nome_cd_nome() {
        return t_nome_cd_nome;
    }

    public void setT_nome_cd_nome(Integer t_nome_cd_nome) {
        this.t_nome_cd_nome = t_nome_cd_nome;
    }

    public Integer getT_celular_cd_celular() {
        return t_celular_cd_celular;
    }

    public void setT_celular_cd_celular(Integer t_celular_cd_celular) {
        this.t_celular_cd_celular = t_celular_cd_celular;
    }

    public String getDs_email() {
        return ds_email;
    }

    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }

    public String getDs_senha() {
        return ds_senha;
    }

    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    @Override
    public String toString() {
        return "Usuario [cd_usuario=" + cd_usuario + ", t_nome_cd_nome=" + t_nome_cd_nome + ", t_celular_cd_celular="
                + t_celular_cd_celular + ", ds_email=" + ds_email + ", ds_senha=" + ds_senha + ", dt_nasc=" + dt_nasc
                + "]";
    }
}
