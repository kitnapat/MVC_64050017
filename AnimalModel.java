import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalModel {
    private List<Animal> animals = new ArrayList<>();

    public AnimalModel(String filePath) {
        loadAnimalsFromCSV(filePath);
    }

    private void loadAnimalsFromCSV(String filePath) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String code = values[0];
                if (values[4].equals("cow")) {
                    int ageYears = Integer.parseInt(values[1]);
                    int ageMonths = Integer.parseInt(values[2]);
                    int udders = Integer.parseInt(values[3]);
                    animals.add(new Animal(code, ageYears, ageMonths, udders, "cow"));
                } else if (values[4].equals("goat")) {
                    animals.add(new Animal(code, 0, 0, 0, "goat"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Animal getAnimalByCode(String code) {
        for (Animal animal : animals) {
            if (animal.getCode().equals(code)) {
                return animal;
            }
        }
        return null;
    }

    public void updateCSV(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Animal animal : animals) {
                if (animal.getType().equals("cow")) {
                    bw.write(animal.getCode() + "," + animal.getAgeYears() + "," + animal.getAgeMonths() + "," + animal.getUdders() + ",cow\n");
                } else {
                    bw.write(animal.getCode() + ",,,,goat\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
