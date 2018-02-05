package design_patterns.structural;

/**
 * Decorator design pattern is used to modify the functionality of an object at runtime. At the same time other
 * instances of the same class will not be affected by this, so individual object gets the modified behavior.
 * Decorator design pattern is one of the structural design pattern
 */
public class DecoratorPattern {

    private interface Pizza{
        String getDescription();
        double getCost();
    }

    private static class BasicPizza implements Pizza{

        BasicPizza(){
            System.out.println("Adding dough");
        }

        @Override
        public String getDescription() {
            return "Basic pizza";
        }

        @Override
        public double getCost() {
            return 4.0;
        }
    }

    private abstract static class ToppingsDecorator implements Pizza{

        Pizza tempPizza;

        ToppingsDecorator(Pizza pizza){
            tempPizza = pizza;
        }

        @Override
        public String getDescription() {
            return tempPizza.getDescription();
        }

        @Override
        public double getCost() {
            return tempPizza.getCost();
        }
    }

    private static class Mozarella extends ToppingsDecorator{

        Mozarella(Pizza pizza) {
            super(pizza);
            System.out.println("Adding Mozarella");
        }

        @Override
        public String getDescription() {
            return tempPizza.getDescription() + " Mozarella";
        }

        @Override
        public double getCost() {
            return tempPizza.getCost() + 1.0;
        }
    }

    private static class Ham extends ToppingsDecorator{

        Ham(Pizza pizza) {
            super(pizza);
            System.out.println("Adding ham");
        }

        @Override
        public String getDescription() {
            return tempPizza.getDescription() + " Ham";
        }

        @Override
        public double getCost() {
            return tempPizza.getCost() + 2.50;
        }
    }

    public static void main(String[] args) {
        Pizza pizza = new Ham(new Mozarella(new BasicPizza()));
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());
    }





}
