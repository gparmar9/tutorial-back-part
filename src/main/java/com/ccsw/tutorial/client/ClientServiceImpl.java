package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.exceptions.NameUsed;

@Service
public class ClientServiceImpl implements ClientService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Client get(Long id) {

        return this.clientRepository.findById(id).orElse(null);
    }

    @Autowired
    ClientRepository clientRepository;

    /**
     * Método para recuperar todas los clientes
     * 
     * @return
     */
    @Override
    public List<Client> findAll() {

        return (List<Client>) this.clientRepository.findAll();
    }

    /**
     * Método para crear o actualizar un cliente
     * 
     * @param dto
     * @return
     */
    @Override
    public void save(Long id, ClientDto dto) throws Error {
        Client cliente = null;
        List<Client> nameRepeat = this.clientRepository.findByName(dto.getName());

        if (!nameRepeat.isEmpty()) {
            throw new NameUsed("Error: este cliente ya existe");
        }

        if (id == null) {
            cliente = new Client();
        } else {
            cliente = this.get(id);
        }

        cliente.setName(dto.getName());
        this.clientRepository.save(cliente);
    }

    /**
     * Método para borrar un cliente
     * 
     * @param id
     */
    public void delete(Long id) {

        this.clientRepository.deleteById(id);
    }
}
