package jogl.name;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Main implements GLEventListener {

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glScalef(0.50f, 0.50f, 0.50f);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        //Desenha R
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(-1.4, 0.6);
        gl.glVertex2d(-1.4, -0.6);
        gl.glVertex2d(-1.4, 0.0);
        gl.glVertex2d(-0.8, 0.0);
        gl.glVertex2d(-0.8, 0.0);
        gl.glVertex2d(-0.8, 0.6);
        gl.glVertex2d(-0.8, 0.6);
        gl.glVertex2d(-1.4, 0.6);
        gl.glVertex2d(-1.0, 0.0);
        gl.glVertex2d(-0.8, -0.6);
        gl.glEnd();

        //Desenha O
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(-0.3, 0.6);
        gl.glVertex2d(-0.3, -0.6);
        gl.glVertex2d(-0.3, -0.6);
        gl.glVertex2d(0.3, -0.6);
        gl.glVertex2d(0.3, 0.6);
        gl.glVertex2d(0.3, -0.6);
        gl.glVertex2d(-0.3, 0.6);
        gl.glVertex2d(0.3, 0.6);
        gl.glEnd();

        //Desenha D
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0.8, 0.6);
        gl.glVertex2d(0.8, -0.6);
        gl.glVertex2d(0.8, -0.6);
        gl.glVertex2d(1.2, -0.6);

        gl.glVertex2d(1.2, 0.6);
        gl.glVertex2d(1.4, 0.4);
        gl.glVertex2d(0.8, 0.6);
        gl.glVertex2d(1.2, 0.6);
        gl.glVertex2d(1.2, -0.6);
        gl.glVertex2d(1.4, -0.4);
        gl.glVertex2d(1.4, -0.4);
        gl.glVertex2d(1.4, 0.4);
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

        final JFrame frame = new JFrame("JOGL - My Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gc);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
    }
}
