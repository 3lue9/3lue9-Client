package cf.vaccat.catclient.module.movement;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.settings.Setting;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DamageBoost extends Module {
    public DamageBoost() {
        super("Damage Boost", "Boost your self by getting damaged", Category.MOVEMENT);
        CatClient.instance.settingsManager.rSetting(new Setting("Horizontal", this, 120, 100, 250, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Vertical", this, 120, 100, 200, true));
    }
    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent e) {
        float horizontal = (float) CatClient.instance.settingsManager.getSettingByName(this, "Horizontal").getValDouble();
        float vertical = (float) CatClient.instance.settingsManager.getSettingByName(this, "Vertical").getValDouble();

        if (mc.player.hurtTime == mc.player.maxHurtTime && mc.player.maxHurtTime > 0) {
            mc.player.motionX *= (float) horizontal / 100;
            mc.player.motionY *= (float) vertical / 100;
            mc.player.motionZ *= (float) horizontal / 100;
        }
    }


}
