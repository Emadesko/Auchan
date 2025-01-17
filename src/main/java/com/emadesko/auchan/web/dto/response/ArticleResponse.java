package com.emadesko.auchan.web.dto.response;


import com.emadesko.auchan.data.entities.Article;

public class ArticleResponse {
    private Long id;
    private String name;
    private String code;
    private Float prix;
    private Integer qteStock;
    private String categorieName;
    private String categorieCode;

    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.name = article.getName();
        this.code = article.getCode();
        this.prix = article.getPrix();
        this.qteStock = article.getQteStock();
        this.categorieName = article.getCategorie().getName();
        this.categorieCode = article.getCategorie().getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public String getCategorieCode() {
        return categorieCode;
    }

    public void setCategorieCode(String categorieCode) {
        this.categorieCode = categorieCode;
    }
}
