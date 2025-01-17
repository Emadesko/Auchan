package com.emadesko.auchan.data.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Article extends ClasseMere{
    @Column(nullable = false)
    private Float prix;
    @Column(nullable = false)
    private Integer qteStock;

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Integer getQteStock() {
        return qteStock;
    }

    public void setQteStock(Integer qteStock) {
        this.qteStock = qteStock;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy = "article")
    private List<Detail> details;
}
