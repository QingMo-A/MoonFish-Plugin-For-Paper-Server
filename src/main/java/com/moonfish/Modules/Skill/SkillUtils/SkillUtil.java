package com.moonfish.Modules.Skill.SkillUtils;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Skill.SkillConfig.SkillConfig;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;

import static org.bukkit.Bukkit.getLogger;

public class SkillUtil {
    private static String text;
    public static void CreatePlayerSkillData(Player player) {
        text =
                "[" + player.getUniqueId() + "]" + "\n" +
                player.getUniqueId() + "--战斗技能等级: 0" + "\n" +
                player.getUniqueId() + "--战斗技能经验: 0" + "\n" +
                player.getUniqueId() + "--挖矿技能等级: 0" + "\n" +
                player.getUniqueId() + "--挖矿技能经验: 0" + "\n" +
                player.getUniqueId() + "--砍伐技能等级: 0" + "\n" +
                player.getUniqueId() + "--砍伐技能经验: 0" + "\n" +
                player.getUniqueId() + "--农业技能等级: 0" + "\n" +
                player.getUniqueId() + "--农业技能经验: 0" + "\n" +
                player.getUniqueId() + "--钓鱼技能等级: 0" + "\n" +
                player.getUniqueId() + "--钓鱼技能经验: 0" + "\n\n";

        File file = new File(InitializeConfig.SkillDataFilePath + "/", InitializeConfig.SkillDataFileName);
        //这里
        if (SkillConfig.getPlayerSkillData(player) == null) {
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
