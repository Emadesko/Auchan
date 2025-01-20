package com.emadesko.auchan.web.dto.response;


import com.emadesko.auchan.data.entities.Client;
import jakarta.persistence.Column;

public class ClientResponse {

    private Long id;
    private String nomComplet;
    private String telephone;
    private String pays;
    private String ville;
    private String rue;

    public ClientResponse(Client client) {
        this.id = client.getId();
        this.nomComplet = client.getNomComplet();
        this.telephone = client.getTelephone();
        this.pays = client.getPays();
        this.ville = client.getVille();
        this.rue = client.getRue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
