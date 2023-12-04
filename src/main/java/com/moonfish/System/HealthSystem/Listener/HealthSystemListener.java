package com.moonfish.System.HealthSystem.Listener;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.Main.Utils.MessageUtil;
import com.moonfish.MoonFish;
import com.moonfish.System.HealthSystem.Config.HealthSystemConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;

public class HealthSystemListener implements Listener {
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    private static BukkitTask task;
    private static int i;
    // 玩家进入游戏时触发该事件
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        HealthSystemConfig.initPlayerHealth(event.getPlayer());
        //MessageUtil.DebugMessage("玩家进入游戏 初始化血量");
        HealthSystemConfig.ShowHealth(event.getPlayer());
    }

    // 玩家重生时触发该事件
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        HealthSystemConfig.initPlayerHealth(event.getPlayer());
        //MessageUtil.DebugMessage("玩家重生 初始化血量");
        HealthSystemConfig.ShowHealth(event.getPlayer());
    }

    // 玩家受伤时触发该事件
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (tasks.containsKey(player)) {
                //MessageUtil.DebugMessage("1玩家在四秒内受到了伤害,回复血量取消");
                int taskId = tasks.get(player).getTaskId();//获取任务ID
                Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
                tasks.remove(player);
            }
            if (HealthSystemConfig.tasks.containsKey(player)) {
                //MessageUtil.DebugMessage("2玩家在四秒内受到了伤害,回复血量取消");
                int taskId = HealthSystemConfig.tasks.get(player).getTaskId();
                Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
                HealthSystemConfig.tasks.remove(player);
            }

            Scoreboard scoreboard = player.getScoreboard();

            Objective objectiveName = scoreboard.getObjective("HealthName");
            // 获取玩家计分板分数
            Score scoreName = objectiveName.getScore(player.getName());

            Objective objectiveList = scoreboard.getObjective("HealthList");
            Score scoreList = objectiveList.getScore(player);

            // 计算受伤血量
            double NowScore = scoreName.getScore();
            double CalculatedScore = NowScore - event.getFinalDamage();
            if (CalculatedScore <= 0) {
                event.setDamage(player.getMaxHealth());
            } else if (CalculatedScore > 0) {
                //MessageUtil.DebugMessage("受到攻击后的血量" + CalculatedScore);
                scoreName.setScore((int) CalculatedScore);
                scoreList.setScore((int) CalculatedScore);
                // 创建新的定时器任务
                task = Bukkit.getScheduler().runTaskLater(MoonFish.getPlugin(MoonFish.class), new Runnable() {
                    @Override
                    public void run() {
                        if (scoreName.getScore() < Integer.parseInt(PlayerAttributesConfig.getPlayerHealth(player))) {
                            HealthSystemConfig.RegainHealth(player);
                        }
                        tasks.remove(player);
                    }
                }, 4*20L);
                tasks.put(player, task);

                event.setDamage(0);
                HealthSystemConfig.ShowHealth(player);
            }

        }
    }
}
