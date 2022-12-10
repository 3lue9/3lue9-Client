

package cf.vaccat.catclient.module.movement;

import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.settings.SettingsManager;


import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;


import java.util.ArrayList;
import java.util.Objects;

public class Fly extends Module {
    public Fly() {
        super("Fly", "fly like a bird", Category.MOVEMENT);
    }
    @SubscribeEvent

    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        String Mode = CatClient.instance.settingsManager.getSettingByName(this.name(), "Mode").getValString();

        if (Objects.equals(Mode, "WellMore")) {
            float speed = (float) 2.11;

            mc.player.noClip = true;
            mc.player.fallDistance = 0;
            mc.player.onGround = false;

            mc.player.capabilities.isFlying = false;

            mc.player.motionX = 0;
            mc.player.motionY = 0;
            mc.player.motionZ = 0;

            mc.player.jumpMovementFactor = speed;

            if (mc.gameSettings.keyBindJump.isKeyDown()) {
                mc.player.motionY += speed;
            }
            if (mc.gameSettings.keyBindSneak.isKeyDown()) {
                mc.player.motionY -= speed;
            }
        } else {
            mc.player.capabilities.isFlying = true;
        }
}
}

