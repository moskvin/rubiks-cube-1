package ru.nsu.ci;

import java.io.PrintStream;

import ru.nsu.ci.translator.ASTturn;
import ru.nsu.ci.translator.ASTtemp;
import ru.nsu.ci.translator.ASTcancel;
import ru.nsu.ci.translator.ASTfore;
import ru.nsu.ci.translator.ASTmov;
import ru.nsu.ci.translator.ASTrestart;
import ru.nsu.ci.translator.SimpleNode;
import ru.nsu.ci.translator.SIVisitor;


public class RubicVisitor implements SIVisitor{
	private PrintStream printStream;
	private int indent=0;
	private boolean cic=false;
	public RubicVisitor(PrintStream printStream)	{
		this.printStream=printStream;
	}
	private String identString() {
		StringBuffer sb= new StringBuffer();
		for (int i = 0; i < indent; ++i)
		{
			sb.append(' ');
		}
		return sb.toString();
	}
	
	
	public Object visit (SimpleNode node, Object data)
	{return null;} 
	
	
	public Object visit (ASTturn node, Object data)
	{ 	
		printStream.println(identString()+node);
		++indent;
		data = node.childrenAccept(this,data);
		--indent;
	    return data;
	        
		}
	
	public Object visit (ASTcancel node, Object data)
	{  printStream.println(identString()+node);
	   ++indent;
		data = node.childrenAccept(this,data);
		--indent;
		return data;
		}
	
	public Object visit (ASTfore node, Object data)
	{   cic=true;
		printStream.println(identString()+node);
	    ++indent;
		data = node.childrenAccept(this,data);
		--indent;
		return data;
		}
	
	public Object visit (ASTmov node, Object data)
	{   printStream.println(identString()+node);
	    ++indent;
		data = node.childrenAccept(this,data);
		--indent;
		return data;
		}
	
	public Object visit (ASTrestart node, Object data)
	{   printStream.println(identString()+node);
	    ++indent;
		data = node.childrenAccept(this,data);
		--indent;
		return data;
		}
	
	public Object visit (ASTtemp node, Object data)
	{   printStream.println(identString()+node);
	    ++indent;
		data = node.childrenAccept(this,data);
		--indent;
		 return data;
		}
	
}




