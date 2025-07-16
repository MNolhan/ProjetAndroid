# 📱 Application Android – Quiz Médiéval

Une application de quiz interactive réalisée en Java, proposant 5 questions à choix multiples sur la légende arthurienne, l’univers médiéval et le Hellfest (🎸).

---

## 🧱 Architecture du projet

```
projet-android/
├── app/
│   ├── java/com/example/projetandroid/
│   │   ├── MainActivity.java        
│   │   ├── Quizz.java               
│   │   ├── Resultat.java            
│   │   ├── Helper.java              
│   └── res/
│       ├── layout/
│       │   ├── activity_main.xml
│       │   ├── activity_quizz.xml
│       │   └── activity_resultat.xml
│       └── values/
│           ├── strings.xml
│           └── themes.xml (+ themes-night.xml)
```

---

## ⚙️ Fonctionnalités

- 👤 **Saisie du prénom** (enregistrée via `SharedPreferences`)
- 🧠 **Quiz avec 5 questions aléatoires**
- ✅ **1 bonne réponse = 1 point**
- 🧾 **Score final affiché + message personnalisé**
- 🏅 **Meilleur score enregistré et affiché**
- 🌗 **Mode clair / sombre dynamique**
- ⏱ **Chronomètre intégré pour la partie**
- 🖼️ **Logo sur l’écran d’accueil**
- 🔁 **Bouton pour recommencer le quiz**
- 🧹 **Bouton pour effacer les préférences**
- 🇫🇷 **Application en français**

---

## ▶️ Lancer l'application

1. **Cloner le projet** ou ouvrir le dossier dans **Android Studio**.
2. Assurez-vous que vous avez un **émulateur** Android configuré ou un **appareil connecté**.
3. Cliquez sur ▶️ **Run** dans Android Studio.
4. L’application démarre sur l’écran d’accueil.

> 📝 *Min SDK recommandé :* **API 21+ (Android 5.0+)**

---

## 🙌 Réalisé par

Nolhan et Isaac, étudiants à l’ESGI 📱
