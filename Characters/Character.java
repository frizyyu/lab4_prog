package Characters;

import enums.Animals;
import enums.Things;
import interfaces.ToNameInterface;
import interfaces.*;

public abstract class Character implements ToNameInterface, ActionInterface, ChooseAnAttackerInterface {
    String name;
    int age;
    int force;
    public Character(String name, int age, int force){
        this.name = name;
        this.age = age;
        this.force = force;
    }
    static class Neznayka extends Character{
        public Neznayka(String name, int age, int force) {
            super(name, age, force);
        }

        @Override
        public void SayHello() {
            class SayHello{
                public SayHello() {
                    System.out.println("Всем привет!!");
                }
            }

        }

        @Override
        public void TooSleep() {

        }

        @Override
        public void Hide() {

        }

        @Override
        public void GoAfk() {

        }

        @Override
        public void Attack() {

        }

        @Override
        public void Fight() {

        }

        @Override
        public String ChooseInanimate(Things t) {
            return null;
        }

        @Override
        public String ChooseAlive(Animals a) {
            return null;
        }

        @Override
        public void NameWhatItIs(Animals a, Things t) {

        }

        @Override
        public void NameANewAnimal(Animals a) {

        }
    }
    public String Return_Spec(){
        return String.format("Имя: %s\nВозраст: %s\nСила: %s\n", name, age, force);
    }

    public abstract void SayHello();

    static class Animal{
        Animal(){
        }
        public void TellYourRole(){
        }
    }
}
