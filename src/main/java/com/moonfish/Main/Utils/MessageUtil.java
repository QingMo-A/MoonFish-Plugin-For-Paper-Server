package com.moonfish.Main.Utils;

import static org.bukkit.Bukkit.*;

public class MessageUtil {
    private static final String ServerSayer = "§c[§r系统§c]§r ";
    public static final String DebugSayer = "§c[§r调试系统§c]§r ";
    public static void SystemMessage(String message) {
        getServer().broadcastMessage(ServerSayer + message);
    }

    public static void DebugMessage(String message) {
        getServer().broadcastMessage(DebugSayer + message);

    }
}
