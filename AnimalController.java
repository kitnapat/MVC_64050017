import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AnimalController {
    private AnimalModel model;
    private AnimalView view;
    private String filePath;

    public AnimalController(AnimalModel model, AnimalView view, String filePath) {
        this.model = model;
        this.view = view;
        this.filePath = filePath;
        this.view.setSubmitButtonListener(new SubmitButtonListener());
    }

    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = view.getCode();

            if (!validateCode(code)) {
                return; 
            }

            Animal animal = model.getAnimalByCode(code);

            if (animal == null) {
                view.showError("Animal not found in the database!");
                return;
            }

            // เช็คตรวจเจอแพะ
            if (animal.getType().equals("goat")) {
                view.setCowResult(""); 
                view.setGoatResult("Goat found! Sending it back to the mountain.");
            } else {
                view.setGoatResult(""); 
                
                String result = processCow(animal);
                view.setCowResult(result);
                
                model.updateCSV(filePath);
            }
        }

        private boolean validateCode(String code) {
            // เช็คตัวเลข
            if (!code.matches("\\d+")) {
                view.showError("Invalid code! Code must only contain numbers.");
                return false;
            }

            // เช็ครหัศ 8 ตัว
            if (code.length() != 8) {
                view.showError("Invalid code! Code must be 8 digits.");
                return false;
            }

            // เช็ครหัศไม่ขึ้นด้วย 0
            if (code.startsWith("0")) {
                view.showError("Invalid code! Code cannot start with a zero.");
                return false;
            }

            return true; 
        }

        private String processCow(Animal cow) {
            Random rand = new Random();
            String result = "Cow found! Age: " + cow.getAgeYears() + " years and " + cow.getAgeMonths() + " months. ";

            if (cow.getUdders() == 4) {
                result += "Ready for milking! ";
                if (rand.nextInt(100) < 5) { // 5% ท่ี่นมหายไป 1 เต้า
                    cow.setUdders(3);
                    result += "Oops! Lost an udder, now has 3 udders.";
                }
            } else {
                result += "Not ready for milking with 3 udders. ";
                if (rand.nextInt(100) < 20) { // 20% เต้านมเพิ่ม
                    cow.setUdders(4);
                    result += "Yay! Gained back an udder, now has 4 udders.";
                }
            }

            // คำนวนจำนวนน้ำนม
            int milkProduced = cow.getAgeYears() * 12 + cow.getAgeMonths();
            result += "\nMilk produced: " + milkProduced + " liters.";
            return result;
        }
    }
}