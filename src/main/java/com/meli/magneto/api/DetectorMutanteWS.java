package com.meli.magneto.api;

import com.meli.magneto.acl.ValidadorACL;
import com.meli.magneto.adn.ADN;
import com.meli.magneto.api.controlador.ControladorBase;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public class DetectorMutanteWS extends ControladorBase {

    public DetectorMutanteWS(){
        prepararDependencias();
    }

    @POST()
    @Path("/mutant")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response esMutante(String[] adn1d) {
        ValidadorACL validadorACL = new ValidadorACL();
        if (validadorACL.esUnADNCorrecto(adn1d)) {
            ADN adn = new ADN(adn1d);
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
