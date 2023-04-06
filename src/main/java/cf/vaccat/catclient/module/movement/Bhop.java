package cf.vaccat.catclient.module.movement;


import cf.vaccat.catclient.module.Category;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import cf.vaccat.catclient.module.Module;

public class Bhop extends Module {
    public Bhop() {
        super("BunnyHop", "go faster", Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent e) {
        if (mc.player.onGround && mc.player.moveForward > 0) {
                mc.player.jump();
        }
    }
}
