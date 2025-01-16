package com.emadesko.auchan.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Categorie extends ClasseMere{
    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;
}
