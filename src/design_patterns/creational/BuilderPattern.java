package design_patterns.creational;

/**
 * Created by sergei.kostin on 1/30/18.
 */
public class BuilderPattern {

    public static class Computer{
        //required
        private String RAM;
        private String HDD;

        //optional
        private boolean isGraphicCard;
        private boolean isBluetooth;

        public String getRAM() {
            return RAM;
        }

        public String getHDD() {
            return HDD;
        }

        public boolean isGraphicCard() {
            return isGraphicCard;
        }

        public boolean isBluetooth() {
            return isBluetooth;
        }

        private Computer(ComputerBuilder builder){
            this.RAM = builder.RAM;
            this.HDD = builder.HDD;
            this.isBluetooth = builder.isBluetooth;
            this.isGraphicCard = builder.isGraphicCard;
        }

        public static class ComputerBuilder{

            private String RAM;
            private String HDD;
            private boolean isGraphicCard;
            private boolean isBluetooth;

            ComputerBuilder(String RAM, String HDD){
                this.RAM = RAM;
                this.HDD = HDD;
            }

            public ComputerBuilder setGraphicCard(boolean graphicCard) {
                this.isGraphicCard = graphicCard;
                return this;
            }

            public ComputerBuilder setBluetooth(boolean bluetooth) {
                this.isBluetooth = bluetooth;
                return this;
            }

            public Computer build(){
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "RAM='" + RAM + '\'' +
                    ", HDD='" + HDD + '\'' +
                    ", isGraphicCard=" + isGraphicCard +
                    ", isBluetooth=" + isBluetooth +
                    '}';
        }

    }


    public static void main(String[] args) {
        Computer comp = new Computer.ComputerBuilder("128", "1TB").setBluetooth(true).build();
        System.out.println(comp);
    }

}
