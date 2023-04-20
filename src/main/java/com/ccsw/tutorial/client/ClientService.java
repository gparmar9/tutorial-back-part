package com.ccsw.tutorial.client;

import java.util.List;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;

public interface ClientService {

    /**
     * Recupera una {@link com.ccsw.tutorial.category.model.Client} a partir de su
     * ID
     * 
     * @param id
     * @return
     */
    Client get(Long id);

    /**
     * Método para recuperar todas los clientes
     * 
     * @return
     */
    List<Client> findAll();

    /**
     * Método para crear o actualizar un cliente
     * 
     * @param dto
     * @return
     */
    void save(Long id, ClientDto dto);

    /**
     * Método para borrar un cliente
     * 
     * @param id
     */
    void delete(Long id);
}
