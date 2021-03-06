/*
              .,-:;//;:=,
          . :H@@@MM@M#H/.,+%;,
       ,/X+ +M@@M@MM%=,-%HMMM@X/,
     -+@MM; $M@@MH+-,;XMMMM@MMMM@+-
    ;@M@@M- XM@X;. -+XXXXXHHH@M@M#@/.
  ,%MM@@MH ,@%=             .---=-=:=,.
  =@#@@@MX.,                -%HX$$%%%:;
 =-./@M@M$                   .;@MMMM@MM:
 X@/ -$MM/                    . +MM@@@M$
,@M@H: :@:                    . =X#@@@@-
,@@@MMX, .                    /H- ;@M@M=
.H@@@@M@+,                    %MM+..%#$.
 /MMMM@MMH/.                  XM@MH; =;
  /%+%$XHH@$=              , .H@@@@MX,
   .=--------.           -%H.,@@@@@MX,
   .%MM@@@HHHXX$$$%+- .:$MMX =M@@MM%.
     =XMMM@MM@MM#H;,-+HMM@M+ /MMMX=
       =%@M@M#@$-.=$@MM@@@M; %M%=
         ,:+$+-,/H#MMMMMMM@= =,
               =++%%%%+/:-.             
*/
//I’m making a note here: huge success

package ru.nsu.ci.graphics;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ru.nsu.ci.graphics.JOGL_cube;

import com.jogamp.opengl.util.Animator;
 

public class JOGL_draw implements GLEventListener, KeyListener {
	 float rotateT = 0.0f;
 
    static GLU glu = new GLU();
 
    static GLCanvas canvas = new GLCanvas();
 
    static Frame frame = new Frame("Rubik's Cube");
 
    static Animator animator = new Animator(canvas); 

    
    float rot1=180f;
    float rot2=0;
    float rot3=0;
    
    public void display(GLAutoDrawable gLDrawable) {
        final GL2 gl = gLDrawable.getGL().getGL2();
        int i,j,k,k2=0;
        gl.glClearColor(0.79f, 0.8f, 0.8f, 0f);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        gl.glTranslatef(-6f, 1.5f, -11f);
        gl.glRotatef(180.0f,1f,0f,0f);
       	
       	for(k=0;k<6;k++)
       	{
       		switch (k)
       		{
       			case 0: {k2=5; break;}
       			case 1: {k2=0; break;}
       			case 2: {k2=4; break;}
       			case 3: {k2=2; break;}
       			case 4: {k2=1; break;}
       			case 5: {k2=3; break;}
       		}
       		gl.glTranslatef(0f,-0.15f,0f);
       		for(j=0;j<3;j++)
       		{
       			gl.glTranslatef(-0.15f,0f, 0f);
       			for(i=0;i<3;i++)
       			{
       				JOGL_cube.SetColor(gl,j,i,k2);
       		       	gl.glBegin(GL2.GL_QUADS);
       				gl.glVertex3f(i,j,0);
       				gl.glVertex3f(i,j+1,0);
       				gl.glVertex3f(i+1,j+1,0);
       				gl.glVertex3f(i+1,j,0);
       		       	gl.glEnd();   
       		       	gl.glTranslatef(0.05f,0f, 0f);
       			}
       			gl.glTranslatef(0f,0.05f, 0f);
       		}
       		
			gl.glBegin(GL2.GL_QUADS);			
			gl.glColor3f(1f,1f,1f);
			
        	switch (k2)
        	{
        		case 1: {
        			gl.glVertex3d(1.3,1,0);
        			gl.glVertex3d(1.3,2,0);
        			gl.glVertex3d(1.7,2,0);
        			gl.glVertex3d(1.7,1,0);
        			break;}
        		case 2: {
        			gl.glVertex3d(1.25,1,0);
        			gl.glVertex3d(1.25,2,0);
        			gl.glVertex3d(1.45,2,0);
        			gl.glVertex3d(1.45,1,0);
        			
        			gl.glVertex3d(1.55,1,0);
        			gl.glVertex3d(1.55,2,0);
        			gl.glVertex3d(1.75,2,0);
        			gl.glVertex3d(1.75,1,0);
        			break;}
        		case 3: {
        			gl.glVertex3d(1.0,1,0);
        			gl.glVertex3d(1.0,2,0);
        			gl.glVertex3d(1.3,2,0);
        			gl.glVertex3d(1.3,1,0);
        			
        			gl.glVertex3d(1.35,1,0);
        			gl.glVertex3d(1.35,2,0);
        			gl.glVertex3d(1.65,2,0);
        			gl.glVertex3d(1.65,1,0);
        			
        			gl.glVertex3d(1.7,1,0);
        			gl.glVertex3d(1.7,2,0);
        			gl.glVertex3d(2,2,0);
        			gl.glVertex3d(2,1,0);
        			break;}         		
        		case 0: {        			
        			gl.glVertex3d(1,1,0);
        			gl.glVertex3d(1,2,0);
        			gl.glVertex3d(1.25,2,0);
        			gl.glVertex3d(1.25,1,0);
        			
        			gl.glVertex3d(1.75,1,0);
        			gl.glVertex3d(1.75,2,0);
        			gl.glVertex3d(2,2,0);
        			gl.glVertex3d(2,1,0);
        			
        			gl.glVertex3d(1,1,0);
        			gl.glVertex3d(2,1,0);
        			gl.glVertex3d(2,1.25,0);
        			gl.glVertex3d(1,1.25,0);
        			
        			gl.glVertex3d(1,2,0);
        			gl.glVertex3d(2,2,0);
        			gl.glVertex3d(2,1.75,0);
        			gl.glVertex3d(1,1.75,0);
        			break;}       		
        		case 5: {        			
        			gl.glVertex3d(1,1,0);
        			gl.glVertex3d(1.2,2,0);
        			gl.glVertex3d(1.5,2,0);
        			gl.glVertex3d(1.3,1,0);
        			
        			gl.glVertex3d(1.5,1,0);
        			gl.glVertex3d(1.2,2,0);
        			gl.glVertex3d(1.5,2,0);
        			gl.glVertex3d(1.75,1,0);
        			break;}  		
        		case 4: {
        			gl.glVertex3d(1.0,1,0);
        			gl.glVertex3d(1.0,2,0);
        			gl.glVertex3d(1.3,2,0);
        			gl.glVertex3d(1.3,1,0);
        			
        			gl.glVertex3d(1.35,1,0);
        			gl.glVertex3d(1.55,2,0);
        			gl.glVertex3d(1.85,2,0);
        			gl.glVertex3d(1.65,1,0);
        			
        			gl.glVertex3d(1.7,1,0);
        			gl.glVertex3d(1.65,2,0);
        			gl.glVertex3d(1.85,2,0);
        			gl.glVertex3d(2,1,0);
        			break;}
        	}        	
			gl.glEnd();
	        
       		if (k<3)
       			gl.glTranslatef(3.2f,0f, 0f);
       		else if (k==3)
       		{       			
       			gl.glTranslatef(-6.4f,-3.2f, 0f);
       		}
       		else
       		{       		
       			gl.glTranslatef(0f,6.4f,0f);
       		}
       	}
    }
 
    public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged, boolean deviceChanged) {
    }
 
    public void init(GLAutoDrawable gLDrawable) {
        GL2 gl = gLDrawable.getGL().getGL2();
        gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
        ((Component) gLDrawable).addKeyListener(this);
    }
 
    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
        GL2 gl = gLDrawable.getGL().getGL2();
        if (height <= 0) {
            height = 1;
        }
        float h = (float) width / (float) height;
        gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(50.0f, h, 1.0, 1000.0);
        gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
 
    public void keyPressed(KeyEvent e) {
    	switch (e.getKeyCode())
    	{
    	  case KeyEvent.VK_ESCAPE: {exit(); break;}
    	  case KeyEvent.VK_LEFT: {rot2-=10; break;}
    	  case KeyEvent.VK_RIGHT: {rot2+=10; break;}
    	  case KeyEvent.VK_UP: {rot1+=10; break;}
    	  case KeyEvent.VK_DOWN: {rot1-=10; break;}
        }
    }
 
    public void keyReleased(KeyEvent e) {
    }
 
    public void keyTyped(KeyEvent e) {
    }
 
    public static void exit() {
        animator.stop();
        frame.dispose();
        System.exit(0);
    }
 
    public static void main(String[] args, JPanel panel, JFrame frame) {
        canvas.addGLEventListener(new JOGL_draw());
        panel.add(canvas);
        canvas.setSize(400, 200);
        JOGL_cube.rubicsCube.init();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        frame.setVisible(true);
        animator.start();
        canvas.requestFocus();
    }
 
    public void dispose(GLAutoDrawable gLDrawable) {
        // do nothing
    }
}
