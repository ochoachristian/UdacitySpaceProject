package Main;

public class Main {

    public static void main (String[]args){

        Simulation s = new Simulation();
        System.out.println("U1 ships taking off...");
        s.runSimulation(s.loadU1());
        System.out.println("U2 ships taking off...");
        s.runSimulation(s.loadU2());
    }
}
