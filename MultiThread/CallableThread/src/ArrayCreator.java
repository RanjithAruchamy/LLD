import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {
    private final int number;

    public ArrayCreator(int number) {
        this.number = number;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            list.add(i);
        }
        return list;
    }
}
