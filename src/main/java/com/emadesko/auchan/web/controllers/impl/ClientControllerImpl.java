package com.emadesko.auchan.web.controllers.impl;

import com.emadesko.auchan.services.ClientService;
import com.emadesko.auchan.web.controllers.ClientController;
import com.emadesko.auchan.web.dto.request.ClientRequest;
import com.emadesko.auchan.web.dto.request.ClientWithCommandeRequest;
import com.emadesko.auchan.web.dto.response.ClientResponse;
import com.emadesko.auchan.web.dto.response.CommandeResponse;
import com.emadesko.auchan.web.dto.response.RequestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }


    @Override
    public ResponseEntity<Map<String, Object>> getAllClients(int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOneClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOneClientWithCommmande(Long id) {
        var client = clientService.getById(id);
        Map<String , Object> map = new HashMap<>();
        if (client == null) {
            map.put("error" , "Aucun client ne correspond a cet Id");
            return new ResponseEntity<>(RequestResponse.response(
                    HttpStatus.NOT_FOUND,
                    map,
                    "error"
                    ),
                    HttpStatus.NOT_FOUND);
        }else {
            var commandes = client.getCommandes();
            map.put("client", new ClientResponse(client));
            map.put("commandes", commandes.stream().map(CommandeResponse::new));
            return new ResponseEntity<>(RequestResponse.response(
                    HttpStatus.OK,
                    map,
                    "ClientResponse"
            ),
                    HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> createClient(ClientRequest clientRequest, BindingResult bindingResult) {

        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> createClientWithCommande(ClientWithCommandeRequest clientRequest, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateClient(Long id, ClientWithCommandeRequest clientRequest, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteClient(Long id) {
        return null;
    }
}
