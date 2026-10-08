import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            arr.add(new Random(100).nextInt());
        }

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        List<Future<Long>> futureList = new ArrayList<>();
        int chunkSize = arr.size() / numberOfCores;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCores);
        for (int i = 0; i < numberOfCores; i++) {
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;
            Task task = new Task(arr, start, end);
            futureList.add(executorService.submit(task));
        }

        Long result = 0L;
        for (Future<Long> future : futureList) {
            result += future.get();
        }
        System.out.println(result);
        executorService.close();
    }
}