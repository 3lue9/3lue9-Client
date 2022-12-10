package cf.vaccat.catclient.module.movement;

import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Speed extends Module {
    public Speed() {
        super("Speed", "Go fast", Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.onGround && mc.player.moveForward > 0 && !mc.player.isInWater() && !mc.player.isInLava()) {
            double speed = 0.5;

            mc.player.setSprinting(true);
            mc.player.motionY = 0.2;

            float yaw = mc.player.rotationYaw * 0.0174532920F;

            mc.player.motionX -= MathHelper.sin(yaw) * (speed / 5);
            mc.player.motionZ += MathHelper.cos(yaw) * (speed / 5);
        }
    }

}
