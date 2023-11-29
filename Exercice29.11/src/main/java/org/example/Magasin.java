package org.example;

import java.util.HashMap;
import java.util.Map;

public class Magasin {
    private final Map<String, Article> catalogue;

    public Magasin() {
        this.catalogue = new HashMap<>();
    }

    public void ajouterArticle(Article article) {
        catalogue.put(article.getReference(), article);
    }

    public Article getArticle(String reference) {
        return catalogue.get(reference);
    }
}
