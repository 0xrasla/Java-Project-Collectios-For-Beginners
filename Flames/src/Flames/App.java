package Flames;

import java.util.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class App {
    public static void main(String[] args) throws Exception {
        // findRelation();
        makeGUI();
    }

    public static List<String> sanitizeData(String male, String female) {

        String[] maleList = male.toLowerCase().split("");
        String[] femaleList = female.toLowerCase().split("");

        List<String> maleli = new ArrayList<>(Arrays.asList(maleList));
        List<String> femaleli = new ArrayList<>(Arrays.asList(femaleList));

        for (String i : maleList) {
            if (femaleli.contains(i)) {
                maleli.remove(i);
                femaleli.remove(i);
            }
        }

        List<String> remainingLetters = new ArrayList<String>(maleli);
        remainingLetters.addAll(femaleli);

        return findRelation(remainingLetters.size());
    }

    public static List<String> findRelation(int count) {
        List<String> relations = new ArrayList<>(Arrays.asList("FLAMES".split("")));

        int index = 0;
        while (relations.size() > 1) {
            for (int i = 0; i < count; i++) {
                index++;
                if (index > relations.size()) {
                    index = 1;
                }
            }
            relations.remove(index - 1);
            index -= 1;
        }

        String relation = "";
        switch (relations.get(0)) {
            case "F":
                relation = "Friend";
                break;
            case "L":
                relation = "Love";
                break;
            case "A":
                relation = "Affection";
                break;
            case "M":
                relation = "Marriage";
                break;
            case "E":
                relation = "Enemy";
                break;
            case "S":
                relation = "Sister";
                break;
        }

        relations.add(1, relation);

        return relations;
    }

    public static void makeGUI() {
        JFrame f = new JFrame("Flames");

        JTextField maleField = new JTextField();
        JTextField femaleField = new JTextField();

        JLabel maleLabel = new JLabel("Your Name");
        JLabel femaleLabel = new JLabel("Partners Name");
        JLabel relationLabel = new JLabel("");

        Font font = new Font("Hermit", Font.BOLD, 15);

        maleField.setBounds(200, 100, 200, 30);
        femaleField.setBounds(200, 160, 200, 30);
        maleLabel.setBounds(200, 70, 200, 30);
        femaleLabel.setBounds(200, 130, 200, 30);
        relationLabel.setBounds(70, 240, 600, 40);

        maleField.setFont(font);
        femaleField.setFont(font);

        f.add(relationLabel);
        f.setBackground(Color.BLACK);

        f.add(maleField);
        f.add(femaleField);
        f.add(maleLabel);
        f.add(femaleLabel);

        JButton butt = new JButton("Relation");

        butt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> rel = sanitizeData(maleField.getText(), femaleField.getText());

                relationLabel.setText("The Relation Between " + maleField.getText() + " and " + femaleField.getText()
                        + " ended up with " + rel.get(1));
            }
        });

        butt.setBounds(200, 200, 90, 40);
        f.add(butt);

        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
    }
}
