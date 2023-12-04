package com.moonfish.BetaModules.Attributes.PlayerAttributes.Utils;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.Main.Initialize.Config.InitializeConfig;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;

import static org.bukkit.Bukkit.getLogger;

public class PlayerAttributesUtil {
    private static String text;
    public static void CreatePlayerAttributesData(Player player) {
        text =
                "[" + player.getUniqueId() + "]" + "\n" +
                        player.getUniqueId() + "--生命: 20" + "\n" +
                        player.getUniqueId() + "--防御: 0" + "\n" +
                        player.getUniqueId() + "--力量: 0" + "\n" +
                        player.getUniqueId() + "--挖矿技巧: 0" + "\n" +
                        player.getUniqueId() + "--砍伐技巧: 0" + "\n" +
                        player.getUniqueId() + "--农业技巧: 0" + "\n" +
                        player.getUniqueId() + "--战斗技巧: 0" + "\n\n";

        File file = new File(InitializeConfig.PlayerAttributesDataFilePath + "/", InitializeConfig.PlayerAttributesDataFileName);
        //这里
        if (PlayerAttributesConfig.getPlayerAttributesData(player) == null) {
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
