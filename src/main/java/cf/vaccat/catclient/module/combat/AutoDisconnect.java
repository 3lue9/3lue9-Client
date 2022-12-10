package cf.vaccat.catclient.module.combat;

import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Objects;

public class AutoDisconnect extends Module {
    double Health = mc.player.getHealth();

    public AutoDisconnect() {
        super("Auto Disconnect", "Quit When you have low health", Category.COMBAT);
    }

    @Override
    public void onEnable() {
       if (Health < 10){{

       }}
    }

    @Override
    public void onDisable() {

    }

}

