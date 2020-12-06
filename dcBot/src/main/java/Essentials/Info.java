package Essentials;

import Main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Arrays;

public class Info extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getAuthor().isBot()){
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "info")) {
            e.getChannel().sendMessage(createEmbed()).queue();
        }
    }

    private MessageEmbed createEmbed() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Info on Lux's Bot:");
        embedBuilder.setThumbnail("https://cdn.discordapp.com/app-icons/781958118581338123/b015d723e653b9533754b4cb1363221b.png");
        embedBuilder.setDescription("\uD83C\uDF38<:sakura:784489394328830014>\uD83C\uDF38<:sakura:784489394328830014>\uD83C\uDF38<:sakura:784489394328830014>" + "\n \n" + "`Creator`:" + " <@684629625313558557>" + "\n" + "\n" +
                                    "`Version`:" + " **2.0.3**" + "\n" + "\n" +
                                    "`Code`:" + " **[found here](https://github.com/lux1a/discordbot/)**");
        embedBuilder.setColor(Color.decode("#3265fe"));
        return embedBuilder.build();
    }

}
