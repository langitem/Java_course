//DATA INITIALISATION APPLICATION
//Y. ing
//March 2007
//The University of Liverpool, UK

public class DataInitialisationApp{

    /*-------Main Method-------*/
    
    public static void main(String args[]){
       	int localData1 = 1;
       	int localData2 = 2, localData3 = 3;
        	int localData4 = localData3 + 1;
        	int localData5 = localData2 * 2 + 1;
        
        	//Create a DataInitialisation Instance
        	DataInitialisation newDataInit = new DataInitialisation();
        
        	//Output the data values assigned on intiailisation
        	newDataInit.outputData();
        
        	/*Change the data values by assigning values of local data items and output*/
        	newDataInit.newValues(localData1, localData2, localData3, localData4, localData5);
        	newDataInit.outputData();
     }
}
