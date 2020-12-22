package Utility;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Levensthein extends ListenerAdapter{

    public static int levensthein(int[][] levArray, String string1, String string2) {
        for(int i = 0; i <= string2.length(); i++) {
            levArray[0][i] = i*2;
        }

        for(int j = 0; j <= string1.length(); j++) {
            levArray[j][0] = j*2;
        }

        for(int i = 1; i <= string1.length(); i++) {
            for(int j = 1; j <= string2.length(); j++) {
                if(string1.charAt(i-1) == string2.charAt(j-1)) {
                    levArray[i][j] = levArray[i-1][j-1];
                } else {
                    levArray[i][j] = Math.min(Math.min(levArray[i-1][j-1]+1, levArray[i][j-1]+1), levArray[i-1][j]+1);
                }
            }
        }
        return levArray[string1.length()][string2.length()];
    }
}
