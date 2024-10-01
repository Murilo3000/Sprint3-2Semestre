package br.com.fiap.clinica.view;

import br.com.fiap.clinica.dao.ResidenteDAO;
import br.com.fiap.clinica.dao.ResidenteDAOImpl;
import br.com.fiap.clinica.dao.TutorDAO;
import br.com.fiap.clinica.dao.TutorDAOImpl;
import br.com.fiap.clinica.model.Residente;
import br.com.fiap.clinica.model.Tutor;

public class Teste {
    public static void main(String[] args) {
        // Instanciar DAOs
        ResidenteDAOImpl residenteDAO = new ResidenteDAOImpl();
        TutorDAOImpl tutorDAO = new TutorDAOImpl();

        // Testar CRUD para Residente
        testarCRUDResidente(residenteDAO);

        // Testar CRUD para Tutor
        testarCRUDTutor(tutorDAO);
    }

    // Método para testar todas as operações de CRUD de Residente
    private static void testarCRUDResidente(ResidenteDAO residenteDAO) {
        System.out.println("=== Testando CRUD de Residente ===");

        // 1. Adicionar um novo Residente
        Residente novoResidente = new Residente(0, "Ana Silva", "ana@email.com", "senha123", 19900812, "3", true);
        boolean sucessoAdicao = residenteDAO.incluirResidente(novoResidente);
        System.out.println("Adicionando Residente: " + (sucessoAdicao ? "Sucesso" : "Falha"));

        // 2. Buscar Residente por ID
        Residente residenteBuscado = residenteDAO.buscarPorId(1); // Assume que o ID 1 está no banco
        if (residenteBuscado != null) {
            System.out.println("Residente encontrado: " + residenteBuscado.getNome());
        } else {
            System.out.println("Residente não encontrado.");
        }

        // 3. Atualizar Residente
        residenteBuscado.setNome("Ana Silva Atualizada");
        boolean sucessoAtualizacao = residenteDAO.atualizarResidente(residenteBuscado);
        System.out.println("Atualizando Residente: " + (sucessoAtualizacao ? "Sucesso" : "Falha"));

        // 4. Listar todos os Residentes
        System.out.println("Lista de todos os Residentes:");
        for (Residente residente : residenteDAO.listarTodosResidentes()) {
            System.out.println(" - " + residente.getNome() + " (" + residente.getEmail() + ")");
        }

        // 5. Deletar Residente
        boolean sucessoDelecao = residenteDAO.deletarResidente(residenteBuscado.getId());
        System.out.println("Deletando Residente: " + (sucessoDelecao ? "Sucesso" : "Falha"));

        System.out.println("=== Fim dos Testes de Residente ===");
    }

    // Método para testar todas as operações de CRUD de Tutor
    private static void testarCRUDTutor(TutorDAO tutorDAO) {
        System.out.println("=== Testando CRUD de Tutor ===");

        // 1. Adicionar um novo Tutor
        Tutor novoTutor = new Tutor(0, "Dr. João Pereira", "joao@tutor.com", "senha456", "Cardiologia", true);
        boolean sucessoAdicao = tutorDAO.incluirTutor(novoTutor);
        System.out.println("Adicionando Tutor: " + (sucessoAdicao ? "Sucesso" : "Falha"));

        // 2. Buscar Tutor por ID
        Tutor tutorBuscado = tutorDAO.buscarPorId(1); // Assume que o ID 1 está no banco
        if (tutorBuscado != null) {
            System.out.println("Tutor encontrado: " + tutorBuscado.getNome());
        } else {
            System.out.println("Tutor não encontrado.");
        }

        // 3. Atualizar Tutor
        tutorBuscado.setNome("Dr. João Pereira Atualizado");
        boolean sucessoAtualizacao = tutorDAO.atualizarTutor(tutorBuscado);
        System.out.println("Atualizando Tutor: " + (sucessoAtualizacao ? "Sucesso" : "Falha"));

        // 4. Listar todos os Tutores
        System.out.println("Lista de todos os Tutores:");
        for (Tutor tutor : tutorDAO.listarTodos()) {
            System.out.println(" - " + tutor.getNome() + " (" + tutor.getEspecialidade() + ")");
        }

        // 5. Deletar Tutor
        boolean sucessoDelecao = tutorDAO.deletarTutor(tutorBuscado.getId());
        System.out.println("Deletando Tutor: " + (sucessoDelecao ? "Sucesso" : "Falha"));

        System.out.println("=== Fim dos Testes de Tutor ===");
    }
}
