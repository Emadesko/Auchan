package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.entities.Client;
import com.emadesko.auchan.data.repositories.ClientRepository;
import com.emadesko.auchan.services.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientServiceImpl extends ServiceImpl <Client> implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }

    @Override
    public Client update(Long id, Client client) {
        var cl = this.clientRepository.findById(id).orElse(null);
        if (cl != null) {
            cl.setNomComplet(client.getNomComplet());
            return this.clientRepository.save(cl);
        }
        return null;
    }
}
