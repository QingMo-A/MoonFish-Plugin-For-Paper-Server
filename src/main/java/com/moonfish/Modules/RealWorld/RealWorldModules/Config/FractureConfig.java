package com.moonfish.Modules.RealWorld.RealWorldModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.RealConfigUtil;

public class FractureConfig {
    private static final String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.RealWorldConfigName;


    private static final String FractureEffectName = "骨折触发效果";
    private static final String FractureTriggerIntervalName = "骨折触发间隔";
    private static final String FractureIndicateName = "骨折触发信息";
    private static final String FractureEnableName = "启用骨折";


    //获取骨折开启状态
    public static String getFractureEnable() {
        return RealConfigUtil.Search(FractureEnableName, ConfigPath);
    }

    //获取骨折触发效果
    public static String getFractureEffect() {
        return RealConfigUtil.Search(FractureEffectName, ConfigPath);
    }

    //获取骨折触发间隔
    public static String getFractureTriggerInterval() {
        return RealConfigUtil.Search(FractureTriggerIntervalName, ConfigPath);
    }

    //获取骨折信息
    public static String getFractureIndicateTemp() {
        return RealConfigUtil.Search(FractureIndicateName, ConfigPath);
    }
}
