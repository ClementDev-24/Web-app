package Interview;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SimpleTradingAlgorithm {

    private static final String API_KEY = "VEY05EZUWNGMXOL3";
    private static final String SYMBOL = "EURUSD"; // Replace with the currency pair you want

    public static void main(String[] args) {
        try {
            List<Double> priceData = fetchMarketData(SYMBOL);
            int shortPeriod = 10;
            int longPeriod = 50;

            List<Double> shortTermMA = calculateMovingAverage(priceData, shortPeriod);
            List<Double> longTermMA = calculateMovingAverage(priceData, longPeriod);
            String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="
                    + SYMBOL + "&interval=1min&apikey=" + API_KEY;
            List<Double> supportLevels = calculateSupportLevels(priceData, 20); // Adjust lookback period
            List<Double> resistanceLevels = calculateResistanceLevels(priceData, 20); // Adjust lookback period

            JsonNode response = Unirest.get(apiUrl)
                    .header("Accept", "application/json")
                    .queryString("apikey", API_KEY)
                    .asJson()
                    .getBody();

            JSONObject timeSeries = response.getObject().getJSONObject("Time Series (1min)");

            List<String> signals = generateTradingSignals(priceData, shortTermMA, longTermMA, supportLevels, resistanceLevels, timeSeries);

            // Display the trading signals with timestamps
            for (int i = 0; i < priceData.size(); i++) {
                System.out.println("Timestamp: " + getTimestamp(i, timeSeries) +
                        " | Price: " + priceData.get(i) +
                        " | Short MA: " + shortTermMA.get(i) +
                        " | Long MA: " + longTermMA.get(i) +
                        " | Support Level: " + supportLevels.get(i) +
                        " | Resistance Level: " + resistanceLevels.get(i) +
                        " | Signal: " + signals.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static List<Double> fetchMarketData(String symbol) throws Exception {
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="
                + symbol + "&interval=1min&apikey=" + API_KEY;

        JsonNode response = Unirest.get(apiUrl)
                .header("Accept", "application/json")
                .queryString("apikey", API_KEY)
                .asJson()
                .getBody();

        JSONObject timeSeries = response.getObject().getJSONObject("Time Series (1min)");
        List<Double> prices = new ArrayList<>();

        for (String timestamp : timeSeries.keySet()) {
            double closingPrice = timeSeries.getJSONObject(timestamp).getDouble("4. close");
            prices.add(closingPrice);
        }

        return prices;
    }

    private static List<Double> calculateMovingAverage(List<Double> data, int period) {
        List<Double> movingAverage = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (i < period - 1) {
                movingAverage.add(null); // Not enough data for the moving average yet
            } else {
                double sum = 0;
                for (int j = i - period + 1; j <= i; j++) {
                    sum += data.get(j);
                }
                movingAverage.add(sum / period);
            }
        }
        return movingAverage;
    }

    private static List<Double> calculateSupportLevels(List<Double> data, int lookbackPeriod) {
        List<Double> supportLevels = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (i < lookbackPeriod - 1) {
                supportLevels.add(null); // Not enough data for calculation
            } else {
                double minPrice = Double.MAX_VALUE;
                for (int j = i - lookbackPeriod + 1; j <= i; j++) {
                    minPrice = Math.min(minPrice, data.get(j));
                }
                supportLevels.add(minPrice);
            }
        }

        return supportLevels;
    }

    private static List<Double> calculateResistanceLevels(List<Double> data, int lookbackPeriod) {
        List<Double> resistanceLevels = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (i < lookbackPeriod - 1) {
                resistanceLevels.add(null); // Not enough data for calculation
            } else {
                double maxPrice = Double.MIN_VALUE;
                for (int j = i - lookbackPeriod + 1; j <= i; j++) {
                    maxPrice = Math.max(maxPrice, data.get(j));
                }
                resistanceLevels.add(maxPrice);
            }
        }

        return resistanceLevels;
    }

    private static String getTimestamp(int index, JSONObject timeSeries) {
        String[] timestamps = timeSeries.keySet().toArray(new String[0]);

        // Check if the index is within bounds
        if (index >= 0 && index < timestamps.length) {
            return timestamps[index];
        } else {
            return "Invalid Index";
        }
    }

    private static List<String> generateTradingSignals(List<Double> priceData,
                                                       List<Double> shortMA,
                                                       List<Double> longMA,
                                                       List<Double> supportLevels,
                                                       List<Double> resistanceLevels,
                                                       JSONObject timeSeries) {
        List<String> signals = new ArrayList<>();

        for (int i = 0; i < priceData.size(); i++) {
            Double currentPrice = priceData.get(i);
            Double shortTermAverage = shortMA.get(i);
            Double longTermAverage = longMA.get(i);
            Double supportLevel = supportLevels.get(i);
            Double resistanceLevel = resistanceLevels.get(i);

            // Add null checks
            if (currentPrice == null || shortTermAverage == null || longTermAverage == null ||
                    supportLevel == null || resistanceLevel == null) {
                signals.add("No Data");
            } else if (currentPrice > shortTermAverage && currentPrice > longTermAverage && currentPrice > resistanceLevel) {
                signals.add("Buy");
            } else if (currentPrice < shortTermAverage && currentPrice < longTermAverage && currentPrice < supportLevel) {
                signals.add("Sell");
            } else {
                signals.add("Hold");
            }
        }
        return signals;
    }

}
