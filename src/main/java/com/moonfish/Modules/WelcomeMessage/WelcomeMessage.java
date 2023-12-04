package com.moonfish.Modules.WelcomeMessage;

import com.moonfish.Main.Initialize.Config.InitializeConfig;
import com.moonfish.Modules.Rank.RankConfig.RankConfig;
import com.moonfish.Modules.WelcomeMessage.WelcomeMessageConfig.WelcomeMessageConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WelcomeMessage implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //如果欢迎语功能开启
        if (WelcomeMessageConfig.getEnableStatus().equals(InitializeConfig.Status)) {
            //如果OP欢迎语功能开启
            if (WelcomeMessageConfig.getOPEnableStatus().equals(InitializeConfig.Status)) {
                //如果玩家不是OP
                if (!(event.getPlayer().isOp())) {
                    //如果玩家Rank为1
                    if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel1)) {
                        //获取欢迎语
                        String JoinMessage = WelcomeMessageConfig.getJoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                        //发送
                        event.setJoinMessage(JoinMessage);
                    } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel2)) {
                        //获取欢迎语
                        String RankLevel2JoinMessage = RankConfig.getRankLevel2JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                        //发送
                        event.setJoinMessage(RankLevel2JoinMessage);
                    } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel3)) {
                        //获取欢迎语
                        String RankLevel3JoinMessage = RankConfig.getRankLevel3JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                        //发送
                        event.setJoinMessage(RankLevel3JoinMessage);
                    } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel4)) {
                        //获取欢迎语
                        String RankLevel4JoinMessage = RankConfig.getRankLevel4JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                        //发送
                        event.setJoinMessage(RankLevel4JoinMessage);
                    } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel5)) {
                        //获取欢迎语
                        String RankLevel5JoinMessage = RankConfig.getRankLevel5JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                        //发送
                        event.setJoinMessage(RankLevel5JoinMessage);
                    }
                    //如果玩家是OP
                } else if (event.getPlayer().isOp()){
                    //获取欢迎语
                    String OPJoinMessage = WelcomeMessageConfig.getOPJoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //发送
                    event.setJoinMessage(OPJoinMessage);
                }
                //如果OP欢迎语没开
            } else {
                if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel1)) {
                    //获取欢迎语
                    String JoinMessage = WelcomeMessageConfig.getJoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //发送
                    event.setJoinMessage(JoinMessage);
                } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel2)) {
                    //获取欢迎语
                    String RankLevel2JoinMessage = RankConfig.getRankLevel2JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //发送
                    event.setJoinMessage(RankLevel2JoinMessage);
                } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel3)) {
                    //获取欢迎语
                    String RankLevel3JoinMessage = RankConfig.getRankLevel3JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //发送
                    event.setJoinMessage(RankLevel3JoinMessage);
                } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel4)) {
                    //获取欢迎语
                    String RankLevel4JoinMessage = RankConfig.getRankLevel4JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //发送
                    event.setJoinMessage(RankLevel4JoinMessage);
                } else if (RankConfig.getPlayerRank(event.getPlayer()).equals(RankConfig.RankLevel5)) {
                    //获取欢迎语
                    String RankLevel5JoinMessage = RankConfig.getRankLevel5JoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //发送
                    event.setJoinMessage(RankLevel5JoinMessage);
                }
            }
            //如果只有OP欢迎语开了
        } else if (WelcomeMessageConfig.getOPEnableStatus().equals(InitializeConfig.Status)) {
            //当玩家是OP
            if (event.getPlayer().isOp()) {
                //获取欢迎语
                String OPJoinMessage = WelcomeMessageConfig.getOPJoinMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                //发送
                event.setJoinMessage(OPJoinMessage);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (WelcomeMessageConfig.getEnableStatus().equals(InitializeConfig.Status)) {
            if (WelcomeMessageConfig.getOPEnableStatus().equals(InitializeConfig.Status)) {
                if (!(event.getPlayer().isOp())) {
                    //获取送别语
                    String QuitMessage = WelcomeMessageConfig.getQuitMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //欢迎
                    event.setQuitMessage(QuitMessage);
                } else if (event.getPlayer().isOp()){
                    //获取送别语
                    String OPQuitMessage = WelcomeMessageConfig.getOPQuitMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                    //欢迎
                    event.setQuitMessage(OPQuitMessage);
                }
            } else {
                //获取送别语
                String QuitMessage = WelcomeMessageConfig.getQuitMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
                //欢迎
                event.setQuitMessage(QuitMessage);
            }
        } else if (WelcomeMessageConfig.getOPEnableStatus().equals(InitializeConfig.Status)) {
            //获取送别语
            String OPQuitMessage = WelcomeMessageConfig.getOPQuitMessageTemp().replace("%player", event.getPlayer().getName()).replace('&', '§');
            //欢迎
            event.setQuitMessage(OPQuitMessage);
        }
    }


}
