import java.util.*;

public class quizapplicationwtimer 
{  
    // time limit set to 15 seconds, it's define private to restrict access of the variable(Time_Limit) only within the class
    // also defined static to ensures that the variable belongs to the class , not an instance
    
    private static final int Time_Limit = 15 ; 
    private int score = 0 ;
    private Scanner sc = new Scanner(System.in);

    // Stores correct/incorrect summary for each question
    public List<String> resultSummary = new ArrayList<>();


    public void  questions()
    {
       System.out.println("Welcome to Java Quiz ! You have "+Time_Limit+" seconds per question.\n");
       
       
       askQuestion("1. What is the default value of a boolean variable in Java?", 
        "(a) True" ,  "(b) False " , "(c) null " ,  "(d) 0 " , 'b');

       askQuestion("2. Which Java feature allows multiple methods with the same name but different parameters?", 
        "(a) Method Overloading " , "(b) Method Overriding " , "(c) Inheritance" , "(d) Polymorphism " , 'a');
       
       askQuestion("3. How do you handle Exceptions in java ?",
        "(a) try-catch" ,  "(b) throw" , "(c)  throws" , "(d) All of the above ",'d');

       askQuestion("4. What will System.out.println( 'Hello' + 5 + 3); print?",
        "(a) Hello53" , "(b) Hello" , "(c) Hello3.0" , "(d) Compilation Error" , 'a');

       askQuestion("5. What is the superclass of all classes in Java?" ,
        "(a) Object" ,  "(b) Main" , "(c) Parent" , "(d) Base" , 'a');

       System.out.println("\nQuiz Over! Your final score: "+ score + "/5");

       System.out.println("\n        'Summary of Your Answers'       ");
       for (int i = 0; i < resultSummary.size(); i++) 
       {
        System.out.println(resultSummary.get(i));
       }

       sc.close();
    }  

    // function to ask questions with timer
       private void askQuestion(String question ,String Option1 , String Option2 , String Option3 , String Option4 , char correct_answer)
      {
        System.out.println('\n' + question);
        System.out.println(Option1);
        System.out.println(Option2);
        System.out.println(Option3);
        System.out.println(Option4);

        Timer timer = new Timer(); //creates a timer to track  time limit
        final boolean[] answered = {false}; //tracks the user answered

        TimerTask task = new TimerTask() 
        {
            public void run() //runs if time limit expires
            {
                if(!answered[0])  // when not answered
                {
                    System.out.println("\n Time's up! Next Question..");
                    resultSummary.add( question + " - Skipped (Time's up!)");
                }

                  //  Synchronized = Ensures that main thread is waithing for user input , which get notified to continue execution
                synchronized (sc)
                {
                    sc.notify(); // notify() methord in synchronized to wake up a thread that is waiting (sc.wait()) for event to happen
                }
            }
        };

                //start the timer
                timer.schedule(task, Time_Limit * 1000); //set timer (converted to milliseconds)
            
                System.out.println("Your answer : ");

                synchronized (sc) 
                {
                    String userAnswer = sc.nextLine().trim().toLowerCase();
                    answered[0] = true; //tells user has answered
                    timer.cancel(); //stop the timer

                     if (!userAnswer.isEmpty() && userAnswer.charAt(0) == correct_answer) 
                     {
                        System.out.println(" Correct!");
                        score++;  // Only increase score if the answer is correct
                        resultSummary.add(  question + " - Correct!"); // Store result
                     } 
                     else if (!userAnswer.isEmpty()) 
                    {
                        System.out.println(" Wrong! The correct answer was: " + correct_answer);
                        resultSummary.add(question + " - Wrong (Your Answer: " + userAnswer + ")");
                    }
                }

           }
        
    public static void main(String[] args)
    {
        quizapplicationwtimer quiz = new quizapplicationwtimer();
        quiz.questions();

    }
    
}

