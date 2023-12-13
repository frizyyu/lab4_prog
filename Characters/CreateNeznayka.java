package Characters;

import enums.Animals;
import enums.Things;

import java.util.Objects;
import static java.lang.Math.*;

public class CreateNeznayka extends Character.Neznayka {
    String strenght;
    boolean is_dropped_down = false;

    public CreateNeznayka(String name, int age, int force) {
        super(name, age, force);
    }

    String[] SelectWhatSay(String... args){
        int random = (int) (random() * args.length - 1);
        String[] what_say = new String[args.length];
        for (int i = 0; i < args.length; i  += 1){
            what_say[i] = args[i];
        }
        String res = Integer.toString(random);
        String[] ress = new String[2];
        ress[0] = what_say[random];
        ress[1] = res;
        return ress;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Статистика персонажа:\n%s", Return_Spec());
    }

    @Override
    public void SayHello(){
        class SayHello{
            SayHello(){
                if (force > 100)
                    strenght = "очень сильный!";
                else
                    strenght = "слабоват..";
                String s = String.format("Привет, меня зовут %s! Я - главный герой этой истории.\nМне %s лет и я %s\n", name, age, strenght);
                System.out.println(s);
            }
        }
        SayHello sh = new SayHello();
    }


    @Override
    public void TooSleep() {
        System.out.println(SelectWhatSay(
                String.format("%s лёг на полку, чтобы хорошенько отдохнуть.", name),
                String.format("Захотев поспать, %s решил сесть на стул и опереться на стену.", name),
                String.format("%s решил отдохнуть, поэтому он начал укладываться на диван.", name),
                String.format("%s уже начинал засыпать, поэтому он прилёг на диван.", name))[0]);
        System.out.println("Герой лёг поудобнее, закрыл глаза и погрузился в сон");
        System.out.println("Вдруг произошло что-то неожиданное.");
    }
    @Override
    public void Attack(){
        String[] r = SelectWhatSay(
                "напали какие-то маленькие зверушки.",
                "напали будто какие-то насекомые и начали кусать.",
                "упали какие-то тяжёлые вещи.",
                "что-то навалилось и придавило сверху.");
        is_dropped_down = !Objects.equals(r[1], "0") && !Objects.equals(r[1], "1");
        String s = String.format("Скоро он почувствовал, что на него %s", r[0]);
        System.out.println(s);
    }

    @Override
    public void Hide() {
        if (!is_dropped_down){
            System.out.println(SelectWhatSay(
                    String.format("%s отпрыгнул в сторону и попятился назад.", name),
                    String.format("%s счёл это неожиданным.", name),
                    String.format("%s был растерян, поэтому просто сел на пол.", name),
                    String.format("%s решил, что лучшем решением будет отойти в сторону.", name))[0]);
        }
        else
            System.out.println(SelectWhatSay(
                    String.format("%s с трудом поднял вещи с себя и принялся их рассматривать.", name),
                    String.format("%s потёр затылок и неспешно поднялся.", name),
                    String.format("Вещи были очень тяжёлыми, %s с трудом вылез из под них.", name),
                    String.format("%s отполз в сторону, скинув с себя груз.", name))[0]);
    }

    @Override
    public void Fight() {
        int opp_force = (int) (random() * 100);
        if (force < opp_force && !is_dropped_down) {
            System.out.println(SelectWhatSay(
                    "Герой долго дрался с живностью, но проиграл.",
                    "Герой был сильно закусан.")[0]);
            System.exit(0);
        }
        else if (force >= opp_force && !is_dropped_down)
            System.out.println(SelectWhatSay(
                    String.format("%s долго дрался с живностью и выиграл.", name),
                    String.format("%s победил зверушек.", name))[0]);
    }

    @Override
    public void NameWhatItIs(Animals a, Things t){
        if (!is_dropped_down)
            //System.out.println(Select_an(a));
            System.out.printf("%s подошёл к животным. Как оказалось, это были %s.%n", name, ChooseAlive(a));
        else
            System.out.printf("%s подошёл к разбросанным вещам. Как оказалось, это %s.%n", name, ChooseInanimate(t));
    }

    @Override
    public String ChooseAlive(Animals a) {
        return switch (a) {
            case BUGS -> "жуки";
            case COCKROACHES -> "тараканы";
            case DINOSAURS -> "динозавры";
        };
    }

    @Override
    public String ChooseInanimate(Things t) {
        return switch (t) {
            case SUITCASES -> " были пустые чемоданы";
            case KETTLEBELLS -> "были разные гантели";
            case GARBAGE -> "был всякий мусор";
        };
    }

    @Override
    public void GoAfk(){
        System.out.println(SelectWhatSay(
                String.format("%s поглядел на это всё и отправился дальше спать.", name),
                "Наш герой решил продолжить отдыхать.")[0]);
        System.out.println("Вдруг он что-то почувствовал.");
    }
    @Override
    public void NameANewAnimal(Animals a) {
        System.out.printf("Оказывается, что %s почувствовал, как его ногу облизывают %s.%n", name, ChooseAlive(a));
    }
}
