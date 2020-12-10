package Anime;

import Main.Main;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Neko extends ListenerAdapter {

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
        String sURL = "https://neko-love.xyz/api/v1/neko";
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.setRequestProperty("User-Agent", "Mozilla/5.0"); //needed so the request does not get blocked when coming from a raspberry pi
        request.connect();

        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        String nekoUrl = rootobj.get("url").getAsString();
        e.getChannel().sendMessage(nekoUrl).queue();
    }
}
