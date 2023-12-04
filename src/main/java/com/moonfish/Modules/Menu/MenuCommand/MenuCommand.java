package com.moonfish.Modules.Menu.MenuCommand;

import com.moonfish.Modules.Menu.MenuPanel.MenuPanel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("Menu")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                MenuPanel.OpenMenu(player);
            }
            return true;
        }
        return false;
    }
}
