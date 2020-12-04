package Anime;

import Main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Arrays;

public class Kitsune extends Json {

    private String[] wrongSpelling = {"kitusne", "kistune", "kiutsne", "kistnue", "kitsnue", "kitsuen"};

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "kitsune")) {
           kitsuneText(e);
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            e.getChannel().sendMessage("Did you mean **Kitsune**?").queue();
            kitsuneText(e);
        }
    }

    private void kitsuneText(MessageReceivedEvent e) {
        JSONObject json = null;
        try {
            json = Json.readJsonFromUrl("https://neko-love.xyz/api/v1/kitsune");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assert json != null;
        e.getChannel().sendMessage(json.get("url").toString()).queue();
    }
}
