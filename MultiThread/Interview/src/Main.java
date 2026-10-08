import java.time.Instant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private final int capacity;
    private int requestCount;
    private Instant startTimeMillis;

    public Main(int capacity) {
        this.capacity = capacity;
        this.requestCount = 0;
        this.startTimeMillis = Instant.now();
    }

    public boolean rateLimitter () {
//        System.out.println(requestCount);
        requestCount++;
        refreshCount();

        if (requestCount > capacity)
            return false;

        return true;
    }

    private void refreshCount() {
        if ((Instant.now().getNano() - startTimeMillis.getNano()) > 1000000) {
            requestCount = 0;
            startTimeMillis = Instant.now();
        }
    }

    public static void main(String[] args) {

        /*
        * Rate Limitter
        * QPS - 5 in Input
        * <= 5 - true
        * > 5 - false
        *
        * Refresh every second
        * */

        Main rateLimitter = new Main(5);

        for (int i = 0; i < 10; i++) {
            System.out.println(rateLimitter.rateLimitter());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("CurrentNanoSecond %d , originialNanoSecond %d, diff %d ",  Instant.now().getNano(), rateLimitter.startTimeMillis.getNano(), (Instant.now().getNano() - rateLimitter.startTimeMillis.getNano()));
        for (int i = 0; i < 10; i++) {
            System.out.println(rateLimitter.rateLimitter());
        }
    }
}