package Anime;

import Main.Main;
import Other.Json;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Waifu extends Json {

    private String[] wrongSpelling = {"waiuf", "wafiu", "wiafu", "awiuf", "wifua", "wafui"};

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals(Main.prefix + "waifu")) {
            try {
                waifuText(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            e.getChannel().sendMessage("Did you mean **Waifu**?").queue();
            try {
                waifuText(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void waifuText(MessageReceivedEvent e) throws IOException {
        String sURL = "https://neko-love.xyz/api/v1/waifu";
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; "
                + "Windows NT 5.1; en-US; rv:1.8.0.11) "); //needed so the request does not get blocked when coming from a raspberry pi
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            line = in.readLine();
            String[] tokens = line.split(":");
            e.getChannel().sendMessage(tokens[2].substring(1) + ":" + tokens[3].substring(0, tokens[3].length()-2)).queue();
            in.close();
        }
        catch (MalformedURLException ex) {
            System.out.println("Malformed URL: " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
        request.connect();
    }
}
