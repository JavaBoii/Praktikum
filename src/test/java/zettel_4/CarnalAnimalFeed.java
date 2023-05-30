package zettel_4;

public class CarnalAnimalFeed extends AnimalFeed {
    private boolean isDead;
    private double escapeChance;

    public CarnalAnimalFeed(String name, double amount, boolean isDead, double escapeChance) {
        super(name, amount);
        this.isDead = isDead;
        this.escapeChance = isDead ? 0 : escapeChance;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    public double getEscapeChance() {
        return escapeChance;
    }

    public void setEscapeChance(double escapeChance) {
        this.escapeChance = escapeChance;
    }

    @Override
    public String toString() {
        return "CarnalAnimalFeed [isDead=" + isDead + ", escapeChance=" + escapeChance + ", " + super.toString() + "]";
    }
}
