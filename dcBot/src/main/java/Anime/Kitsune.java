package Anime;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Kitsune{

    public static void kitsune(MessageReceivedEvent e) {
        try {
            kitsuneText(e);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void kitsuneText(MessageReceivedEvent e) throws IOException {
        String sURL = "https://neko-love.xyz/api/v1/kitsune";
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
