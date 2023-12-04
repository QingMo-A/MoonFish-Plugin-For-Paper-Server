package com.moonfish.Item;

import com.moonfish.MoonFish;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TestItem {
    private final String displayName = ChatColor.YELLOW + "My Custom Item";
    private final Material material = Material.DIAMOND_SWORD;
    private final List<String> lore = new ArrayList<>() {{
        add(ChatColor.GRAY + "This is a custom item.");
        add(ChatColor.GRAY + "It was created by a skilled craftsman.");
    }};

    public ItemStack getItem() {
        // 创建 ItemStack 对象
        ItemStack item = new ItemStack(material, 1);

        // 获取 ItemMeta 对象并设置显示名称和介绍信息
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);

        // 将修改后的 ItemMeta 对象重新应用到物品
        item.setItemMeta(meta);

        return item;
    }

    public ShapedRecipe getRecipe() {
        // 创建 NamespacedKey 对象，用于标识自定义物品的合成方式
        NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "my_custom_item");

        // 创建合成方式，指定合成公式和原材料
        ShapedRecipe recipe = new ShapedRecipe(key, getItem());
        recipe.shape(" # ", "#@#", " # ");
        recipe.setIngredient('#', Material.DIAMOND);
        recipe.setIngredient('@', Material.APPLE);

        return recipe;
    }
}
