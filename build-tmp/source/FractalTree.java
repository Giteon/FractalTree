import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 20; 
private double branchAngle = .6f;  
public void setup() 
{   
	size(640,480);    
	noLoop(); 
} 
public void draw() 
{   
	background(0);   
	stroke((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));   
	line(320,480,320,380);   
	drawBranches(320,380,100,3*Math.PI/2,255);  //will add later 

} 
public void drawBranches(int x,int y, double branchLength, double angle, int col) 
{   
	
double angle1 = angle + branchAngle;
double angle2 = angle - branchAngle;

branchLength = branchLength * fractionLength;

int endX1 = (int)(branchLength*Math.cos(angle1) + x);  
int endY1 = (int)(branchLength*Math.sin(angle1) + y);

int endX2 = (int)(branchLength*Math.cos(angle2) + x);
int endY2 = (int)(branchLength*Math.sin(angle2) + y);
stroke(col);
line(x,y,endX1,endY1);
line(x,y,endX2,endY2);

if (branchLength > smallestBranch)
{
	//variation of 10 (*(int)(y/10)), and take 10 away from origional value to balance variation: 100 --> 90.
	/*Love Destination*/int call1 = color((int)(Math.random()*(int)(y/10)+121),(int)(Math.random()*19),(int)(Math.random()*(int)(y/10)+41));

 /*Shooting Star*/int call2 = color((int)(Math.random()*(int)(y/10)+176),(int)(Math.random()*(int)(y/10)+231),(int)(Math.random()*(int)(y/10)+216));

/*Crappy Deadline*/int call3 = color((int)(Math.random()*(int)(y/10)+237),(int)(Math.random()*(int)(y/10)+85),(int)(Math.random()*(int)(y/10)+154));

 //TO DO:

 

 /*TBD*/int call4 = color((int)(Math.random()*(int)(y/10)+27),(int)(Math.random()*(int)(y/10)+149),(int)(Math.random()*(int)(y/10)+186));

 /*Kraken Yellow*/int call5 = color((int)(Math.random()*(int)(y/10)+240),(int)(Math.random()*(int)(y/10)+177),(int)(Math.random()*(int)(y/10)+23));
if (Math.random()>.9f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call1);
	drawBranches(endX2,endY2,branchLength,angle2,call2);
}
else if (Math.random()>.78f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call1);
	drawBranches(endX2,endY2,branchLength,angle2,call3);
}
else if (Math.random()>.66f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call3);
	drawBranches(endX2,endY2,branchLength,angle2,call2);
}
else if (Math.random()>.54f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call4);
	drawBranches(endX2,endY2,branchLength,angle2,call2);
}
else if (Math.random()>.42f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call1);
	drawBranches(endX2,endY2,branchLength,angle2,call4);
}
else if(Math.random()>.3f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call5);
	drawBranches(endX2,endY2,branchLength,angle2,call1);
}
else if(Math.random()>.18f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call2);
	drawBranches(endX2,endY2,branchLength,angle2,call5);
}
else if(Math.random()>.06f)
{
	drawBranches(endX1,endY1,branchLength,angle1,call5);
	drawBranches(endX2,endY2,branchLength,angle2,call3);
}
else
{
	drawBranches(endX1,endY1,branchLength,angle1,call4);
	drawBranches(endX2,endY2,branchLength,angle2,call5);
}

} 
}

public void mouseDragged()
{
	branchAngle = (float)(mouseX)/(width/8);
	redraw();
}

public void keyPressed() {

	if (keyCode == UP)
	{
		if (smallestBranch > 6)
		{
		smallestBranch --;
	}
	}
	if (keyCode == DOWN)
	{
		if (smallestBranch < 60)
		{
		smallestBranch ++;
	}
	}
	redraw();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
