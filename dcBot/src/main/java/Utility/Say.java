package Utility;

import Main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.concurrent.TimeUnit;

public class Say {

    public static void say(MessageReceivedEvent e) {
        if (e.getAuthor().getId().equals(Main.ownerID)) {
            String[] tokens = e.getMessage().getContentRaw().split(" ");
            if(Vanish.isInt(tokens[1])) {
                int k = e.getMessage().getContentRaw().indexOf(" ",  e.getMessage().getContentRaw().indexOf(" ") + 1);
                for (int i = 0; i < Integer.parseInt(tokens[1]); i++) {
                    e.getChannel().sendMessage(e.getMessage().getContentRaw().substring(k)).queueAfter(1, TimeUnit.SECONDS);
                }
                deleteMessage(e);
            } else if (e.getAuthor().getId().equals(Main.ownerID)){
                e.getChannel().sendMessage( e.getMessage().getContentRaw().substring(5)).queue();
               deleteMessage(e);
            } else if (!e.getAuthor().getId().equals(Main.ownerID)) {
                e.getChannel().sendMessage("Only my owner can do this.").queue();
            }
        }
    }

    public static void deleteMessage (MessageReceivedEvent e) {
        long id = e.getChannel().getLatestMessageIdLong();
        e.getChannel().deleteMessageById(id).queue();
    }
}
