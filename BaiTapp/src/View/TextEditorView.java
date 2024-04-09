package View;

import Controller.TextEditorController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import Model.TextEditorModel;

public class TextEditorView extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;

    public TextEditorView() {
        setTitle("Text Editor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        clearButton = new JButton("Clear");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public void updateTextArea(List<String> lines) {
        textArea.setText("");
        for (String line : lines) {
            textArea.append(line + "\n");
        }
    }

    public void clearTextArea() {
        textArea.setText("");
    }

    public static void main(String[] args) {
        TextEditorModel model = new TextEditorModel();
        TextEditorView view = new TextEditorView();
        TextEditorController controller = new TextEditorController(model, view);

        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }
}