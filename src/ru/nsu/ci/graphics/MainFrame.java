package ru.nsu.ci.graphics;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;
import ru.nsu.ci.translator.ParseException;
import ru.nsu.ci.translator.TokenMgrError;
import ru.nsu.ci.translator.SI;
import ru.nsu.ci.EncodingTest;
import ru.nsu.ci.NumStorError;

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
		JButton help = new JButton("  Помощь  ");
		
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
		help.setFont(MC2);
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
		
		c.gridx = 2;	c.gridy = 2;
		c.gridheight = 1; c.gridwidth = 1; 
		GBL.setConstraints(help, c);
		panelControl.add(help);	
		
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
							JOGL_cube.rubicsCube.delrestartfile();
							System.exit(0);
							
						}
						else
							if (e.getActionCommand().equals("Запустить")){
								try {									
									SI.main(null,text.getText());									
								}catch(NumStorError error){										
								/*	s.replace("\u043f\u043e\u0427\u0430\u0441\u043e\u0432\u043e\u0439", "поЧасовой");
									s.replace("\u043f\u0440\u0427\u0430\u0441\u043e\u0432\u043e\u0439", "прЧасовой");
									s.replace("\u043f\u043e\u0432\u0435\u0440\u043d\u0443\u0442\u044c", "повернуть");
									s.replace("\u043f\u043e\u0432\u0442\u043e\u0440\u0438\u0442\u044c", "повторить");
									s.replace("\u0440\u0430\u0437", "раз");
									s.replace("\u0437\u0430\u043d\u043e\u0432\u043e", "заново");
									s.replace("\u043e\u0442\u043c\u0435\u043d\u0438\u0442\u044c", "отменить");*/									
									JOptionPane.showMessageDialog(null, filter(error.getMessage()),"Ошибка",JOptionPane.WARNING_MESSAGE);
								}catch(ParseException message){																	
									JOptionPane.showMessageDialog(null, filter(message.getMessage()),"Ошибка",JOptionPane.WARNING_MESSAGE);
								}catch(TokenMgrError  message){										
									JOptionPane.showMessageDialog(null, filter(message.getMessage()),"Ошибка",JOptionPane.WARNING_MESSAGE);
								}
							}
							else
								if (e.getActionCommand().equals("Новая игра")){
									 JOGL_cube.rubicsCube.delsavefile();
									
								}
								else
									if (e.getActionCommand().equals("  Помощь  ")){
										String s= "";
										JOptionPane.showMessageDialog(null,s,"Помощь",JOptionPane.INFORMATION_MESSAGE);																														
									}				
			}
		};
		load.addActionListener(actionListener);
		save.addActionListener(actionListener);
		exit.addActionListener(actionListener);
		start.addActionListener(actionListener);
		newgame.addActionListener(actionListener);
		help.addActionListener(actionListener);
		
		frame.setVisible(true);
		frame.pack();
		
	}
	 public static final Map<String, String> unicode;
     static {
        Map<String, String> aMap = new HashMap<String,String>();
        aMap.put("\\u0410","А");
        aMap.put("\\u0411","Б");
        aMap.put("\\u0412","В");
        aMap.put("\\u0413","Г");
        aMap.put("\\u0414","Д");
        aMap.put("\\u0415","Е");
        aMap.put("\\u0416","Ж");
        aMap.put("\\u0417","З");
        aMap.put("\\u0418","И");
        aMap.put("\\u0419","Й");
        aMap.put("\\u041A","К");
        aMap.put("\\u041B","Л");
        aMap.put("\\u041C","М");
        aMap.put("\\u041D","Н");
        aMap.put("\\u041E","О");
        aMap.put("\\u041F","П");
        aMap.put("\\u0420","Р");
        aMap.put("\\u0421","С");
        aMap.put("\\u0422","Т");
        aMap.put("\\u0423","У");
        aMap.put("\\u0424","Ф");
        aMap.put("\\u0425","Х");
        aMap.put("\\u0426","Ц");
        aMap.put("\\u0427","Ч");
        aMap.put("\\u0428","Ш");
        aMap.put("\\u0429","Щ");
        aMap.put("\\u042A","Ъ");
        aMap.put("\\u042B","Ы");
        aMap.put("\\u042C","Ь");
        aMap.put("\\u042D","Э");
        aMap.put("\\u042E","Ю");
        aMap.put("\\u042F","Я");
        aMap.put("\\u0430","а");
        aMap.put("\\u0431","б");
        aMap.put("\\u0432","в");
        aMap.put("\\u0433","г");
        aMap.put("\\u0434","д");
        aMap.put("\\u0435","е");
        aMap.put("\\u0436","ж");
        aMap.put("\\u0437","з");
        aMap.put("\\u0438","и");
        aMap.put("\\u0439","й");
        aMap.put("\\u043A","к");
        aMap.put("\\u043B","л");
        aMap.put("\\u043C","м");
        aMap.put("\\u043D","н");
        aMap.put("\\u043E","о");
        aMap.put("\\u043F","п");
        aMap.put("\\u0440","р");
        aMap.put("\\u0441","с");
        aMap.put("\\u0442","т");
        aMap.put("\\u0443","у");
        aMap.put("\\u0444","ф");
        aMap.put("\\u0445","х");
        aMap.put("\\u0446","ц");
        aMap.put("\\u0447","ч");
        aMap.put("\\u0448","ш");
        aMap.put("\\u0449","щ");
        aMap.put("\\u044A","ъ");
        aMap.put("\\u044B","ы");
        aMap.put("\\u044C","ь");
        aMap.put("\\u044D","э");
        aMap.put("\\u044E","ю");
        aMap.put("\\u044F","я");
        unicode = Collections.unmodifiableMap(aMap);
    }


	public static String filter(String inString) {
		for (String key : unicode.keySet()) {
			inString = inString.replace(key.toLowerCase(), unicode.get(key));
		}
		return inString;
	}


}
