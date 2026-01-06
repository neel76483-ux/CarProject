import javax.swing.*;
import java.util.ArrayList;

public class CarGUI {

    static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Car Management");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField brand = new JTextField();
        JTextField model = new JTextField();
        JTextField price = new JTextField();
        JTextArea output = new JTextArea();

        JButton add = new JButton("Add Car");
        JButton view = new JButton("View Cars");

        add.addActionListener(e -> {
            cars.add(new Car(
                    brand.getText(),
                    model.getText(),
                    Double.parseDouble(price.getText())
            ));
            output.setText("Car added.");
        });

        view.addActionListener(e -> {
            output.setText("");
            for (Car c : cars) {
                output.append(c.getBrand() + "\n");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Brand"));
        panel.add(brand);
        panel.add(new JLabel("Model"));
        panel.add(model);
        panel.add(new JLabel("Price"));
        panel.add(price);
        panel.add(add);
        panel.add(view);
        panel.add(new JScrollPane(output));

        frame.add(panel);
        frame.setVisible(true);
    }
}

