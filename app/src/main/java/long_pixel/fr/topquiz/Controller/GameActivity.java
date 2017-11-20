package long_pixel.fr.topquiz.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import long_pixel.fr.topquiz.Model.Question;
import long_pixel.fr.topquiz.Model.QuestionBank;
import long_pixel.fr.topquiz.R;

/**
 * Created by Clou on 22/09/2017.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    @Override
    public void onClick(View view) {
        int reponseIndex = (int) view.getTag();

        if(reponseIndex == mCurrentQuestion.getAnswerIndex()){
            // bonne question
            Toast.makeText(this, "Bien joué", Toast.LENGTH_SHORT).show();
            mScore++;
        }
        else {
            // mauvaise réponse
            Toast.makeText(this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
        }
        if (--mNumberOfQuestions == 0){
            //end the game
            endGame();
        }
        else{
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bravo !")
                .setMessage("Vous avez fait " + mScore + "/10")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //end the activity
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .create()
                .show();
    }

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_quizz);

        mQuestionBank = this.generateQuestion();

        mScore =0;
        mNumberOfQuestions = 10;

        //Wire widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        //Use the tag property to 'name' the Buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

    }

    private void displayQuestion(final Question question){
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));
    }

    private QuestionBank generateQuestion(){
        Question question1 = new Question("Qu'est ce qu'une String ?", Arrays.asList("Un entier", "Une châine de caractère", "Un sous-vetement", "Une corde"), 1);
        Question question2 = new Question("Qu'elle méthode s'execute dans l'activity quand on clique sur le bouton Home ?", Arrays.asList("onPause()", "onStarted", "onResume()", "OnStopped"), 0);
        Question question3 = new Question("parmi ces quatre méthodes, laquel permet de recupérer un id d'un layout ?", Arrays.asList("onClickListener()", "myLayoutId()", "getDrawable()", "findViewById()"), 3);
        Question question4 = new Question("Qu'est ce qu'une vue/view ?", Arrays.asList("Un type de variable", "Une petite long-vue", "Un element graphique du layout", "Une valeur"), 2);
        Question question5 = new Question("Quelle classe Android permet d’afficher à l’utilisateur un message éphémère en bas de l'écran ?", Arrays.asList("Popup", "Message", "Notification", "Toast"),3);
        Question question6 = new Question("Quelle classe Android permet d’afficher une boîte de dialogue à l’utilisateur ?", Arrays.asList("AlertDialog", "NotificationWindow", "AlertView", "OverlayMessage"), 0);
        Question question7 = new Question("Quelle classe permet de préciser les paramètres d’une nouvelle activité à créer ?", Arrays.asList("ActivityInfo", "Intent", "ActivityLayout", "ViewParam"), 1);
        Question question8 = new Question("Quelle classe permet de sauvegarder des donnés sur le mobile de l'utilisateur", Arrays.asList("SaveData", "PreferencesData", "SharedPreferences", "SavePreferences"), 2);
        Question question9 = new Question("Laquelle de ces phrases est correcte ?", Arrays.asList("Le dossier mipmap permet de gérer le sitemap", "un fragment est un morceau de code", "Batman est le justicier de Gotham City", "une constante est une class qui ne compile pas"), 2);
        Question question10 = new Question("L’adapter d’une RecyclerView est l’objet responsable de ", Arrays.asList("De la création des vues des cellules et de leur remplissage", "De l’affichage des cellules les unes à la suite des autres", "Du clic sur les cellules", "De la gestion de la RecyclerView au sein de son environnement"), 0);
        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10));
    }


}
