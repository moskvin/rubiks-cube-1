package ru.nsu.ci;

import java.io.PrintStream;

import ru.nsu.ci.common.RubicsCube;
import ru.nsu.ci.common.RubiksCubeInterface;
import ru.nsu.ci.translator.ASTcancel;
import ru.nsu.ci.translator.ASTend;
import ru.nsu.ci.translator.ASTfore;
import ru.nsu.ci.translator.ASTg;
import ru.nsu.ci.translator.ASTrestart;
import ru.nsu.ci.translator.ASTstart;
import ru.nsu.ci.translator.ASTtemp;
import ru.nsu.ci.translator.ASTtunum;
import ru.nsu.ci.translator.ASTturn;
import ru.nsu.ci.translator.SIVisitor;
import ru.nsu.ci.translator.SimpleNode;
import ru.nsu.ci.translator.Node;

//import ru.nsu.ci.translator.ASTtemp2;

public class RubicVisitor implements SIVisitor {

	private RubiksCubeInterface rubiccube;
	//private PrintStream printStream;
	private int indent = 0;
	private boolean cic = false;

	public RubicVisitor(RubiksCubeInterface rubiccube) {
		this.rubiccube = rubiccube;
	//	rubiccube.init();
	}

	/*private String identString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < indent; ++i) {
			sb.append(' ');
		}
		return sb.toString();
	}*/

	public Object visit(SimpleNode node, Object data) {
		return null;
	}

	public Object visit(ASTturn node, Object data) {
		int num;
		int num1;
		/*printStream.println(identString() + node);
		++indent;
		--indent;*/
		data = node.childrenAccept(this, data);

		num = node.getNum();
		num1 = node.getNum1();
		System.out.println("prishol = " + num);
		System.out.println("prishol = " + num1);
	    rubiccube.turnGoriz(num, num1);
		return data;

	}

	public Object visit(ASTcancel node, Object data) {
		int num;
		/*printStream.println(identString() + node);
		++indent;
		--indent;*/
		data = node.childrenAccept(this, data);
		num = node.getNum();
		rubiccube.abortStep(num);
		return data;
	}

	public Object visit(ASTfore node, Object data) {

		int num;
		num = node.getNum();
/*		printStream.println(identString() + node);
		++indent;		
		System.out.println("prishol = " + num);
		System.out.println("number of child = " + node.jjtGetNumChildren());
*/		for (int i = 0; i < num; i++) {
			data = node.childrenAccept(this, data);
		}
		--indent;
		return data;
	}

	public Object visit(ASTend node, Object data) {
		/*printStream.println(identString() + node);
		++indent;
		--indent;*/
		data = node.childrenAccept(this, data);
		return data;

	}

	public Object visit(ASTrestart node, Object data) {
		/*printStream.println(identString() + node);
		++indent;
		--indent;*/
		data = node.childrenAccept(this, data);
		rubiccube.restart();
		return data;
	}

	public Object visit(ASTtemp node, Object data) {
		int num = 0;
		/*printStream.println(identString() + node);
		++indent;
		--indent;
		// System.out.println("prishol = " + num);
*/		data = node.childrenAccept(this, data);
		num = node.getNum();
		Node n = node.jjtGetParent();
		RubicNode rn = (RubicNode) n;
		rn.setNum(num);
		return data;
	}

	public Object visit(ASTstart node, Object data) {
		/*printStream.println(identString() + node);
		++indent;
		--indent;*/
		data = node.childrenAccept(this, data);
		return data;

	}

	public Object visit(ASTg node, Object data) {
		/*printStream.println(identString() + node);
		++indent;
		--indent;*/
		data = node.childrenAccept(this, data);
		return data;
	}

	public Object visit(ASTtunum node, Object data) {
/*		printStream.println(identString() + node);
		++indent;
		--indent;
		// System.out.println("prishol = " + num);
	*/
		
		data = node.childrenAccept(this, data);
		int num = node.getNum();
		num = node.getNum();
		Node n = node.jjtGetParent();
		RubicNode rn = (RubicNode) n;
		rn.setNum(num);
		//System.out.println("prishol = " + num);
		if (num > 5 || num < 0)
			throw new NumStorError("Допустимое число от 0 до 5");
		return data;
	}
}
