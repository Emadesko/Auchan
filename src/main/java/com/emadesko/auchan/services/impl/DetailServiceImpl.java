package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.entities.Detail;
import com.emadesko.auchan.data.repositories.ArticleRepository;
import com.emadesko.auchan.data.repositories.CommandeRepository;
import com.emadesko.auchan.data.repositories.DetailRepository;
import com.emadesko.auchan.services.DetailService;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl extends ServiceImpl <Detail> implements DetailService {

    private final DetailRepository detailRepository;
    private final CommandeRepository commandeRepository;
    private final ArticleRepository articleRepository;

    public DetailServiceImpl(DetailRepository detailRepository, CommandeRepository commandeRepository, ArticleRepository articleRepository) {
        super(detailRepository);
        this.detailRepository = detailRepository;
        this.commandeRepository = commandeRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public Detail update(Long id, Detail detail) {
        var dtl = this.detailRepository.findById(id).orElse(null);
        var cmd = this.commandeRepository.findById(detail.getCommande().getId()).orElse(null);
        var art = this.articleRepository.findById(detail.getArticle().getId()).orElse(null);
        if (dtl != null && cmd != null && art != null) {
            dtl.setQteCmd(detail.getQteCmd());
            dtl.setArticle(detail.getArticle());
            dtl.setCommande(cmd);
            return this.detailRepository.save(dtl);
        }
        return null;
    }
}
