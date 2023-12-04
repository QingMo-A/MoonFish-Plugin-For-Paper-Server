package com.moonfish.Item.FUNCTIONALSUPPLY.MenuClock;

import com.moonfish.MoonFish;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class MenuClock {
    private final String Name = "§r§f§k|| §r§5『§g菜单§r§5』 §r§f§k||";
    private final Material material = Material.CLOCK;
    private final List<String> Lore = new ArrayList<>() {{
        add(ChatColor.DARK_PURPLE + "轻轻点击...");
    }};

    public ItemStack getItem() {
        // 创建 ItemStack 对象
        ItemStack item = new ItemStack(material, 1);

        // 获取 ItemMeta 对象并设置显示名称和介绍信息
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Name);
        meta.setLore(Lore);
        meta.setUnbreakable(true); // 将物品设置为不可损坏

        // 添加自定义 NBT 标签
        NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "FUNCTIONALSUPPLY");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "MENUCLOCK");

        // 添加一个空的附魔列表，以启用附魔光效
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        // 将修改后的 ItemMeta 对象重新应用到物品
        item.setItemMeta(meta);

        return item;
    }
}
