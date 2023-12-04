package com.moonfish.Modules.Skill.SkillModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillUtils.SkillConfigUtil;
import org.bukkit.entity.Player;

public class ForagingSkillConfig {
    private static final String ConfigPath = InitializeConfig.SkillDataFilePath + "/" + InitializeConfig.SkillDataFileName;

    private static String PlayerForagingSkillLevelName;

    private static String PlayerForagingSkillEXPName;

    public static String getPlayerForagingSkillLevel(Player player) {
        PlayerForagingSkillLevelName = player.getUniqueId() + "--砍伐技能等级";
        return SkillConfigUtil.Search(PlayerForagingSkillLevelName, ConfigPath);
    }

    public static void setPlayerForagingSkillLevel(Player player, String newEXP) {
        PlayerForagingSkillLevelName = player.getUniqueId() + "--砍伐技能等级";
        SkillConfigUtil.Write(PlayerForagingSkillLevelName, newEXP, ConfigPath);
    }

    public static String getPlayerForagingSkillEXP(Player player) {
        PlayerForagingSkillEXPName = player.getUniqueId() + "--砍伐技能经验";
        return SkillConfigUtil.Search(PlayerForagingSkillEXPName, ConfigPath);
    }

    public static void setPlayerForagingSkillEXP(Player player, String newEXP) {
        PlayerForagingSkillEXPName = player.getUniqueId() + "--砍伐技能经验";
        SkillConfigUtil.Write(PlayerForagingSkillEXPName, newEXP, ConfigPath);
    }
}
