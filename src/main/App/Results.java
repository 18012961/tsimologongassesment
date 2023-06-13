package main.App;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.App.DAO.SurveyDAOImpl;

import javax.swing.JLabel;
import java.awt.GridLayout;

public class Results{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();;
	
	JFrame frame;
	JLabel label;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_6;
	
	JLabel lblNewLabel_7;
	JLabel lblNewLabel_8;
	JLabel lblNewLabel_9;
	JLabel lblNewLabel_10;
	
	private void initialize(SurveyDAOImpl surveyInfo) {
		
		frame = new JFrame();
		label = new JLabel("Survey Results");
		lblNewLabel = new JLabel(String.format("Total number of surveys:		%d", +surveyInfo.getTotalNumberOfSurveys()));
		lblNewLabel_1 = new JLabel("Average age:		"+surveyInfo.getAverageAge());
		lblNewLabel_2 = new JLabel("Oldest person who participated in survey:		"+surveyInfo.getOldPersonToParticipate());
		lblNewLabel_3 = new JLabel("Youngest person who participated in survey:		"+surveyInfo.getYoungPersonToParticipate());
		
		lblNewLabel_4 = new JLabel("Percentage of people who like Pizza:		"+surveyInfo.getPeopleWhoLikePizza());
		lblNewLabel_5 = new JLabel("Percentage of people who like Pasta:		"+surveyInfo.getPeopleWhoLikePasta());
		lblNewLabel_6 = new JLabel("Percentage of people who like Pap and Wors:		"+surveyInfo.getPeopleWhoLikePapa_n_Wors());
		
		lblNewLabel_7 = new JLabel("People like to eat out:		"+surveyInfo.getPeopleLikeToEatOut());
		lblNewLabel_8 = new JLabel("People like to watch movies:		"+surveyInfo.getPeopleLikeToWatchMovies());
		lblNewLabel_9 = new JLabel("People like to watch TV:		"+surveyInfo.getPeopleLikeToWatchTV());
		lblNewLabel_10 = new JLabel("People like to listen to the radio:		"+surveyInfo.getPeopleLikeListenToRadio());
	}
	
	/**
	 * Create the frame.
	 */
	public Results(SurveyDAOImpl surveyInfo) {
		initialize(surveyInfo);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(14, 1, 0, 0));
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(new JLabel(""));
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(new JLabel(""));
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_8);
		contentPane.add(lblNewLabel_9);
		contentPane.add(lblNewLabel_10);	
		frame.setVisible(true);
		
		
	}
}
