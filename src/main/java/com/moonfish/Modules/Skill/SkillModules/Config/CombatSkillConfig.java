package com.moonfish.Modules.Skill.SkillModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillUtils.SkillConfigUtil;
import org.bukkit.entity.Player;

public class CombatSkillConfig {
    private static final String ConfigPath = InitializeConfig.SkillDataFilePath + "/" + InitializeConfig.SkillDataFileName;

    private static String PlayerCombatSkillLevelName;

    private static String PlayerCombatSkillEXPName;

    public static String getPlayerCombatSkillLevel(Player player) {
        PlayerCombatSkillLevelName = player.getUniqueId() + "--战斗技能等级";
        return SkillConfigUtil.Search(PlayerCombatSkillLevelName, ConfigPath);
    }

    public static void setPlayerCombatSkillLevel(Player player, String newEXP) {
        PlayerCombatSkillLevelName = player.getUniqueId() + "--战斗技能等级";
        SkillConfigUtil.Write(PlayerCombatSkillLevelName, newEXP, ConfigPath);
    }

    public static String getPlayerCombatSkillEXP(Player player) {
        PlayerCombatSkillEXPName = player.getUniqueId() + "--战斗技能经验";
        return SkillConfigUtil.Search(PlayerCombatSkillEXPName, ConfigPath);
    }

    public static void setPlayerCombatSkillEXP(Player player, String newEXP) {
        PlayerCombatSkillEXPName = player.getUniqueId() + "--战斗技能经验";
        SkillConfigUtil.Write(PlayerCombatSkillEXPName, newEXP, ConfigPath);
    }
}
