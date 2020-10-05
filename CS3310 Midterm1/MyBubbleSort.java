import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MyBubbleSort {

	public static void main(String[] args) {

		int setOfArrays[] = {10,100,1000,10000,100000};
		
		int sampleSpace = 20; //number of times sort will occur to acquire average time.
		long runningAvg[][]= new long[setOfArrays.length][sampleSpace];//maintains results in a matrix
		

				//Create a workbook
				//XSSFWorkbook workbook = new XSSFWorkbook();
				
				//Create a spreadsheet
				//XSSFSheet sheet = workbook.createSheet("Results");
				
				//Create a Row Object
				//XSSFRow row;
		

		for(int i = 0; i < setOfArrays.length; i++)
		{
			//System.out.println("Creating array of size: " + setOfArrays[i] + ".");
			//row = sheet.createRow(i);
			//Cell cell0 = row.createCell(0);
			//cell0.setCellValue(setOfArrays[i]);
			
			int array[] = new int[setOfArrays[i]];
			randomfy(array);//fill array with random vals
			for(int j = 0; j < sampleSpace; j++){	
				
				long start = 0;
				long end = 0;
				long duration = 0;
				System.out.println("Sorting array of size " + setOfArrays[i] + "...");
			
					start = System.nanoTime();//measure how long it takes
					BubbleSort(array);//actually sort
					end = System.nanoTime();
					duration = end - start;
					
	
					Cell cell = row.createCell(j+1);
					cell.setCellValue(duration);
			//	runningAvg[i][j] = duration;
			   
			   System.out.println("Array number " + (j+1) +" of length: " + array.length + " had a duration of " + duration + "nanoseconds.");
			   duration = 0;
			}
		}
	//writing the created excel file
		
		try {
			FileOutputStream out = new FileOutputStream(new File("Results.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Excel file is created successfully");
		}catch(FileNotFoundException ex) {
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	

	static void BubbleSort(int arr[]) 
    { 
        int sizeOfArr = arr.length; 
        
        //Outer loop traverses array in its entirety.
        for (int index = 0; index < (sizeOfArr - 1); index++)
        {
        //traverse through array comparing adjacent elements.  decreasing by 1 each iteration. 
            for (int j = 0; j < (sizeOfArr - (index + 1)); j++) 
            {
            	
                if (arr[j] > arr[j+1]) 
                { 
                    // swap values if out of order
                    int dummy = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = dummy; 
                }
            }
        }
    } 
	
	static void randomfy(int arr[])
	{
		Random rand = new Random();
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt();
		}
	}

	}


