package com.moonfish.Modules.RealWorld.RealWorldModules;

import com.moonfish.Main.Utils.MessageUtil;
import com.moonfish.MoonFish;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.NecropsyConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.EffectUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class Necropsy {
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    public static void NecropsyModule(EntityDamageByEntityEvent event, Player player) {
        //检测攻击的生物
        if (event.getDamager() instanceof Zombie || event.getDamager() instanceof ZombieVillager || event.getDamager() instanceof Drowned || event.getDamager() instanceof Husk) {
            //当玩家没有中毒效果的时候
            if (!(tasks.containsKey(player))) {
                EffectUtils.GiveEffect(NecropsyConfig.getNecropsyEffect(), player);
                String NecropsyIndicate = NecropsyConfig.getNecropsyIndicateTemp().replace("%player", player.getName()).replace('&', '§');
                MessageUtil.SystemMessage(NecropsyIndicate);
                if (NecropsyConfig.getNecropsyTriggerInterval() != null) {
                    // 创建新的定时器任务
                    BukkitTask task = Bukkit.getScheduler().runTaskLater(MoonFish.getPlugin(MoonFish.class), new Runnable() {
                        @Override
                        public void run() {
                            tasks.remove(player);
                        }
                    }, Long.parseLong(NecropsyConfig.getNecropsyTriggerInterval()));
                    tasks.put(player, task);
                }
            }
        }
    }
}
