package design_patterns.behavioral;

/**
 * Chain of responsibility pattern is used to achieve loose coupling in software design where a request from client is
 * passed to a chain of objects to process them. Then the object in the chain will decide themselves who will be
 * processing the request and whether the request is required to be sent to the next object in the chain or not.
 */
public class ChainOfResponsibility {


    private class Currency{
        private int cash;

        Currency(int cash){
            this.cash = cash;
        }

        public int getCash() {
            return cash;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }
    }

    private class CashDispencer10 implements CashDispencer{

        private CashDispencer nextDispencer;

        @Override
        public void setNextDispencer(CashDispencer dispencer) {
           nextDispencer = dispencer;
        }

        @Override
        public void getCash(int cash) {
        }
    }

    private class CashDispencer20 implements CashDispencer{

        private CashDispencer nextDispencer;

        @Override
        public void setNextDispencer(CashDispencer dispencer) {
            nextDispencer = dispencer;
        }

        @Override
        public void getCash(int cash) {

        }
    }

    private class CashDispencer50 implements CashDispencer{

        private CashDispencer nextDispencer;

        @Override
        public void setNextDispencer(CashDispencer dispencer) {
            nextDispencer = dispencer;
        }

        @Override
        public void getCash(int cash) {
            if(cash > 50){
            }
        }
    }


    public interface CashDispencer{

        void setNextDispencer(CashDispencer dispencer);
        void getCash(int cash);

    }

}


