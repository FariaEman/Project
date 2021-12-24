package application;
import java.io.IOException;
import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SampleController  { 
	
	
	@FXML
	
	private TextField UserField;
	@FXML
	private PasswordField PasswordTextField;
	@FXML
	private Button LoginAsManager;
	@FXML
	private Button LoginAsSalesPerson;
	@FXML
	private Label SuccessField;
	@FXML
	private AnchorPane rootPane;
	@FXML
	private TextField medicineID;
	@FXML
	private Button AddMedicineButton;
	@FXML
	private Button DeleteMedicineButton;
	@FXML
	private Button ViewMedicinesButton;
	@FXML
	private TextField medicineName;
	@FXML
	private TextField medicineDescription;
	@FXML
	private TextField medicinePrice;
	@FXML
	private Button AddButton;
	@FXML
	private Button BackButtonManagerView;
	@FXML 
	private Label medicineAddedSuccessfully;
	@FXML
	private Button backFromViewSales;
	@FXML
	private Button backDeleteMedicine;
	@FXML
	private Button backFromAddMedicine;
	@FXML
	private Button StartNewSaleButton;
	@FXML
	private TextField NewSaleMedicineID;
	@FXML
	private TextField NewSaleMedicineName;
	@FXML
	private TextField NewSaleMedicineQty;
	@FXML
	private TextField NewSaleMedicinePrice;
	@FXML
	private Date dateFieldNewSale;
	@FXML
	private TextField NewSalePaymentMethod;
	@FXML
	private Button AddNewSaleButton;
	@FXML
	private Button Return;
	@FXML
	private Label Reciept;
	@FXML
	private Button ViewSalesButtonSalesPerson;
	@FXML
	private Button BackFromSalesPerson;
	@FXML
	private Button BackFromAddNewSale;
	@FXML
	private Button BackFromReturnItem;
	@FXML
	private Button BackFromViewSalesAsSalesPerson;
	@FXML
	TableView<Medicine> tableAddMedicine;
	@FXML
	TableColumn<Medicine,Integer> MedicineIDColumn;
	@FXML
	TableColumn<Medicine,String > MedicineNameColumn;
	@FXML
	TableColumn<Medicine,String> MedicineQtyColumn;
	@FXML
	TableColumn<Medicine,String> MedicinePriceColumn;
	ObservableList<Medicine> MedicineTable = FXCollections.observableArrayList();
	public void BackFunc(String fxmlFile,Button b1) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		//pharmacy = new Pharmacy();
		Stage window=new Stage();
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fxmlFile));	
		Scene scene = new Scene(root,600,600);
		scene.getStylesheets().add(getClass ().getResource("application.css").toExternalForm());
		window = (Stage) b1.getScene().getWindow(); 
		window.setScene(scene);
		window.show();
	}
	public void NewWindow(String fxmlFileName, Button b) throws IOException
	{
		Stage window=new Stage();
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fxmlFileName));
		Scene scene = new Scene(root,600, 600); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window = (Stage) b.getScene().getWindow(); 
		window.setScene(scene);
		window.show();
	}
	public void loginAsManagerFunc() throws IOException //throws IOException 
, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		SampleController();
		if(pharmacy.ManagerLogin(UserField.getText(), PasswordTextField.getText()))
		{
		
			SuccessField.setText("Login Successful");
			NewWindow("LoginAsManagerView.fxml",LoginAsManager);
		}
		else
		{
			SuccessField.setText("User Name or Password incorrect");
		}
		
	}
	public void addNewMedicineFunc() throws IOException
	{
		
		NewWindow("AddSale.fxml",AddMedicineButton);
		
	}
	
	public void AddButtonFunc()
	{
		
		 if(medicineName.getText().equals("") ||  medicineID.getText().equals("") ||  medicinePrice.getText().equals("") || medicineDescription.getText().equals(""))
		{
			medicineAddedSuccessfully.setText("Please Provide Complete Information");
		}
		else
		{
			medicineAddedSuccessfully.setText("Medicine Added Successfully");
		}
	}
	public void DeleteMedicine() throws IOException
	{
	    NewWindow("DeleteMedicine.fxml",DeleteMedicineButton);
	    
	}
	
	public void ViewSales() throws IOException
	{
		NewWindow("ViewSales.fxml",ViewMedicinesButton);
	}
	public void ViewSalesAsSalesPerson() throws IOException
	{
		NewWindow("viewSalesAsSalesPerson.fxml",ViewSalesButtonSalesPerson);
	}
	public void loginSalesPersonFunc() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		pharmacy=new Pharmacy();
		if(pharmacy.SalesPersonLogin(UserField.getText() ,PasswordTextField.getText()))
		{
			
			NewWindow("LoginAsSalesPersonView.fxml",LoginAsSalesPerson);
			
		}
		else
		{
			SuccessField.setText("User Name or Password incorrect");
		}
	}
	public void backFromManagerFunc() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		BackFunc("Sample.fxml",BackButtonManagerView);
	}
	public void backFromAddMedicineFunc() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		BackFunc("loginAsManagerView.fxml",backFromAddMedicine);
	}
	public void backFromDeleteMedicineFunc() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		BackFunc("loginAsManagerView.fxml",backDeleteMedicine);
	}
	public void backFromViewSale() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		BackFunc("loginAsManagerView.fxml",backFromViewSales);
	}
	public void StartNewSaleButton() throws IOException
	{
		NewWindow("StartNewSales.fxml",StartNewSaleButton);
	}
	String NMedicineID;
	String NMedicineName;
	String MedicineQty;
	String NMedicinePrice;
	String NPaymentMethod;
	public void AddNewSaleButtonFunc()
	{   NMedicineID=NewSaleMedicineID.getText();
	    NMedicineName=NewSaleMedicineName.getText();
	    MedicineQty=NewSaleMedicineQty.getText();
	    NMedicinePrice=NewSaleMedicinePrice.getText();
	    NPaymentMethod=NewSalePaymentMethod.getText();
	    
		Reciept.setText(" ID \t\t Name \t\t Qty \t\t Total \r\n " + NMedicineID+"\t\t"+NMedicineName+"\t\t"+MedicineQty+"\t\t"+NPaymentMethod);
		
	   
	     
	}
	public void HandleReturn() throws IOException
	{
		NewWindow("Return.fxml",Return);
	}
    public void BackFromSalesPersonView() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
    	BackFunc("Sample.fxml", BackFromSalesPerson);
    }
    public void BackFromReturnSaleButtonFunc() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
    	BackFunc("loginAsSalesPersonView.fxml",BackFromReturnItem);
    }
   
    public void BackFromViewSalesButtonFunc() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
    	BackFunc("LoginAsSalesPersonView.fxml",BackFromViewSalesAsSalesPerson);
    }
    public void BackFromAddNewSaleButtonFunc() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
    	BackFunc("LoginAsSalesPersonView.fxml",BackFromAddNewSale);
    }
    public void TableShow()
    {
    	
    }
    
		//Pharmacy pharmacy =new Pharmacy();
}

