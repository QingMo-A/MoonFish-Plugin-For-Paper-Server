package com.moonfish.Item.FUNCTIONALSUPPLY.MenuClock.Command;

import com.moonfish.Item.FUNCTIONALSUPPLY.MenuClock.MenuClock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MenuClockCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // 检查命令执行者是否为玩家
        if (command.getName().equalsIgnoreCase("Clock")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                // 给玩家添加物品
                MenuClock clock = new MenuClock();
                player.getInventory().addItem(clock.getItem());

                return true;
            }
        }
        return false;
    }
}
