package Utility;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import Main.Main;

public class Pong extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "ping")) {
            e.getChannel().sendMessage("pong!").queue();
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "pong")) {
            e.getChannel().sendMessage("ping!").queue();
        }
    }
}