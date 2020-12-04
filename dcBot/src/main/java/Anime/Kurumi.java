package Anime;

import Main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

public class Kurumi extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "kurumi")) {
            kurumiText(e, 115, "", ".jpg");
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "kurumigif")) {
            kurumiText(e, 33,"gif/", ".gif");
        }
    }

    private void kurumiText(MessageReceivedEvent e, int end, String subfolder, String suffix) {
        Random r = new Random();
        int result = r.nextInt(end-1) + 1;
        e.getChannel().sendMessage("https://luxia.ch/Kurumi/" + subfolder + result + suffix).queue();
    }
}
