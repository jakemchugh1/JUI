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

public class Background implements Entity{

    private float x;
    private float y;

    private int height;
    private int width;

    private Texture texture;


    private boolean remove;

    public Background(int width, int height, String fileName){

        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
        this.texture = LoadTexture(fileName);


        remove = false;

    }

    public void Draw() {
        DrawQuadTex(texture, x, y, width, height);
    }

    public void CheckInputs() {

    }


    public boolean isRemove() {
        return remove;
    }

}
