package cf.vaccat.catclient.module.render.ESP;


import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.module.utils.render.RenderUtils;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerESP extends Module {
    public PlayerESP() {
        super("PlayerESP", "", Category.RENDER);
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (Object c : mc.world.playerEntities) {
            if (c instanceof TileEntityChest) {
                RenderUtils.blockESP(((TileEntityChest) c).getPos());
            }
        }
    }

}