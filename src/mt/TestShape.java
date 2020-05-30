/*
	This program creates 15 random shapes and displays information on them either on the screen
		or in a txt file based on user input.
		
	Author: Darryl Karney
	Course: CPSC24500
 */

package mt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestShape {

	public static void main(String[] args) {
		//Create member variables
		Scanner kb = new Scanner(System.in);
		DecimalFormat mydf = new DecimalFormat("00.00");
		boolean validSelection = false;
		int selection = 0;
		
		//Get selection from user for output type
		while (!validSelection) {
			System.out.print("Please select one of the following options" +
					"\n    1. Display results to screen" +
					"\n    2. Save result to file\n");
			
			//Test if user entered a valid input
			try {
				selection = kb.nextInt();
				
				if (selection == 1 || selection == 2) {
					validSelection = true;
				} else {
					//Display error message to user
					System.out.println("Invalid selection! Please try again.");
				}
			} catch(Exception e) {
				//Clear input buffer and display error message to user
				kb.next();
				System.out.println("Invalid selection! Please try again.");
			}
		}
		
		//Create objects for file creation
		String filename = "";
		BufferedWriter writer = null;
		
		if (selection == 2) {
			boolean validFilename = false;
			
			//Get file name from user
			while(!validFilename) {
				System.out.print("\nEnter file name: ");
				
				//Check if user entered a valid file name
				try {
					filename = kb.next();
					//Try to create the file
					writer = new BufferedWriter(new FileWriter("E:\\eclipse-workspace\\OOPMT\\bin\\" + filename + ".txt"));
					validFilename = true;
				} catch(Exception e) {
					//Display error message to user
					System.out.println("Invalid file name! Please try again.");
				}
			}
		}
		
		//Create objects for getting and storing random shapes
		ArrayList<Shape> shapeList = new ArrayList<>();
		int amountOfShapes = 15;
		Random r = new Random();
		
		//Create amountOfShapes amount of random shapes
		for(int i = 0; i < amountOfShapes; i++) {
			int rand = r.nextInt(3) + 1;
			
			switch(rand) {
			case 1: //Circle
				shapeList.add(new Circle());
				break;
			case 2: //Square
				shapeList.add(new Square());
				break;
			case 3: //Cube
				shapeList.add(new Cube());
				break;
			}
		}
		
		//Loop through ArrayList created
		for(Shape s : shapeList) {
			if (selection == 1) {
				//Display results to screen
				System.out.println(s.toString());
				System.out.println("Find area result: " + mydf.format(s.find_area()));
				
				if (s instanceof Cube) {
					System.out.println("Finding volume: " + ((Cube) s).find_Volume());
				}
			} else {
				//Save results to file
				writeToFile(writer, s.toString());
				writeToFile(writer, "Find area result: " + mydf.format(s.find_area()));
				
				if (s instanceof Cube) {
					writeToFile(writer, "Finding volume: " + ((Cube) s).find_Volume());
				}
			}
		}
		
		if (selection == 2) {
			//Close the writer
			try {
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//Notify user writing to file has completed
			System.out.println("Writing to file complete!");
		}
	}

	//Writes data sent in the buffered writer and catches any IO exceptions
	private static void writeToFile(BufferedWriter bw, String s) {
		try {
			bw.append(s);
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Unable to write to output file!");
			System.exit(3);
		}
	}
}
