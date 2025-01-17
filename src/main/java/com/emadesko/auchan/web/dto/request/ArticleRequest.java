package com.emadesko.auchan.web.dto.request;


import com.emadesko.auchan.data.entities.Article;
import com.emadesko.auchan.data.entities.Categorie;

public class ArticleRequest {
    private String name;
    private String code;
    private Float prix;
    private Integer qteStock;
    private Long categorieId;

    public Article convert () {
        var cat = new Categorie();
        cat.setId(categorieId);
        var article = new Article();
        article.setName(this.name);
        article.setCode(this.code);
        article.setPrix(this.prix);
        article.setQteStock(this.qteStock);
        article.setCategorie(cat);
        return article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}
