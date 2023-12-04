package com.moonfish.Modules.Skill.SkillModules;

import com.moonfish.MoonFish;
import com.moonfish.Modules.Skill.SkillConfig.SkillConfig;
import com.moonfish.Modules.Skill.SkillModules.Config.FarmingSkillConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class FarmingSkill {
    private static BossBar bossBar;
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    private static BukkitTask task;
    public static void addFarmingSkillEXP(Player player, int value) {
        if (tasks.containsKey(player)) {
            int taskId = tasks.get(player).getTaskId();//获取任务ID
            Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
            bossBar.setVisible(false);
            bossBar.removePlayer(player);
            tasks.remove(player);
        }

        //玩家等级 < 等级上限
        if (Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player)) < SkillConfig.ExperienceRequiredForLevelingUp.length) {
            //玩家原本的经验数值 + 增加的数值 < 玩家现在等级升级所需的经验
            if (Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillEXP(player)) + value < (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player))])) {
                //保存玩家原本的经验数值 + 增加的数值
                FarmingSkillConfig.setPlayerFarmingSkillEXP(player, Integer.toString(Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillEXP(player)) + value));

                //玩家原本的经验数值 + 增加的数值 > 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillEXP(player)) + value > (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player))])) {
                int one = Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillEXP(player)) + value;
                //玩家原本的经验数值 + 增加的数值 - 玩家现在等级升级所需的经验
                FarmingSkillConfig.setPlayerFarmingSkillEXP(player, Integer.toString(one - SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player))]));
                //玩家等级 + 1
                FarmingSkillConfig.setPlayerFarmingSkillLevel(player, Integer.toString(Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player)) + 1));

                //玩家原本的经验数值 + 增加的数值 = 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillEXP(player)) + value == (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player))])) {
                //重置玩家经验数值
                FarmingSkillConfig.setPlayerFarmingSkillEXP(player, Integer.toString(0));
                //玩家等级 + 1
                FarmingSkillConfig.setPlayerFarmingSkillLevel(player, Integer.toString(Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player)) + 1));
            }

            bossBar = Bukkit.createBossBar("农业经验 + " + value + " | " + FarmingSkillConfig.getPlayerFarmingSkillEXP(player)  + "/" + SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player))], BarColor.YELLOW, BarStyle.SEGMENTED_6);
            bossBar.setProgress((double) Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillEXP(player)) / SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FarmingSkillConfig.getPlayerFarmingSkillLevel(player))]); // 将BossBar的完整度设置为50%
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

    public static boolean isCrop(Material material) {
        return  material == Material.CARROTS ||
                material == Material.POTATOES ||
                material == Material.NETHER_WART ||
                material == Material.WHEAT ||
                material == Material.BEETROOT;
    }
}
