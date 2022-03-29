package com.example.animals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class BookingController  implements Initializable  {



        @FXML
        private Label lbl_msg;


        @FXML
        private Button btn_book;


        @FXML
        private Button cage_6;
        @FXML
        private Button cage_5;

        @FXML
        private Button cage_4;

        @FXML
        private Button cage_3;

        @FXML
        private Button cage_2;

        @FXML
        private Button cage_1;

        @FXML
        private TextField txt_phone;
        @FXML
        private TextField txt_price;

        @FXML
        private TextArea txtArea;

        @FXML
        private ImageView imgView;

    @FXML
    private ComboBox comboBox;


        public boolean isCustomer(){
            getConnection();
            try{
                PreparedStatement ps = dataBaseLink.prepareStatement("  SELECT phone from customer where (phone='93999027')");
                //ps.setString(1, "93999037");
                ResultSet rs=ps.executeQuery();
                if(rs.next()==(true)){
                    lbl_msg.setText("The phone number already exists");
                    return true;
                }else {
                    lbl_msg.setText("Please register first");
                    return false;
                }
            }catch (SQLException e){
                e.getMessage();
            }
            return false;
        }

        public String getPhoneNo(String p){
          p=txt_phone.getText().toString();
            return p;
        }

        public void PrintInvoice(){
            String customer=getPhoneNo("");
            int selectedCage=getCage(new ActionEvent());
            double price=calculatePrice();
            int selectedWeek=getWeek();
            txtArea.setWrapText(true);
            txtArea.setEditable(false);
            txtArea.setText(txtArea.getText()+"********************************************");
            txtArea.setText(txtArea.getText()+"********************** Bill ******************");
            txtArea.setText(txtArea.getText()+" Customer no"+"\t"+customer+"\n");
            txtArea.setText(txtArea.getText()+" Cage no"+"\t"+selectedCage+"\n");
            txtArea.setText(txtArea.getText()+" Price"+"\t"+price+"\n"+"kr");
            txtArea.setText(txtArea.getText()+" Week no"+"\t"+selectedWeek+"\n");
            txtArea.setText(txtArea.getText()+"******************** Thank you *******************");

        }

        double price=300;
        public double calculatePrice(){
              price=this.price*cageNo;
            txt_price.setText(String.valueOf(price));
            txt_price.getText();
             return price;
        }



        public int getWeek(){

            int  weekNo= Integer.parseInt(comboBox.getSelectionModel().getSelectedItem().toString());
                 return weekNo;
        }


         public void makeBooking(ActionEvent event){
            String phone = txt_phone.getText();

             event.getSource().toString();
             if (isCustomer()==true  && checkAvailability()==true&& getCage(new ActionEvent())!=0) {

                  PrintInvoice();
                 lbl_msg.setText("the booking has been done");

             } else {
                 lbl_msg.setText("please register first");

             }

         }



        int cageNo=0;
        public int getCage(ActionEvent event){
            if(event.getSource()==cage_1){
                cageNo=1;
            }else if(event.getSource()==cage_2){
                cageNo=2;
            }else if(event.getSource()==cage_3){
                cageNo=3;
            }else if(event.getSource()==cage_4){
                cageNo=4;
            }else if(event.getSource()==cage_5){
                cageNo=5;
            }else if(event.getSource()==cage_6){
                cageNo=6;
            }
            return cageNo;
        }



        public Connection dataBaseLink;
        public Connection getConnection() {
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


        public void fillCompoBox(){
            getConnection();
            String sql="Select weekNo from week";
            try {
                PreparedStatement ps=dataBaseLink.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while (rs.next()){
                    weekList1.add(Integer.valueOf(rs.getString("weekNo")));
                   // comboBox.getItems().addAll(rs);

                }
            } catch (SQLException e) {
                e.printStackTrace();
                e.getMessage();
            }
        }


        public boolean checkAvailability(){
        getConnection();
        getWeek();
        getCage(new ActionEvent());
        try{
             PreparedStatement ps = dataBaseLink.prepareStatement("SELECT weekNo,cageNo from booking where weekNo = ? and cageNo=?");
             ResultSet rs=ps.executeQuery();
            if(rs.next()==true){
                lbl_msg.setText("This cageNo already booked");
             }else {
                ps=dataBaseLink.prepareStatement("insert into  booking  values (?,?,?,?,?)");
                ps.setInt(1,3322);
                ps.setInt(2,211);
                ps.setInt(1,14);
                ps.setInt(1,15);
                ps.setInt(1,5);


                int k=ps.executeUpdate();
                if(k==1){
                    lbl_msg.setText("cage booked");
                    return true;
                }else {
                    lbl_msg.setText("wrong entries");
                    return false;
                }
            }
        }catch (SQLException | RuntimeException e){
            e.getMessage();
        }
        return false;
        }
    private final  ObservableList <Integer>weekList1= FXCollections.observableArrayList();

    void getComboSelectedItems(ActionEvent event) {
        int selected= (int) comboBox.getValue();
        ObservableList weekList1=FXCollections.observableArrayList(selected);
     }

    @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            comboBox.getItems().addAll(weekList1);

           }
        }
