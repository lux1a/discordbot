package Utility;

import Main.Main;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Channel extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e) {
        MessageChannel channel = e.getChannel();
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "channel")) {
            e.getChannel().sendMessage("Current Channel: " + "`" + channel + "`").queue();
        }
    }
}
