package com.moonfish.Modules.RealWorld.RealWorldModules;

import com.moonfish.Main.Utils.MessageUtil;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.StumbleConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.EffectUtils;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Stumble {
    private static final Random random = new Random();
    public static void StumbleModule(PlayerMoveEvent event, Player player) {
        // 检查玩家是否在奔跑 没有缓慢效果 模式为生存 在地上
        if (player.isSprinting() && player.getGameMode() == GameMode.SURVIVAL && player.isOnGround() && !player.hasPotionEffect(PotionEffectType.SLOW)) {
            // 根据伤害概率给予瞬间伤害效果
            if (random.nextInt(Integer.parseInt(StumbleConfig.getStumbleProbability())) + 1 == 1) {
                //player.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 0));
                double newHealth = Math.max(player.getHealth() - Double.parseDouble(StumbleConfig.getStumbleDamage()), 0.0); // 计算扣除血量后的值，并确保不会低于0
                EffectUtils.GiveEffect(StumbleConfig.getStumbleEffect(), player);
                player.setHealth(newHealth);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 1, 1);
                String StumbleIndicate = StumbleConfig.getStumbleIndicateTemp().replace("%player", player.getName()).replace('&', '§');
                MessageUtil.SystemMessage(StumbleIndicate);
            }
        }
    }
}
