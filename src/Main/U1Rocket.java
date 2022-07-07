package Main;

public class U1Rocket extends Rocket {

    private final double CHANCE_OF_LAUNCH_EXPLOSION = .05;
    private final double CHANCE_OF_LANDING_CRASH = .01;
    private final double COST = 100000000;
    private final double TONS = 2204.62;
    private final double ROCKET_WEIGHT = 10 * TONS;
    private final double MAX_WEIGHT = 18 * TONS;
    private double cargoLimit;

    public U1Rocket() {
        this.cargoLimit = MAX_WEIGHT - ROCKET_WEIGHT;
        this.cost = COST;
        this.rocketWeight = ROCKET_WEIGHT;
        this.maxWeight = MAX_WEIGHT;
    }

    @Override
    public boolean launch() {
        int random = (int) (Math.random() * 100);
        double chanceOfExplosion = 100 * (CHANCE_OF_LAUNCH_EXPLOSION * ((rocketWeight - ROCKET_WEIGHT) / cargoLimit));
        boolean successfulLaunch = random >= chanceOfExplosion;
        if(successfulLaunch){
            System.out.println("Ship took off successfully!");
        } else {
            System.out.println("Ship blew up...");
        }
        return successfulLaunch;
    }

    @Override
    public boolean land() {
        int random = (int) (Math.random() * 100);
        double chanceOfExplosion = 100 * (CHANCE_OF_LANDING_CRASH * ((rocketWeight - ROCKET_WEIGHT) / cargoLimit));
        boolean successfulLand = random >= chanceOfExplosion;
        if(successfulLand){
            System.out.println("Ship landed successfully!");
        } else {
            System.out.println("Ship crashed..");
        }
        return successfulLand;
    }

    public double getROCKET_WEIGHT() {
        return ROCKET_WEIGHT;
    }
}
