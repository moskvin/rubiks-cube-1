package ru.nsu.ci;

import ru.nsu.ci.RubicVisitor;
import ru.nsu.ci.graphics.MainFrame;
import ru.nsu.ci.translator.*;
import java.io.*;
import java.nio.charset.Charset;


/**
 * Здесь должна запускаться графика,
 * возможно инициализация компонентов
 */


public class Main {
	

	public static void main(String[] args) throws ParseException, TokenMgrError, NumberFormatException
{		
		new MainFrame();
        SI si=new SI(System.in);
        si.start();
    //    RubicVisitor visitorC = new RubicVisitor();
    //    si.rootNode().jjtAccept(visitorC,null);
	}
}
