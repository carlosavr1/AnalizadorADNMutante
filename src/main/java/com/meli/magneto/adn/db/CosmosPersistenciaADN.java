package com.meli.magneto.adn.db;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.*;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.fasterxml.jackson.databind.JsonNode;
import com.meli.magneto.adn.db.modelo.ADNRegistro;
import com.meli.magneto.adn.db.modelo.EstadisticasRegistro;
import com.meli.magneto.adn.modelo.TiposADN;
import com.meli.magneto.util.ConfiguracionBD;

import java.util.Iterator;

public class CosmosPersistenciaADN extends PersistenciaADN {

    final String nombreBD = "BDADN";
    final String nombreContenedor = "ContenedorADN";


    @Override
    public void crearCliente() throws Exception {
        cliente = new CosmosClientBuilder()
                .endpoint(ConfiguracionBD.HOST)
                .key(ConfiguracionBD.MASTER_KEY)
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .contentResponseOnWriteEnabled(true)
                .buildClient();
    }

    public void crearBDSiNoExiste() throws Exception {
        CosmosDatabaseResponse respuestaBD = cliente.createDatabaseIfNotExists(nombreBD);
        bd = cliente.getDatabase(respuestaBD.getProperties().getId());
    }

    public void crearContenedorSiNoExiste() throws Exception {
        CosmosContainerProperties propiedadesContenedor =
                new CosmosContainerProperties(nombreContenedor, "/identificadorHash");
        ThroughputProperties throughputProperties = ThroughputProperties.createManualThroughput(400);
        CosmosContainerResponse containerResponse = bd.createContainerIfNotExists(propiedadesContenedor, throughputProperties);
        contenedor = bd.getContainer(containerResponse.getProperties().getId());
    }

    @Override
    public void crearADNRegistro(ADNRegistro aDNRegistro) throws Exception {
        contenedor.createItem(aDNRegistro, new PartitionKey(aDNRegistro.getIdentificadorHash()), new CosmosItemRequestOptions());
    }

    @Override
    public ADNRegistro consultarADNRegistro(String identificadorHashADN) throws Exception {
        String sql = "SELECT * FROM c WHERE c.identificadorHash = '"+identificadorHashADN+"'";
        CosmosPagedIterable<ADNRegistro> ADNsFiltrados = contenedor.queryItems(sql, new CosmosQueryRequestOptions(), ADNRegistro.class);
        ADNRegistro aDNRegistro = null;
        if (ADNsFiltrados.iterator().hasNext()) {
            aDNRegistro = ADNsFiltrados.iterator().next();
        }
        return aDNRegistro;
    }

    @Override
    public void actualizarCantidadADNRegistro(ADNRegistro aDNRegistro) throws Exception {
        contenedor.upsertItem(aDNRegistro, new CosmosItemRequestOptions());
    }

    @Override
    public EstadisticasRegistro obtenerEstadisticas() throws Exception {
        String sql = "SELECT c.tipo TIPO, SUM(c.cantidad) CANTIDAD FROM c group by c.tipo";
        CosmosPagedIterable<JsonNode> resultadoSumatorias = contenedor.queryItems(sql, new CosmosQueryRequestOptions(), JsonNode.class);
        EstadisticasRegistro estadisticasRegistro = new EstadisticasRegistro();
        Iterator<JsonNode> iterador = resultadoSumatorias.iterator();
        while(iterador.hasNext()) {
            JsonNode jsonnode = iterador.next();
            String tipo = jsonnode.get("TIPO").asText();
            int cantidad = jsonnode.get("CANTIDAD").asInt();
            if(TiposADN.MUTANTE.name().equals(tipo)){
                estadisticasRegistro.setCantidadMutantes(cantidad);
            }if(TiposADN.HUMANO.name().equals(tipo)){
                estadisticasRegistro.setCantidadHumanos(cantidad);
            }
        }
        return estadisticasRegistro;
    }

}
