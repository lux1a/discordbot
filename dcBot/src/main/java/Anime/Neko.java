package Anime;

import Main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Arrays;

public class Neko extends Json {

    private String[] wrongSpelling = {"neok", "nkeo", "enko", "noek", "keno", "neo"};

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "neko")) {
            nekoText(e);
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            e.getChannel().sendMessage("Did you mean **Neko**?").queue();
            nekoText(e);
        }
    }

    private void nekoText(MessageReceivedEvent e) {
        JSONObject json = null;
        try {
            json = readJsonFromUrl("https://neko-love.xyz/api/v1/neko");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assert json != null;
        e.getChannel().sendMessage(json.get("url").toString()).queue();
    }
}
