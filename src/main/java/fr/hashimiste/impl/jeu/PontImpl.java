package fr.hashimiste.impl.jeu;

import fr.hashimiste.core.jeu.*;

/**
 * Cette classe représente un case avec un pont dessus dans le jeu.
 */
public class PontImpl implements Pont {

    private final int x;
    private final int y;
    private final int n;
    private final Grille grille;
    private final Direction direction;
    private final Ile ile1;
    private final Ile ile2;

    /**
     * Constructeur de la classe PontImpl
     *
     * @param x coordonée en x de la case avec le pont
     * @param y coordonée en y de la case avec le pont
     * @param n nombre de pont sur la case (1 ou 2)
     * @param g grille où se trouve la case
     * @param d direction dans lequel vont les ponts de la case
     * @param ile1 première île reliée par le pont
     * @param ile2 deuxième île reliée par le pont
     */
    public PontImpl(int x, int y, int n, Grille g, Direction d, Ile ile1, Ile ile2) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.grille = g;
        this.direction = d;
        this.ile1 = ile1;
        this.ile2 = ile2;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public Grille getGrille() {
        return this.grille;
    }

    @Override
    public Case getVoisinCase(Direction d) {
        Case c = null;
        switch (d) {
            case NORD:
                c = (grille.getIle(x, y - 1));
                break;
            case EST:
                c = (grille.getIle(x + 1, y));
                break;
            case SUD:
                c = (grille.getIle(x, y + 1));
                break;
            case OUEST:
                c = (grille.getIle(x - 1, y));
        }
        return c;
    }

    @Override
    public Ile getVoisinIle(Direction d) {
        if(getVoisinCase(d) == null) return null;
        return getVoisinCase(d).getVoisinIle(d);
    }

    @Override
    public int opParcours(Direction d) {
        if (direction == Direction.NORD || direction == Direction.SUD)
            if (d == Direction.NORD || d == Direction.SUD)
                return (getVoisinCase(d).opParcours(d));
        if (direction == Direction.EST || direction == Direction.OUEST)
            if (d == Direction.EST || d == Direction.OUEST)
                return (getVoisinCase(d).opParcours(d));
        return -1;
    }

    @Override
    public int getN() {
        return this.n;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Renvoie la première île que relie le pont
     * @return la première île que relie le pont
     */
    public Ile getIle1() {
        return ile1;
    }

    /**
     * Renvoie la deuxième île que relie le pont
     * @return la deuxième île que relie le pont
     */
    public Ile getIle2() {
        return ile2;
    }

    /**
     * Indique si le pont connecte l'île en paramètre
     * @param ile île dont on veut vérifier la connection avec le pont
     * @return vrai si le pont est relié à l'île, faux sinon
     */
    public boolean estConnecte(Ile ile) {
        return ile.equals(ile1) || ile.equals(ile2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pont) {
            PontImpl p = (PontImpl) obj;
            return p.getX() == x && p.getY() == y && p.getN() == n && p.getGrille().getId() == grille.getId()
                    && ile1.equals(p.getIle1()) && ile2.equals(p.getIle2());
        }
        return false;
    }

    @Override
    public String toString() {
        return "PontImpl{" +
                "x=" + x +
                ", y=" + y +
                ", n=" + n +
                ", id(grille)=" + grille.getId() +
                ", direction=" + direction +
                '}';
    }
}
