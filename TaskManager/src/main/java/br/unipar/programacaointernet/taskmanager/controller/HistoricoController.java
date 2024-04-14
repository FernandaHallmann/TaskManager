package br.unipar.programacaointernet.taskmanager.controller;

import br.unipar.programacaointernet.taskmanager.model.Historico;
import br.unipar.programacaointernet.taskmanager.model.Task;
import br.unipar.programacaointernet.taskmanager.service.HistoricoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/historico")
public class HistoricoController {
    @Inject
    private HistoricoService historicoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarHistorico() {
        return Response.ok(historicoService.listar()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarHistoricoPorId(@PathParam("id") Integer id) {
        return Response.ok(historicoService.buscarPorId(id)).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarHistorico(Historico historico) {
        try {
            historicoService.cadastrar(historico);
            return Response.status(201)
                    .entity("Histórico cadastrado com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
