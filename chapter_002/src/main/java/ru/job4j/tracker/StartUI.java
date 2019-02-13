package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс отвечает за инициализацию и работу всего приложения. Основной класс приложения.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @version 0.1
 */
public class StartUI {
    private boolean working = true;


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
     * Сеттер для working
     */
    public void stop() {
        this.working = false;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Выбирите пункт меню: ", range));
        } while (this.working);
    }

    /**
     * Запускт программы.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    /**
     * Внутренний класс реализует добавленяи новый заявки в хранилище.
     */
    public static class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс реализует поиск и вывод всех заявок.
     */
    public static class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс реализует редактирование заявки.
     */
    public static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс реализует удаление заявки.
     */
    public static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс реализует вывод на эакран заявки по Id.
     */
    public static class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс реализует вывод на эакран заявки по имени.
     */
    public static class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
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
    }
    /**
     * Внутренний класс реализует выход из программы.
     */
    public static class Exit extends BaseAction {
        private final StartUI ui;

       public Exit(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Выбран пункт меню 6. Выход из программы. До свидания");
            this.ui.stop();
        }
    }
}
