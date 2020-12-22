package Essentials;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.awt.*;

public class Info {

    public static void info(MessageReceivedEvent e) {
         e.getChannel().sendMessage(createEmbed()).queue();
    }

    public static MessageEmbed createEmbed() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Info on Lux's Bot:");
        embedBuilder.setThumbnail("https://cdn.discordapp.com/app-icons/781958118581338123/b015d723e653b9533754b4cb1363221b.png");
        embedBuilder.setDescription("\uD83C\uDF38<:sakura:784489394328830014>\uD83C\uDF38<:sakura:784489394328830014>\uD83C\uDF38<:sakura:784489394328830014>" + "\n \n" + "`Creator`:" + " <@684629625313558557>" + "\n" + "\n" +
                                    "`Version`:" + " **3.0.0**" + "\n" + "\n" +
                                    "`Code`:" + " **[found here](https://github.com/lux1a/discordbot/)**");
        embedBuilder.setColor(Color.decode("#3265fe"));
        return embedBuilder.build();
    }

}
