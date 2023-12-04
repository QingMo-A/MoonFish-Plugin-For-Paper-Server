package com.moonfish.Modules.Skill.SkillConfig;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillUtils.SkillConfigUtil;
import org.bukkit.entity.Player;

public class SkillConfig {
    private static final String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.SkillFolderName + "/" + InitializeConfig.SkillDataFileName;

    private static String PlayerUUIDName;

    public static final int[] ExperienceRequiredForLevelingUp = {
            100, //0-1
            500, //1-2
            1000, //2-3
            1500, //3-4
            2000, //4-5
            2500, //5-6
            3000, //6-7
            3500, //7-8
            4000, //8-9
            4500, //9-10
            5000, //10-11
            5500, //11-12
            6000, //12-13
            6500, //13-14
            7000, //14-15
            7500, //15-16
            8000, //16-17
            9000, //17-18
            10000, //18-19
            11000 //19-20
    };

    public static final int[] MiningLucky = {
            5,
    };

    public static final int PlayerHealth = 5;


    public static String getPlayerSkillData(Player player) {
        PlayerUUIDName = "[" + player.getUniqueId() + "]";
        return SkillConfigUtil.Search(PlayerUUIDName, ConfigPath);
    }
}
