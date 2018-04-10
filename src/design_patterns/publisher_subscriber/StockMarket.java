package design_patterns.publisher_subscriber;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class StockMarket extends Publisher {

    public StockMarket(EventBus mBus) {
        super(mBus);
    }
}
