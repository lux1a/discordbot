package Main;

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

        BufferedReader reader = new BufferedReader(new FileReader(new File("variables.txt")));
        final String token = reader.readLine();
        ownerID = reader.readLine();
        prefix = reader.readLine();
        reader.close();
    
        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        Commands commands = new Commands();
        jdaBuilder.addEventListeners(commands);
        jdaBuilder.setActivity(Activity.watching("time fly by"));
        jdaBuilder.build();
    }
}
