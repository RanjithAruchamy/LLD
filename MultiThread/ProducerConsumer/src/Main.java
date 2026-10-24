import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Store store = new Store(10);
        ExecutorService executorService = Executors.newCachedThreadPool();

        Semaphore prodSemaphore = new Semaphore(10);
        Semaphore consumerSemaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            Producer producer = new Producer(store, prodSemaphore, consumerSemaphore);
            executorService.execute(producer);
        }

        for (int i = 0; i < 15; i++) {
            Consumer consumer = new Consumer(store, prodSemaphore, consumerSemaphore);
            executorService.execute(consumer);
        }
    }
}