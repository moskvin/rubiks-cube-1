package ru.nsu.ci;

import ru.nsu.ci.RubicVisitor;
import ru.nsu.ci.graphics.MainFrame;
import ru.nsu.ci.translator.SI;
import ru.nsu.ci.translator.ParseException;
import ru.nsu.ci.translator.TokenMgrError;
import java.io.*;
import java.nio.charset.Charset;


/**
 * Здесь должна запускаться графика,
 * возможно инициализация компонентов
 */


public class Main {
	

	public static void main(String[] args) throws ParseException, TokenMgrError, NumberFormatException
{

        SI si=new SI(System.in);
        si.start(System.out);
        RubicVisitor visitorC = new RubicVisitor();
        si.rootNode().jjtAccept(visitorC,null);
	}
}
