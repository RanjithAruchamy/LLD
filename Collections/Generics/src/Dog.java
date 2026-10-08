public class Dog extends Animal<Dog> {

    public Dog(String name) {
        super.name = name;
        super.type = this;
    }
}
