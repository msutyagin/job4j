package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String description;
    private long created;
    private String[] comments;

    /**
     * Конструктор по умолчанию.
     */
    public Item() {
    }

    /**
     * Основной конструктор класса.
     * @param name - Название заявки.
     * @param desc - Описание заявки.
     * @param created - Время создания заявки в мс.
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.description = desc;
        this.created = created;
    }

    /**
     * Короткий констркутор.
     * @param name - Название заявки.
     * @param desc - Описание заявки.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    /**
     * Геттер для получения id заявки.
     * @return - ID заявки.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Геттер для получения времени создания заявки в милисекундах.
     * @return - время создания заявки в милисекундах.
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * Геттер для получения имени заявки.
     * @return - ID заявки.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер для получения описания заявки.
     * @return - ID заявки.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Сеттер для установки нового идентификатора
     * @param id - Новый идентификатор
     */
    public void setId(String id) {
        this.id = id;
    }
}
