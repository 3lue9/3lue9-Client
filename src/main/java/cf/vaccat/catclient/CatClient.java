package cf.vaccat.catclient;


import cf.vaccat.catclient.module.utils.menu.tools.onGuiOpenEvent;
import net.minecraft.util.Session;
import org.lwjgl.input.Keyboard;

import cf.vaccat.catclient.clickgui.ClickGui;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.module.ModuleManager;
import cf.vaccat.catclient.settings.SettingsManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import org.lwjgl.opengl.Display;


public class CatClient
{
    public static CatClient instance;
    public static String version = "1.3";
    public static String cName = "3lue9 Client";
    public ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public ClickGui clickGui;

    public static void setSession(Session session) {
    }


    public void init() {
    	MinecraftForge.EVENT_BUS.register(this);
    	settingsManager = new SettingsManager();
    	moduleManager = new ModuleManager();
    	clickGui = new ClickGui();


        MinecraftForge.EVENT_BUS.register(new onGuiOpenEvent());
        Display.setTitle("3lue9 Client 1.12.2");
    }
    
    @SubscribeEvent
    public void key(KeyInputEvent e) {
    	if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
    		return; 
    	try {
             if (Keyboard.isCreated()) {
                 if (Keyboard.getEventKeyState()) {
                     int keyCode = Keyboard.getEventKey();
                     if (keyCode <= 0)
                    	 return;
                     for (Module m : moduleManager.modules) {
                    	 if (m.getKey() == keyCode) {
                    		 m.toggle();
                    	 }
                     }
                 }
             }
         } catch (Exception q) { q.printStackTrace(); }
    }
}
