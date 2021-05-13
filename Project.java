import java.net.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import java.util.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import java.io.*;
import java.text.*;
import java.lang.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.animation.*;

public class Project extends Application{
   
   //variables
   int [][] maze;
   int y = 0; 
   int x;
   
   //flowPane
   FlowPane root = new FlowPane();
   
   //Create canvas
   CanvasProject canvas = new CanvasProject();   
        
   //start method
   public void start(Stage stage){
   
      //add canvas to the flowpane
      root.getChildren().add(canvas);
      
      //scene
      Scene scene = new Scene(root, 525, 525); //window 525x525
      stage.setScene(scene);
      stage.setTitle("Project");
      stage.show();
      
      //read from the file to set the 1 to black spaces and 0 to white
      Scanner read;
      
      try{
         read = new Scanner (new File("maze.txt"));
         
         maze = new int[21][21];  //21x21 grid of squares
         
         for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++) {
               maze[i][j] = read.nextInt();
            }     
         }
         for(int i = 0; i < 21; i++){
            if(maze[0][i] == 0){
               x = i;
            }
         }
      }
      catch(FileNotFoundException fnfe){
      }
      
      //call the getSquare method to draw all the squares in order for maze
      getSquare();
      
      //draw square in the start position
      canvas.drawMySquare(x,y);
      
      //add key handler inner class to the flowpane
      root.setOnKeyPressed(new KeyHandler());
      
      //request the focus
      root.requestFocus();
   }
   
   //accessor for the squares
   public boolean getSquare(){        
      for(int i = 0; i < 21; i++){
         for(int j = 0; j < 21; j++) {
            if(maze[i][j] == 1){
               canvas.draw(true, j ,i);
            }
            if(maze[i][j] == 0){
               canvas.draw(false, j ,i);
            }
         }     
      }
      return false; 
   }   
   
   //method
   
   
   //key handler inner class
   public class KeyHandler implements EventHandler<KeyEvent>{  
      public void handle(KeyEvent event){
         //three steps
         //check if its a possible space
         //if yes change the variable of mySquare +25
         //update the whole board
               //if up move up
               if(event.getCode() == KeyCode.UP){ 
                  //check if its a possible space
                  //if there is a 0
                  if(y!= 0 && maze[y-1][x] == 0){
                     canvas.clearSquare(x,y);
                     y--;
                     canvas.drawMySquare(x, y); 
                     //update the whole board
                  }
               }
               
               //if down move down
               if(event.getCode() == KeyCode.DOWN){
                  //check if its a possible space
                  //if there is a 0
                  if(y!=20 && maze[y+1][x] == 0){
                     canvas.clearSquare(x,y);
                     y++;
                     canvas.drawMySquare(x, y); 
                  }
                  //if final position
                  if(y == 20){
                     //label to say finish
                     System.out.println("You win!");
                  }
               }
               
               //if left move left
               if(event.getCode() == KeyCode.LEFT){
                  //check if its a possible space
                  //if there is a 0
                  if(x!= 0 && maze[y][x-1] == 0){
                     canvas.clearSquare(x,y);
                     x--;
                     canvas.drawMySquare(x, y);
                     //update the whole board
                  }
               }
               //if right move right
               if(event.getCode() == KeyCode.RIGHT){
                  //check if its a possible space
                  //if there is a 0
                  if(x!=20 && maze[y][x+1] == 0){
                     canvas.clearSquare(x,y);
                     x++;
                     canvas.drawMySquare(x, y);
                     //update the whole board
                  }
         } 
     } 
   }
   
   //main method
   public static void main(String[] args)   
   {
      launch(args); //tells to run          
   }
}
