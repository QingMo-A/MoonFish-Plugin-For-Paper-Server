package com.moonfish.Modules.Rank.RankConfig;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Rank.RankUtils.RankConfigUtil;
import org.bukkit.entity.Player;

public class RankConfig {
    private static final String ConfigPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.RankConfigName;
    private static final String DataPath = InitializeConfig.WorkingPath + "/" + InitializeConfig.PluginFolderName + "/" + InitializeConfig.RankFolderName + "/" +InitializeConfig.RankDataFileName;

    private static String PlayerUUIDName;

    private static String PlayerRankName;

    public static final String RankLevel1 = "CommonFish";
    public static final String RankLevel2 = "IronFish";
    public static final String RankLevel3 = "GoldFish";
    public static final String RankLevel4 = "DiamondFish";
    public static final String RankLevel5 = "DiamondFishPlus";

    private static final String EnableMessageName = "[启用]";

    private static final String RankLevel2JoinMessageName = "[Rank等级2进入消息]";

    private static final String RankLevel3JoinMessageName = "[Rank等级3进入消息]";

    private static final String RankLevel4JoinMessageName = "[Rank等级4进入消息]";

    private static final String RankLevel5JoinMessageName = "[Rank等级5进入消息]";

    public static String getPlayerRankData(Player player) {
        PlayerUUIDName = "[" + player.getUniqueId() + "]";
        return RankConfigUtil.Search(PlayerUUIDName, DataPath);
    }

    public static String getPlayerRank(Player player) {
        PlayerRankName = "[" + player.getUniqueId() + "]";
        return RankConfigUtil.Search(PlayerRankName, DataPath);
    }

    public static String getEnableStatus() {
        return RankConfigUtil.Search(EnableMessageName, ConfigPath);
    }

    public static String getRankLevel2JoinMessageTemp() {
        return RankConfigUtil.Search(RankLevel2JoinMessageName, ConfigPath);
    }

    public static String getRankLevel3JoinMessageTemp() {
        return RankConfigUtil.Search(RankLevel3JoinMessageName, ConfigPath);
    }

    public static String getRankLevel4JoinMessageTemp() {
        return RankConfigUtil.Search(RankLevel4JoinMessageName, ConfigPath);
    }

    public static String getRankLevel5JoinMessageTemp() {
        return RankConfigUtil.Search(RankLevel5JoinMessageName, ConfigPath);
    }
}
