public class Animal<T> {

    protected String name;
    protected T type;

    public String getType() {
        return type.getClass().getSimpleName();
    }
}
