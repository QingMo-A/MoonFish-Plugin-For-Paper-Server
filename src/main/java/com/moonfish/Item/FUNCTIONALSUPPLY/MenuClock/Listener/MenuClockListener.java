package com.moonfish.Item.FUNCTIONALSUPPLY.MenuClock.Listener;

import com.moonfish.Item.FUNCTIONALSUPPLY.MenuClock.Config.MenuClockConfig;
import com.moonfish.Modules.Menu.MenuPanel.MenuPanel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MenuClockListener implements Listener {
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        // 检测是否拿着
        if (MenuClockConfig.isMenuClock(itemInHand)) {
            // 检测是否右键生物
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                MenuPanel.OpenMenu(player);
            }
        }
    }
}
