package com.moonfish.System.ProficiencySystem.Listener;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.System.ProficiencySystem.Config.ProficiencySystemConfig;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ProficiencySystemListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        /*if (block.getType() == Material.COAL_ORE) {
            ProficiencySystemConfig.ModifyDropRate(event, PlayerAttributesConfig.getPlayerMiningProficiency(player), Material.COAL_ORE, Material.COAL);
        }*/

        // 判断被破坏的方块是否为煤矿
        if (block.getType() == Material.COAL_ORE) {
            // 获取掉落物列表
            for (ItemStack drop : event.getBlock().getDrops()) {
                // 如果掉落物为煤炭，则将数量翻倍
                if (drop.getType() == Material.COAL) {
                    drop.setAmount(drop.getAmount() * 2);
                }
            }
            // 取消原有的煤炭掉落
            event.setDropItems(false);
            // 重新加入修改后的掉落物
            for (ItemStack drop : event.getBlock().getDrops()) {
                Item item = block.getWorld().dropItemNaturally(block.getLocation(), drop);
                item.setVelocity(item.getVelocity().multiply(0.5)); // 减缓掉落速度以防止重叠
            }
        }
    }
}
