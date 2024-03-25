package ntu.a63131916;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends ntu.a63131916 {

    private Stage stage;
    
   @Override
   public void start(Stage stage) throws Exception {
      this.stage = stage;
      GridPane gp = new GridPane();
      gp.setAlignment(Pos.CENTER);
      gp.setHgap(50);
      gp.setVgap(20);
      gp.setMinSize(500, 500);
      Label lblTitle = new Label("BMI Calculator");
      lblTitle.setFont(Font.font(38));
      Label lb1 = new Label("Calculate your BMI");
      lb1.setFont(Font.font(22));
      Label lb2 = new Label("Fetching the Data");
      lb2.setFont(Font.font(22));
      Label l2 = new Label("Your Name");
      TextField t1 = new TextField();
      Label l3 = new Label("Your Height (cm)");
      TextField t2 = new TextField();
      Label l4 = new Label("Your weight (kg)");
      TextField t3 = new TextField();
      Label l5 = new Label("Enter your name to retrieve your data");
      TextField t4 = new TextField();
      l5.setFont(Font.font(16));
    
      l2.setFont(Font.font(16));
      l3.setFont(Font.font(16));
      l4.setFont(Font.font(16));
      l5.setFont(Font.font(16));
   
      gp.add(lblTitle, 1, 0);
      gp.add(lb1,0,2);
      gp.add(lb2,2,2);
      gp.add(l2, 0,3);
      gp.add(t1, 0,4);
      gp.add(l3, 0,5);
      gp.add(t2, 0,6);
      gp.add(l4, 0,7);
      gp.add(t3, 0,8);
      gp.add(l5, 2,3);
      gp.add(t4, 2,4);
   
          Button button = new Button();
          gp.add(button, 0,9);
          button.setText("Insert");
          button.setFont(Font.font(20));
          Button retrieve=new Button();
          gp.add(retrieve, 2, 9);
          retrieve.setText("Retrieve");
          retrieve.setFont(Font.font(20));

      button.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent ev) {
            double mass;
            double height;
            String condition;
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");  
                final Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/bmicalc","root","navenesvar123#");
                String sql = "insert into BMI(Name,Height,Weight,BMI,Result) values(?,?,?,?,?)";
                PreparedStatement p = con.prepareStatement(sql);
               mass = Double.parseDouble(t3.getText());
               height = Double.parseDouble(t2.getText());
               double result = calculateBMI(mass, height);
               
               if(result<18.5)
               {
            	   condition="Underweight";
               }
               else if(result>=18.5 && result<25)
               {
            	   condition="Healthy weight";
               }
               else if(result>=25 && result<30)
               {
            	   condition="Overweight";
               }
               else
               {
            	   condition="Obese";
               }
               p.setString(1,t1.getText());
               p.setLong(2,(long) height);
               p.setLong(3,(long) mass);
               p.setLong(4, (long) result);
               p.setString(5,condition);
               p.executeUpdate();
               showMessage("Your BMI is: " + (Math.round(result * 100.0) / 100.0), "Your BMI result",condition);
            } catch (Exception e) {
               showMessage("Check your input.", "Error in number input","");
               return;
            } 
         }
      });
      
     retrieve.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent cv) {
             
             try {
            	
             	 Class.forName("com.mysql.cj.jdbc.Driver");  
                 final Connection con=DriverManager.getConnection(  
                 "jdbc:mysql://localhost:3306/bmicalc","root","navenesvar123#");
                 String str1 = "select * from BMI";  
                 PreparedStatement stmt = con.prepareStatement(str1);
                 ResultSet rs=stmt.executeQuery();
                String s1,s2,s3,s4,s5;
                 int ch=0;
                 while(rs.next())
                 {
                	
                	 if(rs.getString(1).equals(t4.getText()))
                	 {
                		 s1=rs.getString(1);
                		 s2=rs.getString(2);
                		 s3=rs.getString(3);
                		 s4=rs.getString(4);
                		 s5=rs.getString(5);
                		 show(s1,s2,s3,s4,s5);
                	     ch=1;
                	     break;

                	 }
                 }
                 if(ch==0)
                 {
                	 gp.add(new Label("Data is not available. Add the data please"),2,5);
                 }
                
                 }
             catch (Exception e) {
                 showMessage("Check your input.", "Error in number input","");
                 return;
              } 
          }
     });
      Scene scene = new Scene(gp);
      stage.setTitle("JavaFX BMI Calculator");

      stage.setScene(scene);
      stage.sizeToScene();
      stage.show();
   }

   protected double calculateBMI(double mass, double height) {
      return mass / Math.pow(height / 100.0, 2.0);
   }

   public static void main(String[] args) {
      Application.launch(args);
   }
   public void show(final String name, final String value1,final String value2,final String value3,final String value4) {
	      final Stage dialog = new Stage(StageStyle.UTILITY);
	      dialog.setResizable(false);
	      dialog.initModality(Modality.WINDOW_MODAL);
	      dialog.initOwner(this.stage);
	      GridPane gp2 = new GridPane();
	     
	      gp2.setAlignment(Pos.CENTER);
	      gp2.setHgap(50);
	      gp2.setVgap(20);
	      gp2.setMinSize(500, 500);
	      dialog.setScene(new Scene(gp2));
	      Label Title = new Label("Your data is available");
	      Label lb = new Label("Name");
	      Label l6 = new Label("Height");
	      Label l7 = new Label("Weight");
	      Label l8 = new Label("BMI");
	      Label l9 = new Label("Condition");
	      Title.setFont(Font.font(25));
	      l6.setFont(Font.font(16));
	      l7.setFont(Font.font(16));
	      l8.setFont(Font.font(16));
	      l9.setFont(Font.font(16));
	      lb.setFont(Font.font(16));
	      gp2.add(Title, 0, 0);
	      gp2.add(lb, 0, 1);
	      gp2.add(l6,0,2);
	      gp2.add(l7, 0,3);
	      gp2.add(l8, 0,4);
	      gp2.add(l9, 0,5);
	      gp2.add(new Label(name), 1, 1);
	      gp2.add(new Label(value1),1,2);
	      gp2.add(new Label(value2),1,3);
	      gp2.add(new Label(value3),1,4);
	      gp2.add(new Label(value4),1,5);
	      Button btn = new Button("OK");
	      btn.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent e) {
	            dialog.close();
	         }
	      });
	      gp2.add(btn,1,6);
	      dialog.showAndWait();
	   }

   public void showMessage(final String message, final String title,final String condition) {
      final Stage dialog = new Stage(StageStyle.UTILITY);
      dialog.setTitle(title);
      dialog.setResizable(false);
      dialog.initModality(Modality.WINDOW_MODAL);
      dialog.initOwner(this.stage);

      VBox vbox = new VBox(200);
      HBox pane = new HBox(20);

      dialog.setScene(new Scene(vbox));
      vbox.setAlignment(Pos.CENTER);

      vbox.getChildren().add(pane);
      pane.getChildren().add(new Label(message));
      pane.getChildren().add(new Label(condition));
      Button btn = new Button("OK");
      btn.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent e) {
            dialog.close();
         }
      });
      pane.getChildren().add(btn);
      dialog.showAndWait();
   }
}
