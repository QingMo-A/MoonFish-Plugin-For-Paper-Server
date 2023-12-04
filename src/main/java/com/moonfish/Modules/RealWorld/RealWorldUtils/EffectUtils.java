package com.moonfish.Modules.RealWorld.RealWorldUtils;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectUtils {
    public static void GiveEffect(String EffectConfig, Player player) {
        if (EffectConfig != null) {
            String[] effects = EffectConfig.split(", "); // 根据逗号和空格分割字符串
            for (String effect : effects) {
                String[] parts = effect.split("-"); // 根据短横线分割每个效果的名称、持续时间和等级
                if (parts.length < 3) {
                    // 如果分割出来的部分不足3个，则跳过该效果
                    continue;
                }
                PotionEffectType type = PotionEffectType.getByName(parts[0]); // 获取药水效果类型
                int duration = Integer.parseInt(parts[1]); // 获取持续时间
                int amplifier = Integer.parseInt(parts[2]); // 获取等级
                player.addPotionEffect(new PotionEffect(type, duration, amplifier)); // 应用效果到玩家身上
            }
        }
    }
}
