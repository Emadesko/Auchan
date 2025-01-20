package com.emadesko.auchan.data.mock;

import com.emadesko.auchan.data.entities.Client;
import com.emadesko.auchan.data.entities.Commande;
import com.emadesko.auchan.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.util.Random;

//@Component
@Order(2)
public class ClientMock implements CommandLineRunner {

    private final ClientService clientService;

    public ClientMock(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        String[] prefixes = {"77", "78", "70"};
        for (int i = 1; i <= 10; i++) {
            Client c = new Client();
            c.setTelephone(generatePhoneNumber(random, prefixes));
            c.setNomComplet("Nom_" + i + "Prénom_" + i);
            c.setRue("Rue_" + i);
            c.setVille("Ville_" + i);
            c.setPays("Pays_" + i);
            for (int j = 1; j <= 10; j++) {
                Commande commande = new Commande();
                commande.setDate(LocalDate.now());
                commande.setMontant((float)(10000.0 * j));
                commande.setCode("Code_Com_" + j);
                commande.setPays("Pays_Com_" + j);
                commande.setVille("Ville_Com" + j);
                commande.setRue("Rue_Com" + j);
                commande.setClient(c);
                c.getCommandes().add(commande);
            }
            clientService.create(c);
        }
    }

    private String generatePhoneNumber(Random random, String[] prefixes) {
        String prefix = prefixes[random.nextInt(prefixes.length)];
        int remainingDigits = 7; // 9 chiffres au total moins les 2 ou 3 du préfixe
        StringBuilder phoneNumber = new StringBuilder(prefix);

        for (int i = 0; i < remainingDigits; i++) {
            phoneNumber.append(random.nextInt(10)); // Génère un chiffre aléatoire de 0 à 9
        }

        return phoneNumber.toString();
    }


}
