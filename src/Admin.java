import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin extends JFrame implements ActionListener {
    static JPanel adminpanel2, adminpanel3, adminpanel4;

    //panel2 components
    static JButton admincreateAccP2, adminsignIn, adminbackP2;
    static JLabel adminaccountCheck;
    // panel3 components
    static JButton adminbackP3, admincreateAccP3;
    static JLabel adminnameLabel, adminlastLabel, adminageLabel, admingenderLabel, admincityLabel, adminregistrationLabel, adminusernameLabel, adminpasswordLabel, adminaccCreatedLabel;
    static JPasswordField adminpasswordFieldP3;
    static JTextField adminnameField, adminlastField, adminageField, admincityField, adminusernameField;
    static JComboBox admingenderBox;
    // panel4 components
    static JLabel adminusernameLabelP4, adminpasswordLabelP4, usernameError;
    static JTextField adminusernameFieldP4;
    JPasswordField adminpasswordFieldP4;

    JButton adminbackP4, adminsignInP4;

    Admin() {

        // frame properties
        setSize(600, 600);
        setTitle("CodePro Certification System");
        setLocation(400,50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);



        // -------------------------- panel 2 ----------------------------------
        adminpanel2 = new JPanel();
        adminpanel2.setBounds(0,0,600,600);
        adminpanel2.setOpaque(false);
        adminpanel2.setLayout(null);
        add(adminpanel2);

        // label on panel2
        adminaccountCheck = new JLabel();
        adminaccountCheck.setText("Already have an account?");
        adminaccountCheck.setBounds(140,250, 500, 50);
        adminaccountCheck.setFont(new Font("Candara", Font.PLAIN, 26));
        adminpanel2.add(adminaccountCheck);

        // createAcc button on panel2
        admincreateAccP2 = new JButton();
        admincreateAccP2.setText("Create an account");
        admincreateAccP2.setBounds(180,180,200,36);
        admincreateAccP2.setFont(new Font("Candara", Font.BOLD, 20));
        admincreateAccP2.addActionListener(this);
        adminpanel2.add(admincreateAccP2);

        // signIN button on panel2
        adminsignIn = new JButton();
        adminsignIn.setText("Sign in");
        adminsignIn.setBounds(230,320,100,30);
        adminsignIn.setFont(new Font("Candara", Font.BOLD, 20));
        adminsignIn.addActionListener(this);
        adminpanel2.add(adminsignIn);

        // back button on panel2
        adminbackP2 = new JButton();
        adminbackP2.setText("Back");
        adminbackP2.setBounds(450,500,100,32);
        adminbackP2.setFont(new Font("Candara", Font.BOLD, 20));
        adminbackP2.addActionListener(this);
        adminpanel2.add(adminbackP2);

        // -------------------------- panel 3 ----------------------------------

        // panel3 properties
        adminpanel3 = new JPanel();
        adminpanel3.setBounds(0, 0, 600, 600);
        adminpanel3.setOpaque(false);
        adminpanel3.setLayout(null);
        add(adminpanel3);

        // registration label on panel3
        adminregistrationLabel = new JLabel("Registration") ;
        adminregistrationLabel.setBounds(10,20 , 250,40);
        adminregistrationLabel.setFont(new Font("Candara",Font.BOLD,35));
        adminpanel3.add(adminregistrationLabel) ;

        // first name label on panel3
        adminnameLabel = new JLabel("First Name:") ;
        adminnameLabel.setBounds(100,80 , 150,40);
        adminnameLabel.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(adminnameLabel) ;

        // last name label on panel3
        adminlastLabel = new JLabel("Last Name:") ;
        adminlastLabel.setBounds(100,130 , 150,40);
        adminlastLabel.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(adminlastLabel) ;

        // username label on panel3
        adminusernameLabel = new JLabel("Username:") ;
        adminusernameLabel.setBounds(100,180 , 150,40);
        adminusernameLabel.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(adminusernameLabel) ;

        // password label on panel3
        adminpasswordLabel = new JLabel("Password:") ;
        adminpasswordLabel.setBounds(100,230,150,40);
        adminpasswordLabel.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(adminpasswordLabel);

        // age label on panel3
        adminageLabel = new JLabel("Age:") ;
        adminageLabel.setBounds(100,280 , 150,40);
        adminageLabel.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(adminageLabel);

        // city label on panel3
        admincityLabel = new JLabel("City:") ;
        admincityLabel.setBounds(100,330 , 150,40);
        admincityLabel.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(admincityLabel) ;

        // gender label on panel3
        admingenderLabel = new JLabel("Gender:") ;
        admingenderLabel.setBounds(100,380 , 150,40);
        admingenderLabel.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(admingenderLabel);

        // account created label on panel3
        adminaccCreatedLabel = new JLabel("Account created successfully! Go back and sign in to view your account.") ;
        adminaccCreatedLabel.setBounds(60,500 , 500,40);
        adminaccCreatedLabel.setFont(new Font("Candara",Font.PLAIN,16));
        adminaccCreatedLabel.setVisible(false);
        adminpanel3.add(adminaccCreatedLabel);

        // name field on panel3
        adminnameField = new JTextField() ;
        adminnameField.setBounds(320,80 , 150,30);
        adminnameField.setFont(new Font("Candara",Font.PLAIN,20));
        adminpanel3.add(adminnameField) ;

        // last name field on panel3
        adminlastField = new JTextField() ;
        adminlastField.setBounds(320,130 , 150,30);
        adminlastField.setFont(new Font("Candara",Font.PLAIN,20));
        adminpanel3.add(adminlastField) ;

        // username field om panel3
        adminusernameField = new JTextField() ;
        adminusernameField.setBounds(320,180 , 150,30);
        adminusernameField.setFont(new Font("Candara",Font.PLAIN,20));
        adminpanel3.add(adminusernameField) ;

        // password field on panel3
        adminpasswordFieldP3 = new JPasswordField();
        adminpasswordFieldP3.setBounds(320,230,150,30);
        adminpasswordFieldP3.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel3.add(adminpasswordFieldP3);

        // age field on panel3
        adminageField = new JTextField() ;
        adminageField.setBounds(320,280 , 150,30);
        adminageField.setFont(new Font("Candara",Font.PLAIN,20));
        adminpanel3.add(adminageField) ;

        // city field on panel3
        admincityField = new JTextField() ;
        admincityField.setBounds(320,330 , 150,30);
        admincityField.setFont(new Font("Candara",Font.PLAIN,20));
        adminpanel3.add(admincityField) ;

        // Combo box on panel3
        admingenderBox = new JComboBox();
        admingenderBox.addItem("Male");
        admingenderBox.addItem("Female");
        admingenderBox.setSelectedItem("Male");
        admingenderBox.setBounds(320,380 , 150,30);
        admingenderBox.setFont(new Font("Candara",Font.BOLD,20));
        admingenderBox.setBackground(new Color(227,223,182,255));
        adminpanel3.add(admingenderBox) ;

        // back button on panel3
        adminbackP3 = new JButton("Back") ;
        adminbackP3.setBounds(130,450,100,36);
        adminbackP3.setFont(new Font("Candara", Font.BOLD, 20));
        adminbackP3.addActionListener(this);
        adminpanel3.add(adminbackP3);

        // create account button on panel3
        admincreateAccP3 = new JButton("Create Account") ;
        admincreateAccP3.setBounds(260,450,200,36);
        admincreateAccP3.setFont(new Font("Candara", Font.BOLD, 20));
        admincreateAccP3.addActionListener(this);
        adminpanel3.add(admincreateAccP3);
        adminpanel3.setVisible(false);

        // -------------------------------- Panel 4 ---------------------------------
        adminpanel4 = new JPanel();
        adminpanel4.setBounds(0, 0, 600, 600);
        adminpanel4.setOpaque(false);
        adminpanel4.setLayout(null);
        adminpanel4.setVisible(false);
        add(adminpanel4);

        // username label on panel4
        adminusernameLabelP4 = new JLabel("Username:") ;
        adminusernameLabelP4.setBounds(100,170 , 150,40);
        adminusernameLabelP4.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel4.add(adminusernameLabelP4);

        // password label on panel4
        adminpasswordLabelP4 = new JLabel("Password:");
        adminpasswordLabelP4.setBounds(100,220 , 150,40);
        adminpasswordLabelP4.setFont(new Font("Candara",Font.PLAIN,26));
        adminpanel4.add(adminpasswordLabelP4);

        // Admin Name error on panel 4
        usernameError = new JLabel("Username does not exist!");
        usernameError.setBounds(190,400,300,40);
        usernameError.setFont(new Font("Candara", Font.BOLD, 20));
        usernameError.setVisible(false);
        adminpanel4.add(usernameError);

        // username field on panel4
        adminusernameFieldP4 = new JTextField() ;
        adminusernameFieldP4.setBounds(280,171, 200,30);
        adminusernameFieldP4.setFont(new Font("Candara",Font.PLAIN,20));
        adminpanel4.add(adminusernameFieldP4);

        //password on panel4
        adminpasswordFieldP4 = new JPasswordField();
        adminpasswordFieldP4.setBounds(280,221 , 200,30);
        adminpasswordFieldP4.setFont(new Font("Candara",Font.PLAIN,20));
        adminpanel4.add(adminpasswordFieldP4) ;

        //back button on panel4
        adminbackP4 = new JButton("Back") ;
        adminbackP4.setBounds(190,300,100,36);
        adminbackP4.setFont(new Font("Candara", Font.BOLD, 20));
        adminbackP4.addActionListener(this);
        adminpanel4.add(adminbackP4);

        // sign in button on panel4
        adminsignInP4 = new JButton("Sign in") ;
        adminsignInP4.setBounds(320,300,100,36);
        adminsignInP4.setFont(new Font("Candara", Font.BOLD, 20));
        adminsignInP4.addActionListener(this);
        adminpanel4.add(adminsignInP4);



        // show the Jframe on screen
        setResizable(false);
        setVisible(true);


    }

    public void actionPerformed (ActionEvent e){

        // if user clicks back button adminpanel2
        if (e.getSource() == adminbackP2) {
            setVisible(false);
            new Login();
        }
        // if user clicks on create account button on adminpanel2
        if (e.getSource() == admincreateAccP2) {
            adminpanel2.setVisible(false);
            adminpanel3.setVisible(true);
        }

        // if user clicks on sign in button on adminpanel2
        if(e.getSource() == adminsignIn) {
            adminpanel2.setVisible(false);
            adminpanel4.setVisible(true);
        }

        // if user clicks on back button on adminpanel3
        if (e.getSource() == adminbackP3) {
            adminaccCreatedLabel.setVisible(false);
            adminpanel3.setVisible(false);
            adminpanel2.setVisible(true);
        }

        // if user clicks on create account button on adminpanel3
        if (e.getSource() == admincreateAccP3) {

            // if user has left any textfield empty
            if(adminnameField.getText().equals("") || adminlastField.getText().equals("") || adminageField.getText().equals("") || adminusernameField.getText().equals("") || adminpasswordFieldP3.getText().equals("") || admincityField.getText().equals("")) {
                adminaccCreatedLabel.setText("Please make sure all fields are entered properly.");
                adminaccCreatedLabel.setFont(new Font("Candara", Font.BOLD, 20));
                adminaccCreatedLabel.setBounds(105,500 , 500,40);
                adminaccCreatedLabel.setVisible(true);
            } else {
                // store user entered values into variables
                String firstName = adminnameField.getText();
                String lastName = adminlastField.getText();
                String username = adminusernameField.getText();
                String password = adminpasswordFieldP3.getText();
                int age = Integer.parseInt(adminageField.getText());
                String city = admincityField.getText();

                // insert user entered values into database if username is not matched with any other username in database
                try {
                    Connection connect = connection.create();
                    String query = "insert into admindata (firstname, lastname, username, password, age, city) values(?,?,?,?,?,?)";
                    PreparedStatement statement = connect.prepareStatement(query);
                    statement.setString(1, firstName);
                    statement.setString(2, lastName);
                    statement.setString(3, username);
                    statement.setString(4, password);
                    statement.setInt(5, age);
                    statement.setString(6, city);
                    statement.executeUpdate();
                    adminaccCreatedLabel.setText("Account created successfully!");
                    adminaccCreatedLabel.setBounds(165,500 , 500,40);
                    adminaccCreatedLabel.setFont(new Font("Candara", Font.BOLD, 20));
                    adminaccCreatedLabel.setVisible(true);
                    adminnameField.setText("");
                    adminlastField.setText("");
                    adminusernameField.setText("");
                    adminpasswordFieldP4.setText("");
                    adminageField.setText("");
                    admincityField.setText("");
                }
                // if username already exists then print an error message
                catch (Exception b) {
                    System.out.println("Username already exists!");
                    adminaccCreatedLabel.setText("Username already exists!");
                    adminaccCreatedLabel.setBounds(200,500 , 500,40);
                    adminaccCreatedLabel.setFont(new Font("Candara", Font.BOLD, 20));
                    adminaccCreatedLabel.setVisible(true);
                }
            }
        }

        // if user clicks on back button on adminpanel4
        if(e.getSource() == adminbackP4) {
            adminusernameFieldP4.setText("");
            adminpasswordFieldP4.setText("");
            adminpanel4.setVisible(false);
            adminpanel2.setVisible(true);
            usernameError.setVisible(false);
        }

        // if user clicks on sign in button on adminpanel4
        if (e.getSource() == adminsignInP4) {
            // if user has left any textfield empty
            if(adminusernameFieldP4.getText().equals("") || adminpasswordFieldP4.getText().equals("") ) {
                usernameError.setText("Please make sure all fields are entered properly.");
                usernameError.setBounds(90, 400, 500, 40);
                usernameError.setVisible(true);
            }
            // if user has entered all fields properly
            else {
                // store the user-entered username and password into variables
                String userName = adminusernameFieldP4.getText();
                String password = adminpasswordFieldP4.getText();

                // see if username matches with the username in the database
                try {
                    Connection connect = connection.create();
                    String query = "select * from admindata where username = '" + userName + "'";
                    PreparedStatement statement = connect.prepareStatement(query);
                    ResultSet rs = statement.executeQuery(query);
                    String check = "";
                    while (rs.next()) {
                        check = rs.getString("username");
                    }
                    // if yes
                    if (check.equals(userName)) {
                        try {
                            // see if password matches with the corresponding password
                            Connection conn = connection.create();
                            String query2 = "select password from admindata where username = '" + userName + "'";
                            PreparedStatement ps = conn.prepareStatement(query2);
                            ResultSet resultSet = ps.executeQuery(query2);
                            String check2 = "";
                            while (resultSet.next()) {
                                check2 = resultSet.getString("password");
                            }
                            // if yes, make an object of user class
                            if (check2.equals(password)) {
                                setVisible(false);
                                adminusernameFieldP4.setText("");
                                adminpasswordFieldP4.setText("");
                                new AdminPortal();
                                // otherwise, print an error message saying 'wrong password'
                            } else {
                                System.out.println("Wrong password!");
                                usernameError.setText("Wrong password!");
                                usernameError.setBounds(220, 400, 500, 40);
                                usernameError.setVisible(true);
                            }
                            //  print an error if the password-matching query is not executed properly
                        } catch (Exception a) {
                            a.printStackTrace();
                        }
                    }
                    // if the username does not match with any username in database, print an error message
                    else {
                        System.out.println("Username does not exist!");
                        usernameError.setText("Username does not exist! ");
                        usernameError.setBounds(200, 400, 500, 40);
                        usernameError.setVisible(true);
                    }
                }
                // if the username-matching query is not executed properly, print an error.
                catch (Exception a) {
                    a.printStackTrace();
                }
            }
        }

    }
}
