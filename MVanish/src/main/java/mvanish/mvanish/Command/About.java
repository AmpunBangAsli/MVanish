package mvanish.mvanish.Command;

import mvanish.mvanish.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.text.DecimalFormat;

public class About implements CommandExecutor {

    Main plugin;

    public About(Main plugin){
        this.plugin = plugin;
    }
    




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("vanish-about")) {
                    sender.sendMessage("§7|===========================================|");
                    sender.sendMessage("§e§o" + plugin.getDescription().getName() + " " + plugin.getDescription().getVersion());
                    sender.sendMessage("");
                    sender.sendMessage("§6API Version: §e" + plugin.getDescription().getAPIVersion());
                    sender.sendMessage("§6API: §e" + plugin.getDescription().getSoftDepend());
                    sender.sendMessage("");
                    sender.sendMessage("§6Description: ");
                    sender.sendMessage("§eVanish plugin for AmpunNetwork!, Designed by AmpunBang_!");
                    sender.sendMessage("");
                    sender.sendMessage("§7|===========================================|");
        }
        return true;
    }
}
