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

public class CanvasProject extends Canvas{
   //constructor
   public CanvasProject(){
      //canvas size 525x525
      setWidth(525);
      setHeight(525); 
   }

   //moveable square
   public void drawMySquare(int x, int y){
      GraphicsContext gc = getGraphicsContext2D();
      gc.setFill(Color.CYAN);

      /*//start position
      gc.fillRect(225,0,25,25);*/
      //if statements if good move the square to new position
     // do{
         // call keyhandler method
         //if statements, move the square to new position
         gc.fillRect(x*25,y*25,25,25);
         //gc.clearRect((y-1)*25,(x-1)*25,25,25);
      
      //} while((i!=525) && (j!=300)); //last position
   }
   public void clearSquare(int x, int y){
      GraphicsContext gc = getGraphicsContext2D();
      gc.setFill(Color.WHITE);
      gc.fillRect(x*25,y*25,25,25);
   }
   
   //draw method with graphics context to create the maze
   public void draw(boolean drawMaze, int y, int x) { 
      GraphicsContext gc = getGraphicsContext2D();
      //if 1 == black square
      if(drawMaze == true){
         gc.setFill(Color.BLACK);
         gc.fillRect(y*25,x*25,25,25); //squares of 25x25
      }  
      //if 0 == white square
      if(drawMaze == false){
         gc.setFill(Color.WHITE);
         gc.fillRect(y*25,x*25,25,25); //squares of 25x25
      }
   }
}