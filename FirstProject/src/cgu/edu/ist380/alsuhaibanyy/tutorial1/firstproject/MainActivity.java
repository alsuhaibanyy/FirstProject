package cgu.edu.ist380.alsuhaibanyy.tutorial1.firstproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private int currentQuestion = 0; 
	private int correctAnswers = 0; 
	private String [] questions; 
	private String [] answers;
	
	private Button answerButton; 
	private Button questionButton; 
	private TextView questionView; 
	private TextView answerView; 
	private TextView result; 
	private EditText answerText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	public void init() {
		questions = new String[]{"0 + 1 ?","1 + 1 ?","1 + 2 ?","3 + 1 ?","3 + 2 ?","4 + 2 ?","5 + 2 ?"};
		answers = new String[]{"1","2","3","4","5","6","7"};
		//currentQuestion = -1;
		answerButton = (Button)findViewById(R.id.AnswerButton); 
		questionButton = (Button)findViewById(R.id.QuestionButton); 
		questionView = (TextView)findViewById(R.id.QuestionTextView);
		answerView = (TextView) findViewById(R.id.AnswerTextView); 
		result = (TextView) findViewById(R.id.Result);
		answerText = (EditText) findViewById(R.id.AnswerText); 
		
		answerButton.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v) { checkAnswer();
		}});
		questionButton.setOnClickListener(new OnClickListener(){ 
			@Override
		public void onClick(View v) 
			{ showQuestion();	}
			});
		
		questionView.setText(questions[currentQuestion]); 
		result.setText("Your score 0 / 0"); 
		questionButton.setEnabled(false);
		
		}
		
		/* this method :
		* 1: Read the text ( answer) from the answerTextEdit * 2: call the isCorrect method
		* 3: display the appropriate message.
		*/
		public void checkAnswer() {
		String answer = answerText.getText().toString(); 
		if(isCorrect(answer))
		{
			answerView.setText("You're right!"); 
			correctAnswers++;
			answerView.setBackgroundColor(0xff00ff00);
		}
		else
		{
			answerView.setText("Sorry, the correct answer is "+answers[currentQuestion]);
			answerView.setBackgroundColor(0xffff0000);
		}
		result.setText("Your score "+correctAnswers+" / "+(currentQuestion+1)); 
		questionButton.setEnabled(true);
		answerButton.setEnabled(false);
		}
	
		/*
		* This method
		* 1: increment currentQuestion index
		* 2: check if it is equal to the size of the array and rest if necessary
		* 3: display the question at currentQuestion index in question view
		* 4: Empty answer view
		*/
		public void showQuestion() {
		currentQuestion++;
		if(currentQuestion == questions.length)
		{
			currentQuestion = 0;
			correctAnswers = 0; 
			result.setText("Your score 0 / 0"); 
		}
		questionView.setText(questions[currentQuestion]); 
		answerView.setText("");
		answerText.setText("");
		answerButton.setEnabled(true);
		questionButton.setEnabled(false);
		answerView.setBackgroundColor(0000000000);
		}
		/*
		* This method return true if the answer equals to correct
		answer
		* (Ignoring case)
		*/
		public boolean isCorrect(String answer) {
		return (answer.equalsIgnoreCase(answers[currentQuestion])); }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
