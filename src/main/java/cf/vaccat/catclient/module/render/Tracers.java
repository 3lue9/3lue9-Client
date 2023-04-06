package cf.vaccat.catclient.module.render;

import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.module.utils.render.RenderUtils;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;


public class Tracers extends Module {
    public Tracers() {
        super("Tracers", " ", Category.RENDER);
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (Entity playerEntity : mc.world.playerEntities) {
            if (playerEntity != null && playerEntity != mc.player) {
                RenderUtils.trace(mc, playerEntity, mc.getRenderPartialTicks(), 1);
            }
        }
    }
}