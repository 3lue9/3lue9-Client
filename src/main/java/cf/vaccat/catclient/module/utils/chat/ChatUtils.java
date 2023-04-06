package cf.vaccat.catclient.module.utils.chat;

import cf.vaccat.catclient.CatClient;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtils {
    public static void sendMessage(String msg) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(msg));
    }
}