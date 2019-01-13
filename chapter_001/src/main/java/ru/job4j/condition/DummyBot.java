package ru.job4j.condition;

/**
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @version 1.0
 * @since 13.01.19
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
