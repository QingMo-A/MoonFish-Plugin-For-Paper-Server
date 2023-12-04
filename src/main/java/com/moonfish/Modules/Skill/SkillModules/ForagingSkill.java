package com.moonfish.Modules.Skill.SkillModules;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.MoonFish;
import com.moonfish.Modules.Skill.SkillConfig.SkillConfig;
import com.moonfish.Modules.Skill.SkillModules.Config.ForagingSkillConfig;
import com.moonfish.System.HealthSystem.Config.HealthSystemConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class ForagingSkill {
    private static BossBar bossBar;
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    private static BukkitTask task;

    public static void addForagingSkillEXP(Player player, int value) {
        if (tasks.containsKey(player)) {
            int taskId = tasks.get(player).getTaskId();//获取任务ID
            Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
            bossBar.setVisible(false);
            bossBar.removePlayer(player);
            tasks.remove(player);
        }

        //玩家等级 < 等级上限
        if (Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player)) < SkillConfig.ExperienceRequiredForLevelingUp.length) {
            //玩家原本的经验数值 + 增加的数值 < 玩家现在等级升级所需的经验
            if (Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillEXP(player)) + value < (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player))])) {
                //保存玩家原本的经验数值 + 增加的数值
                ForagingSkillConfig.setPlayerForagingSkillEXP(player, Integer.toString(Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillEXP(player)) + value));

                //玩家原本的经验数值 + 增加的数值 > 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillEXP(player)) + value > (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player))])) {
                int one = Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillEXP(player)) + value;
                //玩家原本的经验数值 + 增加的数值 - 玩家现在等级升级所需的经验
                ForagingSkillConfig.setPlayerForagingSkillEXP(player, Integer.toString(one - SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player))]));
                //玩家等级 + 1
                ForagingSkillConfig.setPlayerForagingSkillLevel(player, Integer.toString(Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player)) + 1));
                //
                PlayerAttributesConfig.setPlayerHealth(player, 5);
                //
                HealthSystemConfig.UpdatePlayerHealthScore(player, 5);

                //玩家原本的经验数值 + 增加的数值 = 玩家现在等级升级所需的经验
            } else if (Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillEXP(player)) + value == (SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player))])) {
                //重置玩家经验数值
                ForagingSkillConfig.setPlayerForagingSkillEXP(player, Integer.toString(0));
                //玩家等级 + 1
                ForagingSkillConfig.setPlayerForagingSkillLevel(player, Integer.toString(Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player)) + 1));
                //
                PlayerAttributesConfig.setPlayerHealth(player, SkillConfig.PlayerHealth);
                //
                HealthSystemConfig.UpdatePlayerHealthScore(player, SkillConfig.PlayerHealth);
            }

            bossBar = Bukkit.createBossBar("砍伐经验 + " + value + " | " + ForagingSkillConfig.getPlayerForagingSkillEXP(player)  + "/" + SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player))], BarColor.GREEN, BarStyle.SEGMENTED_6);
            bossBar.setProgress((double) Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillEXP(player)) / SkillConfig.ExperienceRequiredForLevelingUp[Integer.parseInt(ForagingSkillConfig.getPlayerForagingSkillLevel(player))]); // 将BossBar的完整度设置为50%
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

    public static boolean isWood(Material material) {
        return  material == Material.ACACIA_LOG ||
                material == Material.STRIPPED_ACACIA_LOG ||

                material == Material.DARK_OAK_LOG ||
                material == Material.STRIPPED_DARK_OAK_LOG ||

                material == Material.MANGROVE_LOG ||
                material == Material.STRIPPED_MANGROVE_LOG ||

                material == Material.OAK_LOG ||
                material == Material.STRIPPED_OAK_LOG ||

                material == Material.BIRCH_LOG ||
                material == Material.STRIPPED_BIRCH_LOG ||

                material == Material.JUNGLE_LOG ||
                material == Material.STRIPPED_JUNGLE_LOG ||

                material == Material.SPRUCE_LOG ||
                material == Material.STRIPPED_SPRUCE_LOG ||

                material == Material.CRIMSON_STEM ||
                material == Material.STRIPPED_CRIMSON_STEM ||

                material == Material.WARPED_STEM ||
                material == Material.STRIPPED_WARPED_STEM ||

                material == Material.CHERRY_LOG ||
                material == Material.STRIPPED_CHERRY_LOG;
    }
}
