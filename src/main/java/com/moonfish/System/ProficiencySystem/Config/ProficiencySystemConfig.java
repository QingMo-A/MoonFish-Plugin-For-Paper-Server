package com.moonfish.System.ProficiencySystem.Config;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Config.PlayerAttributesConfig;
import com.moonfish.Main.Utils.MessageUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ProficiencySystemConfig {
    private static final Random random = new Random();
    public static void ModifyDropRate(BlockBreakEvent event, String value, Material target, Material i) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        //判断是否能被100整除
        int one = Integer.parseInt(value) % 100;
        //将获取的值除以100
        int two = Integer.parseInt(value) / 100;
        //获取值
        int three = Integer.parseInt(value);

        MessageUtil.DebugMessage(one + "  " + two + "  " + three);

        if (block.getType() == target) {
            // 获取掉落物列表
            for (ItemStack drop : block.getDrops()) {
                // 如果掉落物为煤炭，则将数量翻倍
                if (drop.getType() == i) {
                    if (one == 0) {
                        drop.setAmount(drop.getAmount() * two + 1);
                        MessageUtil.DebugMessage("12432");
                    } else if (one != 0) {
                        // 生成 0~99 之间的整数
                        int r = random.nextInt(100) + 1;

                        if (r <= three) {
                            MessageUtil.DebugMessage("1111111111111111111");
                            drop.setAmount(drop.getAmount() * two + 1);
                        } else {
                            MessageUtil.DebugMessage("22222222222222");
                            drop.setAmount(drop.getAmount() * two + 2);
                        }
                    }
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
