package com.moonfish.Modules.Menu.MenuListener;

import com.moonfish.Modules.Menu.Modules.SkillMenu.Panel.SkillMenuPanel;
import com.moonfish.Modules.Menu.Modules.TeleportationMenu.Panel.TeleportationMenuPanel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {
    @EventHandler
    public void PlayerClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getWhoClicked().getOpenInventory().getTitle().equals("§k|| §r§b菜单 §r§k||")) {
            event.setCancelled(true);

            if(event.getRawSlot() == 9) {
                //关闭菜单
                player.closeInventory();
                //跳转菜单
                SkillMenuPanel.OpenMenu(player);
            }

            if(event.getRawSlot() == 18) {
                //关闭菜单
                player.closeInventory();
                //跳转菜单
                TeleportationMenuPanel.OpenMenu(player);
            }
        }
    }
}
