import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<Long> {

    private final Integer start;
    private final Integer end;
    private final List<Integer> arr;

    public Task(List<Integer> arr, Integer start, Integer end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        System.out.printf("Starting the new Process %s\n", Thread.currentThread().getName());
        Long sum = 0L;
        for (int i = start; i < end; i++) {
            sum += arr.get(i);
        }
        return sum;
    }
}
