import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {

    private final Node node;
    private final ExecutorService executorService;

    public TreeSizeCalculator (Node root, ExecutorService executorService) {
        this.node = root;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws ExecutionException, InterruptedException {
        if (node == null) {
            return 0;
        }

        Future<Integer> leftHeight = executorService.submit(new TreeSizeCalculator(node.getLeft(), executorService));
        Future<Integer> rightHeight = executorService.submit(new TreeSizeCalculator(node.getLeft(), executorService));

        return Math.max(leftHeight.get(), rightHeight.get()) + 1;
    }
}
