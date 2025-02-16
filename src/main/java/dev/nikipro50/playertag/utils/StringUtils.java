package dev.nikipro50.playertag.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String hex(String message) {
        Pattern patter = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = patter.matcher(message);
        while (matcher.find()) {
            String hexCode = message.substring(matcher.start(), matcher.end());
            String replaceSharp = hexCode.replace('#', 'x');
            char[] ch = replaceSharp.toCharArray();
            StringBuilder builder = new StringBuilder("");
            for (char c : ch) builder.append("&" + c);
            message = message.replace(hexCode, builder.toString());
            matcher = patter.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message).replace("&", "§");
    }
}
