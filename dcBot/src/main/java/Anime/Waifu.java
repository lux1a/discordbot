package Anime;

import Main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Arrays;

public class Waifu extends Json {

    private String[] wrongSpelling = {"waiuf", "wafiu", "wiafu", "awiuf", "wifua", "wafui"};

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "waifu")) {
            waifuText(e);
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            e.getChannel().sendMessage("Did you mean **Waifu**?").queue();
            waifuText(e);
        }
    }

    private void waifuText(MessageReceivedEvent e) {
        JSONObject json = null;
        try {
            json = readJsonFromUrl("https://neko-love.xyz/api/v1/waifu");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assert json != null;
        e.getChannel().sendMessage(json.get("url").toString()).queue();
    }
}
