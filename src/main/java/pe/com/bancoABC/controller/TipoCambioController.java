package pe.com.bancoABC.controller;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pe.com.bancoABC.entity.ErrorResponse;
import pe.com.bancoABC.entity.TipoCambioEntity;
import pe.com.bancoABC.entity.TipoCambioRequest;
import pe.com.bancoABC.entity.TipoCambioResponse;

import java.util.Date;


@Path("/api/tipoCambio/v1")
public class TipoCambioController {
    @Inject
    @RestClient
    TipoCambioClient tipoCambioClient;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getTipoCambio(TipoCambioRequest request) {
       try{
        Log.info("Invocando API de Tipo de Cambio: " + request.getDni());
        TipoCambioResponse TipoCambioResponse = tipoCambioClient.getToday();
        TipoCambioEntity entity = TipoCambioEntity.addResponse(request.getDni(), TipoCambioResponse);

          return Response.ok(new TipoCambioResponse(
                   entity.dni,
                   entity.fecha,
                   entity.sunat,
                   entity.compra,
                   entity.venta
           )).build();
       } catch (IllegalStateException e) {
           return Response.status(Response.Status.BAD_REQUEST)
                   .entity(new ErrorResponse("ERROR", e.getMessage(), 400))
                   .build();
       }
    }
}
