package Actions;

import static org.lwjgl.opengl.GL11.*;

public class DrawBox implements Action {

    private boolean enabled = false;

    public DrawBox(){

    }

    public void Toggle(){
        enabled = !enabled;
    }

    public void Select(boolean select) {
        enabled = select;
    }

    public void Check(){
        if(enabled) {
            glBegin(GL_POLYGON);
            glVertex2f(800, 800);
            glVertex2f(800, 850);
            glVertex2f(850, 850);
            glVertex2f(850, 800);
            glEnd();
        }
    }
}
