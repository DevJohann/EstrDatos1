package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainView extends JFrame {

	// Text
	private JLabel mainTitle;

	// Panels
	private TablePanel TP;

	// Buttons
	private JButton loadBtn;
	private JButton mathHighscoreBtn;
	private JButton bestHighscoreBtn;

	public MainView() {
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		initComponents();
	}

	public void initComponents() {

		// Text
		mainTitle = new JLabel("Lista");
		mainTitle.setBounds(280, 20, 100, 20);
		add(mainTitle);

		// Panels
		TP = new TablePanel();
		TP.setBounds(40, 100, 500, 200);
		// TP.setBackground(Color.green);
		add(TP);

		// Buttons
		loadBtn = new JButton("Cargar notas");
		loadBtn.setActionCommand("loadBtn");
		loadBtn.setBounds(40, 500, 120, 26);
		loadBtn.setFocusable(false);
		add(loadBtn);

		mathHighscoreBtn = new JButton("Mejor nota matemáticas");
		mathHighscoreBtn.setActionCommand("mathHighscoreBtn");
		mathHighscoreBtn.setBounds(180, 500, 180, 26);
		mathHighscoreBtn.setFocusable(false);
		add(mathHighscoreBtn);

		bestHighscoreBtn = new JButton("Mejor promedio");
		bestHighscoreBtn.setActionCommand("bestHighscoreBtn");
		bestHighscoreBtn.setBounds(380, 500, 150, 26);
		bestHighscoreBtn.setFocusable(false);
		add(bestHighscoreBtn);

		// TODO: Materia en la que perdieron más estudiantes
	}

	public JLabel getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(JLabel mainTitle) {
		this.mainTitle = mainTitle;
	}

	public TablePanel getTP() {
		return TP;
	}

	public void setTP(TablePanel tP) {
		TP = tP;
	}

	public JButton getLoadBtn() {
		return loadBtn;
	}

	public void setLoadBtn(JButton loadBtn) {
		this.loadBtn = loadBtn;
	}

	public JButton getMathHighscoreBtn() {
		return mathHighscoreBtn;
	}

	public void setMathHighscoreBtn(JButton mathHighscoreBtn) {
		this.mathHighscoreBtn = mathHighscoreBtn;
	}

	public JButton getBestHighscoreBtn() {
		return bestHighscoreBtn;
	}

	public void setBestHighscoreBtn(JButton bestHighscoreBtn) {
		this.bestHighscoreBtn = bestHighscoreBtn;
	}

}
