package day4.oop.inheritance;

public class HondaCar extends Car{

    String logo;
    String horsePower;

    public HondaCar(){
        super("Honda");
    }

    @Override
    protected void display(){
        System.out.println("Print from honda car");
    }
}


