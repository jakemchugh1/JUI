package entities;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;

public interface Entity {
    public void Draw();
    public void CheckInputs();
    public boolean isRemove();

}
