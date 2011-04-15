package ru.nsu.ci;

import ru.nsu.ci.translator.ASTturn;
import ru.nsu.ci.translator.ASTtemp;
import ru.nsu.ci.translator.ASTcancel;
import ru.nsu.ci.translator.ASTfore;
import ru.nsu.ci.translator.ASTmov;
import ru.nsu.ci.translator.ASTrestart;
import ru.nsu.ci.translator.SimpleNode;
import ru.nsu.ci.translator.SIVisitor;

public class RubicVisitor implements SIVisitor{


	
	
	public Object visit (SimpleNode node, Object data)
	{return null;} 
	
	
	public Object visit (ASTturn node, Object data)
	{ return data;
		}
	
	public Object visit (ASTcancel node, Object data)
	{ return data;
		}
	
	public Object visit (ASTfore node, Object data)
	{ return data;
		}
	
	public Object visit (ASTmov node, Object data)
	{ return data;
		}
	
	public Object visit (ASTrestart node, Object data)
	{ return data;
		}
	public Object visit (ASTtemp node, Object data)
	{ return data;
		}
}