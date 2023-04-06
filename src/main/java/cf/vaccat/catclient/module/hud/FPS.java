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
import cf.vaccat.catclient.module.utils.chat.ChatUtils;


public class FPS extends Module { public FPS() {super("FPS", "fps", Category.HUD);}

    @SubscribeEvent
    public void onEnable(RenderGameOverlayEvent.Post e){
        switch (e.getType()) {
            case TEXT:

                ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
                int fps = Minecraft.getDebugFPS();
                for (Module mod : CatClient.instance.moduleManager.getModuleList()) {

                    //Enable Rendering
                    FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

                    //Render Fps
                    fr.drawString("Fps | " + fps, 1, 20, rainbow(300));
                    // ChatUtils.sendMessage(String.valueOf(fps));
                }}}}