
package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
Test

Автотест для Класс Калькулятор. 
@author Maxim Sutyagin (m.sutyagin.m@gmail.com)
@since 10.01.19
@version 1.0
*/

public class CalculateTest {
	/**
	* Test echo.
	*/

	@Test
	public void whenTakeNameThenThreeEchoPlusName () {
		
		// Определяем переменную input, размещаем входящую строку
		String input = "Maxim Sutyagin";
		// Определяем переменную expect, размещаем там итоговую, ожидаемую строку
		String expect = "Echo, echo, echo : Maxim Sutyagin";
		
		// Создание нового объекта
		Calculate calc = new Calculate();
		
		//Выполнение метода echo с параметром input и запись ее в переменную result.
		String result = calc.echo(input);
		
		//Сравниваем ожидание и результат
		assertThat(result, is(expect));
	}
	
}