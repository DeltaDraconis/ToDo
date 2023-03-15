import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoList extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton addButton;
    private JButton deleteButton;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    public TodoList() {
        // Ustawienia okna
        setTitle("Todo List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tworzenie komponentów
        textField = new JTextField();
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Dodawanie komponentów do kontenerów
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);
        panel.add(deleteButton, BorderLayout.WEST);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);

        // Wyświetlanie okna
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = textField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                textField.setText("");
            }
        } else if (e.getSource() == deleteButton) {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        TodoList app = new TodoList();
    }
}
