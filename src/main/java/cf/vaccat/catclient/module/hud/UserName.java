package cf.vaccat.catclient.module.hud;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static cf.vaccat.catclient.module.utils.Rainbow.Rainbow.rainbow;


public class UserName extends Module {
        public UserName() {
            super("UserName", "user name", Category.HUD);
        }

        @SubscribeEvent
        public void onEnable(RenderGameOverlayEvent.Post e){
            switch (e.getType()) {
                case TEXT:

                    ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
                    int y = 24;
                    int delay = 200;
                    for (Module mod : CatClient.instance.moduleManager.getModuleList()) {

                        //Enable Rendering
                        FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

                        //Render UserName
                        fr.drawString( "Player Name | " + mc.player.getName() ,1, 10, rainbow(300));
                    }
            }
        }
    }
