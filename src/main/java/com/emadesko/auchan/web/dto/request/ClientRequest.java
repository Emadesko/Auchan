package com.emadesko.auchan.web.dto.request;


import com.emadesko.auchan.data.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClientRequest {

    @NotBlank(message = "Le nom complet est obligatoire")
    private String nomComplet;
    @NotBlank(message = "Le nom téléphone est obligatoire")
    @Pattern(regexp = "^(76|77|78)[0-9]{7}", message = "Le téléphone doit avoir 9 chiffres et commencer par 76,77 ou 78")
    private String telephone;
    @NotBlank(message = "Le pays est obligatoire")
    private String pays;
    @NotBlank(message = "La ville est obligatoire")
    private String ville;
    @NotBlank(message = "La rue est obligatoire")
    private String rue;

    public Client convert () {
        var client = new Client();
        client.setNomComplet(this.nomComplet);
        client.setTelephone(this.telephone);
        client.setPays(this.pays);
        client.setVille(this.ville);
        client.setRue(this.rue);
        return client;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

}
