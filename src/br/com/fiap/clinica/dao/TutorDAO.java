package br.com.fiap.clinica.dao;

import br.com.fiap.clinica.model.Tutor;

import java.util.List;

public interface TutorDAO {
    boolean incluirTutor(Tutor tutor);
    Tutor buscarPorId(int id);
    boolean atualizarTutor(Tutor tutor);
    boolean deletarTutor(int id);
    List<Tutor> listarTodos();
}
