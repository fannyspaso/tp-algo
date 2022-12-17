package com.isep.java.isep.jfx;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;


class FenetreUn extends JFrame {

    public FenetreUn() {

        // créer la fenêtre
        setTitle("Jeu RPG");
        setSize(600, 600);

        // ajouter le bouton
        JButton startGameButton = new JButton("Lancer le RPG !");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ouvrir la deuxième fenêtre lorsque l'utilisateur clique sur le bouton
                new FenetreDeux().setVisible(true);
            }
        });
        add(startGameButton);
    }

    public static void main(String[] args) {
        new FenetreUn().setVisible(true);
    }

}

class FenetreDeux extends JFrame {

    public FenetreDeux() {
        // créer la fenêtre
        setTitle("Votre sélection de héros");
        setSize(600, 600);
// ajouter le bouton

        // Créez un JPanel pour contenir les champs de texte
        JPanel panel = new JPanel();


// Créez un JTextField pour le nombre de héros
        JTextField heroesNumberField = new JTextField(5);
        panel.add(new JLabel("Choisissez le nombre de héros :"));
        panel.add(heroesNumberField);
        add(panel);

        JButton startGameButton1 = new JButton("OK !");

        startGameButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // ouvrir la deuxième fenêtre lorsque l'utilisateur clique sur le bouton
                new FenetreTrois().setVisible(true);
            }
        });
        add(startGameButton1);
}

    public static void main(String[] args) {
        new FenetreDeux().setVisible(true);
    }
    }


class FenetreTrois extends JFrame {

       public FenetreTrois() {
           // créer la fenêtre
           setTitle("Votre sélection de héros");
           setSize(600, 600);

           // Créez un JPanel pour contenir les champs de texte
           JPanel panel1 = new JPanel();

// Créez un JTextField pour le nom du héros
        JTextField heroNameField1 = new JTextField(20);
        panel1.add(new JLabel("Nom du héros :"));
        panel1.add(heroNameField1);


// Ajoutez le JPanel à votre interface graphique
        add(panel1);

    }
}