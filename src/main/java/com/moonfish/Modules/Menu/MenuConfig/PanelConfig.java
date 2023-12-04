package com.moonfish.Modules.Menu.MenuConfig;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.Modules.Rank.RankConfig.RankConfig;
import com.moonfish.Modules.Skill.SkillConfig.SkillConfig;
import com.moonfish.Modules.Skill.SkillModules.Config.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class PanelConfig {
    public static ItemStack getPlayerHead(Player player) {
        // 添加玩家头部到第一个插槽
        ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta PlayerHeadMeta = (SkullMeta) PlayerHead.getItemMeta();
        PlayerHeadMeta.setDisplayName(player.getName());
        PlayerHeadMeta.setOwningPlayer(player);
        PlayerHeadMeta.setLore(new ArrayList<>() {{
            add(ChatColor.DARK_PURPLE + "UUID: " + player.getUniqueId());
            add(ChatColor.DARK_PURPLE + "用户组: " + RankConfig.getPlayerRank(player));
            add(ChatColor.DARK_PURPLE + "生命: " + PlayerAttributesConfig.getPlayerHealth(player));
            add(ChatColor.DARK_PURPLE + "防御: " + PlayerAttributesConfig.getPlayerArmour(player));
            add(ChatColor.DARK_PURPLE + "力量: " + PlayerAttributesConfig.getPlayerStrength(player));
            add(ChatColor.DARK_PURPLE + "挖矿技巧: " + PlayerAttributesConfig.getPlayerMiningProficiency(player));
            add(ChatColor.DARK_PURPLE + "砍伐技巧: " + PlayerAttributesConfig.getPlayerForagingProficiency(player));
            add(ChatColor.DARK_PURPLE + "农业技巧: " + PlayerAttributesConfig.getPlayerFarmingProficiency(player));
            add(ChatColor.DARK_PURPLE + "战斗技巧: " + PlayerAttributesConfig.getPlayerCombatProficiency(player));
        }});
        PlayerHead.setItemMeta(PlayerHeadMeta);

        return PlayerHead;
    }

    public static ItemStack getSkillIcon() {
        ItemStack SkillIcon = new ItemStack(Material.NETHER_STAR);
        ItemMeta SkillIconMeta = SkillIcon.getItemMeta();
        SkillIconMeta.setDisplayName("§o§e熟练度数据");
        SkillIconMeta.setLore(Arrays.asList("点我查看你的熟练度数据~"));
        SkillIcon.setItemMeta(SkillIconMeta);

        return SkillIcon;
    }

    public static ItemStack getShowPlayerCombatSkill(Player player) {
        ItemStack CombatSkill = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta CombatSkillMeta = CombatSkill.getItemMeta();
        CombatSkillMeta.setDisplayName("§o§e战斗熟练度");
        int one = SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(player))] - Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillEXP(player));
        CombatSkillMeta.setLore(new ArrayList<>() {{
            add(ChatColor.DARK_PURPLE + "等级: " + CombatSkillConfig.getPlayerCombatSkillLevel(player));
            add(ChatColor.DARK_PURPLE + "距离下一级还剩" + one + "点");
        }});
        CombatSkill.setItemMeta(CombatSkillMeta);

        return CombatSkill;
    }

    public static ItemStack getShowPlayerMiningSkill(Player player) {
        ItemStack MiningSkill = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta MiningSkillMeta = MiningSkill.getItemMeta();
        MiningSkillMeta.setDisplayName("§o§e挖矿熟练度");
        int one = SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player))] - Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillEXP(player));
        MiningSkillMeta.setLore(new ArrayList<>() {{
            add(ChatColor.DARK_PURPLE + "等级: " + MiningSkillConfig.getPlayerMiningSkillLevel(player));
            add(ChatColor.DARK_PURPLE + "距离下一级还剩" + one + "点");
        }});
        MiningSkill.setItemMeta(MiningSkillMeta);

        return MiningSkill;
    }

    public static ItemStack getShowPlayerFarmingSkill(Player player) {
        ItemStack FarmingSkill = new ItemStack(Material.WOODEN_HOE);
        ItemMeta FarmingSkillMeta = FarmingSkill.getItemMeta();
        FarmingSkillMeta.setDisplayName("§o§e农业熟练度");
        int one = SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player))] - Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillEXP(player));
        FarmingSkillMeta.setLore(new ArrayList<>() {{
            add(ChatColor.DARK_PURPLE + "等级: " + FarmingSkillConfig.getPlayerFarmingSkillLevel(player));
            add(ChatColor.DARK_PURPLE + "距离下一级还剩" + one + "点");
        }});
        FarmingSkill.setItemMeta(FarmingSkillMeta);

        return FarmingSkill;
    }

    public static ItemStack getShowPlayerForagingSkill(Player player) {
        ItemStack ForagingSkill = new ItemStack(Material.WOODEN_AXE);
        ItemMeta ForagingSkillMeta = ForagingSkill.getItemMeta();
        ForagingSkillMeta.setDisplayName("§o§e砍伐熟练度");
        int one = SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player))] - Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillEXP(player));
        ForagingSkillMeta.setLore(new ArrayList<>() {{
            add(ChatColor.DARK_PURPLE + "等级: " + ForagingSkillConfig.getPlayerForagingSkillLevel(player));
            add(ChatColor.DARK_PURPLE + "距离下一级还剩" + one + "点");
        }});
        ForagingSkill.setItemMeta(ForagingSkillMeta);

        return ForagingSkill;
    }

    public static ItemStack getShowPlayerFishingSkill(Player player) {
        ItemStack FishingSkill = new ItemStack(Material.FISHING_ROD);
        ItemMeta FishingSkillMeta = FishingSkill.getItemMeta();
        FishingSkillMeta.setDisplayName("§o§e钓鱼熟练度");
        int one = SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player))] - Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillEXP(player));
        FishingSkillMeta.setLore(new ArrayList<>() {{
            add(ChatColor.DARK_PURPLE + "等级: " + FishingSkillConfig.getPlayerFishingSkillLevel(player));
            add(ChatColor.DARK_PURPLE + "距离下一级还剩" + one + "点");
        }});
        FishingSkill.setItemMeta(FishingSkillMeta);

        return FishingSkill;
    }

    public static ItemStack getBedRock() {
        ItemStack BedRock = new ItemStack(Material.BEDROCK);
        ItemMeta SkillIconMeta = BedRock.getItemMeta();
        SkillIconMeta.setDisplayName("§o§4不可用");
        BedRock.setItemMeta(SkillIconMeta);

        return BedRock;
    }

    public static ItemStack getBack() {
        ItemStack Back = new ItemStack(Material.IRON_NUGGET);
        ItemMeta BackMeta = Back.getItemMeta();
        BackMeta.setDisplayName("§o§e返回");
        BackMeta.setLore(Arrays.asList("返回主页"));
        Back.setItemMeta(BackMeta);

        return Back;
    }

    public static ItemStack getTeleportationIcon() {
        ItemStack TeleportationIcon = new ItemStack(Material.ENDER_EYE);
        ItemMeta TeleportationIconMeta = TeleportationIcon.getItemMeta();
        TeleportationIconMeta.setDisplayName("§o§e传送");
        TeleportationIconMeta.setLore(Arrays.asList("点我进入传送菜单~"));
        TeleportationIcon.setItemMeta(TeleportationIconMeta);

        return TeleportationIcon;
    }

    public static ItemStack getWhiteGlass() {
        //新增物品实例
        ItemStack WhiteGlass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta WhiteGlassMeta = WhiteGlass.getItemMeta();
        //设置物品名称与介绍
        WhiteGlassMeta.setDisplayName(" ");
        //更新原物品
        WhiteGlass.setItemMeta(WhiteGlassMeta);

        return WhiteGlass;
    }
}
