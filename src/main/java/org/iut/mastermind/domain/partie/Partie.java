package org.iut.mastermind.domain.partie;

import org.iut.mastermind.domain.proposition.MotSecret;
import org.iut.mastermind.domain.proposition.Reponse;

public class Partie {
    private static final int NB_ESSAIS_MAX = 5;
    private final Joueur joueur;
    private final String motADeviner;
    private int nbEssais;
    private boolean partieTerminee;

    public Partie(Joueur joueur, String motADeviner, int nbEssais, boolean partieTerminee) {
        this.joueur = joueur;
        this.motADeviner = motADeviner;
        this.nbEssais = nbEssais;
        this.partieTerminee = partieTerminee;
    }

    public static Partie create(Joueur joueur, String motADeviner) {
        return new Partie(joueur, motADeviner, 0, false);
    }

    public static Partie create(Joueur joueur, String motADeviner, int nbEssais) {
        return new Partie(joueur, motADeviner, nbEssais, false);
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public int getNbEssais() {
        return nbEssais;
    }

    public String getMot() {
        return motADeviner;
    }

    public Reponse tourDeJeu(String motPropose) {
        verifieNbEssais();
        Reponse reponse = new MotSecret(motADeviner).compareProposition(motPropose);
        nbEssais++;
        if (reponse.lettresToutesPlacees() || nbEssais >= NB_ESSAIS_MAX) {
            partieTerminee = true;
        }
        return reponse;
    }

    private void verifieNbEssais() {
        if (nbEssais >= NB_ESSAIS_MAX) {
            throw new IllegalStateException("Nombre maximum d'essais atteint");
        }
    }

    public boolean isTerminee() {
        return partieTerminee;
    }

    void done() {
        partieTerminee = true;
    }
}