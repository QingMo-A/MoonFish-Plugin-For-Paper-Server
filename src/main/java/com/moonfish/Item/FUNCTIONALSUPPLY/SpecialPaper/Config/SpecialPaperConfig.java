package com.moonfish.Item.FUNCTIONALSUPPLY.SpecialPaper.Config;

import com.moonfish.MoonFish;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class SpecialPaperConfig {
    public static boolean isSpecialPaper(ItemStack item) {
        if (item != null && item.hasItemMeta()) {
            ItemMeta itemMeta = item.getItemMeta();
            NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "FUNCTIONALSUPPLY");

            // 检查物品的 NBT 标签
            if (itemMeta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
                String value = itemMeta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                if (value != null && value.equals("SPECIALPAPER")) {
                    return true;
                }
            }
        }

        return false;
    }
}
