import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Quiz extends JFrame implements ActionListener {

    String userName;

    // panel6 components
    public static JButton cQuiz, javaQuiz, pythonQuiz , backP6;
    public static JLabel chooseSub ;
    public static JPanel panel6;

    // panel7 components
    static JPanel panel7;
    static JLabel rulesLabel;
    static JTextArea textArea;
    JCheckBox acceptCheckBox;
    static JButton backP7,nextP7;

    // panel8 components
    public static JButton readyButtonP8,backP8;
    public static JLabel WelcomeUser ,subjectLabel, totalQues,  subjectName, NumberOfQuestionsLabel, readyLabel;
    public static JPanel panel8;

    // cpp panel1 components
    public static JButton cppQuizNextP1;
    public static JRadioButton cppQuizOption1P1, cppQuizOption2P1, cppQuizOption3P1, cppQuizOption4P1;
    public static ButtonGroup cppQuizGroupRadio1P1;
    public static JLabel cppQuizQuesP1, cppQuizTitleP1;
    public static JPanel cppQuizP1;
    public static int cppQuizScore = 0;

    // cpp panel2 components
    public static JButton cppQuizNextP2;
    public static JRadioButton cppQuizOption1P2, cppQuizOption2P2, cppQuizOption3P2, cppQuizOption4P2;
    public static ButtonGroup cppQuizGroupRadio1P2;
    public static JLabel cppQuizQuesP2, cppQuizTitleP2;
    public static JPanel cppQuizP2;
    // cpp panel3 components
    public static JButton cppQuizSubmitP3;
    public static JRadioButton cppQuizOption1P3, cppQuizOption2P3, cppQuizOption3P3, cppQuizOption4P3;
    public static ButtonGroup cppQuizGroupRadio1P3;
    public static JLabel cppQuizQuesP3, cppQuizTitleP3;
    public static JPanel cppQuizP3;

    // Java panel1 components
    public static JButton javaQuizNextP1;
    public static JRadioButton javaQuizOption1P1, javaQuizOption2P1, javaQuizOption3P1, javaQuizOption4P1;
    public static ButtonGroup javaQuizGroupRadio1P1;
    public static JLabel javaQuizQuesP1, javaQuizTitleP1;
    public static JPanel javaQuizP1;
    public static int javaQuizScore = 0;

    // Java panel2 components
    public static JButton javaQuizNextP2;
    public static JRadioButton javaQuizOption1P2, javaQuizOption2P2, javaQuizOption3P2, javaQuizOption4P2;
    public static ButtonGroup javaQuizGroupRadio1P2;
    public static JLabel javaQuizQuesP2, javaQuizTitleP2;
    public static JPanel javaQuizP2;

    // Java panel3 components
    public static JButton javaQuizSubmitP3;
    public static JRadioButton javaQuizOption1P3, javaQuizOption2P3, javaQuizOption3P3, javaQuizOption4P3;
    public static ButtonGroup javaQuizGroupRadio1P3;
    public static JLabel javaQuizQuesP3, javaQuizTitleP3;
    public static JPanel javaQuizP3;

    // Python panel1 components
    public static JButton pythonQuizNextP1;
    public static JRadioButton pythonQuizOption1P1, pythonQuizOption2P1, pythonQuizOption3P1, pythonQuizOption4P1;
    public static ButtonGroup pythonQuizGroupRadio1P1;
    public static JLabel pythonQuizQuesP1, pythonQuizTitleP1;
    public static JPanel pythonQuizP1;
    public static int pythonQuizScore = 0;

    // Python panel2 components
    public static JButton pythonQuizNextP2;
    public static JRadioButton pythonQuizOption1P2, pythonQuizOption2P2, pythonQuizOption3P2, pythonQuizOption4P2;
    public static ButtonGroup pythonQuizGroupRadio1P2;
    public static JLabel pythonQuizQuesP2, pythonQuizTitleP2;
    public static JPanel pythonQuizP2;

    // Python panel3 components
    public static JButton pythonQuizSubmitP3;
    public static JRadioButton pythonQuizOption1P3, pythonQuizOption2P3, pythonQuizOption3P3, pythonQuizOption4P3;
    public static ButtonGroup pythonQuizGroupRadio1P3;
    public static JLabel pythonQuizQuesP3, pythonQuizTitleP3;
    public static JPanel pythonQuizP3;

    // panel11 components
    static JPanel panel11;
    static JLabel quizResultP11, scoreLabelP11, userScoreP11,statusLabelP11, userStatusP11;
    static JButton mainMenuP11;

    // Java Panel2 componenets
    static JPanel cpP1;


    Quiz(String userName) {
        setSize(800, 700);
        setTitle("CodePro Certification System");
        setLayout(null);
        setLocation(320, 10);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(false);
        setResizable(false);

        this.userName = userName;

//        --------------------------- Panel 6 -----------------------------
        panel6 = new JPanel() ;
        panel6.setLayout(null);
        panel6.setBounds(0, 0, 800, 700);
        panel6.setOpaque(false);

        chooseSub = new JLabel("Choose Subject For Quiz");
        chooseSub.setHorizontalTextPosition(JLabel.CENTER);
        chooseSub.setBounds(225, 30, 600, 40);
        chooseSub.setFont(new Font("Candara", Font.BOLD, 30));
        panel6.add(chooseSub);
        add(panel6) ;

        cQuiz = new JButton("C++ Quiz") ;
        cQuiz.setBounds(260, 150, 250, 30);
        cQuiz.setFont(new Font("Candara", Font.BOLD, 20));
        cQuiz.setFocusable(false);
        cQuiz.addActionListener(this);
        panel6.add(cQuiz);

        javaQuiz = new JButton("Java Quiz") ;
        javaQuiz.setBounds(260, 250, 250, 30);
        javaQuiz.setFont(new Font("Candara", Font.BOLD, 20));
        javaQuiz.setFocusable(false);
        javaQuiz.addActionListener(this);
        panel6.add(javaQuiz);

        pythonQuiz = new JButton("Python Quiz") ;
        pythonQuiz.setBounds(260, 350, 250, 30);
        pythonQuiz.setFont(new Font("Candara", Font.BOLD, 20));
        pythonQuiz.setFocusable(false);
        pythonQuiz.addActionListener(this);
        panel6.add(pythonQuiz);

        backP6 = new JButton("Back") ;
        backP6.setBounds(540, 550, 100, 32);
        backP6.setFont(new Font("Candara", Font.BOLD, 20));
        backP6.addActionListener(this);
        panel6.add(backP6);

//        --------------------------- Panel 7 -----------------------------
        panel7 = new JPanel();
        panel7.setBounds(0, 0, 800, 700);
        panel7.setOpaque(false);
        panel7.setLayout(null);
        add(panel7);

        // rules label on panel7
        rulesLabel = new JLabel("Rules");
        rulesLabel.setBounds(350,20 , 150,40);
        rulesLabel.setFont(new Font("Candara",Font.BOLD,36));
        panel7.add(rulesLabel);

        // text area on panel7 which displays the rules to the user
        textArea = new JTextArea();
        textArea.setBounds(10,150,800,300);
        textArea.setFont(new Font("Candara",Font.BOLD,20));
        textArea.setText("1) The user must choose an option before moving to the next question.\n\n" +
                "2) The user is only allowed one attempt per question.\n\n" +
                "3) The score will be displayed at the end of the quiz.\n\n" +
                "4) The user cannot go back to previous questions once they have moved on.\n\n" +
                "5) The user cannot change their answer once they have submitted it.");
        textArea.setEditable(false);
        panel7.add(textArea);

        // accept checkbox on panel7
        acceptCheckBox = new JCheckBox("I accept the rules and conditions.");
        acceptCheckBox.setBounds(30, 500, 300, 30);
        acceptCheckBox.setOpaque(false);
        acceptCheckBox.setFont(new Font("Candara",Font.BOLD,18));
        acceptCheckBox.addActionListener(this);
        panel7.add(acceptCheckBox);

        // back button on panel7
        backP7 = new JButton("Back") ;
        backP7.setBounds(530,550,100,36);
        backP7.setFont(new Font("Candara", Font.BOLD, 20));
        backP7.addActionListener(this);
        panel7.add(backP7);

        // next button on panel7
        nextP7 = new JButton("Next") ;
        nextP7.setBounds(650,550,100,36);
        nextP7.setFont(new Font("Candara", Font.BOLD, 20));
        nextP7.setEnabled(false);
        nextP7.addActionListener(this);
        panel7.add(nextP7);
        panel7.setVisible(false);

        //        ----------------------------- Panel 8 -----------------------------
        panel8 = new JPanel() ;
        panel8.setLayout(null);
        panel8.setSize( 800, 700);
        panel8.setOpaque(false);
        add(panel8);

        // welcome user label on panel8
        WelcomeUser = new JLabel("Welcome User!");
        WelcomeUser.setBounds(285, 20, 250, 40);
        WelcomeUser.setFont(new Font("Candara", Font.BOLD, 35));
        panel8.add(WelcomeUser);

        // subject selected label on panel8
        subjectLabel = new JLabel("Subject Selected");
        subjectLabel.setBounds(150, 130, 250, 40);
        subjectLabel.setFont(new Font("Candara", Font.BOLD, 26));
        panel8.add(subjectLabel);

        // total questions label on panel8
        totalQues = new JLabel("Total Questions");
        totalQues.setBounds(150, 190, 250, 40);
        totalQues.setFont(new Font("Candara", Font.BOLD, 26));
        panel8.add(totalQues);

        // subject name label on panel8
        subjectName = new JLabel();
        subjectName.setBounds(390, 130, 250, 40);
        subjectName.setFont(new Font("Candara", Font.PLAIN, 26));
        panel8.add(subjectName);

        // number of questions label on panel8
        NumberOfQuestionsLabel = new JLabel("3");
        NumberOfQuestionsLabel.setBounds(390, 190, 250, 40);
        NumberOfQuestionsLabel.setFont(new Font("Candara", Font.PLAIN, 26));
        panel8.add(NumberOfQuestionsLabel);


        // are you ready for the quiz label on panel8
        readyLabel = new JLabel("Are you ready for the quiz?");
        readyLabel.setBounds(110, 310, 600, 60);
        readyLabel.setFont(new Font("Candara", Font.PLAIN, 50));
        panel8.add(readyLabel);

        // ready button on panel8
        readyButtonP8 = new JButton("Ready!") ;
        readyButtonP8.setBounds(400, 450, 150, 35);
        readyButtonP8.setFont(new Font("Candara", Font.BOLD, 20));
        readyButtonP8.setFocusable(false);
        readyButtonP8.addActionListener(this);
        panel8.add(readyButtonP8);

        // back button on panel8
        backP8 = new JButton("Back") ;
        backP8.setBounds(180, 450, 150, 35);
        backP8.setFont(new Font("Candara", Font.BOLD, 20));
        backP8.addActionListener(this);
        panel8.add(backP8);
        panel8.setVisible(false);

        //        ----------------------------- Cpp Panel 1 -----------------------------

        cppQuizP1 = new JPanel();
        cppQuizP1.setLayout(null);
        cppQuizP1.setSize(800, 700);
        cppQuizP1.setOpaque(false);
        add(cppQuizP1);

        // C++ Quiz label on cpp panel1
        cppQuizTitleP1 = new JLabel("C++ Quiz");
        cppQuizTitleP1.setBounds(300, 20, 800, 40);
        cppQuizTitleP1.setFont(new Font("Candara", Font.BOLD, 35));
        cppQuizP1.add(cppQuizTitleP1);

        // Question statement on cpp panel1
        cppQuizQuesP1 = new JLabel("What is the purpose of keyword 'const' in C++?");
        cppQuizQuesP1.setBounds(35, 150, 800, 40);
        cppQuizQuesP1.setFont(new Font("Candara", Font.BOLD, 27));
        cppQuizP1.add(cppQuizQuesP1);

        // option 1 on cpp panel1
        cppQuizOption1P1 = new JRadioButton("Declares a variable that can be modified");
        cppQuizOption1P1.setBounds(30,270,500,50);
        cppQuizOption1P1.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption1P1.setForeground(Color.blue);
        cppQuizOption1P1.setOpaque(false);
        cppQuizP1.add(cppQuizOption1P1);

        // option 2 on cpp panel1
        cppQuizOption2P1 = new JRadioButton("Declares a variable that cannot be modified");
        cppQuizOption2P1.setBounds(30,330,500,50);
        cppQuizOption2P1.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption2P1.setForeground(Color.blue);
        cppQuizOption2P1.setOpaque(false);
        cppQuizP1.add(cppQuizOption2P1);

        // option 3 on cpp panel1
        cppQuizOption3P1 = new JRadioButton("Used to declare an overridden function");
        cppQuizOption3P1.setBounds(30,390,500,50);
        cppQuizOption3P1.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption3P1.setForeground(Color.blue);
        cppQuizOption3P1.setOpaque(false);
        cppQuizP1.add(cppQuizOption3P1);

        // option 4 on cpp panel1
        cppQuizOption4P1 = new JRadioButton("Declares a variable that can be accessed from anywhere");
        cppQuizOption4P1.setBounds(30,450,500,50);
        cppQuizOption4P1.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption4P1.setForeground(Color.blue);
        cppQuizOption4P1.setOpaque(false);
        cppQuizP1.add(cppQuizOption4P1);

        // radio button group on cpp panel1
        cppQuizGroupRadio1P1 = new ButtonGroup() ;
        cppQuizGroupRadio1P1.add(cppQuizOption1P1) ;
        cppQuizGroupRadio1P1.add(cppQuizOption2P1) ;
        cppQuizGroupRadio1P1.add(cppQuizOption3P1) ;
        cppQuizGroupRadio1P1.add(cppQuizOption4P1) ;

        // next button on cpp panel1
        cppQuizNextP1 = new JButton("Next") ;
        cppQuizNextP1.setBounds(580,550,150,50);
        cppQuizNextP1.setFont(new Font("Candara", Font.BOLD, 20));
        cppQuizNextP1.addActionListener(this);
        cppQuizP1.add(cppQuizNextP1);
        cppQuizP1.setVisible(false);

        //        ----------------------------- Cpp Panel 2 -----------------------------

        cppQuizP2 = new JPanel();
        cppQuizP2.setLayout(null);
        cppQuizP2.setSize(800, 700);
        cppQuizP2.setOpaque(false);
        add(cppQuizP2);

        // C++ Quiz label on cpp panel2
        cppQuizTitleP2 = new JLabel("C++ Quiz");
        cppQuizTitleP2.setBounds(300, 20, 800, 40);
        cppQuizTitleP2.setFont(new Font("Candara", Font.BOLD, 35));
        cppQuizP2.add(cppQuizTitleP2);

        // Question statement on cpp panel2
        cppQuizQuesP2 = new JLabel("What is the purpose of 'virtual' keyword in C++?");
        cppQuizQuesP2.setBounds(35, 150, 800, 40);
        cppQuizQuesP2.setFont(new Font("Candara", Font.BOLD, 27));
        cppQuizP2.add(cppQuizQuesP2);

        // option 1 on cpp panel2
        cppQuizOption1P2 = new JRadioButton("Declares a variable that can be overriden");
        cppQuizOption1P2.setBounds(30,270,500,50);
        cppQuizOption1P2.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption1P2.setForeground(Color.blue);
        cppQuizOption1P2.setOpaque(false);
        cppQuizP2.add(cppQuizOption1P2);

        // option 2 on cpp panel2
        cppQuizOption2P2 = new JRadioButton("Declares a function that can be overloaded");
        cppQuizOption2P2.setBounds(30,330,500,50);
        cppQuizOption2P2.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption2P2.setForeground(Color.blue);
        cppQuizOption2P2.setOpaque(false);
        cppQuizP2.add(cppQuizOption2P2);

        // option 3 on cpp panel2
        cppQuizOption3P2 = new JRadioButton("Declares a function that can be overridden in a derived class");
        cppQuizOption3P2.setBounds(30,390,500,50);
        cppQuizOption3P2.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption3P2.setForeground(Color.blue);
        cppQuizOption3P2.setOpaque(false);
        cppQuizP2.add(cppQuizOption3P2);

        // option 4 on cpp panel2
        cppQuizOption4P2 = new JRadioButton("Declares a class that can be inherited");
        cppQuizOption4P2.setBounds(30,450,550,50);
        cppQuizOption4P2.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption4P2.setForeground(Color.blue);
        cppQuizOption4P2.setOpaque(false);
        cppQuizP2.add(cppQuizOption4P2);

        // radio button group on cpp panel2
        cppQuizGroupRadio1P2 = new ButtonGroup() ;
        cppQuizGroupRadio1P2.add(cppQuizOption1P2) ;
        cppQuizGroupRadio1P2.add(cppQuizOption2P2) ;
        cppQuizGroupRadio1P2.add(cppQuizOption3P2) ;
        cppQuizGroupRadio1P2.add(cppQuizOption4P2) ;

        // next button on cpp panel2
        cppQuizNextP2 = new JButton("Next") ;
        cppQuizNextP2.setBounds(580,550,150,50);
        cppQuizNextP2.setFont(new Font("Candara", Font.BOLD, 20));
        cppQuizNextP2.addActionListener(this);
        cppQuizP2.add(cppQuizNextP2);
        cppQuizP2.setVisible(false);

        //        ----------------------------- Cpp Panel 3 -----------------------------

        cppQuizP3 = new JPanel();
        cppQuizP3.setLayout(null);
        cppQuizP3.setSize(800, 700);
        cppQuizP3.setOpaque(false);
        add(cppQuizP3);

        // C++ Quiz Label on cpp panel3
        cppQuizTitleP3 = new JLabel("C++ Quiz");
        cppQuizTitleP3.setBounds(300, 20, 800, 40);
        cppQuizTitleP3.setFont(new Font("Candara", Font.BOLD, 35));
        cppQuizP3.add(cppQuizTitleP3);

        // Question statement on cpp panel3
        cppQuizQuesP3 = new JLabel("How is memory allocated for dynamically created objects in C++?");
        cppQuizQuesP3.setBounds(35, 150, 800, 40);
        cppQuizQuesP3.setFont(new Font("Candara", Font.BOLD, 27));
        cppQuizP3.add(cppQuizQuesP3);

        // option 1 on cpp panel3
        cppQuizOption1P3 = new JRadioButton("By using the 'malloc' function");
        cppQuizOption1P3.setBounds(30,270,500,50);
        cppQuizOption1P3.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption1P3.setForeground(Color.blue);
        cppQuizOption1P3.setOpaque(false);
        cppQuizP3.add(cppQuizOption1P3);

        // option 2 on cpp panel3
        cppQuizOption2P3 = new JRadioButton("By declaring them as global variables");
        cppQuizOption2P3.setBounds(30,330,500,50);
        cppQuizOption2P3.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption2P3.setForeground(Color.blue);
        cppQuizOption2P3.setOpaque(false);
        cppQuizP3.add(cppQuizOption2P3);

        // option 3 on cpp panel3
        cppQuizOption3P3 = new JRadioButton("By declaring them as static variables");
        cppQuizOption3P3.setBounds(30,390,500,50);
        cppQuizOption3P3.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption3P3.setForeground(Color.blue);
        cppQuizOption3P3.setOpaque(false);
        cppQuizP3.add(cppQuizOption3P3);

        // option 4 on cpp panel3
        cppQuizOption4P3 = new JRadioButton("By using the 'new' operator");
        cppQuizOption4P3.setBounds(30,450,500,50);
        cppQuizOption4P3.setFont(new Font("Candara",Font.PLAIN,20));
        cppQuizOption4P3.setForeground(Color.blue);
        cppQuizOption4P3.setOpaque(false);
        cppQuizP3.add(cppQuizOption4P3);

        // radio button group on cpp panel3
        cppQuizGroupRadio1P3 = new ButtonGroup() ;
        cppQuizGroupRadio1P3.add(cppQuizOption1P3) ;
        cppQuizGroupRadio1P3.add(cppQuizOption2P3) ;
        cppQuizGroupRadio1P3.add(cppQuizOption3P3) ;
        cppQuizGroupRadio1P3.add(cppQuizOption4P3) ;

        // submit button on cpp panel3
        cppQuizSubmitP3 = new JButton("Submit") ;
        cppQuizSubmitP3.setBounds(580,550,150,50);
        cppQuizSubmitP3.setFont(new Font("Candara", Font.BOLD, 20));
        cppQuizSubmitP3.addActionListener(this);
        cppQuizP3.add(cppQuizSubmitP3);
        cppQuizP3.setVisible(false);


        //        ----------------------------- Java Panel 1 -----------------------------

        javaQuizP1 = new JPanel();
        javaQuizP1.setLayout(null);
        javaQuizP1.setSize(800, 700);
        javaQuizP1.setOpaque(false);
        add(javaQuizP1);

        // Java Quiz label on Java panel1
        javaQuizTitleP1 = new JLabel("Java Quiz");
        javaQuizTitleP1.setBounds(300, 20, 800, 40);
        javaQuizTitleP1.setFont(new Font("Candara", Font.BOLD, 35));
        javaQuizP1.add(javaQuizTitleP1);

        // Question statement on Java panel1
        javaQuizQuesP1 = new JLabel("Which of the following is not a Java keyword?");
        javaQuizQuesP1.setBounds(35, 150, 800, 40);
        javaQuizQuesP1.setFont(new Font("Candara", Font.BOLD, 27));
        javaQuizP1.add(javaQuizQuesP1);

        // option 1 on Java panel1
        javaQuizOption1P1 = new JRadioButton("break");
        javaQuizOption1P1.setBounds(30,270,500,50);
        javaQuizOption1P1.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption1P1.setForeground(Color.blue);
        javaQuizOption1P1.setOpaque(false);
        javaQuizP1.add(javaQuizOption1P1);

        // option 2 on Java panel1
        javaQuizOption2P1 = new JRadioButton("function");
        javaQuizOption2P1.setBounds(30,330,500,50);
        javaQuizOption2P1.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption2P1.setForeground(Color.blue);
        javaQuizOption2P1.setOpaque(false);
        javaQuizP1.add(javaQuizOption2P1);

        // option 3 on Java panel1
        javaQuizOption3P1 = new JRadioButton("main");
        javaQuizOption3P1.setBounds(30,390,500,50);
        javaQuizOption3P1.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption3P1.setForeground(Color.blue);
        javaQuizOption3P1.setOpaque(false);
        javaQuizP1.add(javaQuizOption3P1);

        // option 4 on Java panel1
        javaQuizOption4P1 = new JRadioButton("void");
        javaQuizOption4P1.setBounds(30,450,500,50);
        javaQuizOption4P1.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption4P1.setForeground(Color.blue);
        javaQuizOption4P1.setOpaque(false);
        javaQuizP1.add(javaQuizOption4P1);

        // radio button group on Java panel1
        javaQuizGroupRadio1P1 = new ButtonGroup() ;
        javaQuizGroupRadio1P1.add(javaQuizOption1P1) ;
        javaQuizGroupRadio1P1.add(javaQuizOption2P1) ;
        javaQuizGroupRadio1P1.add(javaQuizOption3P1) ;
        javaQuizGroupRadio1P1.add(javaQuizOption4P1) ;

        // next button on Java panel1
        javaQuizNextP1 = new JButton("Next") ;
        javaQuizNextP1.setBounds(580,550,150,50);
        javaQuizNextP1.setFont(new Font("Candara", Font.BOLD, 20));
        javaQuizNextP1.addActionListener(this);
        javaQuizP1.add(javaQuizNextP1);
        javaQuizP1.setVisible(false);


        //        ----------------------------- Java Panel 2 -----------------------------

        javaQuizP2 = new JPanel();
        javaQuizP2.setLayout(null);
        javaQuizP2.setSize(800, 700);
        javaQuizP2.setOpaque(false);
        add(javaQuizP2);

        // Java Quiz label on java panel2
        javaQuizTitleP2 = new JLabel("Java Quiz");
        javaQuizTitleP2.setBounds(300, 20, 800, 40);
        javaQuizTitleP2.setFont(new Font("Candara", Font.BOLD, 35));
        javaQuizP2.add(javaQuizTitleP2);

        // Question statement on java panel2
        javaQuizQuesP2 = new JLabel("Which of the following methods is used to compare two strings for equality in Java?");
        javaQuizQuesP2.setBounds(35, 150, 800, 40);
        javaQuizQuesP2.setFont(new Font("Candara", Font.BOLD, 20));
        javaQuizP2.add(javaQuizQuesP2);

        // option 1 on java panel2
        javaQuizOption1P2 = new JRadioButton("compareTo()");
        javaQuizOption1P2.setBounds(30,270,500,50);
        javaQuizOption1P2.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption1P2.setForeground(Color.blue);
        javaQuizOption1P2.setOpaque(false);
        javaQuizP2.add(javaQuizOption1P2);

        // option 2 on java panel2
        javaQuizOption2P2 = new JRadioButton("compare()");
        javaQuizOption2P2.setBounds(30,330,500,50);
        javaQuizOption2P2.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption2P2.setForeground(Color.blue);
        javaQuizOption2P2.setOpaque(false);
        javaQuizP2.add(javaQuizOption2P2);

        // option 3 on java panel2
        javaQuizOption3P2 = new JRadioButton("equals()");
        javaQuizOption3P2.setBounds(30,390,500,50);
        javaQuizOption3P2.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption3P2.setForeground(Color.blue);
        javaQuizOption3P2.setOpaque(false);
        javaQuizP2.add(javaQuizOption3P2);

        // option 4 on java panel2
        javaQuizOption4P2 = new JRadioButton("equalsIgnoreCase()");
        javaQuizOption4P2.setBounds(30,450,550,50);
        javaQuizOption4P2.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption4P2.setForeground(Color.blue);
        javaQuizOption4P2.setOpaque(false);
        javaQuizP2.add(javaQuizOption4P2);

        // radio button group on java panel2
        javaQuizGroupRadio1P2 = new ButtonGroup() ;
        javaQuizGroupRadio1P2.add(javaQuizOption1P2) ;
        javaQuizGroupRadio1P2.add(javaQuizOption2P2) ;
        javaQuizGroupRadio1P2.add(javaQuizOption3P2) ;
        javaQuizGroupRadio1P2.add(javaQuizOption4P2) ;

        // next button on java panel2
        javaQuizNextP2 = new JButton("Next") ;
        javaQuizNextP2.setBounds(580,550,150,50);
        javaQuizNextP2.setFont(new Font("Candara", Font.BOLD, 20));
        javaQuizNextP2.addActionListener(this);
        javaQuizP2.add(javaQuizNextP2);
        javaQuizP2.setVisible(false);


        //        ----------------------------- Java Panel 3 -----------------------------

        javaQuizP3 = new JPanel();
        javaQuizP3.setLayout(null);
        javaQuizP3.setSize(800, 700);
        javaQuizP3.setOpaque(false);
        add(javaQuizP3);

        // Java Quiz Label on java panel3
        javaQuizTitleP3 = new JLabel("Java Quiz");
        javaQuizTitleP3.setBounds(300, 20, 800, 40);
        javaQuizTitleP3.setFont(new Font("Candara", Font.BOLD, 35));
        javaQuizP3.add(javaQuizTitleP3);

        // Question statement on java panel3
        javaQuizQuesP3 = new JLabel("Which of the following is used to handle exceptions in Java?");
        javaQuizQuesP3.setBounds(35, 150, 800, 40);
        javaQuizQuesP3.setFont(new Font("Candara", Font.BOLD, 27));
        javaQuizP3.add(javaQuizQuesP3);

        // option 1 on java panel3
        javaQuizOption1P3 = new JRadioButton("switch-case");
        javaQuizOption1P3.setBounds(30,270,500,50);
        javaQuizOption1P3.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption1P3.setForeground(Color.blue);
        javaQuizOption1P3.setOpaque(false);
        javaQuizP3.add(javaQuizOption1P3);

        // option 2 on java panel3
        javaQuizOption2P3 = new JRadioButton("for loop");
        javaQuizOption2P3.setBounds(30,330,500,50);
        javaQuizOption2P3.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption2P3.setForeground(Color.blue);
        javaQuizOption2P3.setOpaque(false);
        javaQuizP3.add(javaQuizOption2P3);

        // option 3 on java panel3
        javaQuizOption3P3 = new JRadioButton("if-else");
        javaQuizOption3P3.setBounds(30,390,500,50);
        javaQuizOption3P3.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption3P3.setForeground(Color.blue);
        javaQuizOption3P3.setOpaque(false);
        javaQuizP3.add(javaQuizOption3P3);

        // option 4 on java panel3
        javaQuizOption4P3 = new JRadioButton("try-catch");
        javaQuizOption4P3.setBounds(30,450,500,50);
        javaQuizOption4P3.setFont(new Font("Candara",Font.PLAIN,20));
        javaQuizOption4P3.setForeground(Color.blue);
        javaQuizOption4P3.setOpaque(false);
        javaQuizP3.add(javaQuizOption4P3);

        // radio button group on java panel3
        javaQuizGroupRadio1P3 = new ButtonGroup() ;
        javaQuizGroupRadio1P3.add(javaQuizOption1P3) ;
        javaQuizGroupRadio1P3.add(javaQuizOption2P3) ;
        javaQuizGroupRadio1P3.add(javaQuizOption3P3) ;
        javaQuizGroupRadio1P3.add(javaQuizOption4P3) ;

        // submit button on java panel3
        javaQuizSubmitP3 = new JButton("Submit") ;
        javaQuizSubmitP3.setBounds(580,550,150,50);
        javaQuizSubmitP3.setFont(new Font("Candara", Font.BOLD, 20));
        javaQuizSubmitP3.addActionListener(this);
        javaQuizP3.add(javaQuizSubmitP3);
        javaQuizP3.setVisible(false);



        //        ----------------------------- Python Panel 1 -----------------------------

        pythonQuizP1 = new JPanel();
        pythonQuizP1.setLayout(null);
        pythonQuizP1.setSize(800, 700);
        pythonQuizP1.setOpaque(false);
        add(pythonQuizP1);

        // Python Quiz label on Python panel1
        pythonQuizTitleP1 = new JLabel("Python Quiz");
        pythonQuizTitleP1.setBounds(300, 20, 800, 40);
        pythonQuizTitleP1.setFont(new Font("Candara", Font.BOLD, 35));
        pythonQuizP1.add(pythonQuizTitleP1);

        // Question statement on Python panel1
        pythonQuizQuesP1 = new JLabel("What is the correct way to check the length of a list in Python?");
        pythonQuizQuesP1.setBounds(35, 150, 800, 40);
        pythonQuizQuesP1.setFont(new Font("Candara", Font.BOLD, 27));
        pythonQuizP1.add(pythonQuizQuesP1);

        // option 1 on Python panel1
        pythonQuizOption1P1 = new JRadioButton("length(list)");
        pythonQuizOption1P1.setBounds(30,270,500,50);
        pythonQuizOption1P1.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption1P1.setForeground(Color.blue);
        pythonQuizOption1P1.setOpaque(false);
        pythonQuizP1.add(pythonQuizOption1P1);

        // option 2 on Python panel1
        pythonQuizOption2P1 = new JRadioButton("len(list)");
        pythonQuizOption2P1.setBounds(30,330,500,50);
        pythonQuizOption2P1.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption2P1.setForeground(Color.blue);
        pythonQuizOption2P1.setOpaque(false);
        pythonQuizP1.add(pythonQuizOption2P1);

        // option 3 on Python panel1
        pythonQuizOption3P1 = new JRadioButton("list.len()");
        pythonQuizOption3P1.setBounds(30,390,500,50);
        pythonQuizOption3P1.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption3P1.setForeground(Color.blue);
        pythonQuizOption3P1.setOpaque(false);
        pythonQuizP1.add(pythonQuizOption3P1);

        // option 4 on Python panel1
        pythonQuizOption4P1 = new JRadioButton("list.length()");
        pythonQuizOption4P1.setBounds(30,450,500,50);
        pythonQuizOption4P1.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption4P1.setForeground(Color.blue);
        pythonQuizOption4P1.setOpaque(false);
        pythonQuizP1.add(pythonQuizOption4P1);

        // radio button group on Python panel1
        pythonQuizGroupRadio1P1 = new ButtonGroup() ;
        pythonQuizGroupRadio1P1.add(pythonQuizOption1P1) ;
        pythonQuizGroupRadio1P1.add(pythonQuizOption2P1) ;
        pythonQuizGroupRadio1P1.add(pythonQuizOption3P1) ;
        pythonQuizGroupRadio1P1.add(pythonQuizOption4P1) ;

        // next button on Python panel1
        pythonQuizNextP1 = new JButton("Next") ;
        pythonQuizNextP1.setBounds(580,550,150,50);
        pythonQuizNextP1.setFont(new Font("Candara", Font.BOLD, 20));
        pythonQuizNextP1.addActionListener(this);
        pythonQuizP1.add(pythonQuizNextP1);
        pythonQuizP1.setVisible(false);


        //        ----------------------------- Python Panel 2 -----------------------------

        pythonQuizP2 = new JPanel();
        pythonQuizP2.setLayout(null);
        pythonQuizP2.setSize(800, 700);
        pythonQuizP2.setOpaque(false);
        add(pythonQuizP2);

        // Python Quiz label on Python panel2
        pythonQuizTitleP2 = new JLabel("Python Quiz");
        pythonQuizTitleP2.setBounds(300, 20, 800, 40);
        pythonQuizTitleP2.setFont(new Font("Candara", Font.BOLD, 35));
        pythonQuizP2.add(pythonQuizTitleP2);

        // Question statement on Python panel2
        pythonQuizQuesP2 = new JLabel("Which of the following is used to remove an item from a list in Python?");
        pythonQuizQuesP2.setBounds(35, 150, 800, 40);
        pythonQuizQuesP2.setFont(new Font("Candara", Font.BOLD, 22));
        pythonQuizP2.add(pythonQuizQuesP2);

        // option 1 on Python panel2
        pythonQuizOption1P2 = new JRadioButton("remove()");
        pythonQuizOption1P2.setBounds(30,270,500,50);
        pythonQuizOption1P2.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption1P2.setForeground(Color.blue);
        pythonQuizOption1P2.setOpaque(false);
        pythonQuizP2.add(pythonQuizOption1P2);

        // option 2 on Python panel2
        pythonQuizOption2P2 = new JRadioButton("delete()");
        pythonQuizOption2P2.setBounds(30,330,500,50);
        pythonQuizOption2P2.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption2P2.setForeground(Color.blue);
        pythonQuizOption2P2.setOpaque(false);
        pythonQuizP2.add(pythonQuizOption2P2);

        // option 3 on Python panel2
        pythonQuizOption3P2 = new JRadioButton("pop()");
        pythonQuizOption3P2.setBounds(30,390,500,50);
        pythonQuizOption3P2.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption3P2.setForeground(Color.blue);
        pythonQuizOption3P2.setOpaque(false);
        pythonQuizP2.add(pythonQuizOption3P2);

        // option 4 on Python panel2
        pythonQuizOption4P2 = new JRadioButton("discard()");
        pythonQuizOption4P2.setBounds(30,450,550,50);
        pythonQuizOption4P2.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption4P2.setForeground(Color.blue);
        pythonQuizOption4P2.setOpaque(false);
        pythonQuizP2.add(pythonQuizOption4P2);

        // radio button group on Python panel2
        pythonQuizGroupRadio1P2 = new ButtonGroup() ;
        pythonQuizGroupRadio1P2.add(pythonQuizOption1P2) ;
        pythonQuizGroupRadio1P2.add(pythonQuizOption2P2) ;
        pythonQuizGroupRadio1P2.add(pythonQuizOption3P2) ;
        pythonQuizGroupRadio1P2.add(pythonQuizOption4P2) ;

        // next button on Python panel2
        pythonQuizNextP2 = new JButton("Next") ;
        pythonQuizNextP2.setBounds(580,550,150,50);
        pythonQuizNextP2.setFont(new Font("Candara", Font.BOLD, 20));
        pythonQuizNextP2.addActionListener(this);
        pythonQuizP2.add(pythonQuizNextP2);
        pythonQuizP2.setVisible(false);


        //        ----------------------------- Python Panel 3 -----------------------------

        pythonQuizP3 = new JPanel();
        pythonQuizP3.setLayout(null);
        pythonQuizP3.setSize(800, 700);
        pythonQuizP3.setOpaque(false);
        add(pythonQuizP3);

        // Python Quiz Label on Python panel 3
        pythonQuizTitleP3 = new JLabel("Python Quiz");
        pythonQuizTitleP3.setBounds(300, 20, 800, 40);
        pythonQuizTitleP3.setFont(new Font("Candara", Font.BOLD, 35));
        pythonQuizP3.add(pythonQuizTitleP3);

        // Question statement on Python panel 3
        pythonQuizQuesP3 = new JLabel("Which of the following is not a valid method to read user input in Python?");
        pythonQuizQuesP3.setBounds(35, 150, 800, 40);
        pythonQuizQuesP3.setFont(new Font("Candara", Font.BOLD, 22));
        pythonQuizP3.add(pythonQuizQuesP3);

        // option 1 on Python panel 3
        pythonQuizOption1P3 = new JRadioButton("input()");
        pythonQuizOption1P3.setBounds(30,270,500,50);
        pythonQuizOption1P3.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption1P3.setForeground(Color.blue);
        pythonQuizOption1P3.setOpaque(false);
        pythonQuizP3.add(pythonQuizOption1P3);

        // option 2 on Python panel 3
        pythonQuizOption2P3 = new JRadioButton("raw_input()");
        pythonQuizOption2P3.setBounds(30,330,500,50);
        pythonQuizOption2P3.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption2P3.setForeground(Color.blue);
        pythonQuizOption2P3.setOpaque(false);
        pythonQuizP3.add(pythonQuizOption2P3);

        // option 3 on Python panel 3
        pythonQuizOption3P3 = new JRadioButton("sys.stdin.readline()");
        pythonQuizOption3P3.setBounds(30,390,500,50);
        pythonQuizOption3P3.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption3P3.setForeground(Color.blue);
        pythonQuizOption3P3.setOpaque(false);
        pythonQuizP3.add(pythonQuizOption3P3);

        // option 4 on Python panel 3
        pythonQuizOption4P3 = new JRadioButton("read()");
        pythonQuizOption4P3.setBounds(30,450,500,50);
        pythonQuizOption4P3.setFont(new Font("Candara",Font.PLAIN,20));
        pythonQuizOption4P3.setForeground(Color.blue);
        pythonQuizOption4P3.setOpaque(false);
        pythonQuizP3.add(pythonQuizOption4P3);

        // radio button group on Python panel3
        pythonQuizGroupRadio1P3 = new ButtonGroup() ;
        pythonQuizGroupRadio1P3.add(pythonQuizOption1P3) ;
        pythonQuizGroupRadio1P3.add(pythonQuizOption2P3) ;
        pythonQuizGroupRadio1P3.add(pythonQuizOption3P3) ;
        pythonQuizGroupRadio1P3.add(pythonQuizOption4P3) ;

        // submit button on Python panel3
        pythonQuizSubmitP3 = new JButton("Submit") ;
        pythonQuizSubmitP3.setBounds(580,550,150,50);
        pythonQuizSubmitP3.setFont(new Font("Candara", Font.BOLD, 20));
        pythonQuizSubmitP3.addActionListener(this);
        pythonQuizP3.add(pythonQuizSubmitP3);
        pythonQuizP3.setVisible(false);



        // -------------------------------------- Panel 11 --------------------------------------

        panel11 = new JPanel();
        panel11.setBounds(0, 0, 800, 700);
        panel11.setOpaque(false);
        panel11.setLayout(null);
        add(panel11);

        // Quiz Result label on panel11
        quizResultP11 = new JLabel("Quiz Result");
        quizResultP11.setBounds(290,30 , 350,60);
        quizResultP11.setFont(new Font("Candara",Font.BOLD,50));
        panel11.add(quizResultP11);

        // score label on panel11
        scoreLabelP11 = new JLabel("Score:");
        scoreLabelP11.setBounds(370,190 , 200,50);
        scoreLabelP11.setFont(new Font("Candara",Font.BOLD,40));
        panel11.add(scoreLabelP11);

        // user score label on panel 11
        userScoreP11 = new JLabel();
        userScoreP11.setBounds(380,240 , 200,40);
        userScoreP11.setFont(new Font("Candara",Font.BOLD,36));
        userScoreP11.setForeground(Color.decode("#74b9ff"));
        panel11.add(userScoreP11);

        // status label on panel11
        statusLabelP11 = new JLabel("Status:");
        statusLabelP11.setBounds(350,310 , 200,50);
        statusLabelP11.setFont(new Font("Candara",Font.BOLD,40));
        panel11.add(statusLabelP11);

        // user status label on panel11
        userStatusP11 = new JLabel();
        userStatusP11.setBounds(380,360 , 200,40);
        userStatusP11.setFont(new Font("Candara",Font.BOLD,36));
        userStatusP11.setForeground(Color.decode("#00b894"));
        panel11.add(userStatusP11);

        // go to main menu button on panel11
        mainMenuP11 = new JButton("Go back to main menu");
        mainMenuP11.setBounds(220,450,400,40);
        mainMenuP11.setFont(new Font("Candara",Font.BOLD,20));
        mainMenuP11.addActionListener(this);
        panel11.add(mainMenuP11);
        panel11.setVisible(false);

        setVisible(true);

    }

    public void actionPerformed (ActionEvent e) {

        // if user clicks on C++ on panel6
        if(e.getSource() == cQuiz ) {

            subjectName.setText("C++");
            panel6.setVisible(false);
            panel7.setVisible(true);
        }
        // if user clicks on Java on panel6
        if(e.getSource() == javaQuiz ) {
            subjectName.setText("Java");
            panel6.setVisible(false) ;
            panel7.setVisible(true) ;
        }
        // if user clicks on Python on panel6
        if(e.getSource() == pythonQuiz) {
            subjectName.setText("Python");
            panel6.setVisible(false);
            panel7.setVisible(true);
        }
        // if user clicks on back button on panel 6
        if(e.getSource() == backP6) {
            setVisible(false);
            new User(userName);
        }

        // enable the next button if the checkbox on panel7 is selected
        if(e.getSource() == acceptCheckBox) {
            nextP7.setEnabled(acceptCheckBox.isSelected());
        }

        // if user clicks on next button on panel7
        if(e.getSource() == nextP7) {
            panel7.setVisible(false);
            panel8.setVisible(true);
        }

        // if user clicks on back button on panel7
        if(e.getSource() == backP7) {
            panel7.setVisible(false);
            panel6.setVisible(true);
        }

        // if user clicks on back button on panel8
        if(e.getSource() == backP8) {
            panel8.setVisible(false);
            panel7.setVisible(true);
        }

        // if user clicks on ready button on panel8
        if(e.getSource() == readyButtonP8) {
            if(subjectName.getText().equals("C++")) {
                panel8.setVisible(false);
                cppQuizP1.setVisible(true);
            }
            if(subjectName.getText().equals("Java")) {
                panel8.setVisible(false);
                javaQuizP1.setVisible(true);
            }
            if(subjectName.getText().equals("Python")) {
                panel8.setVisible(false);
                pythonQuizP1.setVisible(true);
            }
        }

        // if user clicks on next button on cpp panel 1
       if(e.getSource() == cppQuizNextP1) {
           if(cppQuizOption2P1.isSelected()) {
               cppQuizScore+=10;
           }
           System.out.println(cppQuizScore);
           cppQuizP1.setVisible(false);
           cppQuizP2.setVisible(true);
       }

        // if user clicks on next button on cpp panel 2
        if(e.getSource() == cppQuizNextP2) {
            if(cppQuizOption3P2.isSelected()) {
                cppQuizScore+=10;
            }
            System.out.println(cppQuizScore);
            cppQuizP2.setVisible(false);
            cppQuizP3.setVisible(true);
        }

        // if user clicks on submit button on cpp panel 3
        if(e.getSource() == cppQuizSubmitP3) {
            if(cppQuizOption4P3.isSelected()) {
                cppQuizScore+=10;
            }
            System.out.println(cppQuizScore);
            userScoreP11.setText(cppQuizScore + "/30");
            if(cppQuizScore >= 20) {
                userStatusP11.setText("Pass");
            } else {
                userStatusP11.setText("Fail");
                userStatusP11.setForeground(Color.RED);
            }

                String subject = subjectName.getText();
                int score = cppQuizScore;
                String status = userStatusP11.getText();
                try {
                    Connection connect = connection.create();
                    String query = "insert into quizperformances (username, subject, score, status) values (?,?,?,?)";
                    PreparedStatement ps = connect.prepareStatement(query);
                    ps.setString(1, userName);
                    ps.setString(2, subject);
                    ps.setInt(3, score);
                    ps.setString(4, status);
                    ps.executeUpdate();

                } catch (Exception a) {
                    a.printStackTrace();
                }


            cppQuizP3.setVisible(false);
            panel11.setVisible(true);
        }

        // if user clicks on next button on java panel 1
        if(e.getSource() == javaQuizNextP1) {
            if(javaQuizOption2P1.isSelected()) {
                javaQuizScore+=10;
            }
            System.out.println(javaQuizScore);
            javaQuizP1.setVisible(false);
            javaQuizP2.setVisible(true);
        }

        // if user clicks on next button on java panel 2
        if(e.getSource() == javaQuizNextP2) {
            if(javaQuizOption3P2.isSelected()) {
                javaQuizScore+=10;
            }
            System.out.println(javaQuizScore);
            javaQuizP2.setVisible(false);
            javaQuizP3.setVisible(true);
        }

        // if user clicks on submit button on java panel 3
        if(e.getSource() == javaQuizSubmitP3) {
            if(javaQuizOption4P3.isSelected()) {
                javaQuizScore+=10;
            }
            System.out.println(javaQuizScore);
            userScoreP11.setText(javaQuizScore + "/30");
            if(javaQuizScore >= 20) {
                userStatusP11.setText("Pass");
            } else {
                userStatusP11.setText("Fail");
                userStatusP11.setForeground(Color.RED);
            }

            String subject = subjectName.getText();
            int score = javaQuizScore;
            String status = userStatusP11.getText();
            try {
                Connection connect = connection.create();
                String query = "insert into quizperformances (username, subject, score, status) values (?,?,?,?)";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setString(1, userName);
                ps.setString(2, subject);
                ps.setInt(3, score);
                ps.setString(4, status);
                ps.executeUpdate();

            } catch (Exception a) {
                a.printStackTrace();
            }

            javaQuizP3.setVisible(false);
            panel11.setVisible(true);
        }

        // if user clicks on next button on Python panel 1
        if(e.getSource() == pythonQuizNextP1) {
            if(pythonQuizOption2P1.isSelected()) {
                pythonQuizScore+=10;
            }
            System.out.println(pythonQuizScore);
            pythonQuizP1.setVisible(false);
            pythonQuizP2.setVisible(true);
        }

        // if user clicks on next button on Python panel 2
        if(e.getSource() == pythonQuizNextP2) {
            if(pythonQuizOption3P2.isSelected()) {
                pythonQuizScore+=10;
            }
            System.out.println(pythonQuizScore);
            pythonQuizP2.setVisible(false);
            pythonQuizP3.setVisible(true);
        }

        // if user clicks on submit button on Python panel 3
        if(e.getSource() == pythonQuizSubmitP3) {
            if(pythonQuizOption4P3.isSelected()) {
                pythonQuizScore+=10;
            }
            System.out.println(pythonQuizScore);
            userScoreP11.setText(pythonQuizScore + "/30");
            if(pythonQuizScore >= 20) {
                userStatusP11.setText("Pass");
            } else {
                userStatusP11.setText("Fail");
                userStatusP11.setForeground(Color.RED);
            }

            String subject = subjectName.getText();
            int score = pythonQuizScore;
            String status = userStatusP11.getText();
            try {
                Connection connect = connection.create();
                String query = "insert into quizperformances (username, subject, score, status) values (?,?,?,?)";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setString(1, userName);
                ps.setString(2, subject);
                ps.setInt(3, score);
                ps.setString(4, status);
                ps.executeUpdate();

            } catch (Exception a) {
                a.printStackTrace();
            }

            pythonQuizP3.setVisible(false);
            panel11.setVisible(true);
        }


        // if user clicks on go back to main menu on panel11
        if(e.getSource() == mainMenuP11) {
            cppQuizScore = 0;
            javaQuizScore = 0;
            pythonQuizScore = 0;
            setVisible(false);
            new User(userName);
        }

    }
}
