package Main;

import Anime.Kitsune;
import Anime.Kurumi;
import Anime.Neko;
import Anime.Waifu;
import Other.BeeMovieScript;
import Other.Crypto;
import Utility.Help;
import Utility.Pong;
import Utility.Say;
import Utility.Vanish;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.*;

public class Main {

    public static String ownerID;
    public static String prefix;

    public Main() {
    }

    public static void main(String[] args) throws LoginException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("/home/pi/variables.txt")));
        final String token = reader.readLine();
        ownerID = reader.readLine();
        prefix = reader.readLine();
        reader.close();

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        JDA jda = null;
        Pong pong = new Pong();
        Vanish vanish = new Vanish();
        Help help = new Help();
        Neko neko = new Neko();
        Waifu waifu = new Waifu();
        Kitsune kitsune = new Kitsune();
        Kurumi kurumi = new Kurumi();
        Crypto crypto = new Crypto();
        BeeMovieScript bee = new BeeMovieScript();
        Say say = new Say();
        jdaBuilder.addEventListeners(vanish, help, pong, neko, waifu, kitsune, bee, kurumi, say, crypto);
        jdaBuilder.setActivity(Activity.watching("time fly by"));
        jda = jdaBuilder.build();
    }
}
