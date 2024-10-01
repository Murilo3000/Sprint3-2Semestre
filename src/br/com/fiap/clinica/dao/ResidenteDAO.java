package br.com.fiap.clinica.dao;

import br.com.fiap.clinica.model.Residente;
import java.util.List;

public interface ResidenteDAO {
    boolean incluirResidente (Residente residente);
    Residente buscarPorId (int id);
    boolean atualizarResidente (Residente residente);
    boolean deletarResidente (int id);
    List<Residente> listarTodosResidentes();
}