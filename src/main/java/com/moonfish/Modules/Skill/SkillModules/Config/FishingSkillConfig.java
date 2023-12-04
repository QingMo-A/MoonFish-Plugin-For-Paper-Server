package com.moonfish.Modules.Skill.SkillModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillUtils.SkillConfigUtil;
import org.bukkit.entity.Player;

public class FishingSkillConfig {
    private static final String ConfigPath = InitializeConfig.SkillDataFilePath + "/" + InitializeConfig.SkillDataFileName;

    private static String PlayerFishingSkillLevelName;

    private static String PlayerFishingSkillEXPName;

    public static String getPlayerFishingSkillLevel(Player player) {
        PlayerFishingSkillLevelName = player.getUniqueId() + "--钓鱼技能等级";
        return SkillConfigUtil.Search(PlayerFishingSkillLevelName, ConfigPath);
    }

    public static void setPlayerFishingSkillLevel(Player player, String newEXP) {
        PlayerFishingSkillLevelName = player.getUniqueId() + "--钓鱼技能等级";
        SkillConfigUtil.Write(PlayerFishingSkillLevelName, newEXP, ConfigPath);
    }

    public static String getPlayerFishingSkillEXP(Player player) {
        PlayerFishingSkillEXPName = player.getUniqueId() + "--钓鱼技能经验";
        return SkillConfigUtil.Search(PlayerFishingSkillEXPName, ConfigPath);
    }

    public static void setPlayerFishingSkillEXP(Player player, String newEXP) {
        PlayerFishingSkillEXPName = player.getUniqueId() + "--钓鱼技能经验";
        SkillConfigUtil.Write(PlayerFishingSkillEXPName, newEXP, ConfigPath);
    }
}
