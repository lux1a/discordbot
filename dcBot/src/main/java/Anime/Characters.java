package Anime;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.Random;

public class Characters {

    public static void kurumi(MessageReceivedEvent e) {
        kurumiText(e, 115, "", ".jpg");
    }

    public static void kurumigif(MessageReceivedEvent e) {
        kurumiText(e, 33,"gif/", ".gif");
    }

    public static void zerotwo(MessageReceivedEvent e) {
        zerotwoText(e, 60,"", ".jpg");
    }

    public static void zerotwogif(MessageReceivedEvent e) {
        zerotwoText(e, 22,"gif/", ".gif");
    }

    public static void kurumiText(MessageReceivedEvent e, int end, String subfolder, String suffix) {
        Random r = new Random();
        int result = r.nextInt(end-1) + 1;
        e.getChannel().sendMessage("https://cdn.luxia.ch/Kurumi/" + subfolder + result + suffix).queue();
    }

    public static void zerotwoText(MessageReceivedEvent e, int end, String subfolder, String suffix) {
        Random r = new Random();
        int result = r.nextInt(end-1) + 1;
        e.getChannel().sendMessage("https://cdn.luxia.ch/ZeroTwo/" + subfolder + result + suffix).queue();
    }
}
