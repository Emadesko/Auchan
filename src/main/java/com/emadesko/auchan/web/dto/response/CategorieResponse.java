package com.emadesko.auchan.web.dto.response;


import com.emadesko.auchan.data.entities.Categorie;

public class CategorieResponse {
    private Long id;
    private String name;
    private String code;

    public CategorieResponse(Categorie categorie) {
        this.id = categorie.getId();
        this.name = categorie.getName();
        this.code = categorie.getCode();
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
}
