package br.unipar.programacaointernet.taskmanager.controller;

import br.unipar.programacaointernet.taskmanager.model.Task;
import br.unipar.programacaointernet.taskmanager.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/task")
public class TaskController {
    @Inject
    private TaskService taskService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarTasks() {
        return Response.ok(taskService.listar()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarTaskPorId(@PathParam("id") Integer id) {
        return Response.ok(taskService.buscarPorId(id)).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarTask(Task task) {
        try {
            taskService.cadastrar(task);
            return Response.status(201)
                    .entity("Task cadastrada com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarTask(@PathParam("id") Integer id, Task task) {
        try {
            task.setId(id);
            taskService.editar(task);
            return Response.ok("Task editada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarTask(@PathParam("id") Integer id) {
        try {
            taskService.deletar(id);
            return Response.ok("Task deletada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
