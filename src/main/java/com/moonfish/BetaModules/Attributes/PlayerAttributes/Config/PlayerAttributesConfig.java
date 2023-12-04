package com.moonfish.BetaModules.Attributes.PlayerAttributes.Config;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Utils.PlayerAttributesConfigUtil;
import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillUtils.SkillConfigUtil;
import org.bukkit.entity.Player;

public class PlayerAttributesConfig {
    private static String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.PlayerAttributesFolderName + "/" + InitializeConfig.PlayerAttributesDataFileName;
    private static String PlayerUUIDName;

    private static String PlayerHealthName;
    private static String PlayerArmourName;
    private static String PlayerStrengthName;
    private static String PlayerMiningProficiencyName;
    private static String PlayerForagingProficiencyName;
    private static String PlayerFarmingProficiencyName;
    private static String PlayerCombatProficiencyName;

    public static String getPlayerAttributesData(Player player) {
        PlayerUUIDName = "[" + player.getUniqueId() + "]";
        return SkillConfigUtil.Search(PlayerUUIDName, ConfigPath);
    }

    public static String getPlayerHealth(Player player) {
        PlayerHealthName = player.getUniqueId() + "--生命";
        return PlayerAttributesConfigUtil.Search(PlayerHealthName, ConfigPath);
    }

    public static void setPlayerHealth(Player player, int value) {
        String newValue = Integer.toString(Integer.parseInt(PlayerAttributesConfig.getPlayerHealth(player)) + value);
        PlayerHealthName = player.getUniqueId() + "--生命";
        PlayerAttributesConfigUtil.Write(PlayerHealthName, newValue, ConfigPath);
    }

    public static String getPlayerArmour(Player player) {
        PlayerArmourName = player.getUniqueId() + "--防御";
        return PlayerAttributesConfigUtil.Search(PlayerArmourName, ConfigPath);
    }

    public static String getPlayerStrength(Player player) {
        PlayerStrengthName = player.getUniqueId() + "--力量";
        return PlayerAttributesConfigUtil.Search(PlayerStrengthName, ConfigPath);
    }

    public static String getPlayerMiningProficiency(Player player) {
        PlayerMiningProficiencyName = player.getUniqueId() + "--挖矿技巧";
        return PlayerAttributesConfigUtil.Search(PlayerMiningProficiencyName, ConfigPath);
    }

    public static void setPlayerMiningProficiency(Player player, int value) {
        String newValue = Integer.toString(Integer.parseInt(PlayerAttributesConfig.getPlayerMiningProficiency(player)) + value);
        PlayerMiningProficiencyName = player.getUniqueId() + "--挖矿技巧";
        PlayerAttributesConfigUtil.Write(PlayerMiningProficiencyName, newValue, ConfigPath);
    }

    public static String getPlayerForagingProficiency(Player player) {
        PlayerForagingProficiencyName = player.getUniqueId() + "--砍伐技巧";
        return PlayerAttributesConfigUtil.Search(PlayerForagingProficiencyName, ConfigPath);
    }

    public static String getPlayerFarmingProficiency(Player player) {
        PlayerFarmingProficiencyName = player.getUniqueId() + "--农业技巧";
        return PlayerAttributesConfigUtil.Search(PlayerFarmingProficiencyName, ConfigPath);
    }

    public static String getPlayerCombatProficiency(Player player) {
        PlayerCombatProficiencyName = player.getUniqueId() + "--战斗技巧";
        return PlayerAttributesConfigUtil.Search(PlayerCombatProficiencyName, ConfigPath);
    }
}
