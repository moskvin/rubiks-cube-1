package ru.nsu.ci;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Deque;
import ru.nsu.ci.RubicNode;
import ru.nsu.ci.translator.ASTturn;
import ru.nsu.ci.translator.ASTtunum;
import ru.nsu.ci.translator.ASTg;
import ru.nsu.ci.translator.ASTstart;
import ru.nsu.ci.translator.ASTend;
import ru.nsu.ci.translator.ASTtemp;
import ru.nsu.ci.translator.ASTcancel;
import ru.nsu.ci.translator.ASTfore;
import ru.nsu.ci.translator.ASTmov;
import ru.nsu.ci.translator.ASTrestart;
import ru.nsu.ci.translator.Node;
import ru.nsu.ci.translator.SimpleNode;
import ru.nsu.ci.translator.SIVisitor;
//import ru.nsu.ci.translator.ASTtemp2;



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
		int num;
		String lett;
		printStream.println(identString()+node);
		++indent;
		data = node.childrenAccept(this,data);
		--indent;
		num=node.getNum();
        lett=node.getLett();
	    return data;
	        
		}
	
	public Object visit (ASTcancel node, Object data)
	{
		int num;
		printStream.println(identString()+node);
	   ++indent;
		data = node.childrenAccept(this,data);
		--indent;
		num=node.getNum();
		return data;
		}
	
	public Object visit (ASTfore node, Object data)
	{   

		int num;
		printStream.println(identString()+node);
	    ++indent;
	    num=node.getNum();
	    System.out.println("prishol = " + num);
	    for (int i = 0; i<num; i++)
	    {
		data = node.childrenAccept(this,data);
	    }
		System.out.println("number of child = " + node.jjtGetNumChildren());
		--indent;
		return data;
		}
	
	
	public Object visit (ASTend node, Object data)
	{ 	
		printStream.println(identString()+node);
		++indent;
		data = node.childrenAccept(this,data);
		--indent;		
	    return data;
	        
		}
	
	
	public Object visit (ASTmov node, Object data)
	{
		int num;
		printStream.println(identString()+node);
	    ++indent;
		data = node.childrenAccept(this,data);
		--indent;
        num=node.getNum();
        
      /*  if (num>6 || num <1)
			 throw new NumStorError("Допустимое число от 1 до 6");	*/
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
	{   int num=0;
		printStream.println(identString()+node);
	    ++indent;
		data = node.childrenAccept(this,data);
		--indent;
		//num=node.getNum();
		//System.out.println("prishol = " + num);
        //Node n = node.jjtGetParent();
        //RubicNode rn = (RubicNode)n;
        //rn.setNum(num);
		return data;
		}
	

	
	public Object visit (ASTstart node, Object data)
	{ 	
		printStream.println(identString()+node);
		++indent;
		data = node.childrenAccept(this,data);
		--indent;
	    return data;
	        
	}
	
	public Object visit (ASTg node, Object data)
	{ 	
		printStream.println(identString()+node);
		++indent;
		data = node.childrenAccept(this,data);
		--indent;
	    return data;
	}	
	
	public Object visit (ASTtunum node, Object data)
	{ 	
		printStream.println(identString()+node);
		++indent;
		data = node.childrenAccept(this,data);
		--indent;
		int num=0;
		num=node.getNum();
		if (num>3 || num <1)
			 throw new NumStorError("Допустимое число от 1 до 3");		
	    return data;
	}	
}
