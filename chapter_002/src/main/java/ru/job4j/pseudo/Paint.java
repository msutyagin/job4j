package ru.job4j.pseudo;

/**
 * Класс - context в терминах шаблона strategy. Шаг 3.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 */
public class Paint {
    private Shape shape;

    /**
     * Стандартный конструктор
     */
    public Paint() {
    }

    /**
     * Конструктор класса. Прнимаем произвольную фигуру для отрисовки.
     * @param shape - фигрура передаваемая в конструктор.
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Метод рисует фигуру переданную в него в качестве параметра.
     * @param shape - Фигура для отрисовки.
     */
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    /**
     * РИсует в консоли квадрат и треугольник
     * @param args - аргументы метода main.
     */
    public static void main(String[] args) {
        Paint square = new Paint(new Square());
        square.draw(new Square());
        Paint triangle = new Paint(new Triangle());
        triangle.draw(new Triangle());
    }
}
