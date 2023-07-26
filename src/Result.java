import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Result extends JFrame implements ActionListener {


    // panel13 components
    static JPanel panel13;
    static JButton backP13;
    static JTable table;
    static JScrollPane scrollPane;

    String userName;



    Result(String userName){
        setSize(800, 700);
        setTitle("CodePro Certification System");
        setLayout(null);
        setLocation(320, 10);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(false);
        setResizable(false);

        this.userName = userName;


        // ---------------------------- Panel 13 ---------------------------------------
        panel13 = new JPanel();
        panel13.setBounds(0, 0, 800, 700);
        panel13.setOpaque(false);
        panel13.setLayout(null);
        add(panel13);


        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(1,1,800,400);
        panel13.add(scrollPane);
        try {
            Connection connect = connection.create();
            String query = "select * from quizperformances where username = '"+userName+"'";
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
            table.setModel(tableModel);

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        // back button on panel13
        backP13 = new JButton("Back to main menu");
        backP13.setBounds(300,450,200,40);
        backP13.setFont(new Font("Candara",Font.BOLD,20));
        backP13.addActionListener(this);
        panel13.add(backP13);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {


        // if user clicks on back button on panel13
        if(e.getSource() == backP13) {
            setVisible(false);
            new User(userName);
        }

    }
}
