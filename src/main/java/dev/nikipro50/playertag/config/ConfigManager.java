package dev.nikipro50.playertag.config;

import com.google.common.collect.Lists;
import dev.nikipro50.playertag.PlayerTag;
import dev.nikipro50.playertag.utils.StringUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public enum ConfigManager {
    FORMAT("Format"),
    MESSAGES_NO_PERMS("Messages.NoPerms"),
    MESSAGES_CONFIG_RELOADED("Messages.ConfigReloaded"),
    MESSAGES_HELP("Messages.Help"),
    OPTIONS_PERMISSION_REQUIRED("Options.Permission.Required"),
    OPTIONS_PERMISSION_PERM("Options.Permission.Permission"),
    OPTIONS_SOUND_ENABLED("Options.Sound.Enabled"),
    OPTIONS_SOUND_TYPE("Options.Sound.Type");

    private final String path;

    public String getString() {
        return PlayerTag.getInstance().getConfig().getString(this.path);
    }

    public String getFormattedString() {
        return StringUtils.hex(PlayerTag.getInstance().getConfig().getString(this.path));
    }

    public boolean getBoolean() {
        return PlayerTag.getInstance().getConfig().getBoolean(this.path);
    }

    public List<String> getList() {
        List<String> formatted = Lists.newArrayList();
        PlayerTag.getInstance().getConfig().getStringList(this.path).forEach(s -> formatted.add(StringUtils.hex(s)));
        return formatted;
    }
}
