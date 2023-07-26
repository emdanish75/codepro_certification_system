import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminPortal extends JFrame implements ActionListener {

    // panel16 components
    static JButton questionBank , viewData ,signOutP16 ;
    static JPanel panel16 ;
    static JLabel adminPortal ;

    // panel17 components
    static JPanel panel17;
    static JLabel userInfo ;
    JTable tableP17;
    JScrollPane scrollPaneP17;
    static JButton backP17 ;

    // panel20 components
    public static JButton cppP20, javaP20, pythonP20, backP20;
    public static JLabel QuestionbankP20, chooseSubP20;
    public static JPanel panel20;
    static String subject;

    // panel21 components
    public static JButton addQues, deleteQues, viewQues, backP21;
    public static JLabel QuestionbankP21, UserChoiceP21;
    public static JPanel panel21;

    // panel22 components
    public static JPanel panel22;
    public static JLabel QuestionbankP22, QuestionStatementP22, correctoptionP22, status;
    public static JTextField QuestionStatementTextFieldP22, correctoptionfieldP22;
    public  static JButton addP22, backP22;

    // panel 23 Components
    static JPanel panel23;
    static JLabel DeleteQuestionsP23, statusP23;
    static JButton deleteP23, BackP23;
    JTable tableP23;
    JScrollPane scrollPaneP23;
//  panel 24 components
    static JPanel panel24;
    static JLabel questionStat;
    JTable tableP24;
    JScrollPane scrollPaneP24;
    static JButton backP24 ;
    AdminPortal() {
        // frame properties
        setSize(800, 700);
        setTitle("CodePro Certification System");
        setLocation(320, 10);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);

        // -------------------------------- Panel 16 ---------------------------

        panel16 = new JPanel();
        panel16.setBounds(0, 0, 800, 700);
        panel16.setOpaque(false);
        panel16.setLayout(null);
        add(panel16);
// Labels on Panel16
        adminPortal = new JLabel("Admin Portal");
        adminPortal.setBounds(250,50 , 400,60);
        adminPortal.setFont(new Font("Candara",Font.BOLD,45));
        panel16.add(adminPortal);
// Buttons on Panel16
        questionBank = new JButton("Question Bank System") ;
        questionBank.setBounds(270, 220, 250, 35);
        questionBank.setFont(new Font("Candara", Font.BOLD, 20)) ;
        questionBank.addActionListener(this);
        panel16.add(questionBank);

        viewData = new JButton("View User Data") ;
        viewData.setBounds(270, 320, 250, 35);
        viewData.setFont(new Font("Candara", Font.BOLD, 20));
        viewData.addActionListener(this);
        panel16.add(viewData);

        signOutP16 = new JButton("Sign Out") ;
        signOutP16.setBounds(270, 420, 250, 35);
        signOutP16.setFont(new Font("Candara", Font.BOLD, 20)) ;
        signOutP16.addActionListener(this);
        panel16.add(signOutP16);

        // -------------------------------- Panel 17 -----------------------------
        panel17 = new JPanel();
        panel17.setBounds(0, 0, 800, 700);
        panel17.setOpaque(false);
        panel17.setLayout(null);
        add(panel17);
        userInfo = new JLabel("All User's Information");
        userInfo.setBounds(225,50 , 400,60);
        userInfo.setFont(new Font("Candara",Font.BOLD,35));
        panel17.add(userInfo);


        tableP17 = new JTable();
        scrollPaneP17 = new JScrollPane(tableP17);
        scrollPaneP17.setBounds(1,100,800,400);
        panel17.add(scrollPaneP17);
        try {
            Connection connect = connection.create();
            String query = "select * from userdata";
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            // Create a table model and populate it with the result set
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get column count
            int columnCount = metaData.getColumnCount();

            // Add columns to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    rowData[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(rowData);
            }

            // Set the table model to the JTable
            tableP17.setModel(tableModel);

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        backP17 = new JButton("Back") ;
        backP17.setBounds(350, 530, 100, 35);
        backP17.setFont(new Font("Candara", Font.BOLD, 20));
        backP17.addActionListener(this);
        panel17.add(backP17);
        panel17.setVisible(false);

        // ----------------------------- Panel 20 --------------------------
        panel20 = new JPanel() ;
        panel20.setLayout(null);
        panel20.setBounds(0, 0, 800, 700);
        panel20.setOpaque(false);
        add(panel20);

        QuestionbankP20 = new JLabel("Question Bank");
        QuestionbankP20.setHorizontalTextPosition(JLabel.CENTER);
        QuestionbankP20.setBounds(230, 30, 400, 60);
        QuestionbankP20.setFont(new Font("Candara", Font.BOLD, 50));
        panel20.add(QuestionbankP20);

        chooseSubP20 = new JLabel("Choose Subject:");
        chooseSubP20.setHorizontalTextPosition(JLabel.CENTER);
        chooseSubP20.setBounds(280, 150, 600, 40);
        chooseSubP20.setFont(new Font("Candara", Font.BOLD, 30));
        panel20.add(chooseSubP20);

        cppP20 = new JButton("C++") ;
        cppP20.setBounds(260, 240, 250, 30);
        cppP20.setFont(new Font("Candara", Font.BOLD, 20));
        cppP20.setFocusable(false);
        cppP20.addActionListener(this);
        panel20.add(cppP20);

        javaP20 = new JButton("Java") ;
        javaP20.setBounds(260, 330, 250, 30);
        javaP20.setFont(new Font("Candara", Font.BOLD, 20));
        javaP20.setFocusable(false);
        javaP20.addActionListener(this);
        panel20.add(javaP20);

        pythonP20 = new JButton("Python") ;
        pythonP20.setBounds(260, 420, 250, 30);
        pythonP20.setFont(new Font("Candara", Font.BOLD, 20));
        pythonP20.setFocusable(false);
        pythonP20.addActionListener(this);
        panel20.add(pythonP20);

        backP20 = new JButton("Back") ;
        backP20.setBounds(540, 550, 100, 32);
        backP20.setFont(new Font("Candara", Font.BOLD, 20));
        backP20.addActionListener(this);
        panel20.add(backP20);
        panel20.setVisible(false);

        // ---------------------------- Panel 21 --------------------------------
        panel21 = new JPanel() ;
        panel21.setLayout(null);
        panel21.setBounds(0, 0, 800, 700);
        panel21.setOpaque(false);
        add(panel21);

        QuestionbankP21 = new JLabel("Question Bank");
        QuestionbankP21.setHorizontalTextPosition(JLabel.CENTER);
        QuestionbankP21.setBounds(230, 30, 400, 60);
        QuestionbankP21.setFont(new Font("Candara", Font.BOLD, 50));
        panel21.add(QuestionbankP21);

        UserChoiceP21 = new JLabel("What do you want to do?");
        UserChoiceP21.setHorizontalTextPosition(JLabel.CENTER);
        UserChoiceP21.setBounds(220, 150, 600, 40);
        UserChoiceP21.setFont(new Font("Candara", Font.BOLD, 30));
        panel21.add(UserChoiceP21);

        addQues = new JButton("Add Questions") ;
        addQues.setBounds(260, 240, 250, 30);
        addQues.setFont(new Font("Candara", Font.BOLD, 20));
        addQues.setFocusable(false);
        addQues.addActionListener(this);
        panel21.add(addQues);

        deleteQues = new JButton("Delete Questions") ;
        deleteQues.setBounds(260, 330, 250, 30);
        deleteQues.setFont(new Font("Candara", Font.BOLD, 20));
        deleteQues.setFocusable(false);
        deleteQues.addActionListener(this);
        panel21.add(deleteQues);

        viewQues = new JButton("View Questions") ;
        viewQues.setBounds(260, 420, 250, 30);
        viewQues.setFont(new Font("Candara", Font.BOLD, 20));
        viewQues.setFocusable(false);
        viewQues.addActionListener(this);
        panel21.add(viewQues);

        backP21 = new JButton("Back") ;
        backP21.setBounds(540, 550, 100, 32);
        backP21.setFont(new Font("Candara", Font.BOLD, 20));
        backP21.addActionListener(this);
        panel21.add(backP21);
        panel21.setVisible(false);

//        -------------------------------- Panel 22 -----------------------------------
        panel22 = new JPanel() ;
        panel22.setLayout(null);
        panel22.setBounds(0, 0, 800, 700);
        panel22.setOpaque(false);
        add(panel22);

        QuestionbankP22 = new JLabel("Add Question");
        QuestionbankP22.setBounds(260, 30, 400, 60);
        QuestionbankP22.setFont(new Font("Candara", Font.BOLD, 50));
        panel22.add(QuestionbankP22);

        QuestionStatementP22 = new JLabel("Write question statement:");
        QuestionStatementP22.setBounds(30, 130, 400, 30);
        QuestionStatementP22.setFont(new Font("Candara", Font.BOLD, 20));
        panel22.add(QuestionStatementP22);

        QuestionStatementTextFieldP22 = new JTextField();
        QuestionStatementTextFieldP22.setBounds(30, 170, 725, 100);
        QuestionStatementTextFieldP22.setFont(new Font("Candara", Font.PLAIN, 20));
        QuestionStatementTextFieldP22.setBackground(Color.decode("#ffeaa7"));
        panel22.add(QuestionStatementTextFieldP22);


        correctoptionP22 = new JLabel("Correct Option:");
        correctoptionP22.setBounds(200, 340, 200, 30);
        correctoptionP22.setFont(new Font("Candara", Font.BOLD, 20));
        panel22.add(correctoptionP22);


        correctoptionfieldP22 = new JTextField();
        correctoptionfieldP22.setBounds(400, 340, 300, 30);
        correctoptionfieldP22.setFont(new Font("Candara", Font.PLAIN, 20));
        correctoptionfieldP22.setBackground(Color.decode("#ffeaa7"));
        panel22.add(correctoptionfieldP22);

        status = new JLabel();
        status.setBounds(150, 500, 500, 30);
        status.setFont(new Font("Candara", Font.BOLD, 20));
        status.setVisible(false);
        panel22.add(status);

        backP22 = new JButton("Back");
        backP22.setBounds(270, 430, 100, 32);
        backP22.setFont(new Font("Candara", Font.BOLD, 20));
        backP22.addActionListener(this);
        panel22.add(backP22);

        addP22 = new JButton("Add") ;
        addP22.setBounds(390, 430, 100, 32);
        addP22.setFont(new Font("Candara", Font.BOLD, 20));
        addP22.addActionListener(this);
        panel22.add(addP22);
        panel22.setVisible(false);

        //--------------------------------Panel 23-----------------------------------
        panel23 = new JPanel();
        panel23.setBounds(0, 0, 800, 700);
        panel23.setOpaque(false);
        panel23.setLayout(null);
        add(panel23);
// label on panel23
        DeleteQuestionsP23 = new JLabel("Delete Questions");
        DeleteQuestionsP23.setBounds(255,50 , 400,60);
        DeleteQuestionsP23.setFont(new Font("Candara",Font.BOLD,35));
        panel23.add(DeleteQuestionsP23);


// Table Showcasing on panel23
        tableP23 = new JTable();
        scrollPaneP23 = new JScrollPane(tableP23);
        scrollPaneP23.setBounds(1,100,800,400);
        panel23.add(scrollPaneP23);
        try {
            Connection connect = connection.create();
            String query = "select * from questionbank";
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            // Create a table model and populate it with the result set
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get column count
            int columnCount = metaData.getColumnCount();

            // Add columns to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    rowData[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(rowData);
            }

            // Set the table model to the JTable
            tableP23.setModel(tableModel);

//             Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        statusP23 = new JLabel();
        statusP23.setBounds(255,550 , 400,60);
        statusP23.setFont(new Font("Candara",Font.BOLD,35));
        statusP23.setVisible(false);
        panel23.add(statusP23);

        deleteP23 = new JButton("Delete") ;
        deleteP23.setBounds(400, 550, 100, 35);
        deleteP23.setFont(new Font("Candara", Font.BOLD, 20));
        deleteP23.addActionListener(this);
        panel23.add(deleteP23);


        BackP23 = new JButton("Back") ;
        BackP23.setBounds(280, 550, 100, 35);
        BackP23.setFont(new Font("Candara", Font.BOLD, 20));
        BackP23.addActionListener(this);
        panel23.add(BackP23);
        panel23.setVisible(false);


//--------------------------------Panel 24-----------------------------------
        panel24 = new JPanel();
        panel24.setBounds(0, 0, 800, 700);
        panel24.setOpaque(false);
        panel24.setLayout(null);
        add(panel24);
// label on Panel 24
        questionStat = new JLabel("View Questions");
        questionStat.setBounds(240,50 , 400,60);
        questionStat.setFont(new Font("Candara",Font.BOLD,35));
        panel24.add(questionStat);

        tableP24 = new JTable();
        scrollPaneP24 = new JScrollPane(tableP24);
        scrollPaneP24.setBounds(1,100,800,400);
        panel24.add(scrollPaneP24);
        try {
            Connection connect = connection.create();
            String query = "select * from questionbank";
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            // Create a table model and populate it with the result set
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get column count
            int columnCount = metaData.getColumnCount();

            // Add columns to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    rowData[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(rowData);
            }

            // Set the table model to the JTable
            tableP24.setModel(tableModel);

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


// Buttons on Panel 24
        backP24 = new JButton("Back") ;
        backP24.setBounds(350, 530, 100, 35);
        backP24.setFont(new Font("Candara", Font.BOLD, 20));
        backP24.addActionListener(this);
        panel24.add(backP24);
        panel24.setVisible(false);

        setVisible(true);
    }

    public boolean delete(int id) {
        boolean check = false;
        try {
            Connection connect = connection.create();
            String query = "delete from questionbank where ID = ?";
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setString(1,String.valueOf(id));
            ps.executeUpdate();

            check = true;

            if (check) {
                int selectedRow = tableP23.getSelectedRow();
                if (selectedRow != -1) {
                    ((DefaultTableModel) tableP23.getModel()).removeRow(selectedRow);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public void actionPerformed(ActionEvent e) {

//         if user clicks on question bank on panel16
        if(e.getSource() == questionBank) {
            panel16.setVisible(false);
            panel20.setVisible(true);
        }
//         if user clicks on view user data on panel16
        if(e.getSource() == viewData) {
            panel16.setVisible(false);
            panel17.setVisible(true);
        }
        if(e.getSource() == questionBank) {
            panel16.setVisible(false);
            panel20.setVisible(true);
        }

        // if user clicks on sign out button on panel16
        if(e.getSource() == signOutP16) {
            setVisible(false);
            new Login();
        }
        // if user clicks on back button on panel17
        if(e.getSource() == backP17) {
            panel17.setVisible(false);
            panel16.setVisible(true);
        }
//         if user clicks on Java button on panel20
        if(e.getSource() == cppP20) {
            subject = "C++";
            panel20.setVisible(false);
            panel21.setVisible(true);
        }

        if(e.getSource() == javaP20) {
            subject = "Java";
            panel20.setVisible(false);
            panel21.setVisible(true);
        }

        if(e.getSource() == pythonP20) {
            subject = "Python";
            panel20.setVisible(false);
            panel21.setVisible(true);
        }
//         if user clicks on back button on panel20
        if(e.getSource() == backP20) {
            panel20.setVisible(false);
            panel16.setVisible(true);
        }
//         if user clicks on Add Question on panel21
        if(e.getSource() == addQues) {
            panel21.setVisible(false);
            panel22.setVisible(true);
        }
//         if user clicks on delete Question on panel21
        if(e.getSource() == deleteQues) {
            panel21.setVisible(false);
            panel23.setVisible(true);
            repaint();
        }
//         if user clicks on view Question on panel21
        if(e.getSource() == viewQues) {
            panel21.setVisible(false);
            panel24.setVisible(true);
        }
//         if user clicks on back on panel21
        if(e.getSource() == backP21) {
            panel21.setVisible(false);
            panel20.setVisible(true);
        }

        //  if user clicks on Add on panel22
        if(e.getSource() == addP22) {
            if(QuestionStatementTextFieldP22.getText().equals("") || correctoptionfieldP22.getText().equals("")) {
                status.setText("Please make sure you have entered all the fields properly!");
                status.setBounds(150, 500, 500, 30);
                status.setVisible(true);
                repaint();
            } else {
                String questionStatementP22 = QuestionStatementTextFieldP22.getText();
                String correctOptionP22 = correctoptionfieldP22.getText();

                try {
                    Connection connect = connection.create();
                    String query = "insert into questionbank (Subject, Question_Statement, Correct_Option) values (?,?,?)";
                    PreparedStatement ps = connect.prepareStatement(query);
                    ps.setString(1, subject);
                    ps.setString(2, questionStatementP22);
                    ps.setString(3, correctOptionP22);
                    ps.executeUpdate();
                    status.setText("Data entered successfully!");
                    status.setBounds(270, 500, 500, 30);
                    status.setVisible(true);
                    repaint();

                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        }
//         if user clicks on back on panel22
        if(e.getSource() == backP22) {
            QuestionStatementTextFieldP22.setText("");
            correctoptionfieldP22.setText("");
            status.setText("");
            panel22.setVisible(false);
            panel21.setVisible(true);
        }

        // if user clicks on Add on panel23
        if(e.getSource() == BackP23) {
            panel23.setVisible(false);
            panel21.setVisible(true);
        }

        // if user clicks on delete button on P23
        if(e.getSource() == deleteP23) {
            int column = 0;
            int row = tableP23.getSelectedRow();
            String value = tableP23.getModel().getValueAt(row,column).toString();
            delete(Integer.valueOf(value));
            repaint();
        }

        // if user clicks on back button on P24
        if(e.getSource() == backP24) {
            panel24.setVisible(false);
            panel21.setVisible(true);
        }

    }
}
