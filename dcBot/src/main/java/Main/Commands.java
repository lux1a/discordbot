package Main;

import Anime.*;
import Other.*;
import Utility.*;
import Essentials.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public static long beeTimer = (System.currentTimeMillis() / 1000L) - 3001;
    public static long asciiTimer = (System.currentTimeMillis()/1000L) - 31;
    String[] commands = {"ping", "pong", "info", "vanish", "help", "neko", "waifu", "kitsune", "kurumi", "kurumigif", "zerotwo", "zerotwogif", "crypto", "bee", "say", "info", "ascii", "channel", "user", "02", "02gif", "ascii", "ascii help", "ascii ahegao", "ascii uwu", "ascii ayaya", "ascii 02", "ascii chika", "ascii pikachu", "ascii padoru", "ascii pacman"};

    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getMessage().getContentRaw().startsWith(Main.prefix) && e.getAuthor().isBot() == false) {
            int currentLowest = Integer.MAX_VALUE;
            String currentLowestCommand = "help";
            String input = e.getMessage().getContentRaw().substring(1);
            String[] tokens = input.split(" ");
             input = tokens[0];
            for(String string : commands) {
                int[][] levArray = new int[input.length()+1][string.length()+1];
                if(Levensthein.levensthein(levArray, input, string) < currentLowest) {
                    currentLowest = Levensthein.levensthein(levArray, input, string);
                    currentLowestCommand = string;
                }
            }

            if(currentLowest >= 10) {
                e.getChannel().sendMessage("I do not recognize this command. Use `_help` for a list of available commands.").queue();
            }else if(currentLowest != 0) {
               e.getChannel().sendMessage("Did you mean **_" + currentLowestCommand + "**?").queue();
            }

            if(currentLowest < 10) {
                switch(currentLowestCommand) {
                    case "ping":
                        Pong.pong(e);
                        break;
                    case "pong":
                        Pong.ping(e);
                        break;
                    case "vanish":
                        Vanish.vanish(e);
                        break;
                    case "help":
                        Help.help(e);
                        break;
                    case "neko":
                        Neko.neko(e);
                        break;
                    case "waifu":
                        Waifu.waifu(e);
                        break;
                    case "kitsune":
                        Kitsune.kitsune(e);
                        break;
                    case "say":
                        Say.say(e);
                        break;
                    case "crypto":
                        Crypto.crypto(e);
                        break;
                    case "kurumi":
                        Characters.kurumi(e);
                        break;
                    case "kurumigif":
                        Characters.kurumigif(e);
                        break;
                    case "02":
                        Characters.zerotwo(e);
                        break;
                    case "02gif":
                        Characters.zerotwogif(e);
                        break;
                    case "zerotwo":
                        Characters.zerotwo(e);
                        break;
                    case "zerotwogif":
                        Characters.zerotwogif(e);
                        break;
                    case "bee":
                        BeeMovieScript.bee(e);
                        break;
                    case "ascii":
                        Ascii.asciiHelp(e);
                        break;
                    case "ascii help":
                        Ascii.asciiHelp(e);
                        break;
                    case "ascii ahegao":
                        Ascii.asciiAhegao(e);
                        break;
                    case "ascii uwu":
                        Ascii.asciiUwu(e);
                        break;
                    case "ascii ayaya":
                        Ascii.asciiAyaya(e);
                        break;
                    case "ascii 02":
                        Ascii.ascii02(e);
                        break;
                    case "ascii pikachu":
                        Ascii.asciiPikachu(e);
                        break;
                    case "ascii chika":
                        Ascii.asciiChika(e);
                        break;
                    case "ascii padoru":
                        Ascii.asciiPadoru(e);
                        break;
                    case "ascii pacman":
                        Ascii.asciiPacman(e);
                        break;
                    case "info":
                        Info.info(e);
                        break;
                    case "user":
                        Channel.user(e);
                        break;
                    case "channel": 
                        Channel.channel(e);
                        break;
                }
            }
        }        
    }
}