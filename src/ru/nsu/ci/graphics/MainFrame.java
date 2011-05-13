package ru.nsu.ci.graphics;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;
import ru.nsu.ci.NumStorError;
import ru.nsu.ci.translator.SI;
import ru.nsu.ci.translator.TokenMgrError;
import ru.nsu.ci.translator.ParseException;
import com.jogamp.opengl.util.Animator;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
				
		final JFrame frame = new JFrame("Rubiks Cube Interpreter");		
		
		Color darkViolet = new Color(66,49,137); 
		Color indigo = new Color(75,0,130);
		Font MC = new Font("Monotype Corsiva",0,20);
		Font MC2 = new Font("Monotype Corsiva",0,15);
		
		JPanel panelJOGL_draw = new JPanel();
		JPanel panelDraw = new JPanel();
		JPanel panelControl = new JPanel();
		
		final JTextArea text = new JTextArea(5,5);
		JScrollPane scrollpane = new JScrollPane(text);
	
		JButton start = new JButton("Запустить");
		JButton exit = new JButton("    Выход    ");
		JButton save = new JButton("Сохранить");
		JButton load = new JButton("Загрузить");
		JButton newgame = new JButton("Новая игра");
		
		GLCanvas canvas = new GLCanvas();
		Animator animator = new Animator(canvas);
		
		frame.setSize(800, 600);
		frame.setResizable(false); 
		
		GridBagLayout GBL = new GridBagLayout();
		frame.setLayout(GBL);
		GridBagConstraints c =  new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH; 
		c.fill   = GridBagConstraints.BOTH;  
		c.gridx = GridBagConstraints.RELATIVE; 
		c.gridy = GridBagConstraints.RELATIVE; 
		c.insets = new Insets(2, 2, 2, 2);
		c.weightx = 0.3; c.weighty = 0.3;
		
		c.ipadx = 0; c.ipady = 0;
		c.gridheight = 2;
		c.gridwidth = 1;
		GBL.setConstraints(panelControl, c);
		frame.add(panelControl);
		
		c.weightx = 0.3; c.weighty = 0.3;
		c.gridheight = 1;
		c.ipadx = 0; c.ipady = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		GBL.setConstraints(panelDraw, c);
		frame.add(panelDraw);

		c.ipadx = 0; c.ipady = 0;
		c.weightx = 0.3; c.weighty = 0.3;
		c.gridheight = 1; c.gridwidth = 1; 
		GBL.setConstraints(panelJOGL_draw, c);
		frame.add(panelJOGL_draw);
		
		panelDraw.setBackground(indigo);
		panelControl.setBackground(darkViolet);
		panelJOGL_draw.setBackground(Color.BLACK);
		
		panelControl.setLayout(GBL);
				
		c.anchor = GridBagConstraints.NORTH; 
		c.fill   = GridBagConstraints.NONE;  
		c.gridheight = 1; 	c.gridwidth =  5;
		c.gridx = 0;	c.gridy = 0; 
		c.insets = new Insets(2, 2, 2, 2);
		c.weightx = 0.6; c.weighty = 0.6;
		c.ipadx = 290;	c.ipady = 400;
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		text.setWrapStyleWord(true);
		text.setFont(MC);
		text.setLineWrap(true);
		GBL.setConstraints(scrollpane, c);
		panelControl.add(scrollpane);
		
		c.weightx = 0.1; c.weighty = 0.1; 
		
		start.setFont(MC2);
		save.setFont(MC2);
		newgame.setFont(MC2);
		load.setFont(MC2);
		exit.setFont(MC2);
		
		c.ipadx = 0;	c.ipady = 0;
		c.gridx = 0;	c.gridy = 1;
		c.gridheight = 1; c.gridwidth = 1; 
		GBL.setConstraints(start, c);
		panelControl.add(start);

		c.gridx = 1;	c.gridy = 1;
		c.gridheight = 1; c.gridwidth = 1; 
		GBL.setConstraints(save, c);
		panelControl.add(save);
		
		c.gridx = 2;	c.gridy = 1;
		c.gridheight = 1; c.gridwidth = 1; 
		GBL.setConstraints(load, c);
		panelControl.add(load);
		
		c.gridx = 0;	c.gridy = 2;
		c.gridheight = 1; c.gridwidth = 1; 
		GBL.setConstraints(newgame, c);
		panelControl.add(newgame);
		
		c.gridx = 1;	c.gridy = 2;
		c.gridheight = 1; c.gridwidth = 1; 
		GBL.setConstraints(exit, c);
		panelControl.add(exit);
						
	    JOGL_draw.main(null, panelJOGL_draw, frame);
	    JOGL_cube.main(null, panelDraw, frame);
	    
		animator.start();
		canvas.requestFocus();
		
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Загрузить")) {
					JFileChooser fileopen = new JFileChooser();
					int ret = fileopen.showOpenDialog(MainFrame.this);
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = fileopen.getSelectedFile();
						try {
							FileInputStream fis = new FileInputStream(file);
							DataInputStream dis = new DataInputStream(fis);
							text.setText("");
							while ((dis.available()) != 0) {
								text.setText(text.getText()+dis.readUTF()+"\n");								
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "File not found");
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "File not read");
						}
					}
				}
				else
					if (e.getActionCommand().equals("Сохранить")) {
						JFileChooser fileopen = new JFileChooser();
						int ret = fileopen.showSaveDialog(MainFrame.this);
						if (ret == JFileChooser.APPROVE_OPTION) {
							File file = fileopen.getSelectedFile();
							fileopen.setSelectedFile(file);
							try {
								FileOutputStream fos = new FileOutputStream(file);
								DataOutputStream dos = new DataOutputStream(fos);
								dos.writeUTF(text.getText());								
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "File not create");
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
								JOptionPane.showMessageDialog(null, "File not write");
							}
						}
						
					}
					else
						if (e.getActionCommand().equals("    Выход    ")){	
							System.exit(0);
						}
						else
							if (e.getActionCommand().equals("Запустить")){
								try {									
									SI.main(null, text.getText());																		
								}catch(NumStorError error){	
									JOptionPane.showMessageDialog(null, "Error");
								}catch(ParseException message){		
									JOptionPane.showMessageDialog(null, "Error");
								}catch(TokenMgrError  message){	
									JOptionPane.showMessageDialog(null, "Error");
								}
							}
							else
								if (e.getActionCommand().equals("Новая игра")){
									
								}
								
			}
		};
		load.addActionListener(actionListener);
		save.addActionListener(actionListener);
		exit.addActionListener(actionListener);
		start.addActionListener(actionListener);
		newgame.addActionListener(actionListener);
		
		frame.setVisible(true);
		frame.pack();
		
	}

}
