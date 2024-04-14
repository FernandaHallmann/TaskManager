package br.unipar.programacaointernet.taskmanager.service;

import br.unipar.programacaointernet.taskmanager.model.Usuario;
import br.unipar.programacaointernet.taskmanager.repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.listarTodos();
    }
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.buscarPorID(id);
    }

    public void cadastrar(Usuario usuario) throws Exception {
        usuarioRepository.cadastrar(usuario);
    }

    public void editar(Usuario usuario) throws Exception {
        usuarioRepository.editar(usuario);
    }

    public void deletar(Integer id) throws Exception {
        usuarioRepository.deletar(id);
    }
}
