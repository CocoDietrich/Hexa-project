package org.iut.mastermind.domain.proposition;

public class MotSecret {
    private final String mot;

    public MotSecret(String mot) {
        this.mot = mot;
    }

    public Reponse compareProposition(String proposition) {
        Reponse reponse = new Reponse(mot);
        reponse.compare(proposition);
        return reponse;
    }
}