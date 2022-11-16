import java.util.Random;

public class Dealership {
    private static int CURRENT_YEAR = 2022;
    private class BrandOffer implements Offer{
        public int getDiscount(Car car) {
            switch(car.getCarType()) {
                case MERCEDES -> {
                    return car.getPrice() * 5 / 100;
                }
                case FIAT -> {
                    return car.getPrice() * 10 / 100;
                }
                case SKODA -> {
                    return car.getPrice() * 15 / 100;
                }
            }
            return 0;
        }
    }
    private class DealerOffer implements Offer{
        public int getDiscount(Car car) {
            switch (car.getCarType()) {
                case MERCEDES -> {
                    return (CURRENT_YEAR - car.getYear()) * 300;
                }
                case  FIAT -> {
                    return (CURRENT_YEAR - car.getYear()) * 100;
                }
                case SKODA -> {
                    return (CURRENT_YEAR - car.getYear()) * 150;
                }
            }
            return 0;
        }
    }

    private class SpecialOffer implements Offer {
        private static Random rand = new Random(20);
        private int random;
        public SpecialOffer() {
            random = rand.nextInt(1000);
        }
        public int getDiscount(Car car) {
            return random;
        }
    }

    public int getFinalPrice(Car car) {
        int firstDiscount = (new BrandOffer()).getDiscount(car);
        int secondDiscount = (new DealerOffer()).getDiscount(car);
        int thirdDiscount = (new SpecialOffer()).getDiscount(car);
        System.out.println("Applying Brand discount: " + firstDiscount + " euros");
        System.out.println("Applying Dealer discount: " + secondDiscount+ " euros");
        System.out.println("Applying Special discount: " + thirdDiscount + " euros");
        return car.getPrice() - firstDiscount
                - secondDiscount - thirdDiscount;
    }

    public void negotiate(Car car, Offer offer) {
        System.out.println("Applying Client discount: " + offer.getDiscount(car) + " euros");
    }
}
