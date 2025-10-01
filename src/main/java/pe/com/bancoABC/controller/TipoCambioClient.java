package pe.com.bancoABC.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pe.com.bancoABC.entity.TipoCambioResponse;

@Path("/")
@RegisterRestClient(configKey = "tipo-cambio-api")
public interface TipoCambioClient {

    @GET
    @Path("/tipo-cambio/today.json")
    @Produces(MediaType.APPLICATION_JSON)
    TipoCambioResponse getToday();
}
