package com.moonfish.Item.SWORD.VampireSword.Listener;

import com.moonfish.Main.Utils.MessageUtil;
import com.moonfish.Item.SWORD.VampireSword.Config.VampireSwordConfig;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class VampireSwordListener implements Listener {
    @EventHandler
    public void OnAttackEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player)event.getDamager();
            Entity entity = event.getEntity();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            //是否手持吸血鬼剑
            if (VampireSwordConfig.isVampireSword(itemInHand)) {
                if (entity instanceof LivingEntity) {
                    double damage = event.getDamage() * 0.3;
                    VampireSwordConfig.AddHealth(damage, player);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    //MessageUtil.DebugMessage(player.getName() + "使用吸血鬼剑对" + entity.getName() + "造成了" + event.getDamage() + "点伤害,恢复了自身" + damage + "点生命");
                }
            }
        }
    }
}
