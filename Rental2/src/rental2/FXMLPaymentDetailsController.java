/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class FXMLPaymentDetailsController implements Initializable {
    /**
     * Button to handle change of scene
     */
    @FXML
    public void changescene1Button(ActionEvent event) throws IOException{
        Parent Payment = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene Paymentscene = new Scene(Payment);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Paymentscene);
        window.show();
    }
    ObservableList<String>HouseNo = FXCollections.observableArrayList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13");
    ObservableList<String>MonthPaid = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    
    @FXML
    private void exitRental(){
        System.exit(0);
    }
    
    @FXML
    private Label label;
    
    @FXML
    private ComboBox HouseNoBox;
    @FXML
    private void initializeHouseNoBox(){
        HouseNoBox.setItems(HouseNo);
    }
    
    @FXML
    private TextField AmountPaid;
    @FXML
    private void AmountInput(){
        AmountPaid.getText();
    }
    
    @FXML
    private DatePicker DateOfPayment;
    @FXML
    private void getDate(){
        DateOfPayment.getValue();
    }
  
    @FXML
    public ComboBox MonthPaidBox;
    
    
    @FXML
    public void initializeMonthPaidBox(){
        MonthPaidBox.setItems(MonthPaid);
    }
    
    @FXML
    private TextField TenantName;
    @FXML
    private void getTenantName(){
        TenantName.getText();
    }
    
    @FXML
    private  Button Submit;
    
    @FXML
    private void handleSubmit(){
        try {
           File file = new File("Tenant Payment Details.txt");
           FileWriter myfile = new FileWriter(file, true);
           myfile.write("\r\n");
           if(!file.exists()){
               file.createNewFile();
           }
           PrintWriter PTD = new PrintWriter(myfile);
           PTD.println(HouseNoBox.getSelectionModel().getSelectedItem());
           PTD.println(AmountPaid.getText());
           PTD.println(DateOfPayment.getValue());
           PTD.println(MonthPaidBox.getSelectionModel().getSelectedItem());
           PTD.println(TenantName.getText());
           
           PTD.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
         System.exit(0);
        };

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
