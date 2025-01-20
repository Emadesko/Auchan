package com.emadesko.auchan.web.dto.response;


import com.emadesko.auchan.data.entities.Commande;

public class CommandeResponse {

    private Long id;
    private String code;
    private Float montant;
    private String pays;
    private String rue;
    private String ville;

    public CommandeResponse (Commande commande) {
        this.id = commande.getId();
        this.code = commande.getCode();
        this.montant = commande.getMontant();
        this.pays = commande.getPays();
        this.rue = commande.getRue();
        this.ville = commande.getVille();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
