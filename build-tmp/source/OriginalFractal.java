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

public class OriginalFractal extends PApplet {

public void setup()
{
	size(500,500);
	noStroke();
	rectMode(CENTER);
	background(0);
	frameRate(5);
}

public void draw()
{
	pushMatrix();
	translate(250,250);
	for(int i=0;i<360;i++)
	{
		//rotate((float)(Math.PI/15));
		background(0);
		fractal(250,250,100,8.0f,0);
	}
	popMatrix();
}

public void fractal(int centerX,int centerY,int radius, float x,int change)
{
	if(change<500)
	{
		for(int i=0;i<4;i++)
		{
			pushMatrix();
			//translate(centerX,centerY);
			rotate((float)(2*Math.PI/x));
			fill((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
			rect(0+change, 0+change, radius, radius);
			rect(0-change, 0+change, radius, radius);
			rect(0+change, 0-change, radius, radius);
			rect(0-change, 0-change, radius, radius);
			popMatrix();
			x=x-2;
		}
		fractal(centerX,centerY,radius,3.0f,change+(radius/2));
	}	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
