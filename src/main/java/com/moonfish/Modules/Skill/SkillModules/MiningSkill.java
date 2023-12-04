package com.moonfish.Modules.Skill.SkillModules;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.MoonFish;
import com.moonfish.Modules.Skill.SkillConfig.SkillConfig;
import com.moonfish.Modules.Skill.SkillModules.Config.MiningSkillConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class MiningSkill {
    private static BossBar bossBar;
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    private static BukkitTask task;
    public static void addMiningSkillEXP(Player player, int value) {
        if (tasks.containsKey(player)) {
            int taskId = tasks.get(player).getTaskId();//获取任务ID
            Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
            bossBar.setVisible(false);
            bossBar.removePlayer(player);
            tasks.remove(player);
        }

        //玩家等级 < 等级上限
        if (Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player)) < SkillConfig.ExperienceRequiredForLevelingUp.length) {
            //玩家原本的经验数值 + 增加的数值 < 玩家现在等级升级所需的经验
            if (Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillEXP(player)) + value < (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player))])) {
                //保存玩家原本的经验数值 + 增加的数值
                MiningSkillConfig.setPlayerMiningSkillEXP(player, Integer.toString(Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillEXP(player)) + value));

                //玩家原本的经验数值 + 增加的数值 > 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillEXP(player)) + value > (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player))])) {
                int one = Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillEXP(player)) + value;
                //玩家原本的经验数值 + 增加的数值 - 玩家现在等级升级所需的经验
                MiningSkillConfig.setPlayerMiningSkillEXP(player, Integer.toString(one - SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player))]));
                //玩家等级 + 1
                MiningSkillConfig.setPlayerMiningSkillLevel(player, Integer.toString(Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player)) + 1));
                //
                PlayerAttributesConfig.setPlayerMiningProficiency(player, 5);

                //玩家原本的经验数值 + 增加的数值 = 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillEXP(player)) + value == (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player))])) {
                //重置玩家经验数值
                MiningSkillConfig.setPlayerMiningSkillEXP(player, Integer.toString(0));
                //玩家等级 + 1
                MiningSkillConfig.setPlayerMiningSkillLevel(player, Integer.toString(Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player)) + 1));
                //
                PlayerAttributesConfig.setPlayerMiningProficiency(player, 5);
            }

            bossBar = Bukkit.createBossBar("挖矿经验 + " + value + " | " + MiningSkillConfig.getPlayerMiningSkillEXP(player)  + "/" + SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player))], BarColor.WHITE, BarStyle.SEGMENTED_6);
            bossBar.setProgress((double) Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillEXP(player)) / SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(MiningSkillConfig.getPlayerMiningSkillLevel(player))]); // 将BossBar的完整度设置为50%
            bossBar.addPlayer(player);
            bossBar.setVisible(true);
            // 创建新的定时器任务
            task = Bukkit.getScheduler().runTaskLater(MoonFish.getPlugin(MoonFish.class), new Runnable() {
                @Override
                public void run() {
                    bossBar.setVisible(false);
                    bossBar.removePlayer(player);
                    tasks.remove(player);
                }
            }, 5*20L);
            tasks.put(player, task);
        }
    }

    public static boolean isMineral(Material material) {
        return  material == Material.COAL_ORE ||
                material == Material.DEEPSLATE_COAL_ORE ||

                material == Material.IRON_ORE ||
                material == Material.DEEPSLATE_IRON_ORE ||

                material == Material.GOLD_ORE ||
                material == Material.DEEPSLATE_GOLD_ORE ||

                material == Material.LAPIS_ORE ||
                material == Material.DEEPSLATE_LAPIS_ORE ||

                material == Material.REDSTONE_ORE ||
                material == Material.DEEPSLATE_REDSTONE_ORE ||

                material == Material.EMERALD_ORE ||
                material == Material.DEEPSLATE_EMERALD_ORE ||

                material == Material.DIAMOND_ORE ||
                material == Material.DEEPSLATE_DIAMOND_ORE ||

                material == Material.COPPER_ORE ||
                material == Material.DEEPSLATE_COPPER_ORE ||

                material == Material.NETHER_GOLD_ORE ||
                material == Material.NETHER_QUARTZ_ORE ||
                material == Material.ANCIENT_DEBRIS;
    }
}
