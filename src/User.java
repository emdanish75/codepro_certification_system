import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends JFrame implements ActionListener {
    //panel5 components
    public static JPanel panel5 ;
    public static JLabel userPortal;
    public static JButton quizApp , viewPerformance, certificate, signOut;

    // panel14 components
    static JPanel panel14;
    static JLabel eligibleForCertificate,quizPerfomance;
    static JButton generateCertificate, backP14;

    // panel15 components
    public static JButton backP15;
    public static JLabel achiever , acheiverName ;
    public static JPanel panel15;

    String userName;
    User(String userName) {

        this.userName = userName;

        // frame properties
        setSize(800, 700);
        setTitle("CodePro Certification System");
        setLocation(320, 10);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        // --------------------------- Panel5 -----------------------------
        panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setBounds(0, 0, 800, 700);
        panel5.setOpaque(false);

        // user portal label on panel5
        userPortal = new JLabel("User portal");
        userPortal.setBounds(290, 20, 250, 40);
        userPortal.setFont(new Font("Candara", Font.PLAIN, 36));
        panel5.add(userPortal);
        add(panel5);

        // take quiz button on panel5
        quizApp = new JButton("Take Quiz");
        quizApp.setBounds(250, 150, 250, 30);
        quizApp.setFont(new Font("Candara", Font.BOLD, 20));
        quizApp.setFocusable(false);
        quizApp.addActionListener(this);
        panel5.add(quizApp);

        // view performance button on panel5
        viewPerformance = new JButton("View Performance");
        viewPerformance.setBounds(250, 250, 250, 30);
        viewPerformance.setFont(new Font("Candara", Font.BOLD, 20));
        viewPerformance.setFocusable(false);
        viewPerformance.addActionListener(this);
        panel5.add(viewPerformance);

        // certificate status button on panel5
        certificate = new JButton("Certificate Status");
        certificate.setBounds(250, 350, 250, 30);
        certificate.setFont(new Font("Candara", Font.BOLD, 20));
        certificate.setFocusable(false);
        certificate.addActionListener(this);
        panel5.add(certificate);

        // sign out button on panel5
        signOut = new JButton("Sign Out");
        signOut.setBounds(310, 489, 140, 35);
        signOut.setFont(new Font("Candara", Font.BOLD, 20));
        signOut.setFocusable(false);
        signOut.addActionListener(this);
        panel5.add(signOut);

        // -------------------------------------- Panel 14 --------------------------------
        panel14 = new JPanel();
        panel14.setBounds(0, 0, 800, 700);
        panel14.setOpaque(false);
        panel14.setLayout(null);
        add(panel14);
// label on panel14
        quizPerfomance = new JLabel("Certificate status:");
        quizPerfomance.setBounds(250,150 , 400,60);
        quizPerfomance.setFont(new Font("Candara",Font.BOLD,35));
        panel14.add(quizPerfomance);

        eligibleForCertificate = new JLabel();
        eligibleForCertificate.setBounds(130,250 , 600,60);
        eligibleForCertificate.setFont(new Font("Candara",Font.BOLD,22));
        panel14.add(eligibleForCertificate);


// Buttons on Panel14
        generateCertificate = new JButton("Get Certificate Now!") ;
        generateCertificate.setBounds(270, 350, 230, 35);
        generateCertificate.setFont(new Font("Candara", Font.BOLD, 20));
        generateCertificate.setEnabled(true);
        generateCertificate.addActionListener(this);
        panel14.add(generateCertificate);

        backP14 = new JButton("Back to main menu") ;
        backP14.setBounds(270, 450, 230, 35);
        backP14.setFont(new Font("Candara", Font.BOLD, 20));
        backP14.addActionListener(this);
        panel14.add(backP14);
        panel14.setVisible(false);

        //        ----------------------------- Panel15 -----------------------------
        panel15 = new JPanel() ;
        panel15.setLayout(null);
        panel15.setSize(800, 700);
        panel15.setOpaque(false);
        add(panel15);


        acheiverName = new JLabel() ;
        acheiverName.setBounds(280,280,480,30);
        acheiverName.setFont(new Font("Monospaced",Font.PLAIN,28));
        panel15.add(acheiverName) ;

        achiever = new JLabel() ;
        ImageIcon certificateP15 = new ImageIcon("logoCer.jpg");
        achiever.setIcon(certificateP15);
        achiever.setBounds(20,0,750,550);
        achiever.setLayout(null);
        panel15.add(achiever);

        backP15 = new JButton("Back To Main Menu") ;
        backP15.setBounds(280,580,250,50);
        backP15.setFont(new Font("Candara", Font.BOLD, 20));
        backP15.addActionListener(this);
        panel15.add(backP15) ;
        panel15.setVisible(false);

        setResizable(false);
        setVisible(true);

        }

    private boolean checkCertificateEligibility() {
        // Perform the database query to check the eligibility for the certificate
        String query = "SELECT COUNT(DISTINCT subject) AS count FROM quizperformances WHERE username = ? AND status = 'Pass'";
        try {
            Connection connect = connection.create();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count >= 3; // Assuming there are three subjects: C++, Java, Python
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

        public void actionPerformed (ActionEvent e) {

            // if user clicks on take quiz on panel5
            if(e.getSource() == quizApp) {
                setVisible(false);
                new Quiz(userName);
            }

            // if user clicks on view performance on panel5
            if(e.getSource() == viewPerformance) {
                setVisible(false);
                new Result(userName);
            }


            // if user clicks on show certificate status on panel5
            if(e.getSource() == certificate) {
                boolean isEligibleForCertificate = checkCertificateEligibility();
                generateCertificate.setEnabled(isEligibleForCertificate);
                if(!isEligibleForCertificate) {
                    eligibleForCertificate.setText("You are not eligible to get the certificate yet.");
                    eligibleForCertificate.setForeground(Color.RED);
                    eligibleForCertificate.setBounds(160,250 , 600,60);
                } else {
                    eligibleForCertificate.setText("Congratulations! You are eligible to get the certificate.");
                    eligibleForCertificate.setForeground(Color.GREEN);
                }
                panel5.setVisible(false);
                panel14.setVisible(true);
            }

            // if user clicks on sign out on panel5
            if(e.getSource() == signOut) {
                setVisible(false);
                new Login();
            }

            // if user clicks on back button on panel14
            if(e.getSource() == backP14) {
                panel14.setVisible(false);
                panel5.setVisible(true);
            }

            // if user clicks on generate certificate button on panel14
            if(e.getSource() == generateCertificate) {

                String fullName = "";
                String query = "SELECT firstname, lastname FROM userdata WHERE username = ?";
                try {
                    Connection connect = connection.create();
                    PreparedStatement statement = connect.prepareStatement(query);
                    statement.setString(1, userName);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String firstName = resultSet.getString("firstname");
                        String lastName = resultSet.getString("lastname");
                        fullName = firstName + " " + lastName;
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                }
                acheiverName.setText(fullName);
                panel14.setVisible(false);
                panel15.setVisible(true);
            }

            // if user clicks on back button on panel15
            if(e.getSource() == backP15) {
                setVisible(false);
                new User(userName);
            }
        }

    }

