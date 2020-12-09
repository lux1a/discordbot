package Anime;

import Main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Neko extends Json {

    private String[] wrongSpelling = {"neok", "nkeo", "enko", "noek", "keno", "neo"};

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "neko")) {
            try {
                nekoText(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            e.getChannel().sendMessage("Did you mean **Neko**?").queue();
            try {
                nekoText(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void nekoText(MessageReceivedEvent e) throws IOException {
        URL url = new URL("https://neko-love.xyz/api/v1/neko");
        JSONObject json = null;
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        try {
            json = readJsonFromUrl(url.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assert json != null;
        e.getChannel().sendMessage(json.get("url").toString()).queue();
    }
}
