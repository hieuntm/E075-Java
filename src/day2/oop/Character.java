package day2.oop;

class Character {

    // public, private, protected
    // static, final
    // extends, implements
        double hp;
        double mp;
        double exp;
        double attackSteed;
        double damage;
        double critRate;
        double lifeSteal;
        String classCharacter;

        void death(){
            if(hp == 0){
                System.out.println(classCharacter + " is dead");
            }
        }

        void clearDungeon(){
            exp+=20;
        }

        void levelUp(){
            if(exp == 100){
                System.out.println("Character level up");
                exp = 0;
                hp+=1;
            }
        }

        void attack(){
            int x = 10; // Random
            if(x == 5){
                System.out.println(classCharacter + " attack: " + damage);
            } else if(x == 10){
                System.out.println(classCharacter + "" +
                        " attack: " + damage * 2);
            }
        }
}
