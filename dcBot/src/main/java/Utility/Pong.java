package Utility;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Pong {

    public static void pong(MessageReceivedEvent e) {
        e.getChannel().sendMessage("pong!").queue();
    }

    public static void ping(MessageReceivedEvent e) {
        e.getChannel().sendMessage("ping!").queue();
    }
}