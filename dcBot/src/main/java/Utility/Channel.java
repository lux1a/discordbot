package Utility;

import Main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Channel extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent e) {
        MessageChannel channel = e.getChannel();
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "channel")) {
            e.getChannel().sendMessage("Current Channel: " + "`" + channel + "`").queue();
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "user")) {
            e.getChannel().sendMessage("Please mention a user.").queue();
        } else if (e.getMessage().getContentRaw().startsWith(Main.prefix + "user") && e.getMessage().getContentRaw().contains("@")) {
            e.getChannel().sendMessage(createEmbed(e)).queue();

        }
    }
}
