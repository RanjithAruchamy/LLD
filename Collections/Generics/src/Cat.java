public class Cat extends Animal<Cat> {

    public Cat(String name) {
        super.name = name;
        super.type = this;
    }
}
