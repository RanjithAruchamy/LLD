import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private final Store store;
    private final Semaphore prodSemaphore;
    private final Semaphore consumerSemaphore;

    public Consumer(Store store, Semaphore prodSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.prodSemaphore = prodSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                prodSemaphore.release();
                store.removeItem();
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
