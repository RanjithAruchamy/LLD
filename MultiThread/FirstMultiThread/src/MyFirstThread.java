public class MyFirstThread implements Runnable{
    @Override
    public void run() {
        System.out.printf("Hey I'm running in a new thread, my thread name is %s", Thread.currentThread().getName());
    }
}
