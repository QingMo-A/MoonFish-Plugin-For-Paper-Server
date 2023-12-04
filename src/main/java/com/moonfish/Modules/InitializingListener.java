package com.moonfish.Modules;

import com.moonfish.BetaModules.Attributes.PlayerAttributes.Utils.PlayerAttributesUtil;
import com.moonfish.Modules.Rank.RankUtils.RankUtil;
import com.moonfish.Modules.Skill.SkillUtils.SkillUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class InitializingListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        SkillUtil.CreatePlayerSkillData(event.getPlayer());
        RankUtil.CreatePlayerRankData(event.getPlayer());
        PlayerAttributesUtil.CreatePlayerAttributesData(event.getPlayer());
    }
}
