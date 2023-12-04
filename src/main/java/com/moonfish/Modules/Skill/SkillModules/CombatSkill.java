package com.moonfish.Modules.Skill.SkillModules;

import com.moonfish.MoonFish;
import com.moonfish.Modules.Skill.SkillConfig.SkillConfig;
import com.moonfish.Modules.Skill.SkillModules.Config.CombatSkillConfig;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class CombatSkill {
    private static BossBar bossBar;
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    private static BukkitTask task;
    public static void addCombatSkillEXP(Player killer, int value) {
        if (tasks.containsKey(killer)) {
            int taskId = tasks.get(killer).getTaskId();//获取任务ID
            Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
            bossBar.setVisible(false);
            bossBar.removePlayer(killer);
            tasks.remove(killer);
        }

        //玩家等级 < 等级上限
        if (Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer)) < SkillConfig.ExperienceRequiredForLevelingUp.length) {
            //玩家原本的经验数值 + 增加的数值 < 玩家现在等级升级所需的经验
            if (Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillEXP(killer)) + value < (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer))])) {
                //保存玩家原本的经验数值 + 增加的数值
                CombatSkillConfig.setPlayerCombatSkillEXP(killer, Integer.toString(Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillEXP(killer)) + value));

                //玩家原本的经验数值 + 增加的数值 > 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillEXP(killer)) + value > (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer))])) {
                int one = Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillEXP(killer)) + value;
                //玩家原本的经验数值 + 增加的数值 - 玩家现在等级升级所需的经验
                CombatSkillConfig.setPlayerCombatSkillEXP(killer, Integer.toString(one - SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer))]));
                //玩家等级 + 1
                CombatSkillConfig.setPlayerCombatSkillLevel(killer, Integer.toString(Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer)) + 1));

                //玩家原本的经验数值 + 增加的数值 = 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillEXP(killer)) + value == (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer))])) {
                //重置玩家经验数值
                CombatSkillConfig.setPlayerCombatSkillEXP(killer, Integer.toString(0));
                //玩家等级 + 1
                CombatSkillConfig.setPlayerCombatSkillLevel(killer, Integer.toString(Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer)) + 1));
            }

            bossBar = Bukkit.createBossBar("战斗经验 + " + value + " | " + CombatSkillConfig.getPlayerCombatSkillEXP(killer) + "/" + SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer))], BarColor.RED, BarStyle.SEGMENTED_6);
            bossBar.setProgress((double) Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillEXP(killer)) / SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(CombatSkillConfig.getPlayerCombatSkillLevel(killer))]); // 将BossBar的完整度设置为50%
            bossBar.addPlayer(killer);
            bossBar.setVisible(true);
        /*new BukkitRunnable() {
            @Override
            public void run() {
                bossBar.setVisible(false);
                bossBar.removePlayer(killer);
            }
        }.runTaskLater(MoonFish.getPlugin(MoonFish.class), 100); // 100 ticks = 5 seconds*/

            // 创建新的定时器任务
            task = Bukkit.getScheduler().runTaskLater(MoonFish.getPlugin(MoonFish.class), new Runnable() {
                @Override
                public void run() {
                    bossBar.setVisible(false);
                    bossBar.removePlayer(killer);
                    tasks.remove(killer);
                }
            }, 5*20L);
            tasks.put(killer, task);
        }
    }
}
