/*package ru.nsu.ci;

import ru.nsu.ci.graphics.MainFrame;

/**
 * Здесь должна запускаться графика,
 * возможно инициализация компонентов
 */
/*
public class Main {
	public static void main(String[] args) {
		new MainFrame();
	}
}
*/
package ru.nsu.ci;

import ru.nsu.ci.graphics.MainFrame;
import ru.nsu.ci.translator.SI;
import ru.nsu.ci.translator.ParseException;
import ru.nsu.ci.translator.TokenMgrError;

/**
 * Здесь должна запускаться графика,
 * возможно инициализация компонентов
 */
public class Main {
	public static void main(String[] args) throws ParseException, TokenMgrError, NumberFormatException
{
		new MainFrame();
        SI si=new SI(System.in);
        si.start(System.out);
	}
}
