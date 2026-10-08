import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        List<Dog> dogs = List.of(new Dog("Tommy"), new Dog("Rohit"));
        List<Cat> cats = List.of(new Cat("Rosy"), new Cat("Chikku"));
        List<Animal> animals = new ArrayList<>();
        animals.addAll(dogs);
        animals.addAll(cats);
        doSomething(animals);
    }

    public static void doSomething(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getType());
        }
    }
}