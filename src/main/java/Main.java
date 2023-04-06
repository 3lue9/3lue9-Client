import cf.vaccat.catclient.CatClient;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;



@Mod(modid = "lueclient", version = "v 1.0.2")
public class Main {

    @EventHandler
    public void init(FMLInitializationEvent event) {
        CatClient.instance = new CatClient();
        CatClient.instance.init();

    }
}