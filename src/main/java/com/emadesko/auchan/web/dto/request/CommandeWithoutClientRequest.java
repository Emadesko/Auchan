package com.emadesko.auchan.web.dto.request;


import com.emadesko.auchan.data.entities.Article;
import com.emadesko.auchan.data.entities.Categorie;
import com.emadesko.auchan.data.entities.Commande;
import jakarta.persistence.Column;

public class CommandeWithoutClientRequest {


    private String code;
    private Float montant;
    private String pays;
    private String rue;
    private String ville;

    public Commande convert () {
        var commande = new Commande();
        commande.setCode(this.code);
        commande.setMontant(this.montant);
        commande.setPays(this.pays);
        commande.setRue(this.rue);
        commande.setVille(this.ville);
        return commande;
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
