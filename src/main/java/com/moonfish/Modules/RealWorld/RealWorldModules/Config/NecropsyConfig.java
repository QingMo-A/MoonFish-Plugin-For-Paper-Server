package com.moonfish.Modules.RealWorld.RealWorldModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.RealConfigUtil;

public class NecropsyConfig {
    private static final String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.RealWorldConfigName;

    private static final String NecropsyEffectName = "尸毒触发效果";
    private static final String NecropsyTriggerIntervalName = "尸毒触发间隔";
    private static final String NecropsyIndicateName = "尸毒触发信息";
    private static final String NecropsyEnableName = "启用尸毒";


    //获取尸毒开启状态
    public static String getNecropsyEnable() {
        return RealConfigUtil.Search(NecropsyEnableName, ConfigPath);
    }

    //获取尸毒触发效果
    public static String getNecropsyEffect() {
        return RealConfigUtil.Search(NecropsyEffectName, ConfigPath);
    }

    //获取尸毒触发间隔
    public static String getNecropsyTriggerInterval() {
        return RealConfigUtil.Search(NecropsyTriggerIntervalName, ConfigPath);
    }

    //获取尸毒信息
    public static String getNecropsyIndicateTemp() {
        return RealConfigUtil.Search(NecropsyIndicateName, ConfigPath);
    }
}
