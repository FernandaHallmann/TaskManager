package br.unipar.programacaointernet.taskmanager.repository;

import br.unipar.programacaointernet.taskmanager.model.Historico;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class HistoricoRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Historico> listarTodos() {
        String jpql = "SELECT h FROM Historico h";
        return em.createQuery(jpql, Historico.class).getResultList();
    }

    public Historico buscarPorID(Integer id) {
        return em.find(Historico.class, id);
    }

    public void cadastrar(Historico historico) throws Exception {
        try {
            em.persist(historico);
        } catch (Exception ex) {
            throw new Exception("Histórico não pode ser cadastrado");
        }
    }
}
