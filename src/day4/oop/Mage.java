package day4.oop;

public class Mage {

    public int hp;
    private int mana;

    void test(){
        hp = 10;
        mana = 20;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana > 100 && mana < 200 ? mana : 0;
    }
}
