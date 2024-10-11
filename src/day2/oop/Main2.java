package day2.oop;

public class Main2 {
    public static void main(String[] args) {
        Character mage = new Character();
        mage.hp = 30;
        mage.mp = 100;
        mage.exp = 0;
        mage.attackSteed = 5;
        mage.damage = 50;
        mage.classCharacter = "Mage";
        mage.attack();

        Character warrior = new Character();
        warrior.hp = 100;
        warrior.mp = 50;
        warrior.exp = 0;
        warrior.attackSteed = 10;
        warrior.damage = 20;
        warrior.critRate = 0.1;
        warrior.lifeSteal = 0.1;
        warrior.classCharacter = "Warrior";

//        System.out.println("Character HP: " + warrior.hp);
//        System.out.println("Character MP: " + warrior.mp);
//        System.out.println("Character EXP: " + warrior.exp);
//        System.out.println("Character Attack Steed: " + warrior.attackSteed);
//        System.out.println("Character Damage: " + warrior.damage);
//        System.out.println("Character Crit Rate: " + warrior.critRate);
//        System.out.println("Character Life Steal: " + warrior.lifeSteal);
//        System.out.println("Character Class: " + warrior.classCharacter);

        warrior.death();
        warrior.attack();
    }
}
