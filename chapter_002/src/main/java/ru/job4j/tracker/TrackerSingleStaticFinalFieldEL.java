package ru.job4j.tracker;

public class TrackerSingleStaticFinalFieldEL {
    private static final TrackerSingleStaticFinalFieldEL INSTANCE = new TrackerSingleStaticFinalFieldEL();

    private TrackerSingleStaticFinalFieldEL() {
    }

    public static TrackerSingleStaticFinalFieldEL getInstance() {
        return INSTANCE;
    }

    private final Tracker tracker = new Tracker();

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }

    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }
}
