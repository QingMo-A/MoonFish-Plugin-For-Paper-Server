package com.moonfish.Modules.RealWorld.RealWorldModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.RealConfigUtil;

public class StumbleConfig {
    private static final String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.RealWorldConfigName;

    private static final String StumbleEffectName = "跌倒触发效果";
    private static final String StumbleDamageName = "跌倒伤害";
    private static final String StumbleProbabilityName = "跌倒触发几率";
    private static final String StumbleIndicateName = "跌倒触发消息";
    private static final String StumbleEnableName = "启用跌倒";


    //获取跌倒开启状态
    public static String getStumbleEnable() {
        return RealConfigUtil.Search(StumbleEnableName, ConfigPath);
    }

    //获取跌倒触发效果
    public static String getStumbleEffect() {
        return RealConfigUtil.Search(StumbleEffectName, ConfigPath);
    }

    //获取跌倒触发几率
    public static String getStumbleProbability() {
        return RealConfigUtil.Search(StumbleProbabilityName, ConfigPath);
    }

    //获取跌倒伤害
    public static String getStumbleDamage() {
        return RealConfigUtil.Search(StumbleDamageName, ConfigPath);
    }

    //获取跌倒信息
    public static String getStumbleIndicateTemp() {
        return RealConfigUtil.Search(StumbleIndicateName, ConfigPath);
    }
}
