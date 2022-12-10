package cf.vaccat.catclient.module.movement;


import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;

import net.minecraft.block.Block;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;


public class Jesus extends Module {
    public Jesus() {
        super("Jesus", "Walk on water", Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {

        BlockPos blockPos = new BlockPos(mc.player.posX, mc.player.posY - 0.1, mc.player.posZ);
        Block block = mc.world.getBlockState(blockPos).getBlock();


        if (mc.player.isInWater()) {
            if (!mc.player.collidedHorizontally) {
                mc.player.motionY = 0.4;
            }
        }
    }
}



