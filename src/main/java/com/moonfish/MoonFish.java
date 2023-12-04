package com.moonfish;

import com.moonfish.Item.FUNCTIONALSUPPLY.MenuClock.Command.MenuClockCommand;
import com.moonfish.Item.FUNCTIONALSUPPLY.MenuClock.Listener.MenuClockListener;
import com.moonfish.Item.FUNCTIONALSUPPLY.SpecialPaper.SpecialPaper;
import com.moonfish.Item.SWORD.VampireSword.Listener.VampireSwordListener;
import com.moonfish.Item.SWORD.VampireSword.VampireSword;
import com.moonfish.Main.Initialize.Initialize;
import com.moonfish.Modules.InitializingListener;
import com.moonfish.Modules.Menu.MenuCommand.MenuCommand;
import com.moonfish.Modules.Menu.MenuListener.MenuListener;
import com.moonfish.Modules.Menu.Modules.SkillMenu.Listener.SkillMenuListener;
import com.moonfish.Modules.Menu.Modules.TeleportationMenu.Listener.TeleportationMenuListener;
import com.moonfish.Modules.RealWorld.RealWorld;
import com.moonfish.Modules.ReloadCommand.ReloadCommand;
import com.moonfish.Modules.Skill.Skill;
import com.moonfish.BetaModules.Surface.Surface;
import com.moonfish.Modules.WelcomeMessage.WelcomeMessage;
import com.moonfish.System.HealthSystem.Listener.HealthSystemListener;
import com.moonfish.System.ProficiencySystem.Listener.ProficiencySystemListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoonFish extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("MoonFish插件已加载 作者: QingMo");

        Initialize.CreateFile();
        getServer().getPluginManager().registerEvents(new WelcomeMessage(), this);
        getServer().getPluginManager().registerEvents(new InitializingListener(), this);
        getServer().getPluginManager().registerEvents(new RealWorld(), this);
        getServer().getPluginManager().registerEvents(new Skill(), this);
        getCommand("ReloadMoonFish").setExecutor(new ReloadCommand());

        // 创建一个自定义物品并添加到服务器的合成表中
        SpecialPaper specialPaper = new SpecialPaper();
        getServer().addRecipe(specialPaper.getRecipe());

        VampireSword vampireSword = new VampireSword();
        getServer().addRecipe(vampireSword.getRecipe());
        getServer().getPluginManager().registerEvents(new VampireSwordListener(), this);

        getCommand("Menu").setExecutor(new MenuCommand());
        getCommand("Clock").setExecutor(new MenuClockCommand());
        getServer().getPluginManager().registerEvents(new MenuClockListener(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new SkillMenuListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportationMenuListener(), this);

        getServer().getPluginManager().registerEvents(new Surface(), this);
        getServer().getPluginManager().registerEvents(new HealthSystemListener(), this);
        //getServer().getPluginManager().registerEvents(new ProficiencySystemListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.resetRecipes();
        getLogger().info("MoonFish插件已卸载 作者: QingMo");
    }
}
