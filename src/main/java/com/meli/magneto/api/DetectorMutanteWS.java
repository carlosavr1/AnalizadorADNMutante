package com.meli.magneto.api;

import com.meli.magneto.adn.ADN;
import com.meli.magneto.api.controlador.ControladorBase;
import com.meli.magneto.api.dto.ADNSolicitud;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public class DetectorMutanteWS extends ControladorBase {

    public DetectorMutanteWS(){
        prepararDependencias();
    }

    @Path("/mutant")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @POST()
    public Response esMutante(ADNSolicitud peticion) {
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

}
