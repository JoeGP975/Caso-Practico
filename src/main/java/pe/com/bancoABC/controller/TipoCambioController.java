package pe.com.bancoABC.controller;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
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
    public TipoCambioResponse getTipoCambio(TipoCambioRequest request) {
        Log.info("Invocando API de Tipo de Cambio: " + request.getDni());
        TipoCambioResponse TipoCambioResponse = tipoCambioClient.getToday();
        TipoCambioEntity entity = TipoCambioEntity.addResponse(request.getDni(), TipoCambioResponse);

        return new TipoCambioResponse(
                entity.dni,
                entity.fecha,
                entity.compra,
                entity.venta
        );
    }
}
