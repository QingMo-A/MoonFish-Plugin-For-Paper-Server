package com.moonfish.Modules.Rank.RankUtils;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Rank.RankConfig.RankConfig;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;

import static org.bukkit.Bukkit.getLogger;

public class RankUtil {
    private static String text;

    public static void CreatePlayerRankData(Player player) {

        text =
                "[" + player.getUniqueId() + "]: " + RankConfig.RankLevel1 + "\n\n";

        File file = new File(InitializeConfig.RankDataFilePath + "/", InitializeConfig.RankDataFileName);
        if (RankConfig.getPlayerRankData(player) == null) {
            try {
                // 创建一个FileWriter对象
                FileWriter Write = new FileWriter(file, true);

                // 将数据写入文件
                Write.write(text);

                // 关闭FileWriter
                Write.close();
            } catch (Exception e) {
                getLogger().info("新玩家数据写入失败: " + e);
            }
        }
    }
}
