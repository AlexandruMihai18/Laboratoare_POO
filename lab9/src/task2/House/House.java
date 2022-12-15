package task2.House;

public class House {

    private String location; // mandatory
    private int numFloors; // mandatory
    private int numRooms; // mandatory
    private boolean pool; // optional
    private boolean appliances; // optional
    private boolean solarPanels; // optional
    private String securityCompany; // optional

    // TODO: complete the private constructor
    private House(HouseBuilder builder) {
        this.location = builder.location;
        this.numFloors = builder.numFloors;
        this.numRooms = builder.numRooms;
        this.pool = builder.pool;
        this.appliances = builder.appliances;
        this.solarPanels = builder.solarPanels;
        this.securityCompany = builder.securityCompany;
    }

    // TODO: generate getters

    public String getLocation() {
        return location;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public boolean isPool() {
        return pool;
    }

    public boolean isAppliances() {
        return appliances;
    }

    public boolean isSolarPanels() {
        return solarPanels;
    }

    public String getSecurityCompany() {
        return securityCompany;
    }


    // TODO: override toString method
    @Override
    public String toString() {
        return "House{" +
                "location='" + location + '\'' +
                ", numFloors=" + numFloors +
                ", numRooms=" + numRooms +
                ", pool=" + pool +
                ", appliances=" + appliances +
                ", solarPanels=" + solarPanels +
                ", securityCompany='" + securityCompany + '\'' +
                '}';
    }

    public static class HouseBuilder {
        // TODO: write same facilities
        private String location; // mandatory
        private int numFloors; // mandatory
        private int numRooms; // mandatory
        private boolean pool = false; // optional
        private boolean appliances = false; // optional
        private boolean solarPanels = false; // optional
        private String securityCompany = null; // optional

        // TODO: complete the house builder constructor only with the mandatory facilities
        public HouseBuilder(String location, int numFloors, int numRooms) {
            this.location = location;
            this.numFloors = numFloors;
            this.numRooms = numRooms;
        }

        // TODO: add the optional facilities in a builder design
        public HouseBuilder pool(boolean pool) {
            this.pool = pool;
            return this;
        }

        public HouseBuilder appliances(boolean appliances) {
            this.appliances = appliances;
            return this;
        }

        public HouseBuilder solarPanels(boolean solarPanels) {
            this.solarPanels = solarPanels;
            return this;
        }

        public HouseBuilder securityCompany(String securityCompany) {
            this.securityCompany = securityCompany;
            return this;
        }

        // TODO: complete the final build method
        public House build() {
            return new House(this); // change this
        }

        // TODO: test functionality in a Main class
    }
}
