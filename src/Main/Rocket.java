package Main;

public class Rocket implements SpaceShip {

    double rocketWeight;
    double maxWeight;
    double cost;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
      if(maxWeight >= (rocketWeight + item.weight)){
          return true;
      }
        return false;
    }

    @Override
    public void carry(Item item) {
        this.rocketWeight += item.weight;
    }

    public double getRocketWeight() {
        return rocketWeight;
    }

    public double getCost() {
        return cost;
    }
}
