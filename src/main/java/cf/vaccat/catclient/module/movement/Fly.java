package cf.vaccat.catclient.module.movement;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.settings.Setting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Fly extends Module {
        public Fly() {
            super("Fly", "Fly like a bird", Category.MOVEMENT);
            CatClient.instance.settingsManager.rSetting(new Setting("Speed", this, 2.11, 1, 20, true));

        }

        @SubscribeEvent
        public void onPlayerTick(TickEvent.PlayerTickEvent e) {
             float speed = (float)  CatClient.instance.settingsManager.getSettingByName(this, "Speed").getValDouble();

                mc.player.noClip = true;
                mc.player.fallDistance = 0;
                mc.player.onGround = false;

                mc.player.capabilities.isFlying = false;

                mc.player.motionX = 0;
                mc.player.motionY = 0;
                mc.player.motionZ = 0;
                mc.player.rotationYaw = 100;

                mc.player.jumpMovementFactor = speed;

                if (mc.gameSettings.keyBindJump.isKeyDown()) {
                    mc.player.motionY += speed;
                }
                if (mc.gameSettings.keyBindSneak.isKeyDown()) {
                    mc.player.motionY -= speed;
                }
            }

        @Override
        public void onDisable() {
            super.onDisable();
            mc.player.noClip = false;
            mc.player.onGround = true;

            }
        }

