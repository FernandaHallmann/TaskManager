package br.unipar.programacaointernet.taskmanager.service;

import br.unipar.programacaointernet.taskmanager.model.Task;
import br.unipar.programacaointernet.taskmanager.repository.TaskRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class TaskService {
    @Inject
    private TaskRepository taskRepository;

    public List<Task> listar() {
        return taskRepository.listarTodos();
    }
    public Task buscarPorId(Integer id) {
        return taskRepository.buscarPorID(id);
    }

    public void cadastrar(Task task) throws Exception {
        taskRepository.cadastrar(task);
    }

    public void editar(Task task) throws Exception {
        taskRepository.editar(task);
    }

    public void deletar(Integer id) throws Exception {
        taskRepository.deletar(id);
    }
}
