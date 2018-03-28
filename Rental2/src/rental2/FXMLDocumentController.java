/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Mike
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        
    }
    /**
     * Button to handle change of scene
     */
    @FXML
    public void changesceneButton(ActionEvent event) throws IOException{
        Parent Payment = FXMLLoader.load(getClass().getResource("FXMLPaymentDetails.fxml"));
        Scene Paymentscene = new Scene(Payment);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Paymentscene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
