package com.example.projetandroid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Helper {

    public static class Question {
        public String question;
        public String[] options;
        public int correctIndex;

        public Question(String question, String[] options, int correctIndex) {
            this.question = question;
            this.options = options;
            this.correctIndex = correctIndex;
        }
    }

    public static List<Question> getRandomQuestions(int count) {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Quel est le roi emblématique de la légende arthurienne ?",
                new String[]{"Arthur", "Lancelot", "Charlemagne"}, 0));

        questions.add(new Question("Quelle est l'arme emblématique d'un chevalier ?",
                new String[]{"Lance", "Épée", "Hache"}, 1));

        questions.add(new Question("Que protège un bouclier ?",
                new String[]{"Le roi", "Le corps", "La tête"}, 1));

        questions.add(new Question("Quel animal est souvent associé à la royauté ?",
                new String[]{"Le dragon", "Le lion", "Le loup"}, 1));

        questions.add(new Question("Quel matériaux compose une armure ?",
                new String[]{"Fer", "Cuir", "Bois"}, 0));

        questions.add(new Question("Où se déroule le Hellfest ?",
                new String[]{"Paris", "Lyon", "Clisson"}, 2));

        questions.add(new Question("Quel genre musical est principalement représenté au Hellfest ?",
                new String[]{"Rock", "Métal", "Jazz"}, 1));

        questions.add(new Question("Quelle boisson est souvent associée à l’ambiance du Hellfest ?",
                new String[]{"Bière", "Vin rouge", "Eau gazeuse"}, 0));

        questions.add(new Question("Quel élément emblématique est souvent visible sur scène au Hellfest ?",
                new String[]{"Croix en feu", "Flammes et pyrotechnie", "Confettis colorés"}, 1));

        questions.add(new Question("Quel accessoire est courant dans le public du Hellfest ?",
                new String[]{"Couronne de fleurs", "T-shirt noir", "Casquette rouge"}, 1));


        Collections.shuffle(questions);
        return questions.subList(0, Math.min(count, questions.size()));
    }
}
