package DAOS;

import java.util.List;

import Classes.Parcelamento;
import Exceptions.ParcelamentoException;

public interface ParcelamentoDAO {

    public void cadastrar(Parcelamento parcelamento) throws ParcelamentoException;

    public List<Parcelamento> listar() throws ParcelamentoException;

    public void remover(Integer codigo) throws ParcelamentoException;

    public Parcelamento buscarPorCodigo(Integer codigo) throws ParcelamentoException;

    public void atualizar(Parcelamento parcelamento) throws ParcelamentoException;
}