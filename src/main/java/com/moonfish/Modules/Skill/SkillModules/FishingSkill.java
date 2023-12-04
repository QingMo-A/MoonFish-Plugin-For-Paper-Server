package com.moonfish.Modules.Skill.SkillModules;

import com.moonfish.MoonFish;
import com.moonfish.Modules.Skill.SkillConfig.SkillConfig;
import com.moonfish.Modules.Skill.SkillModules.Config.FishingSkillConfig;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class FishingSkill {
    private static BossBar bossBar;
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    private static BukkitTask task;
    public static void addFishingSkillEXP(Player player, int value) {
        if (tasks.containsKey(player)) {
            int taskId = tasks.get(player).getTaskId();//获取任务ID
            Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
            bossBar.setVisible(false);
            bossBar.removePlayer(player);
            tasks.remove(player);
        }

        //玩家等级 < 等级上限
        if (Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player)) < SkillConfig.ExperienceRequiredForLevelingUp.length) {
            //玩家原本的经验数值 + 增加的数值 < 玩家现在等级升级所需的经验
            if (Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillEXP(player)) + value < (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player))])) {
                //保存玩家原本的经验数值 + 增加的数值
                FishingSkillConfig.setPlayerFishingSkillEXP(player, Integer.toString(Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillEXP(player)) + value));

                //玩家原本的经验数值 + 增加的数值 > 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillEXP(player)) + value > (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player))])) {
                int one = Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillEXP(player)) + value;
                //玩家原本的经验数值 + 增加的数值 - 玩家现在等级升级所需的经验
                FishingSkillConfig.setPlayerFishingSkillEXP(player, Integer.toString(one - SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player))]));
                //玩家等级 + 1
                FishingSkillConfig.setPlayerFishingSkillLevel(player, Integer.toString(Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player)) + 1));

                //玩家原本的经验数值 + 增加的数值 = 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillEXP(player)) + value == (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player))])) {
                //重置玩家经验数值
                FishingSkillConfig.setPlayerFishingSkillEXP(player, Integer.toString(0));
                //玩家等级 + 1
                FishingSkillConfig.setPlayerFishingSkillLevel(player, Integer.toString(Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player)) + 1));
            }

            bossBar = Bukkit.createBossBar("钓鱼经验 + " + value + " | " + FishingSkillConfig.getPlayerFishingSkillEXP(player)  + "/" + SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player))], BarColor.BLUE, BarStyle.SEGMENTED_6);
            bossBar.setProgress((double) Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillEXP(player)) / SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(FishingSkillConfig.getPlayerFishingSkillLevel(player))]); // 将BossBar的完整度设置为50%
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
}
