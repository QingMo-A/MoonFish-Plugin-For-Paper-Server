package com.moonfish.Modules.RealWorld;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.FractureConfig;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.MasturbationConfig;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.NecropsyConfig;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.StumbleConfig;
import com.moonfish.Modules.RealWorld.RealWorldModules.Fracture;
import com.moonfish.Modules.RealWorld.RealWorldModules.Masturbation;
import com.moonfish.Modules.RealWorld.RealWorldModules.Necropsy;
import com.moonfish.Modules.RealWorld.RealWorldModules.Stumble;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;


public class RealWorld implements Listener {


    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player player) {
            //判断功能是否开启
            if (FractureConfig.getFractureEnable().equals(InitializeConfig.Status)) {
                Fracture.FractureModule(event, player);
            }
        }
    }

    //==================================================================================================================

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player player) {
            //检测功能是否开启
            if (NecropsyConfig.getNecropsyEnable().equals(InitializeConfig.Status)) {
                Necropsy.NecropsyModule(event, player);
            }
        }
    }

    //==================================================================================================================

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        //判断功能是否开启
        if (StumbleConfig.getStumbleEnable().equals(InitializeConfig.Status)) {
            Stumble.StumbleModule(event, player);
        }
    }

    //==================================================================================================================

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        //检测功能是否开启
        if (MasturbationConfig.getMasturbationEnable().equals(InitializeConfig.Status)) {
            Masturbation.MasturbationModule(event, player, itemInHand);
        }
    }
}
