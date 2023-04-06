package cf.vaccat.catclient.module.render;

import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Objects;

public class FullBright extends Module {
    public FullBright() {
    super("Full Bright", "See in The Dark", Category.RENDER);

}
    @Override
    public void onEnable() {
        mc.player.addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionById(16)), 9999, 255));
    }

    @Override
    public void onDisable()  {
        mc.player.removePotionEffect(Objects.requireNonNull(Potion.getPotionById(16)));
    }
}


