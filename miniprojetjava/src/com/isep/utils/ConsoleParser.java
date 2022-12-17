package com.isep.utils;

import javax.swing.*;

import java.awt.*;

public class ConsoleParser implements InputParser{


    public class GameWindow {
        public static void main(String[] args) {
            // Crée une nouvelle fenêtre en utilisant la classe JFrame
            JFrame window = new JFrame();
            window.setTitle("Mon super jeu"); // Définit le titre de la fenêtre
            window.setSize(500, 500); // Définit la taille de la fenêtre
            window.setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Définit l'opération par défaut lorsque l'utilisateur ferme la fenêtre
            window.setResizable(false); // Empêche l'utilisateur de redimensionner la fenêtre

            // Ajoute un composant à la fenêtre pour afficher le contenu du jeu
            JPanel gamePanel = new JPanel();
            gamePanel.setPreferredSize(new Dimension(500, 500)); // Définit la taille du composant
            window.add(gamePanel); // Ajoute le composant à la fenêtre

            // Affiche la fenêtre
            window.setVisible(true);
        }
    }

}
