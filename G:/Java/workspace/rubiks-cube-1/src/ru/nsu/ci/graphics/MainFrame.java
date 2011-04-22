package ru.nsu.ci.graphics;

import java.awt.*;
import java.awt.event.*;

import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;

import com.jogamp.opengl.util.Animator;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		
		JFrame frame = new JFrame("Rubiks Cube Interpreter");
		JTextArea text = new JTextArea(25,30);
		JPanel panelDraw = new JPanel();
		JPanel panelControl = new JPanel();
		JButton button = new JButton("Выход");
		
		GLCanvas canvas = new GLCanvas();
		Animator animator = new Animator(canvas);
		frame.setLayout(new GridLayout(1,2));
		
		frame.setSize(800, 500);
		frame.setResizable(false); 
		frame.add(panelDraw);
		frame.add(panelControl);

		panelControl.setSize(400, 400);
		panelDraw.setSize(400, 400);
		panelDraw.setBackground(Color.CYAN);
		panelControl.setBackground(Color.CYAN);
		
		panelControl.add(text);
		panelControl.add(button);
		button.setSize(100, 50);
	    JOGL_draw.main(null, panelDraw, frame);
	    
		animator.start();
		canvas.requestFocus();
		
	  //  frame.pack();
		frame.setVisible(true);
		
	}

}
