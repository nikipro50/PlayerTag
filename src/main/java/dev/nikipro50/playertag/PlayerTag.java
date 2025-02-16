package dev.nikipro50.playertag;

import dev.nikipro50.playertag.commands.PlayerTagCommand;
import dev.nikipro50.playertag.commands.PlayerTagCompleter;
import dev.nikipro50.playertag.events.ChatListener;
import dev.nikipro50.playertag.utils.StringUtils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerTag extends JavaPlugin {
    @Getter
    private static PlayerTag instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginCommand("playertag").setExecutor(new PlayerTagCommand());
        Bukkit.getPluginCommand("playertag").setTabCompleter(new PlayerTagCompleter());
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l _____  _                    _______          "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l |  __ \\| |                  |__   __|         "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l | |__) | | __ _ _   _  ___ _ __| | __ _  __ _ "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l |  ___/| |/ _` | | | |/ _ \\ '__| |/ _` |/ _` | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l | |    | | (_| | |_| |  __/ |  | | (_| | (_| | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l |_|    |_|\\__,_|\\__, |\\___|_|  |_|\\__,_|\\__, | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l                  __/ |                   __/ | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l                 |___/                   |___/  "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex(""));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex(String.format("&#E37F00[PlayerTag]&f Plugin &a&nenabled&f. Running in version &#E37F00&n%s&f...", getDescription().getVersion())));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex(""));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l _____  _                    _______          "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l |  __ \\| |                  |__   __|         "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l | |__) | | __ _ _   _  ___ _ __| | __ _  __ _ "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l |  ___/| |/ _` | | | |/ _ \\ '__| |/ _` |/ _` | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l | |    | | (_| | |_| |  __/ |  | | (_| | (_| | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l |_|    |_|\\__,_|\\__, |\\___|_|  |_|\\__,_|\\__, | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l                  __/ |                   __/ | "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00&l                 |___/                   |___/  "));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex(""));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex("&#E37F00[PlayerTag]&f Plugin &c&ndisabled&f."));
        Bukkit.getConsoleSender().sendMessage(StringUtils.hex(""));
    }
}
