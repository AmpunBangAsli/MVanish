package mvanish.mvanish;

import mvanish.mvanish.AllEvent.onOpeningChest;
import mvanish.mvanish.AllEvent.onStepingFarmLand;
import mvanish.mvanish.Command.About;
import mvanish.mvanish.Command.MainCommand;
import mvanish.mvanish.Command.UtilCommand;
import mvanish.mvanish.TabComplete.TabComplete;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {
    public List<String> invisible;
    FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        invisible = getConfig().getStringList("vanished");
        config.addDefault("prefix", "&e&lVANISH &2/ &6");
        config.addDefault("actionbar", "&7> &e&lVANISHED&7 <");
        this.getCommand("vanish").setExecutor(new MainCommand(this));
        this.getCommand("vanishother").setExecutor(new MainCommand(this));
        this.getCommand("vanish-reload").setExecutor(new UtilCommand(this));
        this.getCommand("vanish-about").setExecutor(new About(this));
        this.getCommand("unvanish").setExecutor(new MainCommand(this));
        this.getCommand("vanish").setTabCompleter(new TabComplete());
        this.getServer().getPluginManager().registerEvents(new MainCommand(this), this);
        config.options().copyDefaults(true);
        saveConfig();
        getServer().getPluginManager().registerEvents(new onStepingFarmLand(), this);
        getServer().getPluginManager().registerEvents(new onOpeningChest(this), this);
    }

    @Override
    public void onDisable() {
        getConfig().set("vanished", invisible);
        saveConfig();
    }
}
