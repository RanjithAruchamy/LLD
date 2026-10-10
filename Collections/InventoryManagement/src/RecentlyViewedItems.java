import java.util.Collection;
import java.util.LinkedList;

public class RecentlyViewedItems<T extends Item> {

    private final LinkedList<T> recentlyViewedItems;
    private static final Integer MAX_SIZE = 3;

    public RecentlyViewedItems() {
        this.recentlyViewedItems = new LinkedList<>();
    }

    public void addRecentlyViewedItem(T item) {
        recentlyViewedItems.remove(item);

        recentlyViewedItems.addFirst(item);
        if (recentlyViewedItems.size() > MAX_SIZE) {
            recentlyViewedItems.removeLast();
        }
    }

    public Collection<T> getRecentlyViewedItems() {
        return recentlyViewedItems;
    }
}
