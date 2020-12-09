package Anime;

import Main.Main;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
       /* JSONObject json = null;
        try {
            json = readJsonFromUrl("https://neko-love.xyz/api/v1/neko");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assert json != null;
        e.getChannel().sendMessage(json.get("url").toString()).queue();*/

        String sURL = "https://neko-love.xyz/api/v1/neko";
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.setRequestProperty("User-Agent", "Mozilla/5.0");
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        String nekoUrl = rootobj.get("url").getAsString();
        e.getChannel().sendMessage(nekoUrl).queue();

    }


}
