package entities;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static helpers.Artist.DrawQuadTex;
import static helpers.Artist.LoadTexture;

public class Box implements Entity{

    private float x;
    private float y;

    private int height;
    private int width;

    private Texture texture;


    private boolean remove;

    public Box(float startX, float startY, String fileName){

        this.x = startX;
        this.y = startY;
        width = 128;
        height = 64;
        this.texture = LoadTexture(fileName);


        remove = false;

    }

    public void Draw() {
        DrawQuadTex(texture, x, y, width, height);
    }

    public void CheckInputs(){
        if(Mouse.getX() < x+width && Mouse.getX() > x && 960-Mouse.getY() > y && 960-Mouse.getY() < y + height){
            if(Mouse.isButtonDown(0)){
                texture = LoadTexture("box_select");
            }
            else{
                texture = LoadTexture("box_hover");
            }
        }else texture = LoadTexture("box");
    }


    public boolean isRemove() {
        return remove;
    }

}
