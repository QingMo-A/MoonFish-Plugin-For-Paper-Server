package com.moonfish.Modules.Skill.SkillModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillUtils.SkillConfigUtil;
import org.bukkit.entity.Player;

public class MiningSkillConfig {
    private static final String ConfigPath = InitializeConfig.SkillDataFilePath + "/" + InitializeConfig.SkillDataFileName;

    private static String PlayerMiningSkillLevelName;

    private static String PlayerMiningSkillEXPName;

    public static String getPlayerMiningSkillLevel(Player player) {
        PlayerMiningSkillLevelName = player.getUniqueId() + "--挖矿技能等级";
        return SkillConfigUtil.Search(PlayerMiningSkillLevelName, ConfigPath);
    }

    public static void setPlayerMiningSkillLevel(Player player, String newEXP) {
        PlayerMiningSkillLevelName = player.getUniqueId() + "--挖矿技能等级";
        SkillConfigUtil.Write(PlayerMiningSkillLevelName, newEXP, ConfigPath);
    }

    public static String getPlayerMiningSkillEXP(Player player) {
        PlayerMiningSkillEXPName = player.getUniqueId() + "--挖矿技能经验";
        return SkillConfigUtil.Search(PlayerMiningSkillEXPName, ConfigPath);
    }

    public static void setPlayerMiningSkillEXP(Player player, String newEXP) {
        PlayerMiningSkillEXPName = player.getUniqueId() + "--挖矿技能经验";
        SkillConfigUtil.Write(PlayerMiningSkillEXPName, newEXP, ConfigPath);
    }
}
