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


public class WaterMark extends Module {
    public WaterMark() {
        super("WaterMark", "watermark", Category.HUD);
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

                    //Render WaterMark
                    fr.drawString("3lue9 Client Version | " + CatClient.version, 1, 1, rainbow(300));
                }
        }
    }
}
