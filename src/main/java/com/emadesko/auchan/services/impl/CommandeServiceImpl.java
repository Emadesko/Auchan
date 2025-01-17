package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.entities.Commande;
import com.emadesko.auchan.data.repositories.ClientRepository;
import com.emadesko.auchan.data.repositories.CommandeRepository;
import com.emadesko.auchan.services.CommandeService;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl extends ServiceImpl <Commande> implements CommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository, ClientRepository clientRepository) {
        super(commandeRepository);
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Commande update(Long id, Commande commande) {
        var cmd = this.commandeRepository.findById(id).orElse(null);
        var cl = this.clientRepository.findById(commande.getClient().getId()).orElse(null);
        if (cmd != null && cl != null) {
            cmd.setCode(commande.getCode());
            cmd.setMontant(commande.getMontant());
            cmd.setClient(cl);
            return this.commandeRepository.save(cmd);
        }
        return null;
    }
}
