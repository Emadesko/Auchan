package com.emadesko.auchan.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Article extends ClasseMere{
    private Float prix;
    private Integer qteStock;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy = "article")
    private List<Detail> details;
}
