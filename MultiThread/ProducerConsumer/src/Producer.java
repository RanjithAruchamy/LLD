import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private final Store store;
    private final Semaphore prodSemaphore;
    private final Semaphore consumerSemaphore;

    public Producer(Store store, Semaphore prodSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.prodSemaphore = prodSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }


    @Override
    public void run() {
        while (true) {
            try {
                prodSemaphore.acquire();
                store.addItem(new Object());
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
