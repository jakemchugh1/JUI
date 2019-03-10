package main;

import entities.*;
import helpers.Artist.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import java.util.HashSet;

import static helpers.Artist.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;


public class JUIEngine {

    public JUIEngine(){
        BeginSession();


        HashSet<Entity> entitySet = new HashSet<>();
        entitySet.add(new Box(0,0,"box"));
        entitySet.add(new Box(0,64,"box"));
        entitySet.add(new Box(0,128,"box"));

        entitySet.add(new Box(128,0,"box"));
        entitySet.add(new Box(128,64,"box"));
        entitySet.add(new Box(128,128,"box"));

        entitySet.add(new Box(256,0,"box"));
        entitySet.add(new Box(256,64,"box"));
        entitySet.add(new Box(256,128,"box"));

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            HashSet<Entity> remove = new HashSet<>();
            for(Entity box : entitySet){
                box.CheckInputs();
                box.Draw();
            }
            for(Entity ball : remove){
                entitySet.remove(ball);
            }

            updateDisplay();

        }


    }

    public static void main(String[] Args){
        new JUIEngine();
    }
}
