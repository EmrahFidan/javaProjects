package application;

import java.io.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.*;

public class Main extends Application {
	int index = 0;
	int m = 0;
	public String selectedItemString;
	String none = "None";
	String n = "\n";
	Employee[] abArray;
	public Employee[] abArray2 = new Employee[100];

	// Text fields
	TextField tfFirstName = new TextField();
	TextField tfLastName = new TextField();
	TextField tfSSN = new TextField();
	TextField tfSearchUpdateSSN = new TextField();
	TextField tfGrossSales = new TextField();
	TextField tfCommissionRate = new TextField();
	TextField tfBaseSalary = new TextField();
	TextField tfWeeklySalary = new TextField();
	TextField tfWage = new TextField();
	TextField tfHours = new TextField();

	// Buttons
	Button btAdd = new Button("Add");
	Button btSearchbySSN = new Button("Search by SSN");
	Button btUpdatebySSN = new Button("Update by SSN");
	Button btCleantextFiles = new Button("Clean textFiles");

	// Labels
	Label lbFirstName = new Label("First Name");
	Label lbLastName = new Label("Last Name");
	Label lbSSN = new Label("SSN");
	Label lbSearchUpdateSSN = new Label("Search/Update SSN");
	Label lbSalary = new Label("SALARY");
	Label lbSalary2 = new Label("VALUE");
	Label lbGrossSales = new Label("Gross Sales");
	Label lbCommissonRate = new Label("Commission Rate");
	Label lbBaseSalary = new Label("Base Salary");
	Label lbWeeklySalary = new Label("Weekly Salary");
	Label lbWage = new Label("Wage");
	Label lbHours = new Label("Hours");
	Label lbComboBox = new Label("Choose Employee Type");

	// dosya oluşturma
	static File data = new File("kod.txt");

	// uygulama çalıştırıldığında ilk çalışacak yer (main)
	@Override
	public void start(Stage primaryStage) {
		try {

			// Create a combo box
			ComboBox<String> combo_box = new ComboBox();
			// Create a tile pane
			TilePane tile_pane = new TilePane(combo_box);
			// Create a scene
			Scene scene = new Scene(tile_pane, 200, 200);

			combo_box.getItems().add("Salaried Employee");
			combo_box.getItems().add("Hourly Employee");
			combo_box.getItems().add("Commission Employee");
			combo_box.getItems().add("Base Plus Commission Employee");
			combo_box.getItems().add("None");

			// comboBox AÇ-Kapa
			combo_box.setEditable(false);

			// Set the scene
			primaryStage.setScene(scene);
			primaryStage.show();

			// kullanıcıya mesajlar
			Alert AlertInformation = new Alert(AlertType.INFORMATION);
			Alert AlertWarning = new Alert(AlertType.WARNING);
			AlertInformation.setTitle("INFO");
			AlertWarning.setTitle("WARNING");

			// Butonların pencereye yerleştirilmesi
			GridPane p1 = new GridPane();
			GridPane p2 = new GridPane();
			p2.setHgap(20);
			p2.setVgap(10);

			p2.add(lbComboBox, 8, 3);
			p2.add(combo_box, 10, 3);
			p1.setAlignment(Pos.CENTER);
			p1.setHgap(20);
			p1.setVgap(10);

			p1.add(lbFirstName, 0, 0);
			p1.add(tfFirstName, 1, 0);

			p1.add(lbLastName, 0, 1);
			p1.add(tfLastName, 1, 1);

			p1.add(lbSSN, 0, 2);
			p1.add(tfSSN, 1, 2);

			p1.add(lbSearchUpdateSSN, 0, 3);
			p1.add(tfSearchUpdateSSN, 1, 3);

			p1.add(lbSalary, 0, 4);
			p1.add(lbSalary2, 1, 4);

			p1.add(lbGrossSales, 3, 0);
			p1.add(tfGrossSales, 4, 0);

			p1.add(lbCommissonRate, 3, 1);
			p1.add(tfCommissionRate, 4, 1);

			p1.add(lbBaseSalary, 3, 2);
			p1.add(tfBaseSalary, 4, 2);

			p1.add(lbWeeklySalary, 3, 3);
			p1.add(tfWeeklySalary, 4, 3);

			p1.add(lbWage, 3, 4);
			p1.add(tfWage, 4, 4);

			p1.add(lbHours, 3, 5);
			p1.add(tfHours, 4, 5);

			HBox p3 = new HBox();
			p3.setSpacing(20);
			p3.setPadding(new Insets(0, 200, 15, 200));
			p3.getChildren().addAll(btAdd, btSearchbySSN, btUpdatebySSN, btCleantextFiles);

			// Pencerenin kullanıcı ekranınndaki görünümü
			BorderPane borderPane = new BorderPane();
			borderPane.setTop(p2);
			borderPane.setCenter(p1);
			borderPane.setBottom(p3);

			scene = new Scene(borderPane, 785, 425);
			primaryStage.setTitle("EMPLOYEE SALARY CALCULATOR");
			primaryStage.setScene(scene);
			primaryStage.show();

			// default textField
			tfSSN.setDisable(true);
			tfSearchUpdateSSN.setDisable(false);
			tfFirstName.setDisable(true);
			tfLastName.setDisable(true);
			tfSSN.setDisable(true);
			tfWeeklySalary.setDisable(true);
			tfBaseSalary.setDisable(true);
			tfCommissionRate.setDisable(true);
			tfGrossSales.setDisable(true);
			tfWage.setDisable(true);
			tfHours.setDisable(true);

			// comboBox buttonu
			combo_box.setOnAction((event) -> {

				Object selectedItem = combo_box.getSelectionModel().getSelectedItem();
				selectedItemString = String.valueOf(selectedItem);

				switch (selectedItemString) {

				case "Salaried Employee":
					tfFirstName.setDisable(false);
					tfLastName.setDisable(false);
					tfWeeklySalary.setDisable(false);
					tfBaseSalary.setDisable(true);
					tfCommissionRate.setDisable(true);
					tfGrossSales.setDisable(true);
					tfWage.setDisable(true);
					tfHours.setDisable(true);
					cleanTextFields();
					break;

				case "None":
					tfFirstName.setDisable(true);
					tfLastName.setDisable(true);
					tfWeeklySalary.setDisable(true);
					tfBaseSalary.setDisable(true);
					tfCommissionRate.setDisable(true);
					tfGrossSales.setDisable(true);
					tfWage.setDisable(true);
					tfHours.setDisable(true);
					cleanTextFields();
					break;

				case "Hourly Employee":
					tfFirstName.setDisable(false);
					tfLastName.setDisable(false);
					tfWeeklySalary.setDisable(true);
					tfBaseSalary.setDisable(true);
					tfCommissionRate.setDisable(true);
					tfGrossSales.setDisable(true);
					tfWage.setDisable(false);
					tfHours.setDisable(false);
					cleanTextFields();
					break;

				case "Commission Employee":
					tfFirstName.setDisable(false);
					tfLastName.setDisable(false);
					tfWeeklySalary.setDisable(true);
					tfBaseSalary.setDisable(true);
					tfCommissionRate.setDisable(false);
					tfGrossSales.setDisable(false);
					tfWage.setDisable(true);
					tfHours.setDisable(true);
					cleanTextFields();
					break;

				case "Base Plus Commission Employee":
					tfFirstName.setDisable(false);
					tfLastName.setDisable(false);
					tfWeeklySalary.setDisable(true);
					tfBaseSalary.setDisable(false);
					tfCommissionRate.setDisable(false);
					tfGrossSales.setDisable(false);
					tfWage.setDisable(true);
					tfHours.setDisable(true);
					cleanTextFields();
					break;

				default:
					throw new IllegalArgumentException("Unexpected value: " + selectedItemString);
				}
			});

			// buton add
			btAdd.setOnAction(e -> {
				try {
					if (data.exists()) {
						readFileFillArray(abArray2);
					}
					writeAddressToFile(combo_box);
					readFileFillArray(abArray2);
					clearFile();
					writeArrayToFile(abArray2);

					AlertInformation.setContentText("Employee is added successfully");
					AlertInformation.showAndWait();
					cleanTextFields();

				} catch (Exception ex) {
					// TODO: handle exception
				}

			});

			// buton Search
			btSearchbySSN.setOnAction(e -> {

				if (tfSearchUpdateSSN.getText().length() == 0) {
					AlertWarning.setContentText("Search box cannot be empty!");
					AlertWarning.showAndWait();
				}
				if (Integer.parseInt(tfSearchUpdateSSN.getText()) > index
						|| Integer.parseInt(tfSearchUpdateSSN.getText()) <= 0) {
					AlertWarning.setContentText("No record found with the SSN you are looking for!");
					AlertWarning.showAndWait();
				} else {

					int m = Integer.parseInt(tfSearchUpdateSSN.getText());
					searchArray(abArray2, m - 1, combo_box);
					clearFile();
					try {
						writeArrayToFile(abArray2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			});

			// buton Update
			btUpdatebySSN.setOnAction(e -> {

				if (index <= abArray2.length) {
					int n = Integer.parseInt(tfSSN.getText());
					update(abArray2, n - 1, combo_box);
					clearFile();
					try {
						writeArrayToFile(abArray2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cleanTextFields();

					AlertInformation.setContentText("Employee is updated successfully");
					AlertInformation.showAndWait();
				}

			});

			btCleantextFiles.setOnAction(e -> {
				cleanTextFields();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// yazma fonksiyonu
	public void bWriter(String s) {
		try {
			FileWriter fwriter = new FileWriter(data, true);
			BufferedWriter bWriter = new BufferedWriter(fwriter);
			bWriter.write(s);
			bWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// diziyi dosyaya yaz
	public void writeArrayToFile(Employee[] abArray2) throws IOException {
		m = 0;
		while (abArray2[m] != null) {
			switch (abArray2[m].getClass().getName()) {
			case "application.SalariedEmployee":
				SalariedEmployee x = (SalariedEmployee) abArray2[m];
				bWriter("Salaried Employee" + n);
				bWriter(x.getFirstName() + n);
				bWriter(x.getLastName() + n);
				bWriter(x.getSSN() + n);
				bWriter(x.getWeeklySalary() + n);
				bWriter(x.getPaymentAmount()+n);
				bWriter("------------------"+n);
				m++;
				break;

			case "application.HourlyEmployee":
				HourlyEmployee x1 = (HourlyEmployee) abArray2[m];
				bWriter("Hourly Employee" + n);
				bWriter(x1.getFirstName() + n);
				bWriter(x1.getLastName() + n);
				bWriter(x1.getSSN() + n);
				bWriter(x1.getWage() + n);
				bWriter(x1.getHours() + n);
				bWriter(x1.getPaymentAmount()+n);
				bWriter("------------------"+n);
				m++;
				break;

			case "application.CommissionEmployee":
				CommissionEmployee x2 = (CommissionEmployee) abArray2[m];
				bWriter("Commission Employee" + n);
				bWriter(x2.getFirstName() + n);
				bWriter(x2.getLastName() + n);
				bWriter(x2.getSSN() + n);
				bWriter(x2.getGrossSales() + n);
				bWriter(x2.getCommissionRate() + n);
				bWriter(x2.getPaymentAmount()+n);
				bWriter("------------------"+n);
				m++;
				break;
			case "application.BasePlusCommissionEmployee":
				BasePlusCommissionEmployee x3 = (BasePlusCommissionEmployee) abArray2[m];
				bWriter("Base Plus Commission Employee" + n);
				bWriter(x3.getFirstName() + n);
				bWriter(x3.getLastName() + n);
				bWriter(x3.getSSN() + n);
				bWriter(x3.getGrossSales() + n);
				bWriter(x3.getCommissionRate() + n);
				bWriter(x3.getBaseSalary() + n);
				bWriter(x3.getPaymentAmount()+n);
				bWriter("------------------"+n);
				m++;
				break;
			}
		}
	}

	// dosyayı diziye yaz
	public void writeAddressToFile(ComboBox combo_box) {
		String FirstName = tfFirstName.getText();
		String LastName = tfLastName.getText();
		String SSN = String.valueOf(index + 1);
		String WeeklySalary;
		Double Wage;
		Double Hours;
		Double GrossSales;
		Double CommissionRate;
		Double BaseSalary;
		Object selectedItem = combo_box.getSelectionModel().getSelectedItem();
		Double PaymentAmount;
		selectedItemString = String.valueOf(selectedItem);

		switch (selectedItemString) {
		case "Salaried Employee":
			WeeklySalary = tfWeeklySalary.getText();
			bWriter("Salaried Employee" + n);
			bWriter(FirstName + n);
			bWriter(LastName + n);
			bWriter(SSN + n);
			bWriter(WeeklySalary + n);
			bWriter(WeeklySalary+n);
			bWriter("------------------"+n);
			break;
		case "Hourly Employee":
			Wage = Double.parseDouble(tfWage.getText()+n);
			Hours = Double.parseDouble(tfHours.getText()+n);
			bWriter("Hourly Employee" + n);
			bWriter(FirstName + n);
			bWriter(LastName + n);
			bWriter(SSN + n);
			bWriter(String.valueOf(Wage) +n);
			bWriter(String.valueOf(Hours) + n);
			if(Hours<=40) {
				PaymentAmount=Wage*Hours;
			}
			else {
				PaymentAmount = (40*Wage + (Hours- 40)*(Wage* 1.5));
			}
			bWriter(String.valueOf(PaymentAmount)+n);
			bWriter("------------------"+n);
			break;

		case "Commission Employee":
			GrossSales = Double.parseDouble(tfGrossSales.getText()+n);
			CommissionRate = Double.parseDouble(tfCommissionRate.getText()+n);
			bWriter("Commission Employee" + n);
			bWriter(FirstName + n);
			bWriter(LastName + n);
			bWriter(SSN + n);
			bWriter(String.valueOf(GrossSales) +n);
			bWriter(String.valueOf(CommissionRate) +n);
			PaymentAmount = CommissionRate * GrossSales;
			bWriter(String.valueOf(PaymentAmount)+n);
			bWriter("------------------"+n);
			break;
		case "Base Plus Commission Employee":
			GrossSales = Double.parseDouble(tfGrossSales.getText()+n);
			CommissionRate = Double.parseDouble(tfCommissionRate.getText()+n);
			BaseSalary = Double.parseDouble(tfBaseSalary.getText()+n);
			bWriter("Base Plus Commission Employee" + n);
			bWriter(FirstName + n);
			bWriter(LastName + n);
			bWriter(SSN + n);
			bWriter(String.valueOf(GrossSales) +n);
			bWriter(String.valueOf(CommissionRate) +n);
			bWriter(String.valueOf(BaseSalary) +n);
			PaymentAmount = (CommissionRate * GrossSales)+ BaseSalary;
			bWriter(String.valueOf(PaymentAmount)+n);
			bWriter("------------------"+n);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + selectedItemString);
		}

	}

	// dosyayı okuma fonksiyonu
	public String bReader() {
		try {
			FileReader freader = new FileReader(data);
			BufferedReader bReader = new BufferedReader(freader);
			String line = bReader.readLine();
			bReader.close();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	// diziyi okuma
	public void readFileFillArray(Employee[] abArray2) throws IOException {
		index = 0;
		int k = 0;
		int counter = 1;
		String[] lineArray = new String[1000];
		int lineIndex = 0;
		FileReader freader = new FileReader(data);
		BufferedReader bReader = new BufferedReader(freader);
		String line;
		while ((line = bReader.readLine()) != null) {
			lineArray[lineIndex] = line;
			lineIndex++;
		}
		bReader.close();

		while (k < lineIndex) {
			String HeadLine;
			String firstName;
			String lastName;
			String SSN;
			Double WeeklySalary;
			Double Wage;
			Double Hours;
			Double GrossSales;
			Double CommissionRate;
			Double BaseSalary;
			Employee p1;
			switch (lineArray[k]) {
			case "Salaried Employee":
				HeadLine = lineArray[k];
				firstName = lineArray[k + 1];
				lastName = lineArray[k + 2];
				SSN = String.valueOf(counter);
				WeeklySalary = Double.parseDouble(lineArray[k + 4]);
				p1 = new SalariedEmployee(firstName, lastName, SSN, WeeklySalary);
				abArray2[index] = p1;
				k = k + 7;
				index++;
				break;

			case "Hourly Employee":
				HeadLine = lineArray[k];
				firstName = lineArray[k + 1];
				lastName = lineArray[k + 2];
				SSN = String.valueOf(counter);
				Wage = Double.parseDouble(lineArray[k + 4]);
				Hours = Double.parseDouble(lineArray[k + 5]);
				p1 = new HourlyEmployee(firstName, lastName, SSN, Wage, Hours);
				abArray2[index] = p1;
				k = k + 8;
				index++;
				break;

			case "Commission Employee":
				HeadLine = lineArray[k];
				firstName = lineArray[k + 1];
				lastName = lineArray[k + 2];
				SSN = String.valueOf(counter);
				GrossSales = Double.parseDouble(lineArray[k + 4]);
				CommissionRate = Double.parseDouble(lineArray[k + 5]);
				p1 = new CommissionEmployee(firstName, lastName, SSN, GrossSales, CommissionRate);
				abArray2[index] = p1;
				k = k + 8;
				index++;
				break;

			case "Base Plus Commission Employee":
				HeadLine = lineArray[k];
				firstName = lineArray[k + 1];
				lastName = lineArray[k + 2];
				SSN = String.valueOf(counter);
				GrossSales = Double.parseDouble(lineArray[k + 4]);
				CommissionRate = Double.parseDouble(lineArray[k + 5]);
				BaseSalary = Double.parseDouble(lineArray[k + 6]);
				p1 = new BasePlusCommissionEmployee(firstName, lastName, SSN, GrossSales, CommissionRate, BaseSalary);
				abArray2[index] = p1;
				k = k + 9;
				index++;
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
			counter++;
		}
	}

	// Search SSN
	public void searchArray(Employee[] abArray2, int index2, ComboBox combo_box) {

		String m = abArray2[index2].getClass().getName();

		switch (m) {
		case "application.SalariedEmployee":
			combo_box.getSelectionModel().select(0);
			tfFirstName.setText(((Employee) abArray2[index2]).getFirstName());
			tfLastName.setText(((Employee) abArray2[index2]).getLastName());
			tfSSN.setText(((Employee) abArray2[index2]).getSSN());
			tfWeeklySalary.setText(String.valueOf(((SalariedEmployee) abArray2[index2]).getWeeklySalary()));
			lbSalary2.setText(String.valueOf(((Employee) abArray2[index2]).getPaymentAmount()));
			break;

		case "application.HourlyEmployee":
			combo_box.getSelectionModel().select(1);
			tfFirstName.setText(((Employee) abArray2[index2]).getFirstName());
			tfLastName.setText(((Employee) abArray2[index2]).getLastName());
			tfSSN.setText(((Employee) abArray2[index2]).getSSN());
			tfWage.setText(String.valueOf(((HourlyEmployee) abArray2[index2]).getWage()));
			tfHours.setText(String.valueOf(((HourlyEmployee) abArray2[index2]).getHours()));
			lbSalary2.setText(String.valueOf(((Employee) abArray2[index2]).getPaymentAmount()));
			break;

		case "application.CommissionEmployee":
			combo_box.getSelectionModel().select(2);
			tfFirstName.setText(((Employee) abArray2[index2]).getFirstName());
			tfLastName.setText(((Employee) abArray2[index2]).getLastName());
			tfSSN.setText(((Employee) abArray2[index2]).getSSN());
			tfGrossSales.setText(String.valueOf(((CommissionEmployee) abArray2[index2]).getGrossSales()));
			tfCommissionRate.setText(String.valueOf(((CommissionEmployee) abArray2[index2]).getCommissionRate()));
			lbSalary2.setText(String.valueOf(((Employee) abArray2[index2]).getPaymentAmount()));
			break;

		case "application.BasePlusCommissionEmployee":
			combo_box.getSelectionModel().select(3);
			tfFirstName.setText(((Employee) abArray2[index2]).getFirstName());
			tfLastName.setText(((Employee) abArray2[index2]).getLastName());
			tfSSN.setText(((Employee) abArray2[index2]).getSSN());
			tfGrossSales.setText(String.valueOf(((CommissionEmployee) abArray2[index2]).getGrossSales()));
			tfCommissionRate.setText(String.valueOf(((CommissionEmployee) abArray2[index2]).getCommissionRate()));
			tfBaseSalary.setText(String.valueOf(((BasePlusCommissionEmployee) abArray2[index2]).getBaseSalary()));
			lbSalary2.setText(String.valueOf(((Employee) abArray2[index2]).getPaymentAmount()));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + selectedItemString);
		}
	}

	// employee update function
	public void update(Employee[] abArray2, int index2, ComboBox combo_box) {
		Object selectedItem = combo_box.getSelectionModel().getSelectedItem();
		selectedItemString = String.valueOf(selectedItem);
		abArray2[index2].setFirstName(tfFirstName.getText());
		abArray2[index2].setLastName(tfLastName.getText());
		abArray2[index2].setSSN(tfSSN.getText());

		switch (selectedItemString) {
		case "Salaried Employee":
			combo_box.getSelectionModel().select(0);
			((SalariedEmployee) abArray2[index2]).setWeeklySalary(Double.parseDouble(tfWeeklySalary.getText()));
			break;

		case "Hourly Employee":
			combo_box.getSelectionModel().select(1);
			((HourlyEmployee) abArray2[index2]).setWage(Double.parseDouble(tfWage.getText()));
			((HourlyEmployee) abArray2[index2]).setHours(Double.parseDouble(tfHours.getText()));
			break;

		case "Commission Employee":
			combo_box.getSelectionModel().select(2);
			((CommissionEmployee) abArray2[index2]).setGrossSales(Double.parseDouble(tfGrossSales.getText()));
			((CommissionEmployee) abArray2[index2]).setCommissionRate(Double.parseDouble(tfCommissionRate.getText()));
			break;

		case "Base Plus Commission Employee":
			combo_box.getSelectionModel().select(3);
			((BasePlusCommissionEmployee) abArray2[index2]).setGrossSales(Double.parseDouble(tfGrossSales.getText()));
			((BasePlusCommissionEmployee) abArray2[index2])
					.setCommissionRate(Double.parseDouble(tfCommissionRate.getText()));
			((BasePlusCommissionEmployee) abArray2[index2]).setBaseSalary(Double.parseDouble(tfBaseSalary.getText()));
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + selectedItemString);
		}

	}

	// dosyayı temizleme (for update operations)
	public static void clearFile() {
		try {
			FileWriter fw = new FileWriter(data, false);
			PrintWriter pw = new PrintWriter(fw, false);
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception exception) {
			System.out.println("Exception have been caught");
		}

	}
	
	// text file temizleme
		public void cleanTextFields() {
			tfFirstName.clear();
			tfLastName.clear();
			tfSSN.clear();
			tfSearchUpdateSSN.clear();
			tfGrossSales.clear();
			tfCommissionRate.clear();
			tfBaseSalary.clear();
			tfWeeklySalary.clear();
			tfWage.clear();
			tfHours.clear();
			lbSalary2.setText("VALUE");

		}

	public static void main(String[] args) {
		launch(args);
	}

}