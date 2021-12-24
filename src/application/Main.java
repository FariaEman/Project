package application;
import java.io.IOException;
import java.util.ArrayList;  
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {		
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("yes");
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println("yes");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
//		pharmacy.StartSale();
//		pharmacy.EnterProduct(1, 999);
//		float x=pharmacy.EnterProduct(2, 222);
//		
//		pharmacy.StartPayment("CashPayment");
//		float y=pharmacy.MakePayment(x, 5000);
//		pharmacy.closeSale();
//		System.out.println(x+" "+y);
		//MedicineCatalog catalog=pharmacy.getMedicineCatalog();
	     //catalog.DisplayCatalog();
	     DBHandler ob=new MySQL();
	    // ob.getManager("Wasay1", "1234");
	     //System.out.println(pharmacy.ManagerLogin("Wasay1","1234"));
	     //ob.getSalesPerson("off", "aunoff");
	
		launch(args);
	}
}
