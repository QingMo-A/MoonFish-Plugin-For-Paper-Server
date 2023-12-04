package com.moonfish.System.HealthSystem.Config;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.Main.Utils.MessageUtil;
import com.moonfish.MoonFish;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.*;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;

public class HealthSystemConfig {
    public static Map<Player, Double> playerHealthMap = new HashMap<>();
    // 用于存储正在回血中的玩家（计分板更新的倒计时任务）
    public static final HashMap<Player, BukkitTask> tasks = new HashMap<>();

    private static Map<String, BukkitRunnable> actionBarRunnables = new HashMap<>();

    // 初始化玩家的血量信息
    public static void initPlayerHealth(Player player) {
        double MaxHealth = Double.parseDouble(PlayerAttributesConfig.getPlayerHealth(player));
        playerHealthMap.put(player, MaxHealth);
        CreateBoard(player, (int) MaxHealth);
    }

    private static void CreateBoard(Player player, int health) {
        // 创建计分板
        ScoreboardManager manager = Bukkit.getScoreboardManager(); // 获取ScoreboardManager实例
        Scoreboard scoreboard = manager.getNewScoreboard(); // 创建一个新的计分板

        // 创建新的计分板目标
        Objective objectiveName = scoreboard.registerNewObjective("HealthName", "dummy", "❤"); // 创建一个新的计分板目标，类型为默认类型，显示名称为“生命值”
        // 将目标与计分板进行绑定
        objectiveName.setDisplaySlot(DisplaySlot.BELOW_NAME); // 将目标与计分板进行绑定，使得该目标显示在玩家名字下面
        // 设置分数
        Score scoreName = objectiveName.getScore(player.getName()); // 获取指定玩家的分数对象
        scoreName.setScore(health); // 将分数设置为88


        // 创建新的计分板目标
        Objective objectiveList = scoreboard.registerNewObjective("HealthList", "dummy", "❤"); // 创建一个新的计分板目标，类型为默认类型，显示名称为“生命值”
        // 将目标与计分板进行绑定
        objectiveList.setDisplaySlot(DisplaySlot.PLAYER_LIST); // 将目标与计分板进行绑定，使得该目标显示在玩家名字下面
        // 设置分数
        Score scoreList = objectiveList.getScore(player.getName()); // 获取指定玩家的分数对象
        scoreList.setScore(health); // 将分数设置为88

        player.setScoreboard(scoreboard); // 将计分板与指定玩家绑定
    }

    // 更新玩家的血量信息
    public static void UpdatePlayerHealthScore(Player player, int health) {
        Scoreboard scoreboard = player.getScoreboard();

        Objective objectiveName = scoreboard.getObjective("HealthName");
        Score scoreName = objectiveName.getScore(player);

        Objective objectiveList = scoreboard.getObjective("HealthList");
        Score scoreList = objectiveList.getScore(player);

        double oneName = scoreName.getScore();

        double oneList = scoreName.getScore();

        scoreName.setScore((int) (oneName + health));
        scoreList.setScore((int) (oneList + health));
    }

    public static void RegainHealth(Player player) {
        // 检查该玩家是否已经有一个回血任务在运行
        if (tasks.containsKey(player)) {
            int taskId = tasks.get(player).getTaskId();//获取任务ID
            Bukkit.getScheduler().cancelTask(taskId);//取消定时任务
            tasks.remove(player);
        }
        //MessageUtil.DebugMessage("玩家四秒内没有受到攻击,开始回血");
        Scoreboard scoreboard = player.getScoreboard();

        Objective objectiveName = scoreboard.getObjective("HealthName");
        // 获取玩家计分板分数
        Score scoreName = objectiveName.getScore(player);

        Objective objectiveList = scoreboard.getObjective("HealthList");
        Score scoreList = objectiveList.getScore(player);

        // 启动一个新的回血任务
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(MoonFish.getPlugin(MoonFish.class), new Runnable() {
            @Override
            public void run() {
                // 计算受伤血量
                double NowScore = scoreName.getScore();
                double MaxHealth = Double.parseDouble(PlayerAttributesConfig.getPlayerHealth(player));

                if (NowScore < MaxHealth) { // 判断玩家当前生命值是否小于最大生命值

                    scoreName.setScore((int) (NowScore + 1));
                    scoreList.setScore((int) (NowScore + 1));
                    //MessageUtil.DebugMessage("现在血量: " + (NowScore + 1));
                } else { // 如果玩家生命值已经满了，取消该任务并从tasks中移除
                    BukkitTask timerTask = tasks.get(player);
                    if (timerTask != null) {
                        //MessageUtil.DebugMessage("血量回满了");
                        timerTask.cancel();
                        tasks.remove(player);
                    }
                }
            }
        }, 0L, 10L);

        // 将该任务添加到tasks中
        tasks.put(player, task);
    }

    public static void ShowHealth(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        Objective objectiveName = scoreboard.getObjective("HealthName");
        // 获取玩家计分板分数
        Score scoreName = objectiveName.getScore(player.getName());

        BukkitRunnable actionBarRunnable = actionBarRunnables.get(player.getName());
        if (actionBarRunnable != null) {
            actionBarRunnable.cancel();
        }

        actionBarRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                String message = "§c§l❤ " + scoreName.getScore();
                player.sendActionBar(message);
            }
        };
        actionBarRunnable.runTaskTimer(MoonFish.getPlugin(MoonFish.class), 0L, 10L);
        actionBarRunnables.put(player.getName(), actionBarRunnable);
    }
}
