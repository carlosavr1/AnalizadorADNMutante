package com.meli.magneto.adn.db;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.*;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.meli.magneto.adn.db.modelo.ADNRegistro;
import com.meli.magneto.util.ConfiguracionBD;

import java.util.UUID;

public class CosmosPersistenciaADN extends PersistenciaADN {

    final String nombreBD = "BDADN";
    final String nombreContenedor = "ContenedorAND";


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

}
