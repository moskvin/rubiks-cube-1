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
import javax.media.opengl.glu.GLU;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jogamp.opengl.util.Animator;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import ru.nsu.ci.common.RubicsCube;
public class JOGL_cube implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {
    float rotateT = 0.0f;
 
    static GLU glu = new GLU();
 //
    static GLCanvas canvas = new GLCanvas();
 
    static Frame frame = new Frame("Rubik's Cube");
 
    static Animator animator = new Animator(canvas); 
    
    public static RubicsCube rubicsCube = new RubicsCube();
    
    float rot1=180f;
    float rot2=0;
    float rot3=0;
    float rot[]=new float[6];
            
    int x0,y0;
        
    public JOGL_cube() {
    	canvas.addGLEventListener(this);
    	canvas.addKeyListener(this);
    	canvas.addMouseListener(this);
    	canvas.addMouseMotionListener(this);
	}

    public void display(GLAutoDrawable gLDrawable) {
        final GL2 gl = gLDrawable.getGL().getGL2();
        int i,j,k,k2=0;
        gl.glClearColor(0.79f, 0.8f, 0.8f, 0f);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslated(0,0,-8);
        gl.glRotatef(rot1,1f,0f,0f);
        gl.glRotatef(rot2,0f,1f,0f);
        gl.glRotatef(rot3,0f,0f,1f);    
        gl.glTranslated(-1.7,-1.7,-1.7);         
        for(k=0;k<6;k++)
        {
        	switch (k)
        	{
        		case 0: {k2=5; gl.glTranslatef(0f, 0f, 3.2f); gl.glRotatef(90.0f,0f,1f,0f); break;}
        		case 1: {k2=0; gl.glTranslatef(0f, 0f, 0f); break;}
        		case 2: {k2=4; gl.glTranslatef(3.17f, 0f, 0f); gl.glRotatef(-90.0f,0f,1f,0f); break;}
        		case 3: {k2=2; gl.glTranslatef(3.2f, 0f, 3.2f); gl.glRotatef(180.0f,0f,1f,0f); break;}
        		case 4: {k2=1; gl.glRotatef(90.0f,1f,0f,0f); gl.glRotatef(-180.0f,1f,0f,0f); gl.glTranslatef(.42f,-3f, -0.17f); break;}
        		case 5: {k2=3; gl.glRotatef(90.0f,1f,0f,0f); gl.glTranslatef(0.4f, 0.2f, -3f); break;}
        	}
        	gl.glTranslatef(0f,-0.15f,0f);
        	for(j=0;j<3;j++)
        	{
        		gl.glTranslatef(-0.15f,0f, 0f);
        		for(i=0;i<3;i++)
        		{
        			SetColor(gl,j,i,k2);
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
        	
	        gl.glTranslated(0,0,4.3);
			gl.glBegin(GL2.GL_QUADS);			
			gl.glColor3f(1f,1f,1f);
			
        	switch (k2)
        	{
        		case 3: {
        			gl.glVertex3d(1.3,1,0);
        			gl.glVertex3d(1.3,2,0);
        			gl.glVertex3d(1.7,2,0);
        			gl.glVertex3d(1.7,1,0);
        			break;}
        		case 0: {
        			gl.glVertex3d(1.25,1,0);
        			gl.glVertex3d(1.25,2,0);
        			gl.glVertex3d(1.45,2,0);
        			gl.glVertex3d(1.45,1,0);
        			
        			gl.glVertex3d(1.55,1,0);
        			gl.glVertex3d(1.55,2,0);
        			gl.glVertex3d(1.75,2,0);
        			gl.glVertex3d(1.75,1,0);
        			break;}
        		case 1: {
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
        		case 5: {        			
        			gl.glVertex3d(1,1,0);
        			gl.glVertex3d(1.2,2,0);
        			gl.glVertex3d(1.5,2,0);
        			gl.glVertex3d(1.3,1,0);
        			
        			gl.glVertex3d(1.5,1,0);
        			gl.glVertex3d(1.2,2,0);
        			gl.glVertex3d(1.5,2,0);
        			gl.glVertex3d(1.75,1,0);
        			
        			gl.glVertex3d(1.8,1,0);
        			gl.glVertex3d(1.8,2,0);
        			gl.glVertex3d(2,2,0);
        			gl.glVertex3d(2,1,0);
        			break;}       		
        		case 4: {        			
        			gl.glVertex3d(1,1,0);
        			gl.glVertex3d(1.2,2,0);
        			gl.glVertex3d(1.5,2,0);
        			gl.glVertex3d(1.3,1,0);
        			
        			gl.glVertex3d(1.5,1,0);
        			gl.glVertex3d(1.2,2,0);
        			gl.glVertex3d(1.5,2,0);
        			gl.glVertex3d(1.75,1,0);
        			break;}  		
        		case 2: {
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
        	}        	
			gl.glEnd();
	        gl.glTranslated(0,0,-4.3);
        	
        	switch (k)
        	{
        		case 0: {gl.glRotatef(-90.0f,0f,1f,0f); gl.glTranslatef(.2f, 0f, -3f); break;}
        		case 1: {gl.glTranslatef(-.15f, 0f, .2f);break;}
        		case 2: {gl.glRotatef(90.0f,0f,1f,0f); gl.glTranslatef(-3.43f, 0f,-.2f); break;}
        		case 3: {gl.glRotatef(180.0f,0f,1f,0f); gl.glTranslatef(-3.2f, 0f, -3.2f); break;}
        		case 4: {gl.glTranslatef(-.42f, 3f, 0.17f); gl.glRotatef(180.0f,1f,0f,0f); gl.glRotatef(-90.0f,1f,0f,0f); break;}
        	}
        }
       
        gl.glColor3f(.2f,.2f,.2f);
        for(i=0;i<3;i++)
        {
        	gl.glTranslatef(.32f,.32f, .52f);
        	DrawCube(1,gl);
        	gl.glTranslatef(0f,1.05f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(0f,1.05f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(1.15f,0f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(0f,-1.05f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(0f,-1.05f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(1.05f,0f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(0f,1.05f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(0f,1.05f, 0f);
        	DrawCube(1,gl);
        	gl.glTranslatef(-1.05f,-2.1f, 0f);
        	gl.glTranslatef(-1.15f,2.1f, 0f);
        	gl.glTranslatef(-.32f,-2.42f, .52f);
        }
        rotateT += 0.2f;
    }
    public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged, boolean deviceChanged) {
    	
    }
 
    public void DrawPlane(GL2 gl,int i,int j,int k2)
    {  
    	SetColor(gl,i,j,k2);
	    gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(i,j,0);
		gl.glVertex3f(i,j+1,0);
		gl.glVertex3f(i+1,j+1,0);
		gl.glVertex3f(i+1,j,0);
	   	gl.glEnd(); 
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
        rot[0]=0;
        rot[1]=0;
        rot[2]=0;
        x0=-100500;
        y0=-100500;
    }

    public void mouseDragged (MouseEvent event) 
    {
    	int x=event.getX();
    	int y=event.getY();
    	if (x0==-100500)
    		x0=x;
    	if (y0==-100500)
    		y0=y;
    	int dx=x-x0;
    	int dy=y-y0;
    	rot1+=dy;
    	rot2-=dx;
    	y0=y;
    	x0=x;
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
    
    public static void SetColor(GL2 gl, int i,int j,int k)
    {
    	switch (rubicsCube.cube[i][j][k])
    	{
    		case 0:{ gl.glColor3f(.9f,.9f,.9f); break;}
    		case 1:{ gl.glColor3f(.9f,0f,0f); break;}
    		case 2:{ gl.glColor3f(.9f,.9f,0f); break;}
    		case 3:{ gl.glColor3f(.9f,.5f,0f); break;}
    		case 4:{ gl.glColor3f(0f,0f,.9f); break;}
    		case 5:{ gl.glColor3f(0f,.9f,0f); break;}
    		case 6:{ gl.glColor3f(0.51f,0.52f,0.53f); break;}
    	}
    } 
 
    public static void exit() {
        animator.stop();
        frame.dispose();
        System.exit(0);
    }
 
    public static void main(String[] args, JPanel panel, JFrame frame) {
        canvas.addGLEventListener(new JOGL_cube());
        panel.add(canvas);

        canvas.setSize(400, 400);



        rubicsCube.init();
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
    
    void DrawCube(float size,GL2 gl)
    {
         gl.glBegin(GL2.GL_QUADS);
         // левая грань
         gl.glVertex3f( -size / 2, -size / 2, -size / 2); 
         gl.glVertex3f( -size / 2,  size / 2, -size / 2);
         gl.glVertex3f( -size / 2,  size / 2,  size / 2);
         gl.glVertex3f( -size / 2, -size / 2,  size / 2);
         // правая грань
         gl.glVertex3f(  size / 2, -size / 2, -size / 2); 
         gl.glVertex3f(  size / 2, -size / 2,  size / 2);
         gl.glVertex3f(  size / 2,  size / 2,  size / 2);
         gl.glVertex3f(  size / 2,  size / 2, -size / 2);
         // нижняя грань
         gl.glVertex3f( -size / 2, -size / 2, -size / 2); 
         gl.glVertex3f( -size / 2, -size / 2,  size / 2);
         gl.glVertex3f(  size / 2, -size / 2,  size / 2);
         gl.glVertex3f(  size / 2, -size / 2, -size / 2);
         // верхняя грань
         gl.glVertex3f( -size / 2, size / 2, -size / 2); 
         gl.glVertex3f( -size / 2, size / 2,  size / 2);
         gl.glVertex3f(  size / 2, size / 2,  size / 2);
         gl.glVertex3f(  size / 2, size / 2, -size / 2);
         // задняя грань
         gl.glVertex3f( -size / 2, -size / 2, -size / 2); 
         gl.glVertex3f(  size / 2, -size / 2, -size / 2);
         gl.glVertex3f(  size / 2,  size / 2, -size / 2);
         gl.glVertex3f( -size / 2,  size / 2, -size / 2);
         // передняя грань
         gl.glVertex3f( -size / 2, -size / 2,  size / 2); 
         gl.glVertex3f(  size / 2, -size / 2,  size / 2);
         gl.glVertex3f(  size / 2,  size / 2,  size / 2);
         gl.glVertex3f( -size / 2,  size / 2,  size / 2);
         gl.glEnd();
    }

	public void mouseMoved(MouseEvent arg0) {		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		x0=arg0.getX();
		y0=arg0.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
