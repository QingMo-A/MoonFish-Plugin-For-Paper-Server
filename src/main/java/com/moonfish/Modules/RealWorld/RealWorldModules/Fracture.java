package com.moonfish.Modules.RealWorld.RealWorldModules;

import com.moonfish.Main.Utils.MessageUtil;
import com.moonfish.MoonFish;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.FractureConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.EffectUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class Fracture {
    private static final HashMap<Player, BukkitTask> tasks = new HashMap<>(); // 存储玩家和他们的定时器任务
    public static void FractureModule(EntityDamageEvent event, Player player) {
        //检查当玩家受到摔落伤害且玩家此时没有缓慢药水效果
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL && !(tasks.containsKey(player))) {
            //event.setCancelled(true); // 取消摔落伤害
            EffectUtils.GiveEffect(FractureConfig.getFractureEffect(), player);
            String FractureIndicate = FractureConfig.getFractureIndicateTemp().replace("%player", player.getName()).replace('&', '§');
            MessageUtil.SystemMessage(FractureIndicate);
            if (FractureConfig.getFractureTriggerInterval() != null) {
                // 创建新的定时器任务
                BukkitTask task = Bukkit.getScheduler().runTaskLater(MoonFish.getPlugin(MoonFish.class), new Runnable() {
                    @Override
                    public void run() {
                        tasks.remove(player);
                    }
                }, Long.parseLong(FractureConfig.getFractureTriggerInterval()));
                tasks.put(player, task);
            }
        }
    }
}
