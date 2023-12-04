package com.moonfish.Modules.Skill.SkillModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillUtils.SkillConfigUtil;
import org.bukkit.entity.Player;

public class FarmingSkillConfig {
    private static final String ConfigPath = InitializeConfig.SkillDataFilePath + "/" + InitializeConfig.SkillDataFileName;

    private static String PlayerFarmingSkillLevelName;

    private static String PlayerFarmingSkillEXPName;

    public static String getPlayerFarmingSkillLevel(Player player) {
        PlayerFarmingSkillLevelName = player.getUniqueId() + "--农业技能等级";
        return SkillConfigUtil.Search(PlayerFarmingSkillLevelName, ConfigPath);
    }

    public static void setPlayerFarmingSkillLevel(Player player, String newEXP) {
        PlayerFarmingSkillLevelName = player.getUniqueId() + "--农业技能等级";
        SkillConfigUtil.Write(PlayerFarmingSkillLevelName, newEXP, ConfigPath);
    }

    public static String getPlayerFarmingSkillEXP(Player player) {
        PlayerFarmingSkillEXPName = player.getUniqueId() + "--农业技能经验";
        return SkillConfigUtil.Search(PlayerFarmingSkillEXPName, ConfigPath);
    }

    public static void setPlayerFarmingSkillEXP(Player player, String newEXP) {
        PlayerFarmingSkillEXPName = player.getUniqueId() + "--农业技能经验";
        SkillConfigUtil.Write(PlayerFarmingSkillEXPName, newEXP, ConfigPath);
    }
}
