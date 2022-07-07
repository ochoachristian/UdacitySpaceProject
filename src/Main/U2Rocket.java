package Main;

public class U2Rocket extends Rocket {

    final double CHANCE_OF_LAUNCH_EXPLOSION = .04;
    final double CHANCE_OF_LANDING_CRASH = .08;
    final int COST = 100000000;
    final double TONS = 2204.62;
    final double ROCKET_WEIGHT = 18 * TONS;
    final double MAX_WEIGHT = 29 * TONS;
    double cargoLimit;

    public U2Rocket() {
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
}
