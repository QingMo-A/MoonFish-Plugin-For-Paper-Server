package com.moonfish.Modules.Menu.Modules.SkillMenu.Listener;

import com.moonfish.Modules.Menu.MenuPanel.MenuPanel;
import com.moonfish.Modules.Menu.Modules.TeleportationMenu.Panel.TeleportationMenuPanel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SkillMenuListener implements Listener {
    @EventHandler
    public void PlayerClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getWhoClicked().getOpenInventory().getTitle().equals("§k|| §r§b熟练度菜单 §r§k||")) {
            event.setCancelled(true);

            if(event.getRawSlot() == 18) {
                //关闭菜单
                player.closeInventory();
                //跳转菜单
                TeleportationMenuPanel.OpenMenu(player);
            }

            if(event.getRawSlot() == 45) {
                //关闭菜单
                player.closeInventory();
                //跳转菜单
                MenuPanel.OpenMenu(player);
            }
        }
    }
}
