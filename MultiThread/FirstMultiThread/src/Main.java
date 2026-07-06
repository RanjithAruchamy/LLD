//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hey I'm running in a main thread, my thread name is %s%n", Thread.currentThread().getName());
        Runnable firstThread = new MyFirstThread();
        Thread thread = new Thread(firstThread, "FirstThread");
        thread.start();
    }
}