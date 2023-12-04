package com.moonfish.Modules.Skill;

import com.moonfish.Modules.Skill.SkillModules.*;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;

public class Skill implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (MiningSkill.isMineral(block.getType())) {
            MiningSkill.addMiningSkillEXP(player, 5);
        } else if (FarmingSkill.isCrop(block.getType())) {
            FarmingSkill.addFarmingSkillEXP(player, 5);
        } else if (ForagingSkill.isWood(block.getType())) {
            ForagingSkill.addForagingSkillEXP(player, 5);
        }
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();

        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            FishingSkill.addFishingSkillEXP(player, 5);
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();

        if (killer != null && event.getEntity() instanceof LivingEntity) {
            CombatSkill.addCombatSkillEXP(killer, 5);
        }
    }
}
