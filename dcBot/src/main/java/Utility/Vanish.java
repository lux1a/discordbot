package Utility;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.concurrent.TimeUnit;

public class Vanish {

    public static void vanish(MessageReceivedEvent e) {
        String[] tokens = e.getMessage().getContentRaw().split(" ");
            if(e.getMessage().getContentRaw().length() < 8) {
                e.getChannel().sendMessage("Correct usage of this command: `_vanish` `5` `text`").queue();
            } else if (isInt(tokens[1])) {
                int value = Integer.parseInt(tokens[1]);
                e.getMessage().delete().queueAfter(value, TimeUnit.SECONDS);
            } else {
                e.getMessage().delete().queueAfter(2, TimeUnit.SECONDS);
            }
    }

    public static boolean isInt(String s)
    {
        try {
            int i = Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException er) {
            return false;
        }
    }
}
