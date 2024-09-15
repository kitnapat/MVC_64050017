public class Main {
    public static void main(String[] args) {
        String filePath = "animals.csv";
        AnimalModel model = new AnimalModel(filePath);
        AnimalView view = new AnimalView();
        AnimalController controller = new AnimalController(model, view, filePath);

        view.setVisible(true);
    }
}