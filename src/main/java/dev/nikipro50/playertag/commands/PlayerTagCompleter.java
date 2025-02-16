package dev.nikipro50.playertag.commands;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;

public class PlayerTagCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("playertag.admin")) Lists.newArrayList();
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        if (args.length == 1) {
            if ("help".startsWith(args[0].toLowerCase(Locale.ROOT)))
                builder.add("build");
            if("reload".startsWith(args[0].toLowerCase(Locale.ROOT)))
                builder.add("reload");
        }
        return builder.build();
    }
}
