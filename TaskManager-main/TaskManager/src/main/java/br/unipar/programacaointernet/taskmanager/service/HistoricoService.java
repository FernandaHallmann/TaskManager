package br.unipar.programacaointernet.taskmanager.service;

import br.unipar.programacaointernet.taskmanager.model.Historico;
import br.unipar.programacaointernet.taskmanager.repository.HistoricoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class HistoricoService {
    @Inject
    private HistoricoRepository historicoRepository;

    public List<Historico> listar() {
        return historicoRepository.listarTodos();
    }

    public Historico buscarPorId(Integer id) {
        return historicoRepository.buscarPorID(id);
    }

    public void cadastrar(Historico historico) throws Exception {
        historicoRepository.cadastrar(historico);
    }
}
