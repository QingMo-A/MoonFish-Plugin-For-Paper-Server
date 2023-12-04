package com.moonfish.Item.SWORD.VampireSword;

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

public class VampireSword {
    private final String Name = "§r§f§k|| §r§b『§c吸血鬼剑§r§b』 §r§f§k||";
    private final Material material = Material.DIAMOND_SWORD;
    private final List<String> Lore = new ArrayList<>() {{
        add(ChatColor.DARK_PURPLE + "由皇家血族『憨憨鱼公爵』亲手锻造而成");
        add(ChatColor.DARK_PURPLE + "        --攻击敌人后恢复自身--");
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
        NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "SWORD");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "VAMPIRESWORD");

        // 添加一个空的附魔列表，以启用附魔光效
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        // 将修改后的 ItemMeta 对象重新应用到物品
        item.setItemMeta(meta);

        return item;
    }

    public ShapedRecipe getRecipe() {
        // 创建 NamespacedKey 对象，用于标识自定义物品的合成方式
        NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "vampire_sword");

        // 创建合成方式，指定合成公式和原材料
        ShapedRecipe recipe = new ShapedRecipe(key, getItem());
        recipe.shape("RGR", "GDG", "RGR");
        recipe.setIngredient('D', Material.DIAMOND_SWORD);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('G', Material.GOLD_INGOT);

        return recipe;
    }
}
