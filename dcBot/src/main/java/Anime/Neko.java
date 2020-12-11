package Anime;

import Main.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
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
                int random = 1 + (int)(Math.random() * ((3 - 1) + 1));
                if(random == 1)
                    nekoText(e);
                 else if(random == 2)
                    nekoText2(e);
                 else
                    nekoText3(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (Arrays.asList(wrongSpelling).contains(Main.prefix + e.getMessage().getContentRaw())) {
            e.getChannel().sendMessage("Did you mean **Neko**?").queue();
            try {
                int random = 1 + (int)(Math.random() * ((3 - 1) + 1));
                if(random == 1)
                    nekoText(e);
                else if(random == 2)
                    nekoText2(e);
                else
                    nekoText3(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void nekoText(MessageReceivedEvent e) throws IOException {
        String sURL = "https://neko-love.xyz/api/v1/neko";
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

    private void nekoText2(MessageReceivedEvent e) throws IOException {
        String sURL = "https://www.nekos.life/api/v2/img/neko";
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; "
                + "Windows NT 5.1; en-US; rv:1.8.0.11) "); //needed so the request does not get blocked when coming from a raspberry pi
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            line = in.readLine();
            String[] tokens = line.split(":");
            e.getChannel().sendMessage(tokens[1].substring(1) + ":" + tokens[2].substring(0, tokens[2].length()-2)).queue();
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

    private void nekoText3(MessageReceivedEvent e) throws IOException {
        String sURL = "http://api.nekos.fun:8080/api/neko";
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; "
                + "Windows NT 5.1; en-US; rv:1.8.0.11) "); //needed so the request does not get blocked when coming from a raspberry pi
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            line = in.readLine();
            String[] tokens = line.split(":");
            e.getChannel().sendMessage(tokens[1].substring(1) + ":" + tokens[2].substring(0, tokens[2].length()-2)).queue();
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
