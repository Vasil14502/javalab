package ua.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GenericRepository<T> {

    private final List<T> items = new ArrayList<>();
    private final IdentityExtractor<T> extractor;
    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());

    public GenericRepository(IdentityExtractor<T> extractor) {
        this.extractor = extractor;
    }

    public void add(T item) {
        items.add(item);
        logger.info("Added: " + item);
    }

    public void remove(T item) {
        items.remove(item);
        logger.info("Removed: " + item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public T findByIdentity(String id) {
        for (T item : items) {
            if (extractor.getIdentity(item).equals(id)) {
                logger.info("Found by identity: " + item);
                return item;
            }
        }
        logger.warning("No item found with id: " + id);
        return null;
    }
}
