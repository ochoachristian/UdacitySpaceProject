package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    File phaseOneFile = new File("Phase-1.txt");
    File phaseTwoFile = new File("Phase-2.txt");
    private double budget;

    public List<Item> loadItems(File file){
        List<Item>items = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[]tempItems = line.split("=");
                Item item = new Item();
                item.name = tempItems[0];
                item.weight = Integer.parseInt(tempItems[1]);
                items.add(item);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return items;
    }

    public List<Rocket> loadU1(){
        List<Rocket>rockets = new ArrayList<>();
        U1Rocket rocket = new U1Rocket();

        for (Item i : loadItems(phaseOneFile)){
            while (!rocket.canCarry(i)){
                rockets.add(rocket);
                rocket = new U1Rocket();

            }
            rocket.carry(i);
        }
        return rockets;
    }

    public List<Rocket> loadU2(){
        List<Rocket>rockets = new ArrayList<>();
        U2Rocket rocket = new U2Rocket();

        for (Item i : loadItems(phaseTwoFile)){
            while (!rocket.canCarry(i)){
                rockets.add(rocket);
                rocket = new U2Rocket();
            }
            rocket.carry(i);
        }

        return rockets;
    }

    public double runSimulation(List<Rocket>rockets){
        for (int i = 0; i < rockets.size(); i++){
            int rocketCount = 1;
            while ((!rockets.get(i).launch()) || (!rockets.get(i).land())){
                rockets.get(i).launch();
                rockets.get(i).land();
                rocketCount++;
            }
            budget += rocketCount * (rockets.get(i).cost);
        }
        System.out.println("Total budget = " + budget + "\n");
     return budget;
    }
}
