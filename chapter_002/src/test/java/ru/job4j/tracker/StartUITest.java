package ru.job4j.tracker;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 AutoTest for StartUITest class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 31.01.19
 @version 1.0
 */
public class StartUITest {

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

}
