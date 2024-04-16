package br.unipar.programacaointernet.taskmanager.repository;

import br.unipar.programacaointernet.taskmanager.model.Task;
import br.unipar.programacaointernet.taskmanager.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UsuarioRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Usuario> listarTodos() {
        String jpql = "SELECT u FROM Usuario u";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }

    public Usuario buscarPorID(Integer id) {
        return em.find(Usuario.class, id);
    }

    public void cadastrar(Usuario usuario) throws Exception {
        try {
            em.persist(usuario);
        } catch (Exception ex) {
            throw new Exception("Usuário não pode ser cadastrada");
        }
    }

    public void editar(Usuario usuario, Integer id) throws Exception {
        try {
            em.merge(usuario);
        } catch (Exception ex) {
            throw new Exception("Usuário não pode ser editado");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            } else {
                throw new Exception("Usuário não encontrado");
            }
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar o Usuário");
        }
    }
}
