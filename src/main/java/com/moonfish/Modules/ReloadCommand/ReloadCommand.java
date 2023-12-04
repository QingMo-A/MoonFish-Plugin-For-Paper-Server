package com.moonfish.Modules.ReloadCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(label.equalsIgnoreCase("ReloadMoonFish")) {
            if (sender instanceof Player) {
                sender.sendMessage("该指令只允许在控制台使用");
                return true;
            }

            PluginManager pm = Bukkit.getServer().getPluginManager();
            Plugin plugin = pm.getPlugin("MoonFish");

            pm.disablePlugin(plugin);
            pm.enablePlugin(plugin);

        }
        return true;
    }
}
