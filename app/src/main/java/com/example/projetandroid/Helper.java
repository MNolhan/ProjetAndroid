package com.example.projetandroid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Helper {

    public static class Question implements Serializable {
        public String question;
        public String[] options;
        public int correctIndex;

        public Question(String question, String[] options, int correctIndex) {
            this.question = question;
            this.options = options;
            this.correctIndex = correctIndex;
        }

        public String getBonneReponse() {
            return options[correctIndex];
        }
    }

    private static final String[][] RAW_DATA = {
            {"Quel est le roi emblématique de la légende arthurienne ?", "Arthur", "Lancelot", "Charlemagne", "0"},
            {"Quelle est l'arme emblématique d'un chevalier ?", "Lance", "Épée", "Hache", "1"},
            {"Que protège un bouclier ?", "Le roi", "Le corps", "La tête", "1"},
            {"Quel animal est souvent associé à la royauté ?", "Le dragon", "Le lion", "Le loup", "1"},
            {"Quel matériaux compose une armure ?", "Fer", "Cuir", "Bois", "0"},
            {"Où se déroule le Hellfest ?", "Paris", "Lyon", "Clisson", "2"},
            {"Quel genre musical est principalement représenté au Hellfest ?", "Rock", "Métal", "Jazz", "1"},
            {"Quelle boisson est souvent associée à l’ambiance du Hellfest ?", "Bière", "Vin rouge", "Eau gazeuse", "0"},
            {"Quel élément emblématique est souvent visible sur scène au Hellfest ?", "Croix en feu", "Flammes et pyrotechnie", "Confettis colorés", "1"},
            {"Quel accessoire est courant dans le public du Hellfest ?", "Couronne de fleurs", "T-shirt noir", "Casquette rouge", "1"}
    };

    public static List<Question> getRandomQuestions(int count) {
        List<Question> questions = new ArrayList<>();
        for (String[] row : RAW_DATA) {
            String question = row[0];
            String[] options = new String[row.length - 2];
            System.arraycopy(row, 1, options, 0, options.length);
            int correctIndex = Integer.parseInt(row[row.length - 1]);
            questions.add(new Question(question, options, correctIndex));
        }
        Collections.shuffle(questions);
        return questions.subList(0, Math.min(count, questions.size()));
    }
}
