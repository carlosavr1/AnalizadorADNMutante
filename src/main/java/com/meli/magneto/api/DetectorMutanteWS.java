package com.meli.magneto.api;

import com.meli.magneto.adn.modelo.ADN;
import com.meli.magneto.adn.modelo.Estadisticas;
import com.meli.magneto.api.controlador.ControladorBase;
import com.meli.magneto.api.dto.ADNSolicitud;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public class DetectorMutanteWS extends ControladorBase {

    public DetectorMutanteWS() throws Exception {
        prepararDependencias();
    }

    @Path("/mutant")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @POST()
    public Response esMutante(ADNSolicitud peticion) throws Exception {
        if (validadorACL.esUnADNCorrecto(peticion.getDna())) {
            ADN adn = new ADN(peticion.getDna());
            if(administradorADN.isMutant(adn)){
                return Response.status(Response.Status.OK).build();
            }else{
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("El ADN no esta formado correctamente").build();
        }

    }

    @Path("/stats")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GET()
    public Response obtenerEstadisticas() throws Exception {
        Estadisticas estadisticas = administradorADN.getStats();
        return Response.status(Response.Status.OK).entity(estadisticas).build();
    }

}
