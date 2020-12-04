package Essentials;

import Main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;
import java.util.Arrays;

public class Help extends ListenerAdapter {

    private String[] wrongSpelling = {"hlep", "hepl", "ehlp", "elhp", "ehpl", "hpel"};

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getAuthor().isBot()){
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "help")) {
            e.getChannel().sendMessage(createEmbed()).queue();
            e.getChannel().sendMessage("https://media1.tenor.com/images/7a5b344c3b2f2259535ea83efc2597b4/tenor.gif").queue();
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            sendText(e);
        }
    }

    private MessageEmbed createEmbed() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Available Commands:");
        embedBuilder.setDescription("" + "```ARM\n" + "_neko: Catgirl Image\n" + "```" + "```ARM\n" + "_waifu: Waifu Image\n" + "```" + "```ARM\n" +
         "_kitsune: Foxgirl Image\n" + "```" + "```ARM\n" + "_ping: pong!\n" + "```" + "```ARM\n" + "_vanish: Message vanishes after one second\n" +
          "```" + "```ARM\n" + "_bee: Bee Movie Script (works once every 50min)\n" + "```" + "```ARM\n" + "_help: this message\n" + "```" + "```ARM\n" + "_kurumi: Kurumi Picture\n" + "```" + "```ARM\n" + "_kurumigif: Kurumi Gif)\n" + "```"
        + "```ARM\n" + "_crypto: Price Data for any cryptocurrency\n" + "```");
        embedBuilder.setAuthor("Luxia's Bot", "https://bit.ly/3fKaDDv", "https://cdn.discordapp.com/avatars/684629625313558557/1705ee73c703b8b3343a29acd24973b3.png");
        embedBuilder.setColor(Color.decode("#db273a"));
        return embedBuilder.build();
    }

    private void sendText(MessageReceivedEvent e) {
        e.getChannel().sendMessage("Did you mean ***help***?").queue();
        e.getChannel().sendMessage(createEmbed()).queue();
        e.getChannel().sendMessage("https://media1.tenor.com/images/7a5b344c3b2f2259535ea83efc2597b4/tenor.gif").queue();
    }
}