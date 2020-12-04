package Utility;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.concurrent.TimeUnit;
import Main.Main;

public class Vanish extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getAuthor().isBot()){
        } else if (e.getMessage().getContentRaw().startsWith(Main.prefix + "vanish")) {
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
    }

    static boolean isInt(String s)
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
