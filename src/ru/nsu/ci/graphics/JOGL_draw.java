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

import com.jogamp.opengl.util.Animator;
 
import ru.nsu.ci.common.RubicsCube;

public class JOGL_draw implements GLEventListener, KeyListener {
    float rotateT = 0.0f;
 
    static GLU glu = new GLU();
 
    static GLCanvas canvas = new GLCanvas();
 
    static Frame frame = new Frame("Jogl Quad drawing");
 
    static Animator animator = new Animator(canvas); 
    
    RubicsCube rubicsCube = new RubicsCube();
    
    public void display(GLAutoDrawable gLDrawable) {
        final GL2 gl = gLDrawable.getGL().getGL2();
        int i,j,k,k2;
        float offset1=0.15f,offset2=0;
        int[] a={0,1,0,0,1,0,0,1,0,2,2,0,0,2,0,2,2,2,3,3,3,0,0,3,3,3,3,4,0,4,4,4,4,0,0,4,0,5,5,0,5,0,5,5,5,6,6,6,6,0,0,6,6,6};
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(-14f, -5f, -25f);
        gl.glRotatef(180.0f,1f,0f,0f);
       	for(k=0;k<6;k++)
   			for(j=0;j<3;j++)
   		   		for(i=0;i<3;i++)
   		   		rubicsCube.cube[i][j][k]=a[i+3*j+9*k];
       	
       	gl.glBegin(GL2.GL_QUADS);
       		SetColor(gl,0,0,0);
       	for(k=0;k<6;k++)
       	{
       		/*switch (k)
       		{
       			case 0: k2=2;
       			case 1: k2=5;
       			case 2: k2=2;
       			case 3: k2=2;
       			case 4: k2=2;
       			case 5: k2=2;
       		}*/
       		offset2-=0.15;
       		for(j=0;j<3;j++)
       		{
       			offset1-=0.15;
       			for(i=0;i<3;i++)
       			{
       				SetColor(gl,i,j,k);
       				gl.glVertex3f(i+offset1,j+offset2,0);
       				gl.glVertex3f(i+offset1,j+offset2+1,0);
       				gl.glVertex3f(i+offset1+1,j+offset2+1,0);
       				gl.glVertex3f(i+offset1+1,j+offset2,0);
       				offset1+=0.05;
       			}
       			offset2+=0.05;
       		}
       		if (k<3)
       			offset1+=3.2;
       		else if (k==3)
       		{       			
       			offset1-=6.4;
       			offset2-=3.2;
       		}
       		else
       		{       		
       			offset2+=6.4;
       		}
       	}
       	gl.glEnd();
                              
        rotateT += 0.2f; 
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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            exit();
        }
    }
 
    public void keyReleased(KeyEvent e) {
    }
 
    public void keyTyped(KeyEvent e) {
    }
    
    public void SetColor(GL2 gl, int i,int j,int k)
    {
    	switch (rubicsCube.cube[i][j][k])
    	{
    		case 0:{ gl.glColor3f(1f,1f,1f); break;}
    		case 1:{ gl.glColor3f(1f,1f,0f); break;}
    		case 2:{ gl.glColor3f(1f,0f,1f); break;}
    		case 3:{ gl.glColor3f(0f,1f,1f); break;}
    		case 4:{ gl.glColor3f(0f,0f,1f); break;}
    		case 5:{ gl.glColor3f(0.1f,0.2f,0.3f); break;}
    		case 6:{ gl.glColor3f(0.51f,0.52f,0.53f); break;}
    	}
    } 
 
    public static void exit() {
        animator.stop();
        frame.dispose();
        System.exit(0);
    }
 
    public static void main(String[] args) {
        canvas.addGLEventListener(new JOGL_draw());
        frame.add(canvas);
        frame.setSize(640, 480);
        frame.setUndecorated(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
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

