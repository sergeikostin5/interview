package design_patterns.structural;

/**
 * Adapter design pattern is one of the structural design pattern and its used so that two unrelated interfaces can
 * work together. The object that joins these unrelated interface is called an Adapter.
 */
public class AdapterPattern {



    private static class Socket120 implements Socket{
        public Volt getVolt(){
            return new Volt(120);
        }
    }

    interface Socket{
        Volt getVolt();
    }

    private static class Charger3Volt{

        private Socket mSocket;
        private SocketAdapter mAdapter;

        Charger3Volt(Socket socket){
            this.mSocket = socket;
            mAdapter = new SocketAdapterImpl(mSocket);
        }

        Volt getVolts(){
            return mAdapter.get3Volt();
        }

    }

    interface SocketAdapter{
        Volt get120Volt();
        Volt get12Volt();
        Volt get3Volt();
    }

    private static class SocketAdapterImpl implements SocketAdapter{

        Socket mSocket;

        SocketAdapterImpl(Socket socket){
            this.mSocket = socket;
        }

        @Override
        public Volt get120Volt() {
            return mSocket.getVolt();
        }

        @Override
        public Volt get12Volt() {
            return new Volt(mSocket.getVolt().volts/10);
        }

        @Override
        public Volt get3Volt() {
            return new Volt(mSocket.getVolt().volts/40);
        }
    }

    private static class Volt{
        private int volts;

        public Volt(int volts) {
            this.volts = volts;
        }

        public int getVolts() {
            return volts;
        }

        public void setVolts(int volts) {
            this.volts = volts;
        }

        @Override
        public String toString() {
            return "Volt{" +
                    "volts=" + volts +
                    '}';
        }
    }

    public static void main(String[] args) {
        Socket120 socket = new Socket120();
        Charger3Volt charger = new Charger3Volt(socket);
        System.out.println(charger.getVolts());
    }

}
