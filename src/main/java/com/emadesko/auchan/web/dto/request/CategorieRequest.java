package com.emadesko.auchan.web.dto.request;


import com.emadesko.auchan.data.entities.Categorie;

public class CategorieRequest {
    private String name;
    private String code;

    public Categorie convert () {
        var categorie = new Categorie();
        categorie.setName(this.name);
        categorie.setCode(this.code);
        return categorie;
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
