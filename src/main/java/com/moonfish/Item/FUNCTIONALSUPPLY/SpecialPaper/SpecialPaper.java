package com.moonfish.Item.FUNCTIONALSUPPLY.SpecialPaper;

import com.moonfish.MoonFish;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class SpecialPaper {
    private final String Name = ChatColor.WHITE + "§k|| §r『§b特制§e的§c纸§r』 §k||";
    private final Material material = Material.PAPER;
    private final List<String> Lore = new ArrayList<>() {{
        add(ChatColor.RED + "一张特制的纸?");
        add(ChatColor.YELLOW + "当你饥渴难耐时说不定有用");
    }};

    public ItemStack getItem() {
        // 创建 ItemStack 对象
        ItemStack item = new ItemStack(material, 1);

        // 获取 ItemMeta 对象并设置显示名称和介绍信息
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Name);
        meta.setLore(Lore);

        // 添加自定义 NBT 标签
        NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "FUNCTIONALSUPPLY");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "SPECIALPAPER");

        // 将修改后的 ItemMeta 对象重新应用到物品
        item.setItemMeta(meta);

        return item;
    }

    public ShapedRecipe getRecipe() {
        // 创建 NamespacedKey 对象，用于标识自定义物品的合成方式
        NamespacedKey key = new NamespacedKey(MoonFish.getPlugin(MoonFish.class), "special_paper");

        // 创建合成方式，指定合成公式和原材料
        ShapedRecipe recipe = new ShapedRecipe(key, getItem());
        recipe.shape("   ", "PPP", "   ");
        recipe.setIngredient('P', Material.PAPER);

        return recipe;
    }
}
