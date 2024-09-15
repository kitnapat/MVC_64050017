import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AnimalView extends JFrame {
    private JTextField codeInput = new JTextField(10);
    private JButton submitButton = new JButton("Submit Code");

    private JTextArea cowResultArea = new JTextArea(10, 20);
    private JTextArea goatResultArea = new JTextArea(10, 20);

    public AnimalView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Animal Code:"));
        inputPanel.add(codeInput);
        inputPanel.add(submitButton);

        JPanel resultPanel = new JPanel(new GridBagLayout());

        JPanel cowPanel = new JPanel(new BorderLayout());
        cowPanel.setBorder(BorderFactory.createTitledBorder("Cow Results"));
        cowPanel.add(new JScrollPane(cowResultArea), BorderLayout.CENTER);

        JPanel goatPanel = new JPanel(new BorderLayout());
        goatPanel.setBorder(BorderFactory.createTitledBorder("Goat Results"));
        goatPanel.add(new JScrollPane(goatResultArea), BorderLayout.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        this.add(inputPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 5); 
        this.add(cowPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 5, 10, 10); 
        this.add(goatPanel, gbc);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
    }

    public String getCode() {
        return codeInput.getText();
    }

    public void setSubmitButtonListener(ActionListener actionListener) {
        submitButton.addActionListener(actionListener);
    }

    public void setCowResult(String result) {
        cowResultArea.setText(result);
    }

    public void setGoatResult(String result) {
        goatResultArea.setText(result);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
