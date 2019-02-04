package ru.job4j.tracker;

/**
 * Класс отвечает за инициализацию и работу всего приложения. Основной класс приложения.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @version 0.1
 */
public class StartUI {
    /**
     * Константы меню
     */
    private static final int ADD = 0;
    private static final int SHOWALL = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FINDID = 4;
    private static final int FINDNAME = 5;
    private static final int EXIT = 6;
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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Выбирите пункт меню: ")));
        } while (!"y".equals(this.input.ask("Выйти из программы (y / n): ")));
    }

    /**
     * Запускт программы.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Внутренний класс реализует добавленяи новый заявки в хранилище.
     */
    public static class AddItem implements UserAction {
        @Override
        public int key() {
            return ADD;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с id : " + item.getId() + " -----------");
            System.out.println("------------ Имя новой заявки : " + item.getName() + " ------------");
            System.out.println("------------ Описание новой заявки : " + item.getDescription() + " ------------");
        }

        @Override
        public String info() {
            return "0. Добавление заявки";
        }
    }

    /**
     * Внутренний класс реализует поиск и вывод всех заявок.
     */
    public static class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return SHOWALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод всех заявок --------------");
            Item[] result = tracker.findAll();
            for (int i = 0; i < result.length; i++) {
                System.out.println("------------ заявка " + i + " : -----------");
                System.out.println("Id: " + result[i].getId() + ", name: " + result[i].getName() + ", description: " + result[i].getDescription());
            }
        }

        @Override
        public String info() {
            return "1. Показать все заявки";
        }
    }

    /**
     * Внутренний класс реализует редактирование заявки.
     */
    public static class EditItem implements UserAction {
        @Override
        public int key() {
            return EDIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите Id заявки для редактирования: ");
            String newName = input.ask("Введите новое имя заявки");
            String newDescription = input.ask("Введите новое описание заявки");
            Item item = new Item(newName, newDescription);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Заявка с Id : " + item.getId() + " отредактирована-----------");
            } else {
                System.out.println("------------ Заявка с Id : " + item.getId() + " не найдена-----------");
            }
        }

        @Override
        public String info() {
            return "2. Редактирование заявки";
        }
    }

    /**
     * Внутренний класс реализует удаление заявки.
     */
    public static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите Id заявки для удаления: ");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка с Id : " + id + " удалена-----------");
            } else {
                System.out.println("------------ Заявка с Id : " + id + " не найдена-----------");
            }
        }

        @Override
        public String info() {
            return "3. Удаление заявки";
        }
    }

    /**
     * Внутренний класс реализует вывод на эакран заявки по Id.
     */
    public static class FindById implements UserAction {
        @Override
        public int key() {
            return FINDID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id--------------");
            String id = input.ask("Введите Id заявки : ");
            Item result = tracker.findById(id);
            if (result.getId() != null && result.getId().equals(id)) {
                System.out.println("------------ Заявка с Id : " + id + " найдена-----------");
                System.out.println("Id: " + result.getId() + ", name: " + result.getName() + ", description: " + result.getDescription());
            } else {
                System.out.println("------------ Заявка с Id : " + id + " не найдена-----------");
            }
        }

        @Override
        public String info() {
            return "4. Найти заявку по Id";
        }
    }
    /**
     * Внутренний класс реализует вывод на эакран заявки по имени.
     */
    public static class FindByName implements UserAction {
        @Override
        public int key() {
            return FINDNAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по названию--------------");
            String key = input.ask("Введите название заявки : ");
            if (tracker.findByName(key).length != 0) {
                System.out.println("------------ Найдены заявки: -----------");
                for (int i = 0; i < tracker.findByName(key).length; i++) {
                    System.out.println("Id: " + tracker.findByName(key)[i].getId() + ", name: " + tracker.findByName(key)[i].getName() + ", description: " + tracker.findByName(key)[i].getDescription());
                }
            } else {
                System.out.println("------------ Заявка с name : " + key + " не найдена-----------");
            }
        }

        @Override
        public String info() {
            return "5. Найти заявки по имени";
        }
    }
    /**
     * Внутренний класс реализует выход из программы.
     */
    public static class Exit implements UserAction {
        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return "6. Выход";
        }
    }
}
