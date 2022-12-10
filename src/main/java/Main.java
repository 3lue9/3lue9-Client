import cf.vaccat.catclient.CatClient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.opengl.Display;

@Mod(modid = "lueclient", version = "v1.0.2")
public class Main {

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	CatClient.instance = new CatClient();
    	CatClient.instance.init();
        Display.setTitle("3lue9 Client 1.12.2 ");
    }
}
