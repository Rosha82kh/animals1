package com.example.animals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class InserBookingController implements Initializable {


        @FXML
        private Button btn_Add;
        @FXML
        private Button btn_Delete;
        @FXML
        private Button btn_update;
        @FXML
        private Button btn_close;


        @FXML
        private TableColumn<Booking, Integer> col_bookingNo;
        @FXML
        private TableColumn<Booking, Integer> col_custNo;
        @FXML
        private TableColumn<Booking, Integer> col_animalNo;
        @FXML
        private TableColumn<Booking, Integer> col_weekNo;
        @FXML
        private TableColumn<Booking, Integer> col_cageNo;


        @FXML
        private Label lbl_AnimalsHome;

        @FXML
        private TableView<Booking> BKtblview;


        @FXML
        private TextField txt_custNo;
        @FXML
        private TextField txt_cageNo;
        @FXML
        private TextField txt_weekNo;
        @FXML
        private TextField txt_bookingNo;
        @FXML
        private TextField txt_animalNo;





        public Connection dataBaseLink;

        public Connection getConnection(){
                String dataBaseName=" ";
                String dataBaseUser="sa";
                String dataBasePassword="1234";
                String url="jdbc:sqlserver://localhost:1433;databaseName=animals";
                try{
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        dataBaseLink= DriverManager.getConnection(url,dataBaseUser,dataBasePassword);
                }catch (Exception e){
                        e.printStackTrace();
                        e.getMessage();
                }
                return dataBaseLink;
        }

        @FXML
        void btnAddAction(ActionEvent event) {
                Booking bk=insertBooking();
                 if(bk!=null){
                        BKtblview.getItems().add(bk);
                }else
                         lbl_AnimalsHome.setText("Please Enter values inside the text field");
        }


        @FXML
        void btnDeleteAction(ActionEvent event) {
                Booking selected=BKtblview.getSelectionModel().getSelectedItem();
                BKtblview.getItems().removeAll(selected);
        }
        @FXML
        void btnCloseAction(ActionEvent event){
                System.exit(0);

        }

        ObservableList<Booking> list = FXCollections.observableArrayList(
                new Booking(1,211,2222,14,22),
                new Booking(2,66,2222,15,9),
                new Booking(3,77,2222,17,33));

        //method to show the content of text fields
        private Booking insertBooking(){
                Booking book=null;

                try{
                        int bookingNo= Integer.parseInt(txt_bookingNo.getText());
                        int custNo= Integer.parseInt(txt_custNo.getText());
                        int anmalNo= Integer.parseInt(txt_animalNo.getText());
                        int weekNo= Integer.parseInt(txt_weekNo.getText());
                        int cageNo= Integer.parseInt(txt_cageNo.getText());

                        book=new Booking(bookingNo,custNo,anmalNo,weekNo,cageNo);
                }catch(NumberFormatException n){
                        n.getMessage();
                        n.printStackTrace();
                }
                return book;
        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) throws RuntimeException{
                col_bookingNo.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingNo"));
                col_custNo.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("custNo"));
                col_animalNo.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("animalNo"));
                col_weekNo.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("weekNo"));
                col_cageNo.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("cageNO"));

                BKtblview.getItems().addAll();
                BKtblview.setItems(list);
        }
}