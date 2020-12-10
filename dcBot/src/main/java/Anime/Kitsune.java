package Anime;

import Main.Main;
import Other.Json;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Kitsune extends Json {

    private String[] wrongSpelling = {"kitusne", "kistune", "kiutsne", "kistnue", "kitsnue", "kitsuen"};

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "kitsune")) {
            try {
                kitsuneText(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            e.getChannel().sendMessage("Did you mean **Kitsune**?").queue();
            try {
                kitsuneText(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void kitsuneText(MessageReceivedEvent e) throws IOException {
        String sURL = "https://neko-love.xyz/api/v1/kitsune";
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
