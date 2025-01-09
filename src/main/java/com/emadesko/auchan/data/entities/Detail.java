package com.emadesko.auchan.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer qteCmd;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Article article;
}
