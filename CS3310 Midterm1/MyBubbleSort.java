import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Imported Apache library to write to Excel file. 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MyBubbleSort {

	public static void main(String[] args) {

		int setOfArrays[] = {100,1000,100000,1000000};
		
		int sampleSpace = 1; //number of times sort will occur to acquire average time. only does it 1 time for submission.
		
		

				//Create a workbook to export to spreadsheet: will not do for submission
				XSSFWorkbook workbook = new XSSFWorkbook();
				
				//Create a spreadsheet
				XSSFSheet sheet = workbook.createSheet("Results");
				
				//Create a Row Object
				XSSFRow row;
		

		for(int i = 0; i < setOfArrays.length; i++)
		{
			System.out.println("Creating array of size: " + setOfArrays[i] + ".");
			//Workbook Excel Export:
			row = sheet.createRow(i);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(setOfArrays[i]);
			
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

			   
			   System.out.println("Array number " + (j+1) +" of length: " + array.length + " had a duration of " + duration + " nanoseconds.");
			   duration = 0;
			}
		}
	//writing to excel file
		
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
	
	//Function to sort an array of any size, input is an array of integers and sorts in-place
	static void BubbleSort(int arr[]) 
    { 
        int sizeOfArr = arr.length; 
        boolean swapped = false;
        //Outer loop traverses array in its entirety.
        for (int index = 0; index < (sizeOfArr - 1); index++)
        {
        //traverse through array comparing adjacent elements.  decreasing by 1 each iteration. 
        	swapped = false;
            for (int j = 0; j < (sizeOfArr - (index + 1)); j++) 
            {
            	
                if (arr[j] > arr[j+1]) 
                { 
                    // swap values if out of order
                	swapped = true;
                    int dummy = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = dummy; 
                }
            }
            if(swapped == false) {
            	//array is completely swapped and there is no point in continuing to traverse array.
            	break;
            }
        }
        
    } 
	
	//function to fill array with random values input is an array of integers of any size.
	static void randomfy(int arr[])
	{
		Random rand = new Random();
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt();
		}
	}

	}


