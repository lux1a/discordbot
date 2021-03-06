package Other;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;
import java.awt.*;
import java.io.IOException;

public class Crypto extends Json {

    public static void crypto(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().length() < 8) {
            e.getChannel().sendMessage(
                    "Correct usage: " + "`_crypto` + `cryptocurrency (e.g bitcoin)` + `currency (e.g usd) [optional]`")
                    .queue();
        } else {
            String[] tokens = e.getMessage().getContentRaw().split(" ");
            String currency;
            String chart = "\uD83D\uDCC8";
            if (tokens.length < 3) {
                currency = "usd";
            } else {
                currency = tokens[2].toString().toLowerCase();
            }
            e.getChannel().sendMessage(cryptoText(e, tokens[1].toString().toLowerCase(), currency, chart)).queue();
        }
    }

    public static MessageEmbed cryptoText(MessageReceivedEvent e, String cryptocurrency, String currency,
            String chart) {
        JSONObject json = null;
        try {
            String url = "https://api.coingecko.com/api/v3/coins/" + cryptocurrency
                    + "?localization=false&tickers=true&market_data=true&community_data=false&developer_data=false&sparkline=false";
            json = readJsonFromUrl(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assert json != null;
        EmbedBuilder embedBuilder = new EmbedBuilder();
        if (Double.parseDouble(json.getJSONObject("market_data").get("price_change_percentage_24h").toString()
                .substring(0, 5)) < 0.0) {
            chart = "\uD83D\uDCC9";
        }
        embedBuilder.setThumbnail(json.getJSONObject("image").get("large").toString());
        embedBuilder.setTitle("Current " + json.get("name").toString() + " ($"
                + json.get("symbol").toString().toUpperCase() + ")" + " Price");
        embedBuilder.setDescription("```Price: "
                + json.getJSONObject("market_data").getJSONObject("current_price").get(currency).toString() + " "
                + currency.toUpperCase() + "```" + "```24h Change: "
                + json.getJSONObject("market_data").get("price_change_percentage_24h").toString().substring(0, 5)
                + "% | "
                + json.getJSONObject("market_data").getJSONObject("price_change_percentage_24h_in_currency")
                        .get(currency).toString().substring(0, 5)
                + " " + currency.toUpperCase() + " " + chart + "```" + "```7d Change: "
                + json.getJSONObject("market_data").get("price_change_percentage_7d").toString().substring(0, 5)
                + "% | " + json.getJSONObject("market_data").getJSONObject("price_change_percentage_7d_in_currency")
                        .get(currency).toString().substring(0, 5)
                + " " + currency.toUpperCase() + " " + chart + "```");
        embedBuilder.setColor(Color.decode("#FF9900"));
        return embedBuilder.build();
    }
}
