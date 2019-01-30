package ru.job4j.tracker;


public class StartUI {
    /**
     * Константы меню
     */
    private static final String ADD = "0";
    private static final String SHOWWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWWALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findItemById();
            } else if (FINDNAME.equals(answer)) {
                this.findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Введен неверный пункт меню, повторите попытку:");
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        // добавить остальные пункты меню.
        System.out.println("0. Добавление заяки");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактирование заявки");
        System.out.println("3. Удаление заявки");
        System.out.println("4. Найти заявку по Id");
        System.out.println("5. Найти заявки по имени");
        System.out.println("6. Выход");
    }

    /**
     * Запускт программы.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с id : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует поиск и вывод всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Вывод всех заявок --------------");
        Item[] result = this.tracker.findAll();
        for (int i = 0; i < result.length; i++) {
            System.out.println("------------ заявка " + i + " : -----------");
            System.out.println("Id: " + result[i].getId() + ", name: " + result[i].getName() + ", description: " + result[i].getDescription());
        }
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите Id заявки для редактирования: ");
        String newName = this.input.ask("Введите новое имя заявки");
        String newDescription = this.input.ask("Введите новое описание заявки");
        Item item = new Item(newName, newDescription);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Заявка с Id : " + item.getId() + " отредактирована-----------");
        } else {
            System.out.println("------------ Заявка с Id : " + item.getId() + " не найдена-----------");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите Id заявки для удаления: ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка с Id : " + id + " удалена-----------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена-----------");
        }
    }

    /**
     * Метод реализует вывод на эакран заявки по Id.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по Id--------------");
        String id = this.input.ask("Введите Id заявки : ");
        Item result = this.tracker.findById(id);
        if (result.getId() != null && result.getId().equals(id)) {
            System.out.println("------------ Заявка с Id : " + id + " найдена-----------");
            System.out.println("Id: " + result.getId() + ", name: " + result.getName() + ", description: " + result.getDescription());
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена-----------");
        }
    }

    /**
     * Метод реализует вывод на эакран заявокки по имени.
     */
    private void findItemsByName() {
        System.out.println("------------ Поиск заявок по названию--------------");
        String key = this.input.ask("Введите название заявки : ");
        if (this.tracker.findByName(key).length != 0) {
            for (int i = 0; i < this.tracker.findByName(key).length; i++) {
                System.out.println("------------ Найдены заявки: -----------");
                System.out.println("Id: " + this.tracker.findByName(key)[i].getId() + ", name: " + this.tracker.findByName(key)[i].getName() + ", description: " + this.tracker.findByName(key)[i].getDescription());
            }
        } else {
            System.out.println("------------ Заявка с name : " + key + " не найдена-----------");
        }
    }
}
