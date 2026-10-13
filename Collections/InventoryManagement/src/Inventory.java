import exceptions.InvalidQuantityException;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory<T extends Item> {

    private final Map<String, T> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(T item) throws InvalidQuantityException {
        if (item.getQuantity() <= 0) {
            throw new InvalidQuantityException("Quantity cannot be zero..");
        }

        items.putIfAbsent(getId(item), item);
    }

    public void removeItem(String id) {
        items.remove(id);
    }

    public T getItem(String id) {
        if (items.containsKey(id)) {
            return items.get(id);
        }
        return null;
    }

    public Collection<T> getAllItems() {
        return items.values();
    }

    private String getId(T item) {
        return item.getId().toString();
    }

    public Collection<Item> filterByPriceRange(double minPrice, double maxPrice) {
        List<Item> items = new ArrayList<>(getAllItems());

        return items.stream()
                .sorted(new ItemPriceComparator())
                .filter(item -> item.getPrice() >= minPrice && item.getPrice() <= maxPrice)
                .toList();
    }

    public Collection<Item> filterByAvailability() {
        List<Item> items = new ArrayList<>(getAllItems());

        return items.stream()
                .sorted(new ItemQuantityComparator())
                .filter(item -> item.getQuantity() > 0)
                .collect(Collectors.toList());
    }
}
