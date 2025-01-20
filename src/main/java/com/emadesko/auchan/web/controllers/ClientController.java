package com.emadesko.auchan.web.controllers;

import com.emadesko.auchan.web.dto.request.ClientRequest;
import com.emadesko.auchan.web.dto.request.ClientWithCommandeRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/clients")
public interface ClientController {
    @GetMapping("")
    ResponseEntity<Map<String , Object>> getAllClients(
            @RequestParam( defaultValue = "1") int page,
            @RequestParam( defaultValue = "5") int size
    );

    @GetMapping("{id}")
    ResponseEntity<Map<String , Object>> getOneClient(@PathVariable Long id);

    @GetMapping("{id}/commandes")
    ResponseEntity<Map<String , Object>> getOneClientWithCommmande(@PathVariable Long id);

    @PostMapping("")
    ResponseEntity<Map<String , Object>> createClient(@Valid  @RequestBody ClientRequest clientRequest, BindingResult bindingResult);

    @PostMapping("commandes")
    ResponseEntity<Map<String , Object>> createClientWithCommande(@Valid @RequestBody ClientWithCommandeRequest clientRequest, BindingResult bindingResult);

    @PutMapping("{id}")
    ResponseEntity<Map<String , Object>> updateClient(@PathVariable Long id, @Valid @RequestBody ClientWithCommandeRequest clientRequest, BindingResult bindingResult);

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteClient(@PathVariable Long id);
}
