package br.unipar.programacaointernet.taskmanager.controller;

import br.unipar.programacaointernet.taskmanager.model.Usuario;
import br.unipar.programacaointernet.taskmanager.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioController {
    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarUsuarios() {
        return Response.ok(usuarioService.listar()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarUsuarioPorId(@PathParam("id") Integer id) {
        return Response.ok(usuarioService.buscarPorId(id)).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario) {
        try {
            usuarioService.cadastrar(usuario);
            return Response.status(201)
                    .entity("Usuário cadastrado com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarUsuario(@PathParam("id") Integer id, Usuario usuario) {
        try {
            usuario.setId(id);
            usuarioService.editar(usuario);
            return Response.ok("Usuario editado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarUsuario(@PathParam("id") Integer id) {
        try {
            usuarioService.deletar(id);
            return Response.ok("Usuario deletado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
