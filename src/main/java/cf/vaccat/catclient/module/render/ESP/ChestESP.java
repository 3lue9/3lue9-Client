package cf.vaccat.catclient.module.render.ESP;


import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.module.utils.render.RenderUtils;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChestESP extends Module {
    public ChestESP() {
        super("ChestESP","", Category.RENDER);
    }
@SubscribeEvent
public void onRender(RenderWorldLastEvent e) {
        for (Object c : mc.world.loadedTileEntityList) {
        if (c instanceof TileEntityChest) {
        RenderUtils.blockESP(((TileEntityChest) c).getPos());
        }
        }
    }
}