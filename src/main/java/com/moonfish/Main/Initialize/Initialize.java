package com.moonfish.Main.Initialize;

import com.moonfish.Config;
import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Main.Utils.CreateUtil;

import java.io.File;
import java.io.FileWriter;

import static org.bukkit.Bukkit.getLogger;

public class Initialize {

    public static void CreateFile() {
        CreateUtil.CreateFolder(InitializeConfig.PluginFolderPath, "已创建插件文件夹", "插件文件夹已存在");

        CreateUtil.CreateFolder(InitializeConfig.RankFolderPath, "已创建Rank文件夹", "Rank文件夹已存在");

        CreateUtil.CreateFile(InitializeConfig.RankDataFilePath, InitializeConfig.RankDataFileName, "已创建Rank数据文件", "Rank数据文件创建失败", "Rank数据文件已存在", "");

        CreateUtil.CreateFile(InitializeConfig.RankConfigPath, InitializeConfig.RankConfigName, "已创建Rank配置文件", "Rank配置文件创建失败", "Rank配置文件已存在", InitializeConfig.RankConfigText);

        CreateUtil.CreateFolder(InitializeConfig.SkillFolderPath, "已创建技能数据文件夹", "技能数据文件夹已存在");

        CreateUtil.CreateFile(InitializeConfig.SkillDataFilePath, InitializeConfig.SkillDataFileName, "已创建技能数据文件", "技能数据文件创建失败", "技能数据文件已存在", "");

        CreateUtil.CreateFolder(InitializeConfig.PlayerAttributesFolderPath, "已创建玩家属性文件夹", "玩家属性文件夹已存在");

        CreateUtil.CreateFile(InitializeConfig.PlayerAttributesDataFilePath, InitializeConfig.PlayerAttributesDataFileName, "已创建玩家属性文件", "玩家属性文件创建失败", "玩家属性文件已存在", "");

        CreateUtil.CreateFile(InitializeConfig.WelcomeMessageConfigPath, InitializeConfig.WelcomeMessageConfigName, "已创建欢迎语配置文件", "欢迎语配置文件创建失败", "欢迎语配置文件已存在", InitializeConfig.WelcomeMessageConfigText);

        CreateUtil.CreateFile(InitializeConfig.RealWorldConfigPath, InitializeConfig.RealWorldConfigName, "已创建真实世界配置文件", "真实世界配置文件创建失败", "真实世界配置文件已存在", InitializeConfig.RealWorldConfigText);
    }
}
