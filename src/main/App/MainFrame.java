package main.App;

import main.App.Connectivity.DatabaseConnectivitySingleton;
import main.App.DAO.SurveyDAOImpl;
import main.App.Entity.User;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;
import javax.swing.AbstractButton;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainFrame extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
    }

    private final Font mainFont = new Font("Segoe Print", Font.BOLD, 15);
    private JTextField tfFirstName, tfLastName, tfContactNumber, tfDate, tfAge;
    private JLabel lbWelcome;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JComboBox<String> comboBox;

    public void initialize() {

        // Form panel
        comboBox = new JComboBox<String>(new String[] {"Pizza", "Pasta", "Pap and Wors", "Chicken stir fry", "Other"});
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JLabel lbContactNumber = new JLabel("Contact Number");
        lbContactNumber.setFont(mainFont);

        tfContactNumber = new JTextField();
        tfContactNumber.setFont(mainFont);

        JLabel lbDate = new JLabel("Date");
        lbDate.setFont(mainFont);

        tfDate = new JTextField();
        tfDate.setFont(mainFont);

        JLabel lbAge = new JLabel("Age");
        lbAge.setFont(mainFont);

        tfAge = new JTextField();
        tfAge.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);
        formPanel.add(lbContactNumber);
        formPanel.add(tfContactNumber);
        formPanel.add(lbDate);
        formPanel.add(tfDate);
        formPanel.add(lbAge);
        formPanel.add(tfAge);

        // Welcome label
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        radioButton1 = new JRadioButton("Pizza");
        radioButton2 = new JRadioButton("Pasta");
        radioButton3 = new JRadioButton("Pap And Wors");
        radioButton4 = new JRadioButton("Chicken And Stir Fry");
        radioButton5 = new JRadioButton("Beef And Stir Fry");
        radioButton6 = new JRadioButton("Other");
        
        ArrayList<JRadioButton> eat_out = new ArrayList<>();
        eat_out.add(new JRadioButton("1"));
        eat_out.add(new JRadioButton("2"));
        eat_out.add(new JRadioButton("3"));
        eat_out.add(new JRadioButton("4"));
        eat_out.add(new JRadioButton("5"));
        
        ArrayList<JRadioButton> watch_movies = new ArrayList<>();
        watch_movies.add(new JRadioButton("1"));
        watch_movies.add(new JRadioButton("2"));
        watch_movies.add(new JRadioButton("3"));
        watch_movies.add(new JRadioButton("4"));
        watch_movies.add(new JRadioButton("5"));
        
        ArrayList<JRadioButton> watch_tv = new ArrayList<>();
        
        watch_tv.add(new JRadioButton("1"));
        watch_tv.add(new JRadioButton("2"));
        watch_tv.add(new JRadioButton("3"));
        watch_tv.add(new JRadioButton("4"));
        watch_tv.add(new JRadioButton("5"));        
        
        ArrayList<JRadioButton> listen_to_radio = new ArrayList<>();;
        listen_to_radio.add(new JRadioButton("1"));
        listen_to_radio.add(new JRadioButton("2"));
        listen_to_radio.add(new JRadioButton("3"));
        listen_to_radio.add(new JRadioButton("4"));
        listen_to_radio.add(new JRadioButton("5"));
        
        radioButton1.setFont(mainFont);
        radioButton2.setFont(mainFont);
        radioButton3.setFont(mainFont);
        radioButton4.setFont(mainFont);
        radioButton5.setFont(mainFont);
        radioButton6.setFont(mainFont);

        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        radioButtonGroup.add(radioButton3);
        radioButtonGroup.add(radioButton4);
        radioButtonGroup.add(radioButton5);
        radioButtonGroup.add(radioButton6);
        
        
        ButtonGroup radioButtonGroupEatOut = new ButtonGroup();
        eat_out.stream().forEach( e -> {
            radioButtonGroupEatOut.add(e);
        });
        
        ButtonGroup radioButtonGroupwatch_tv = new ButtonGroup();
        watch_tv.stream().forEach( e -> {
            radioButtonGroupwatch_tv.add(e);
        });
        
        ButtonGroup radioButtonGroupwatch_movies = new ButtonGroup();
        watch_movies.stream().forEach( e -> {
            radioButtonGroupwatch_movies.add(e);
        });
        
        ButtonGroup radioButtonGrouplisten_to_radio = new ButtonGroup();
        listen_to_radio.stream().forEach( e -> {
            radioButtonGrouplisten_to_radio.add(e);
        });
        
        
        JPanel eat_outPanel = new JPanel(new GridLayout(1, 6, 0, 0));
        eat_outPanel.setName("eat_out");
        eat_outPanel.setOpaque(false);
        eat_outPanel.add(new JLabel("I like to eat out"));
        eat_outPanel.add(eat_out.get(0));
        eat_outPanel.add(eat_out.get(1));
        eat_outPanel.add(eat_out.get(2));
        eat_outPanel.add(eat_out.get(3));
        eat_outPanel.add(eat_out.get(4));
        
        
        JPanel watch_moviesPanel = new JPanel(new GridLayout(1, 6, 0, 0));
        watch_moviesPanel.setName("watch_movies");
        watch_moviesPanel.setOpaque(false);
        watch_moviesPanel.add(new JLabel("I like to watch movies"));
        watch_moviesPanel.add(watch_movies.get(0));
        watch_moviesPanel.add(watch_movies.get(1));
        watch_moviesPanel.add(watch_movies.get(2));
        watch_moviesPanel.add(watch_movies.get(3));
        watch_moviesPanel.add(watch_movies.get(4));
        
        JPanel watch_tvPanel = new JPanel(new GridLayout(1, 6, 0, 0));
        watch_tvPanel.setName("watch_tv");
        watch_tvPanel.setOpaque(false);
        watch_tvPanel.add(new JLabel("I like to watch TV"));
        watch_tvPanel.add(watch_tv.get(0));
        watch_tvPanel.add(watch_tv.get(1));
        watch_tvPanel.add(watch_tv.get(2));
        watch_tvPanel.add(watch_tv.get(3));
        watch_tvPanel.add(watch_tv.get(4));
        
        
        JPanel listen_to_radioPanel = new JPanel(new GridLayout(1, 6, 0, 0));
        listen_to_radioPanel.setName("listen_to_radioPanel");
        listen_to_radioPanel.setOpaque(false);
        listen_to_radioPanel.add(new JLabel("I like to listen to the radio"));
        listen_to_radioPanel.add(listen_to_radio.get(0));
        listen_to_radioPanel.add(listen_to_radio.get(1));
        listen_to_radioPanel.add(listen_to_radio.get(2));
        listen_to_radioPanel.add(listen_to_radio.get(3));
        listen_to_radioPanel.add(listen_to_radio.get(4));

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(6, 1, 0, 0));
        radioPanel.setOpaque(false);
        radioPanel.add(eat_outPanel);
        radioPanel.add(watch_moviesPanel);
        radioPanel.add(watch_tvPanel);
        radioPanel.add(listen_to_radioPanel);

        // Clear button
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfFirstName.setText("");
                tfLastName.setText("");
                tfContactNumber.setText("");
                tfDate.setText("");
                tfAge.setText("");
                lbWelcome.setText("");
            }
        });

        // OK button
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                String date = tfDate.getText();
                String age = tfAge.getText();
                lbWelcome.setText("Hello " + firstName + " " + lastName);

                SurveyDAOImpl surveyDAOImpl = new SurveyDAOImpl();
                System.out.println(getSelectedValue(radioButtonGroupEatOut));
                surveyDAOImpl.save(
                        new User(firstName, lastName, date, Integer.parseInt(age), 
                        		((String) comboBox.getSelectedItem()), 
                        		tfContactNumber.getText(), 
                        		getSelectedValue(radioButtonGroupEatOut), 
                        		getSelectedValue(radioButtonGroupwatch_movies), 
                        		getSelectedValue(radioButtonGroupwatch_tv),
                        		getSelectedValue(radioButtonGrouplisten_to_radio))
                );
                
                Results result = new Results(surveyDAOImpl);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnOK);
        buttonPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(lbWelcome);
        panel.add(radioPanel);
        mainPanel.add(panel);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        setTitle("Fortunate Internship Assessment");
        setSize(950, 600);
        setMinimumSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    int getSelectedValue(ButtonGroup componentGroup) {
    	Iterator<AbstractButton> radios = componentGroup.getElements().asIterator();
    	
    	int item = 0;
        while(radios.hasNext()) {
        	JRadioButton radio = (JRadioButton) radios.next(); 
        	if(radio.isSelected())
        		item = Integer.parseInt(radio.getText());
        }
    	return item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle radio button events if needed
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
        try {
            DatabaseConnectivitySingleton singleton = DatabaseConnectivitySingleton.getInstance();
            System.out.print("Show me what is happening with that connection: "+singleton.getConnection().getClientInfo());
        } catch (SQLException e) {
            // TODO Auto-generated catch  block
            e.printStackTrace();
        }
    }
}
