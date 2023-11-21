package jogl.lighting;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class Main implements GLEventListener {

    private float rpoly;

    @Override

    public void display(GLAutoDrawable drawable) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(1f, 0f, 0f); //applying red

        // Clear The Screen And The Depth Buffer 
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT
                | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();       // Reset The View    
        gl.glRotatef(rpoly, 0.0f, 1.0f, 0.0f);
           gl.glLineWidth(9.0f);
       
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.9f, 0.3f, 0);
        gl.glVertex3f(-0.5f, 0.3f, 0);
        gl.glEnd();

        //drawing bottom
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.9f, -0.3f, 0);
        gl.glVertex3f(-0.5f, -0.3f, 0);
        gl.glEnd();

        //drawing the right edge
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.9f, 0.3f, 0);
        gl.glVertex3f(-0.9f, -0.3f, 0);
        gl.glEnd();

        //drawing the left edge
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.5f, 0.0f, 0);
        gl.glVertex3f(-0.5f, -0.3f, 0);
        gl.glEnd();
        
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.8f, 0.0f, 0);
        gl.glVertex3f(-0.5f, 0.0f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.4f, 0.3f, 0);
        gl.glVertex3f(-0.4f, -0.3f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.4f, 0.3f, 0);
        gl.glVertex3f(0.0f, 0.3f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-0.4f, 0.0f, 0);
        gl.glVertex3f(0.0f, 0.0f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.0f, 0.3f, 0);
        gl.glVertex3f(0.0f, -0.3f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.1f, 0.3f, 0);
        gl.glVertex3f(0.1f, -0.3f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.1f, 0.3f, 0);
        gl.glVertex3f(0.5f, 0.3f, 0);
        gl.glEnd();

        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.1f, -0.3f, 0);
        gl.glVertex3f(0.5f, -0.3f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.1f, 0.0f, 0);
        gl.glVertex3f(0.5f, 0.0f, 0);
        gl.glEnd();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0.5f, 0.3f, 0);
        gl.glVertex3f(0.5f, -0.3f, 0);
        gl.glEnd();

        
        gl.glFlush();

        rpoly += 0.5f;  //assigning the angle 

        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_NORMALIZE);

//        // weak RED ambient 
        float[] ambientLight = {0.9f, 0.f, 0.f, 0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);
        // multicolor diffuse 
       float[] diffuseLight = {2f, 1f, 3f, 0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0);
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        //method body  
    }

    @Override
    public void init(GLAutoDrawable arg0) {
        // method body     
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body 
    }

    public static void main(String[] args) {

        //getting the capabilities object of GL2 profile 
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas  
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Main main = new Main();
        glcanvas.addGLEventListener(main);
        glcanvas.setSize(400, 400);

        //creating frame 
        final JFrame frame = new JFrame("JOGL - Polygon Lighting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding canvas to it 
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

        //Instantiating and Initiating Animator 
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);//taxa de quadros
        animator.start();

    } //end of main 

} //end of class 

//import javax.media.opengl.GL2;
//import javax.media.opengl.GLAutoDrawable;
//import javax.media.opengl.GLCapabilities;
//import javax.media.opengl.GLEventListener;
//import javax.media.opengl.GLProfile;
//import javax.media.opengl.awt.GLCanvas;
//
//import javax.swing.JFrame;
//
//import com.jogamp.opengl.util.FPSAnimator;
//
//public class Main implements GLEventListener {
//
//    private float rpoly;
//
//    @Override
//
//    public void display(GLAutoDrawable drawable) {
//
//        final GL2 gl = drawable.getGL().getGL2();
//        gl.glColor3f(1f, 0f, 0f); //applying red
//
//        gl.glEnable(GL2.GL_LIGHTING);
//        gl.glEnable(GL2.GL_LIGHT0);
//        gl.glEnable(GL2.GL_NORMALIZE);
//
////        float[] ambientLight = {0.1f, 0.f, 0.f, 0f};  // weak RED ambient 
////        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);
////
////        float[] diffuseLight = {1f, 2f, 1f, 0f};  // multicolor diffuse 
////        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0);
//        // Clear The Screen And The Depth Buffer 
//        gl.glClear(GL2.GL_COLOR_BUFFER_BIT
//                | GL2.GL_DEPTH_BUFFER_BIT);
//        gl.glLoadIdentity();       // Reset The View    
//        gl.glRotatef(rpoly, 0.0f, 1.0f, 0.0f);
//
//        gl.glBegin(GL2.GL_POLYGON);
//
//        gl.glVertex3f(0f, 0.5f, 0f);
//        gl.glVertex3f(-0.5f, 0.2f, 0f);
//        gl.glVertex3f(-0.5f, -0.2f, 0f);
//        gl.glVertex3f(0f, -0.5f, 0f);
//        gl.glVertex3f(0f, 0.5f, 0f);
//        gl.glVertex3f(0.5f, 0.2f, 0f);
//        gl.glVertex3f(0.5f, -0.2f, 0f);
//        gl.glVertex3f(0f, -0.5f, 0f);
//
//        gl.glEnd();
//
//        gl.glFlush();
//
//        rpoly += 0.2f;  //assigning the angle 
//
//        gl.glEnable(GL2.GL_LIGHTING);
//        gl.glEnable(GL2.GL_LIGHT0);
//        gl.glEnable(GL2.GL_NORMALIZE);
//
//        // weak RED ambient 
//        float[] ambientLight = {0.1f, 0.f, 0.f, 0f};
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);
//
//        // multicolor diffuse 
//        float[] diffuseLight = {1f, 2f, 1f, 0f};
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0);
//    }
//
//    @Override
//    public void dispose(GLAutoDrawable arg0) {
//        //method body  
//    }
//
//    @Override
//    public void init(GLAutoDrawable arg0) {
//        // method body     
//    }
//
//    @Override
//    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
//        // method body 
//    }
//
//    public static void main(String[] args) {
//
//        //getting the capabilities object of GL2 profile 
//        final GLProfile profile = GLProfile.get(GLProfile.GL2);
//        GLCapabilities capabilities = new GLCapabilities(profile);
//
//        // The canvas  
//        final GLCanvas glcanvas = new GLCanvas(capabilities);
//        Main polygonlighting = new Main();
//        glcanvas.addGLEventListener(polygonlighting);
//        glcanvas.setSize(400, 400);
//
//        //creating frame 
//        final JFrame frame = new JFrame("JOGL - Polygon lighting ");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //adding canvas to it 
//        frame.getContentPane().add(glcanvas);
//        frame.setSize(frame.getContentPane().getPreferredSize());
//        frame.setVisible(true);
//
//        //Instantiating and Initiating Animator 
//        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
//        animator.start();
//
//    } //end of main 
//
//} //end of class 
