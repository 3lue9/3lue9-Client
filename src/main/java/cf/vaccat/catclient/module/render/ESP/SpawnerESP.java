package cf.vaccat.catclient.module.render.ESP;


import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.module.utils.render.RenderUtils;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class SpawnerESP extends Module {
    public SpawnerESP() {
        super("SpawnerESP","See spawners", Category.RENDER);
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (Object c : mc.world.loadedTileEntityList) {
            if (c instanceof TileEntityMobSpawner) {
                RenderUtils.blockESP(((TileEntityMobSpawner) c).getPos());
            }
        }
    }
}
