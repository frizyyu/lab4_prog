import Characters.*;
import enums.Animals;
import enums.Things;
import interfaces.ShortySpeakInterface;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws MyIOException
    {
        CreateNeznayka m = new CreateNeznayka("Незнайка", 15, 150);
        System.out.println(m.toString());
        m.SayHello();

        ShortySpeakInterface ShortySpeak = new ShortySpeakInterface() {
            @Override
            public void Say(String name, int num) throws MyRuntimeException{
                System.out.println(String.format("Я коротышка %s. Меня зовут %s", num, name));
                switch (num){
                case 1:
                    System.out.println("Мне стало скучно и я притихла.");
                    break;
                case 2:
                    System.out.println("Мне тоже стало скучно и я замолчала.");
                    break;
                }
            }
        };
        ShortySpeak.Say("Алина", 1);
        ShortySpeak.Say("Марина", 2);

        m.TooSleep();
        m.Attack();
        m.Hide();
        m.Fight();
        m.NameWhatItIs(Animals.BUGS, Things.GARBAGE);
        m.GoAfk();
        m.NameANewAnimal(Animals.DINOSAURS);
        Animal r = new Animal();
        r.TellYourRole();
    }
}

class MyIOException extends IOException {
    public MyIOException(String e){
        super(e);
    }
}

class MyRuntimeException extends RuntimeException{
    public MyRuntimeException(String e){
        super(e);
    }
}