package main;

import Actions.DrawBox;
import Actions.NullAction;
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

        //Background background = new Background(1365,1025,"background");
        Background background = new Background(1280,960,"background");

        HashSet<Entity> entitySet = new HashSet<>();
        entitySet.add(new Box(0,0,64, 64,"box", new NullAction()));
        entitySet.add(new Box(0,64,64, 64,"box", new NullAction()));
        entitySet.add(new Box(0,128,64, 64,"box", new NullAction()));

        entitySet.add(new Box(128,0,64, 64,"box", new NullAction()));
        entitySet.add(new Box(128,64,64, 64,"box", new NullAction()));
        entitySet.add(new Box(128,128,64, 64,"box", new NullAction()));

        entitySet.add(new Box(256,0,64, 64,"box", new NullAction()));
        entitySet.add(new Box(256,64,64, 64,"box", new NullAction()));
        entitySet.add(new Box(256,128,64, 64,"box", new DrawBox()));

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            background.Draw();
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
