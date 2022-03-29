package com.example.animals;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try{

        BookingController BC=new BookingController();
        BC.getConnection();
        BC.fillCompoBox();
        //BC.calculatePrice();
        BC.PrintInvoice();

      //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InsertBooking.fxml"));
      // FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
       FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Booking.fxml"));


        Scene scene = new Scene(fxmlLoader2.load(), 1080, 700);
        stage.setTitle("Animal Home System!");
        stage.setScene(scene);
        stage.show();
    }catch (NullPointerException | IOException e){
            e.printStackTrace();
            e.getMessage();
        }}

    public static void main(String[] args) {
        launch();
     }
}