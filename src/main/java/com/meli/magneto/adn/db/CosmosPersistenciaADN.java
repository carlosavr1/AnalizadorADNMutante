package com.meli.magneto.adn.db;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.*;
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
    public void crearADNRegistro(String identificadorHashADN, String[] adn, String tipo, int cantidad) throws Exception {
        ADNRegistro aDNRegistro = new ADNRegistro(UUID.randomUUID().toString(), identificadorHashADN, adn, tipo, cantidad);
        contenedor.createItem(aDNRegistro, new PartitionKey(aDNRegistro.getIdentificadorHash()), new CosmosItemRequestOptions());
    }

}
