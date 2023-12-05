package org.example;
import java.util.List;

public class Pizza {
    private String taille;
    private String typeDePate;
    private String fromage;
    private List<String> garnitures;
    private String sauce;

    private Pizza(Builder builder) {
        this.taille = builder.taille;
        this.typeDePate = builder.typeDePate;
        this.fromage = builder.fromage;
        this.garnitures = builder.garnitures;
        this.sauce = builder.sauce;
    }
    public static class Builder {
        private String taille;
        private String typeDePate;
        private String fromage;
        private List<String> garnitures;
        private String sauce;

        public Builder taille(String taille) {
            this.taille = taille;
            return this;
        }

        public Builder typeDePate(String typeDePate) {
            this.typeDePate = typeDePate;
            return this;
        }

        public Builder fromage(String fromage) {
            this.fromage = fromage;
            return this;
        }

        public Builder garnitures(List<String> garnitures) {
            this.garnitures = garnitures;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Pizza build() {
            if (taille == null || typeDePate == null || fromage == null || garnitures == null || sauce == null) {
                throw new IllegalStateException("Certains attributs de la pizza ne sont pas définis.");
            }

            return new Pizza(this);
        }
    }
    public String getTaille() {
        return taille;
    }

    public String getTypeDePate() {
        return typeDePate;
    }

    public String getFromage() {
        return fromage;
    }

    public List<String> getGarnitures() {
        return garnitures;
    }

    public String getSauce() {
        return sauce;
    }
}
