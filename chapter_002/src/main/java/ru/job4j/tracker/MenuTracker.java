package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(0, new AddItem(0, "Добавление заявки"));
        this.actions.add(1, new ShowAllItems(1, "Показать все заявки"));
        this.actions.add(2, new EditItem(2, "Редактирование заявки"));
        this.actions.add(3, new DeleteItem(3, "Удаление заявки"));
        this.actions.add(4, new FindById(4, "Найти заявку по Id"));
        this.actions.add(5, new FindByName(5, "Найти заявки по имени"));
        this.actions.add(6, new Exit(6, "Выход", ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    /**
     * Внутренний класс реализует добавленяи новый заявки в хранилище.
     */
    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка с id : " + item.getId() + " -----------");
            output.accept("------------ Имя новой заявки : " + item.getName() + " ------------");
            output.accept("------------ Описание новой заявки : " + item.getDescription() + " ------------");
        }
    }

    /**
     * Внутренний класс реализует поиск и вывод всех заявок.
     */
    public class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Вывод всех заявок --------------");
            List<Item> result = tracker.findAll();
            int i = 0;
            for (Item el : result) {
                output.accept("------------ заявка " + i++ + " : -----------");
                output.accept("Id: " + el.getId() + ", name: " + el.getName() + ", description: " + el.getDescription());
            }
        }
    }

    /**
     * Внутренний класс реализует редактирование заявки.
     */
    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Редактирование заявки --------------");
            String id = input.ask("Введите Id заявки для редактирования: ");
            String newName = input.ask("Введите новое имя заявки");
            String newDescription = input.ask("Введите новое описание заявки");
            Item item = new Item(newName, newDescription);
            if (tracker.replace(id, item)) {
                output.accept("------------ Заявка с Id : " + item.getId() + " отредактирована-----------");
            } else {
                output.accept("------------ Заявка с Id : " + item.getId() + " не найдена-----------");
            }
        }
    }

    /**
     * Внутренний класс реализует удаление заявки.
     */
    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки --------------");
            String id = input.ask("Введите Id заявки для удаления: ");
            if (tracker.delete(id)) {
                output.accept("------------ Заявка с Id : " + id + " удалена-----------");
            } else {
                output.accept("------------ Заявка с Id : " + id + " не найдена-----------");
            }
        }
    }

    /**
     * Внутренний класс реализует вывод на эакран заявки по Id.
     */
    public class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по Id--------------");
            String id = input.ask("Введите Id заявки : ");
            Item result = tracker.findById(id);
            if (result.getId() != null && result.getId().equals(id)) {
                output.accept("------------ Заявка с Id : " + id + " найдена-----------");
                output.accept("Id: " + result.getId() + ", name: " + result.getName() + ", description: " + result.getDescription());
            } else {
                output.accept("------------ Заявка с Id : " + id + " не найдена-----------");
            }
        }
    }

    /**
     * Внутренний класс реализует вывод на эакран заявки по имени.
     */
    public class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявок по названию--------------");
            String key = input.ask("Введите название заявки : ");
            if (!tracker.findByName(key).isEmpty()) {
                output.accept("------------ Найдены заявки: -----------");
                for (Item el : tracker.findByName(key)) {
                    output.accept("Id: " + el.getId() + ", name: " + el.getName() + ", description: " + el.getDescription());
                }
            } else {
                output.accept("------------ Заявка с name : " + key + " не найдена-----------");
            }
        }
    }

    /**
     * Внутенний класс реализует выход из программы.
     */
    public class Exit extends BaseAction {
        private final StartUI ui;

       public Exit(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("Выбран пункт меню 6. Выход из программы. До свидания");
            this.ui.stop();
        }
    }
}
