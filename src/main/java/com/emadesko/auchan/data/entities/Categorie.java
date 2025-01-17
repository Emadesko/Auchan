package com.emadesko.auchan.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categorie extends ClasseMere{
    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
