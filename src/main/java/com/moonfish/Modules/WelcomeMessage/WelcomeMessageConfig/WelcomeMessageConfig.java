package com.moonfish.Modules.WelcomeMessage.WelcomeMessageConfig;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.WelcomeMessage.WelcomeMessageUtils.WelcomeMessageConfigUtil;

public class WelcomeMessageConfig {

    private static final String EnableMessageName = "[启用玩家进出消息]";
    private static final String JoinMessageName = "[玩家进入消息]";
    private static final String QuitMessageName = "[玩家退出消息]";

    private static final String OPEnableMessageName = "[启用OP进出消息]";
    private static final String OPJoinMessageName = "[OP进入消息]";
    private static final String OPQuitMessageName = "[OP退出消息]";

    private static final String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.WelcomeMessageConfigName;
    public static String getEnableStatus() {
        return WelcomeMessageConfigUtil.Search(EnableMessageName, ConfigPath);
    }

    public static String getJoinMessageTemp() {
        return WelcomeMessageConfigUtil.Search(JoinMessageName, ConfigPath);
    }

    public static String getQuitMessageTemp() {
        return WelcomeMessageConfigUtil.Search(QuitMessageName, ConfigPath);
    }

    //==================================================================================================================

    public static String getOPEnableStatus() {
        return WelcomeMessageConfigUtil.Search(OPEnableMessageName, ConfigPath);
    }

    public static String getOPJoinMessageTemp() {
        return WelcomeMessageConfigUtil.Search(OPJoinMessageName, ConfigPath);
    }

    public static String getOPQuitMessageTemp() {
        return WelcomeMessageConfigUtil.Search(OPQuitMessageName, ConfigPath);
    }
}
