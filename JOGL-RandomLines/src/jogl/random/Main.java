package jogl.random;

import java.util.Random;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

/*
* Author: Rodrigo Reis Pereira (rreisp@gmail.com)
Based on 'https://www.tutorialspoint.com/jogl/' HelloWorld example.
 */
public class Main implements GLEventListener {

    @Override
    public void init(GLAutoDrawable arg0) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3f(1f, 1f, 1f);

        double max = 1;
        double min = -1;
        Random r = new Random();
        int nVertexes = r.nextInt(1500);

        for (int i = 0; i < nVertexes; i++) {
            double d1 = min + (max - min) * r.nextDouble();
            double d2 = min + (max - min) * r.nextDouble();
            gl.glColor3f(r.nextFloat(), r.nextFloat(), r.nextFloat());
            gl.glVertex2d(d1, d2);
        }
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {

    }

    @Override
    public void dispose(GLAutoDrawable arg0) {

    }

    public static void main(String[] args) {

        final GLProfile gp = GLProfile.get(GLProfile.GL2);
        GLCapabilities cap = new GLCapabilities(gp);

        final GLCanvas gc = new GLCanvas(cap);
        Main sq = new Main();
        gc.addGLEventListener(sq);
        gc.setSize(400, 400);

        final JFrame frame = new JFrame("JOGL - Random Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(gc);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
    }
}
