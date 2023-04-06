package cf.vaccat.catclient.module.utils.panic;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Panic extends Module {
    public static boolean isPanic = false;

    public Panic() {
        super("Panic", "Panics", Category.EXPLOITS);

    }

    @Override
    public void onEnable() {
        isPanic = true;

        Display.setTitle("3lue9 Client 1.12.2");
    }

    @Override
    public void onDisable() {
        isPanic = false;

        Display.setTitle("3lue9 Client 1.12.2");
    }
}
