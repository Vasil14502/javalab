package ua.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class GenericRepository<T> {
    protected final List<T> items = new ArrayList<>();
    protected final IdentityExtractor<T> extractor;
    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());

    public GenericRepository(IdentityExtractor<T> extractor) {
        this.extractor = extractor;
    }

    public void add(T item) {
        items.add(item);
        logger.info("Added: " + String.valueOf(item));
    }

    public void remove(T item) {
        items.remove(item);
        logger.info("Removed: " + String.valueOf(item));
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public T findByIdentity(String id) {
        for (T item : items) {
            if (extractor.getIdentity(item).equals(id)) {
                logger.info("Found by identity: " + String.valueOf(item));
                return item;
            }
        }
        logger.warning("No item found with id: " + id);
        return null;
    }

    public void sortByIdentity(String order) {
        if (order == null) return;
        Comparator<T> comp = Comparator.comparing(extractor::getIdentity);
        if ("desc".equalsIgnoreCase(order)) comp = comp.reversed();
        items.sort(comp);
        logger.info("Sorted by identity: " + order);
    }
}
