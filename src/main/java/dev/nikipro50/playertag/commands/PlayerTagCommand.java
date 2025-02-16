package dev.nikipro50.playertag.commands;

import dev.nikipro50.playertag.PlayerTag;
import dev.nikipro50.playertag.config.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PlayerTagCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("playertag.admin")) {
            sender.sendMessage(ConfigManager.MESSAGES_NO_PERMS.getFormattedString());
            return true;
        }
        if (args[0].equalsIgnoreCase("help")) {
            ConfigManager.MESSAGES_HELP.getList().forEach(sender::sendMessage);
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            long start = System.currentTimeMillis();
            PlayerTag.getInstance().saveConfig();
            PlayerTag.getInstance().reloadConfig();
            sender.sendMessage(ConfigManager.MESSAGES_CONFIG_RELOADED.getFormattedString().replace("%ms%", String.valueOf(Math.abs(start - System.currentTimeMillis()))));
            return true;
        }
        ConfigManager.MESSAGES_HELP.getList().forEach(sender::sendMessage);
        return false;
    }
}
