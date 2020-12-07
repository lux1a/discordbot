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

    private MessageEmbed createEmbed(MessageReceivedEvent e) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        Object[] userArray = e.getMessage().getMentionedUsers().toArray();
        User firstMention = (User) userArray[0];
        firstMention.getName();
        embedBuilder.setTitle(firstMention.getName().replace(firstMention.getName().charAt(0), firstMention.getName().toUpperCase().charAt(0))+ ":");
        embedBuilder.setThumbnail(firstMention.getAvatarUrl());
        embedBuilder.setDescription("**Account created: ** " + "`" + firstMention.getTimeCreated().getDayOfMonth() + "." + firstMention.getTimeCreated().getMonthValue() + "." + firstMention.getTimeCreated().getYear() + "`" + "\n"
                + "**ID:** " + "`" + firstMention.getId() + "`" + "\n" +"**Discriminator: ** " + "`" + firstMention.getDiscriminator() + "`" + "\n" +
                "**Bot?: ** " + "`" + firstMention.isBot() + "`");
        embedBuilder.setColor(Color.decode("#db273a"));
        embedBuilder.setFooter("Query by: " + e.getAuthor().getName().replace(e.getAuthor().getName().charAt(0), e.getAuthor().getName().toUpperCase().charAt(0)), e.getAuthor().getAvatarUrl());
        return embedBuilder.build();
    }
}
