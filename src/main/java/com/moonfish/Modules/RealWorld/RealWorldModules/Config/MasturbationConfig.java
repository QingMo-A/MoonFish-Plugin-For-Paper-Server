package com.moonfish.Modules.RealWorld.RealWorldModules.Config;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.RealConfigUtil;

public class MasturbationConfig {
    private static final String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.RealWorldConfigName;

    private static final String MasturbationEffectName = "打胶触发效果";
    private static final String MasturbationIndicateName = "打胶触发信息";
    private static final String MasturbationFailIndicateName = "打胶失败触发信息";
    private static final String MasturbationEnableName = "启用打胶";
    private static final String MasturbationTimeRangeName = "触发信息中 %t 的范围";


    //获取打胶开启状态
    public static String getMasturbationEnable() {
        return RealConfigUtil.Search(MasturbationEnableName, ConfigPath);
    }

    //获取打胶触发效果
    public static String getMasturbationEffect() {
        return RealConfigUtil.Search(MasturbationEffectName, ConfigPath);
    }

    //获取打胶信息
    public static String getMasturbationIndicateTemp() {
        return RealConfigUtil.Search(MasturbationIndicateName, ConfigPath);
    }

    //获取打胶失败信息
    public static String getMasturbationFailIndicateTemp() {
        return RealConfigUtil.Search(MasturbationFailIndicateName, ConfigPath);
    }

    //获取打胶时间范围
    public static String getMasturbationTimeRange() {
        return RealConfigUtil.Search(MasturbationTimeRangeName, ConfigPath);
    }
}
