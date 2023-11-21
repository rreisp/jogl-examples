package jogl.rotation;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class Main implements GLEventListener {

    private float rtri;  //for angle of rotation

    @Override
    public void display(GLAutoDrawable drawable) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        // Clear The Screen And The Depth Buffer 
        gl.glLoadIdentity();  // Reset The View     

        //triangle rotation      
        gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);

        // Drawing Using Triangles 
        gl.glBegin(GL2.GL_TRIANGLES);

        gl.glColor3f(1.0f, 0.0f, 0.0f);   // Red 
        gl.glVertex3f(0.5f, 0.7f, 0.0f);    // Top 
        gl.glColor3f(0.0f, 1.0f, 0.0f);     // blue 
        gl.glVertex3f(-0.2f, -0.50f, 0.0f); // Bottom Left 
        gl.glColor3f(0.0f, 0.0f, 1.0f);     // green 
        gl.glVertex3f(0.5f, -0.5f, 0.0f);   // Bottom Right 

        gl.glEnd();
        gl.glFlush();

        rtri += 0.2f;  //assigning the angle               
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
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public static void main(String[] args) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas  
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Main triangle = new Main();
        glcanvas.addGLEventListener(triangle);
        glcanvas.setSize(400, 400);

        // creating frame 
        final JFrame frame = new JFrame("JOGL - Rotating Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding canvas to it 
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

        //Instantiating and Initiating Animator 
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
        animator.start();
    }//end of main

} //end of class 
