package com.moonfish.Item.SWORD.VampireSword.Config;

import com.moonfish.MoonFish;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class VampireSwordConfig {
    public static boolean isVampireSword(ItemStack item) {
        if (item != null && item.hasItemMeta()) {
            ItemMeta itemMeta = item.getItemMeta();
            NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "SWORD");

            // 检查物品的 NBT 标签
            if (itemMeta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
                String value = itemMeta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                if (value != null && value.equals("VAMPIRESWORD")) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void AddHealth(double value, Player player) {
        double one = player.getMaxHealth() - player.getHealth();
        if (value >= one) {
            player.setHealth(player.getMaxHealth());
        } else if (value < one) {
            player.setHealth(player.getHealth() + value);
        }
    }
}
