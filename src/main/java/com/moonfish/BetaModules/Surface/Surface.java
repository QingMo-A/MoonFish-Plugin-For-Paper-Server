package com.moonfish.BetaModules.Surface;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;

public class Surface implements Listener {
    private Location center = new Location(Bukkit.getWorld("world"), 0, 0, 0); // 中心点
    private int radius = 150; // 范围半径
    private Map<Player, Boolean> hasEntered = new HashMap<>(); // 用于储存玩家是否已经进入该区域

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (hasEntered.get(player) == null || !hasEntered.get(player)) { // 玩家还没进入过该区域
            if (center.distance(player.getLocation()) <= radius) { // 玩家进入了该区域
                hasEntered.put(player, true); // 标记该玩家已经进入过该区域

                //double distance = center.distance(player.getLocation());
                //System.out.println("The distance between player and center is " + distance);
                System.out.println("Center coordinate: " + center.getX() + ", " + center.getY() + ", " + center.getZ());
                System.out.println("Player coordinate: " + player.getLocation().getX() + ", " + player.getLocation().getY() + ", " + player.getLocation().getZ());
                System.out.println("Distance between player and center: " + center.distance(player.getLocation()));

                // 在边缘生成绿色粒子
                for (double i = 0; i < Math.PI * 2; i += Math.PI / 12) {
                    double x = center.getX() + radius * Math.cos(i);
                    double z = center.getZ() + radius * Math.sin(i);
                    Location loc = new Location(player.getWorld(), x, center.getY(), z);
                    player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc, 1, 0, 0, 0, 1);
                }

                player.sendTitle("主城", null, 10, 70, 20);
                player.sendMessage("欢迎来到主城," + player.getName());
            }
        } else { // 玩家已经进入过该区域
            if (center.distance(player.getLocation()) > radius) { // 玩家离开了该区域
                hasEntered.put(player, false); // 标记该玩家还没进入过该区域
                player.sendMessage("你离开了主城,欢迎下次再来!");
            }
        }
    }

}
