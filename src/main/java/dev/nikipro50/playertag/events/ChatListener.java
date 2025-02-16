package dev.nikipro50.playertag.events;

import dev.nikipro50.playertag.config.ConfigManager;
import dev.nikipro50.playertag.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (ConfigManager.OPTIONS_PERMISSION_REQUIRED.getBoolean() && !event.getPlayer().hasPermission(ConfigManager.OPTIONS_PERMISSION_PERM.getString()))
            return;
        Bukkit.getOnlinePlayers().forEach(target -> {
            if (!event.getMessage().contains(target.getName())) return;
            event.setMessage(StringUtils.hex(event.getMessage().replaceAll(target.getName(), ConfigManager.FORMAT.getFormattedString()).replace("%player%", target.getName())));
            if (!ConfigManager.OPTIONS_SOUND_ENABLED.getBoolean()) return;
            Location location = target.getLocation();
            if (ConfigManager.OPTIONS_SOUND_TYPE.getString().equals("PIANO")) {
                target.playNote(location, Instrument.PIANO, Note.natural(1, Note.Tone.A));
                return;
            }
            target.playSound(location, Sound.valueOf(ConfigManager.OPTIONS_SOUND_TYPE.getString()), 1F, 1F);
        });
    }
}
