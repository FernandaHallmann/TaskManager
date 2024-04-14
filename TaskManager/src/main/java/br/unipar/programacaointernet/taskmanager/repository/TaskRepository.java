package br.unipar.programacaointernet.taskmanager.repository;

import br.unipar.programacaointernet.taskmanager.model.Task;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class TaskRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Task> listarTodos() {
        String jpql = "SELECT t FROM Task t";
        return em.createQuery(jpql, Task.class).getResultList();
    }

    public Task buscarPorID(Integer id) {
        return em.find(Task.class, id);
    }

    public void cadastrar(Task task) throws Exception {
        try {
            em.persist(task);
        } catch (Exception ex) {
            throw new Exception("Task não pode ser cadastrada");
        }
    }

    public void editar(Task task) throws Exception {
        try {
            em.merge(task);
        } catch (Exception ex) {
            throw new Exception("Task não pode ser editada");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
            Task task = em.find(Task.class, id);
            if (task != null) {
                em.remove(task);
            } else {
                throw new Exception("Task não encontrada");
            }
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar a Task");
        }
    }
}
