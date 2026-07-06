import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayCreator arrayCreator = new ArrayCreator(10);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<List<Integer>> futureList = executorService.submit(arrayCreator);
        System.out.println(futureList.get());
        executorService.close();
    }
}