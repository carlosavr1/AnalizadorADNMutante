package com.meli.magneto.adn.db;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;

public abstract class PersistenciaADN implements IPersistenciaADN {

    CosmosClient cliente;
    CosmosDatabase bd;
    CosmosContainer contenedor;



}
