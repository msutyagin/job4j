package ru.job4j.tracker;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 AutoTest for StartUITest class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 31.01.19
 @version 1.0
 */
public class StartUITest {
    // получаем ссылку на стандартный вывод в консоль. Поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;

    // Создаем буфер для хранения вывода. Поле содержит буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();


    @Before
    public void loadOutput() {
        //    System.out.println("execute before method");
        //Заменяем стандартный вывод на вывод в память для тестирования.
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(this.stdout);
        //   System.out.println("execute after method");
    }


    /**
     * Тестирование метода StartUI.createItem.
     */
    @Test
    public void whenCreateItemThenNewItemInTrackerWithTheSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desc1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test1"));
    }

    /**
     * Тестирование метода StartUI.editItem.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тестирование метода StartUI.deleteItem.
     */
    @Test
    public void whenDeleteItemThenTrackerHasNotIt() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
    }

    /**
     * Тестирование метода Показать все заявки
     */
    @Test
    public void whenChooseShowAllItemsThenShowThem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test1", "Desc1"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2. Редактирование заявки")
                                .append(System.lineSeparator())
                                .append("3. Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4. Найти заявку по Id")
                                .append(System.lineSeparator())
                                .append("5. Найти заявки по имени")
                                .append(System.lineSeparator())
                                .append("6. Выход")
                                .append(System.lineSeparator())
                                .append("------------ Вывод всех заявок --------------")
                                .append(System.lineSeparator())
                                .append("------------ заявка 0 : -----------")
                                .append(System.lineSeparator())
                                .append("Id: " + tracker.findAll()[0].getId() + ", name: " + tracker.findAll()[0].getName() + ", description: " + tracker.findAll()[0].getDescription())
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2. Редактирование заявки")
                                .append(System.lineSeparator())
                                .append("3. Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4. Найти заявку по Id")
                                .append(System.lineSeparator())
                                .append("5. Найти заявки по имени")
                                .append(System.lineSeparator())
                                .append("6. Выход")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Тестирование метода интерфейса Найти заявку по Id.
     */
    @Test
    public void whenChooseFindItemByIdThenShowIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test1", "Desc1"));
        Input input = new StubInput(new String[]{"4", tracker.findAll()[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2. Редактирование заявки")
                                .append(System.lineSeparator())
                                .append("3. Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4. Найти заявку по Id")
                                .append(System.lineSeparator())
                                .append("5. Найти заявки по имени")
                                .append(System.lineSeparator())
                                .append("6. Выход")
                                .append(System.lineSeparator())
                                .append("------------ Поиск заявки по Id--------------")
                                .append(System.lineSeparator())
                                .append("------------ Заявка с Id : " + tracker.findAll()[0].getId() + " найдена-----------")
                                .append(System.lineSeparator())
                                .append("Id: " + tracker.findAll()[0].getId() + ", name: " + tracker.findAll()[0].getName() + ", description: " + tracker.findAll()[0].getDescription())
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2. Редактирование заявки")
                                .append(System.lineSeparator())
                                .append("3. Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4. Найти заявку по Id")
                                .append(System.lineSeparator())
                                .append("5. Найти заявки по имени")
                                .append(System.lineSeparator())
                                .append("6. Выход")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Тестирование метода интерфейса Найти заявки по имени.
     */
    @Test
    public void whenChooseFindItemsByNameThenShowThem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test1", "Desc1"));
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", "Test1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2. Редактирование заявки")
                                .append(System.lineSeparator())
                                .append("3. Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4. Найти заявку по Id")
                                .append(System.lineSeparator())
                                .append("5. Найти заявки по имени")
                                .append(System.lineSeparator())
                                .append("6. Выход")
                                .append(System.lineSeparator())
                                .append("------------ Поиск заявок по названию--------------")
                                .append(System.lineSeparator())
                                .append("------------ Найдены заявки: -----------")
                                .append(System.lineSeparator())
                                .append("Id: " + tracker.findAll()[0].getId() + ", name: " + tracker.findAll()[0].getName() + ", description: " + tracker.findAll()[0].getDescription())
                                .append(System.lineSeparator())
                                .append("Id: " + tracker.findAll()[1].getId() + ", name: " + tracker.findAll()[1].getName() + ", description: " + tracker.findAll()[1].getDescription())
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Добавление заявки")
                                .append(System.lineSeparator())
                                .append("1. Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2. Редактирование заявки")
                                .append(System.lineSeparator())
                                .append("3. Удаление заявки")
                                .append(System.lineSeparator())
                                .append("4. Найти заявку по Id")
                                .append(System.lineSeparator())
                                .append("5. Найти заявки по имени")
                                .append(System.lineSeparator())
                                .append("6. Выход")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
