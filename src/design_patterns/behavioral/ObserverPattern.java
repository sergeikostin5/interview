package design_patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * The observer pattern defines a one-to-many dependency between objects so that when one object changes state, all of
 * its dependents are notified and updated automatically. The object which is being watched is called the subject.
 * The objects which are watching the state changes are called observers or listeners.
 */
public class ObserverPattern {

    private static class StockModel {

        List<Stock> stocks = new ArrayList<>();
        List<StockChangeListener> observers;

        StockModel(){
            observers = new ArrayList<>();
            Stock apple = new Stock("Apple", 20);
            Stock google = new Stock("Google", 30);
            stocks.add(apple);
            stocks.add(google);
        }

        public class Stock{
            String name;
            int price;

            Stock(String name, int price){
                this.name = name;
                this.price = price;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPrice(int price) {
                this.price = price;
                for(StockChangeListener listener : observers){
                    listener.onPriceChanged(name, price);
                }
            }
        }

        public List<Stock> getStocks() {
            return stocks;
        }

        void setPriceChangeListener(StockChangeListener listener){
           observers.add(listener);
        }
    }

    interface StockChangeListener{
        void onPriceChanged(String stockName, int price);
    }

    private static class StockPriceObserver implements StockChangeListener{

        StockModel model;
        String name;

        StockPriceObserver(StockModel model, String name){
            this.model = model;
            this.name = name;
            model.setPriceChangeListener(this);
        }

        @Override
        public void onPriceChanged(String stockName, int price) {
            System.out.println(name + " Price for " + stockName + " was changed to " + price);
        }
    }

    public static void main(String[] args) {
        StockModel model = new StockModel();

        StockPriceObserver observer1 = new StockPriceObserver(model, "Observer 1 ");
        StockPriceObserver observer2 = new StockPriceObserver(model, "Observer 2 ");

        model.getStocks().get(0).setPrice(100);

    }


}
