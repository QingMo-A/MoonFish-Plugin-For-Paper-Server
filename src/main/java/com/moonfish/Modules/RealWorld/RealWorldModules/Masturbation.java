package com.moonfish.Modules.RealWorld.RealWorldModules;

import com.moonfish.Item.FUNCTIONALSUPPLY.SpecialPaper.Config.SpecialPaperConfig;
import com.moonfish.Main.Utils.MessageUtil;
import com.moonfish.Modules.RealWorld.RealWorldModules.Config.MasturbationConfig;
import com.moonfish.Modules.RealWorld.RealWorldUtils.EffectUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Masturbation {
    private static final Random random = new Random();
    public static void MasturbationModule(PlayerInteractEntityEvent event, Player player, ItemStack itemInHand) {
        // 检测是否拿着特制的纸
        if (SpecialPaperConfig.isSpecialPaper(itemInHand)) {
            Entity rightClickedEntity = event.getRightClicked();
            // 检测是否右键生物
            if (rightClickedEntity instanceof org.bukkit.entity.LivingEntity) {
                //检测玩家是否有虚弱
                if (!player.hasPotionEffect(PotionEffectType.WEAKNESS)) {
                    itemInHand.setAmount(itemInHand.getAmount() - 1);
                    EffectUtils.GiveEffect(MasturbationConfig.getMasturbationEffect(), player);
                    String MasturbationIndicate = MasturbationConfig.getMasturbationIndicateTemp().replace("%player", player.getName()).replace('&', '§').replace("%t", random.nextInt(Integer.parseInt(MasturbationConfig.getMasturbationTimeRange())) + 1 + "").replace("%e", event.getRightClicked().getName() + "");
                    MessageUtil.SystemMessage(MasturbationIndicate);
                } else if (player.hasPotionEffect(PotionEffectType.WEAKNESS)) {
                    String MasturbationFailIndicate = MasturbationConfig.getMasturbationFailIndicateTemp().replace("%player", player.getName()).replace('&', '§');
                    player.sendMessage(MasturbationFailIndicate);
                }
            }
        }
    }
}
