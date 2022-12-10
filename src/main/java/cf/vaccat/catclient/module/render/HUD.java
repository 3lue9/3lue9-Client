package cf.vaccat.catclient.module.render;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import cf.vaccat.catclient.module.utils.Rainbow;

import java.awt.*;
import java.util.Objects;

import static cf.vaccat.catclient.module.utils.Rainbow.rainbow;


public class HUD extends Module {

	public HUD() {
		super("HUD", "modules on screen", Category.RENDER);
	}
	
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent.Post e) {
		switch (e.getType()) {
			case ALL:
				break;
			case HELMET:
				break;
			case PORTAL:
				break;
			case CROSSHAIRS:
				break;
			case BOSSHEALTH:
				break;
			case BOSSINFO:
				break;
			case ARMOR:
				break;
			case HEALTH:
				break;
			case FOOD:
				break;
			case AIR:
				break;
			case HOTBAR:
				break;
			case EXPERIENCE:
				break;
			case TEXT:

				ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
				int y = 2;
				for (Module mod : CatClient.instance.moduleManager.getModuleList()) {

					//Enable Rendering
					FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

					//Render WaterMark
					fr.drawString("3lue9 Client Version 1.0", 1, 1, rainbow(300));

					//Render Username
					fr.drawString( "Player Name | " + mc.player.getName() ,1, 10, rainbow(300));

					//Render FPS
					fr.drawString("Fps | " + Minecraft.getDebugFPS(),1, 20, rainbow(300));


					if (!mod.getName().equalsIgnoreCase("HUD") && mod.isToggled() && mod.visible) {

						//Render ModuleArray
						fr.drawString(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 1, y, rainbow(300));
						y += fr.FONT_HEIGHT;
					}
				}

			case HEALTHMOUNT:
				break;
			case JUMPBAR:
				break;
			case CHAT:
				break;
			case PLAYER_LIST:
				break;
			case DEBUG:
				break;
			case POTION_ICONS:
				break;
			case SUBTITLES:
				break;
			case FPS_GRAPH:
				break;
			case VIGNETTE:
				break;
		}
	}
}

