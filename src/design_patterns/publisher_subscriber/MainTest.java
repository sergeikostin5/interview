package design_patterns.publisher_subscriber;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class MainTest {

    public static void main(String[] args) {
        EventBus bus = new EventBus();
        StockMarket market = new StockMarket(bus);
        AppleLover appleLover = new AppleLover();
        appleLover.setName("AppleLover");
        appleLover.subscribe("Apple");

        GoogleLover googleLover = new GoogleLover();
        googleLover.setName("GoogleLover");
        googleLover.subscribe("Google");
        AllStocksLover allStocksLover = new AllStocksLover();
        allStocksLover.setName("AllStockLover");
        allStocksLover.subscribe("Apple");
        allStocksLover.subscribe("Google");

        Message message1 = new Message("Apple stock went up", "Apple");
        Message message2 = new Message("Google stock went down", "Google");

        bus.addSubscriber(googleLover);
        bus.addSubscriber(appleLover);
        bus.addSubscriber(allStocksLover);

        market.sendMessage(message1);
        market.sendMessage(message2);


    }

}
