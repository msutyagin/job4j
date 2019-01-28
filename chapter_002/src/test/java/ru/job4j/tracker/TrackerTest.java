package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

    /**
     * Тестрируем метод add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Тестрируем метод replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тестрируем метод delete.
     */
    @Test
    public void whenDeleteSecondItemThenNewSecondItemIsThirdLast() {
        Tracker tracker = new Tracker();
        Item one = new Item("Test1", "Desc1", 123L);
        tracker.add(one);
        Item two = new Item("Test2", "Desc2", 1234L);
        tracker.add(two);
        Item three = new Item("Test3", "Desc3", 12345L);
        tracker.add(three);
        tracker.delete(two.getId());
        assertThat(tracker.findAll()[1].getId(), is(three.getId()));
    }

    /**
     * Тестрируем метод findAll. (Не придумал как протестировать)
     */
    @Test
    public void whenTreeItemsThenReturnThem() {
        Tracker tracker = new Tracker();
        Item one = new Item("Task1", "Desc1", 123L);
        tracker.add(one);
        Item two = new Item("Test2", "Desc2", 1234L);
        tracker.add(two);
        Item three = new Item("Task3", "Desc3", 12345L);
        tracker.add(three);
        Item[] result = tracker.findAll();
        Item[] expected = {one, two, three};
        assertThat(result, is(expected));
    }

    /**
     * Тестрируем метод findByName.
     */
    @Test
    public void whenHaveTwoItemsWithSameNameThenReturnThem() {
        Tracker tracker = new Tracker();
        Item one = new Item("Task", "Desc1", 123L);
        tracker.add(one);
        Item two = new Item("Test2", "Desc2", 1234L);
        tracker.add(two);
        Item three = new Item("Task", "Desc3", 12345L);
        tracker.add(three);
        Item four = new Item("Task4", "Desc4", 123456L);
        tracker.add(four);
        Item[] result = tracker.findByName("Task");
        Item[] expected = {one, three};
        assertThat(result, is(expected));
    }

    /**
     * Тестрируем метод findById.
     */
    @Test
    public void whenKnowIdThenReturnItemWithIt() {
        Tracker tracker = new Tracker();
        Item one = new Item("Task", "Desc1", 123L);
        tracker.add(one);
        Item two = new Item("Test2", "Desc2", 1234L);
        tracker.add(two);
        Item three = new Item("Task", "Desc3", 12345L);
        tracker.add(three);
        Item four = new Item("Task4", "Desc4", 123456L);
        tracker.add(four);
        Item result = tracker.findById(one.getId());
        assertThat(result, is(one));
    }
}