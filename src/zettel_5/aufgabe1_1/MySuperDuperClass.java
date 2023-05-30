package zettel_5.aufgabe1_1;

public class MySuperDuperClass {
    private int mySuperDuperAttribute;
    public MySuperDuperClass() {
        this(0);
    }
    public MySuperDuperClass(int value){
        mySuperDuperAttribute = value;
    }
    public int getMySuperDuperAttribute() {
        return mySuperDuperAttribute;
    }

    public void setMySuperDuperAttribute(int mySuperDuperAttribute) {
        this.mySuperDuperAttribute = mySuperDuperAttribute;
    }
}
