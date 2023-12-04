package com.moonfish.Modules.Menu.Modules.TeleportationMenu.Panel;

import com.moonfish.Modules.Menu.MenuConfig.PanelConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TeleportationMenuPanel {
    private static Inventory inventory;
    public static void OpenMenu(Player player) {
        Initialize(player);
        player.openInventory(inventory);
    }

    private static void Initialize(Player player) {
        inventory = Bukkit.createInventory(null, 54, "§k|| §r§b传送菜单 §r§k||");
        //第一行(0-8)
        inventory.setItem(0, PanelConfig.getPlayerHead(player));
        inventory.setItem(1, PanelConfig.getWhiteGlass());
        inventory.setItem(2, PanelConfig.getWhiteGlass());
        inventory.setItem(3, PanelConfig.getWhiteGlass());
        inventory.setItem(4, PanelConfig.getWhiteGlass());
        inventory.setItem(5, PanelConfig.getWhiteGlass());
        inventory.setItem(6, PanelConfig.getWhiteGlass());
        inventory.setItem(7, PanelConfig.getWhiteGlass());
        inventory.setItem(8, PanelConfig.getWhiteGlass());

        //第二行(9-17)
        inventory.setItem(9, PanelConfig.getSkillIcon());
        inventory.setItem(10, PanelConfig.getWhiteGlass());

        //第三行(18-26)
        inventory.setItem(18, PanelConfig.getTeleportationIcon());
        inventory.setItem(19, PanelConfig.getWhiteGlass());

        //第四行(27-35)
        inventory.setItem(28, PanelConfig.getWhiteGlass());

        //第五行(36-44)
        inventory.setItem(37, PanelConfig.getWhiteGlass());

        //第六行(45-53)
        inventory.setItem(45, PanelConfig.getBack());
        inventory.setItem(46, PanelConfig.getWhiteGlass());
        inventory.setItem(47, PanelConfig.getWhiteGlass());
        inventory.setItem(48, PanelConfig.getWhiteGlass());
        inventory.setItem(49, PanelConfig.getWhiteGlass());
        inventory.setItem(50, PanelConfig.getWhiteGlass());
        inventory.setItem(51, PanelConfig.getWhiteGlass());
        inventory.setItem(52, PanelConfig.getWhiteGlass());
        inventory.setItem(53, PanelConfig.getWhiteGlass());
    }
}
