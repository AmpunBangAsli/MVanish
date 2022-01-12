package mvanish.mvanish.Command;

import mvanish.mvanish.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UtilCommand implements CommandExecutor {
    public static Main plugin;

    public UtilCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("vanish-reload")){
            sender.sendMessage("Reloaded Config!");
            plugin.reloadConfig();
        }


        return true;
    }
}
