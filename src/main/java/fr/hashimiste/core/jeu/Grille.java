package fr.hashimiste.core.jeu;

import fr.hashimiste.core.data.Stockage;
import fr.hashimiste.core.data.sql.Identifiable;
import fr.hashimiste.core.utils.Union;

import java.awt.*;
import java.util.List;

/**
 * L'interface Grille représente une grille de jeu.
 * Elle est identifiable et contient des méthodes pour gérer les îles et les sauvegardes.
 */
public interface Grille extends Identifiable {
    /**
     * Récupère une île à une position spécifique.
     *
     * @param x la position x de l'île.
     * @param y la position y de l'île.
     * @return l'île à la position spécifiée.
     */
    Case getIle(int x, int y);

    /**
     * Récupère la liste de toutes les îles.
     *
     * @return la liste de toutes les îles.
     */
    List<Case> getIles();

    /**
     * Récupère les dimensions de la grille.
     *
     * @return les dimensions de la grille.
     */
    Dimension getDimension();

    /**
     * Si une île doit figurer dans l'écran aventure
     *
     * @return vrai si l'île doit figurer dans l'écran aventure, faux sinon.
     */
    boolean estAventure();

    /**
     * Récupère la liste de toutes les sauvegardes.
     *
     * @param stockage le système de stockage des données.
     * @return la liste de toutes les sauvegardes.
     */
    List<Sauvegarde> getSauvegardes(Stockage stockage);

    /**
     * Rafraîchit la liste des sauvegardes.
     *
     * @param stockage le système de stockage des données.
     */
    void rafraichirSauvegardes(Stockage stockage);

    /**
     * Vérifie si la grille est correcte.
     *
     * @return vrai si la grille est correcte, faux sinon.
     */
    boolean verification();

    /**
     * Fournit une aide pour résoudre la grille.
     *
     * @return L'île où l'aide peut s'appliquer et un message d'aide pour résoudre la grille.
     */
    Union<Ile, String> aide();

    /**
     * Parcourt la grille à la recherche de l'île sur laquelle on peut appliquer une technique.
     *
     * @return une Ile avec la technique qui peut s'y appliquer.
     */
    Union<Ile, Technique> chercherIle();

    /**
     * Récupère la difficulté de la grille.
     *
     * @return la difficulté de la grille.
     */
    Difficulte getDifficulte();

    /**
     * Indique si la grille est jouable.
     *
     * @return vrai si la grille est jouable, faux sinon.
     */
    boolean estJouable();

    /**
     * Réinitialise la grille.
     */
    void reset();

    /**
     * Charge une sauvegarde.
     *
     * @param sauvegarde la sauvegarde a chargé.
     */
    void chargerSauvegarde(Sauvegarde sauvegarde);
}