
public class Client {

private static Change[] changeArray;
    public static void main(String[] args) {

        changeArray = new Change[100];
        
        println("~~~Coin Change Calculation System~~~");
        initData();

        run();
    }

private static void run(){
    while (true){
    int choice = printMenuAndGetChoice();

    if (choice==1){
    findNameAndDisplayChangeDenomination();
    }else if(choice==2) {
    findNameWithLargestChangeAndDisplayChangeDenomination();
    }else if(choice==3) {
     findNameWithSmallestChangeAndDisplayChangeDenomination();
    }else if(choice==4) {
     displayTotalCoinForEachDenomination();
    }else if(choice==5) {
     displayTotalSumForAllDenomination();
    }else if(choice==6) {
     break;//exit while(true)
    }else {
     println("Invalid choice:");
    }
  }
   println("Program ends");
 }

    private static int printMenuAndGetChoice() {
        println("\n1. Enter a name and display change to be given for each denomination");
        println("2. Find the name with the largest amount and display change to be given for each denomination");
        println("3. Find the name with the smallest amount and display change to be given for each denomination");
        println("4. Calculate and display the total number of coins for each denomination");
        println("5. Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
        println("6. Exit");
        int choice = getInt("Enter choice: ");
        return choice;
    }

    private static void findNameAndDisplayChangeDenomination() {  

        boolean nonExistName = false;
        println("1. Enter a name and display change to be given for each denomination ");
        String inputName = getString("Enter a name from the list: ");
        for(int i=0;i<changeArray.length;i++) {
            Change changeq1 = changeArray[i];
            if (changeq1 != null){
                if (changeq1.getName().equalsIgnoreCase(inputName)){
                    changeq1.display();

                    changeq1.getChange();
                    changeq1.coinDisplay();
                    break;
                    } else {
                    nonExistName = true;   
                    }
            }
        }
        if (nonExistName==true){
            println("That name does not exist!");
            }
        //problem: how to call an array element based on inputting a name
   
   }

    private static void findNameWithLargestChangeAndDisplayChangeDenomination() {
        println("2. Find the name with the largest amount and display change to be given for each denomination");
        int largest = changeArray[0].getChangeamt();

        for(int i=0;i<changeArray.length;i++) {

            Change changeq2 = changeArray[i];
            if (changeq2 != null){
            if (changeArray[i].getChangeamt() > largest) {
                largest = changeArray[i].getChangeamt();
                changeq2.display();
                changeq2.getChange();
                changeq2.coinDisplay();
                break;
                }
            }
        }
   }

    private static void findNameWithSmallestChangeAndDisplayChangeDenomination() {
        println("3. Find the name with the smallest amount and display change to be given for each denomination");
        int smallest = changeArray[0].getChangeamt();

        for(int i=0;i<changeArray.length;i++) {

            Change changeq3 = changeArray[i];
            if (changeq3 != null){
            if (changeArray[i].getChangeamt() < smallest) {
                smallest = changeArray[i].getChangeamt();
                changeq3.display();
                changeq3.getChange();
                changeq3.coinDisplay();
                break;
                }
            }
        }

   }

    private static void displayTotalCoinForEachDenomination() {
        println("4. Calculate and display the total number of coins for each denomination");
        int totalChangeamt = 0;
            for(int i=0;i<changeArray.length;i++) { 
                Change changeq4 = changeArray[i];
                if (changeq4 != null){
                totalChangeamt = totalChangeamt + changeArray[i].getChangeamt();
            }
        }

        totalChangeamt;//??? how

        coinDisplay();
   }

    private static void displayTotalSumForAllDenomination() {
        println("5. Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
   }

  
   //some test methods
   //make sure you remove these test methods before submission
 private static void printAllChangeObjects() {
  for(int i=0;i<changeArray.length;i++) {
   Change change = changeArray[i];
   if(change!=null) {
    change.display();
        }
    }//end of for
 }
 
 //test methods
 //make sure you remove these test methods before submission

 /* private static void addChangeAmountToChangeObject() {
  Change c1 = changeArray[1];
  c1.addCoinChangeAmount(10);
  c1.display();
  
 }*/


private static void initData(){
        int choice = getInt("1 - Use hardcode data\n2 - Enter data\n");
        if (choice==1){
            initArrayByHardCode();
        } else if(choice==2){
            initArrayByUser();
        } else {
            choice = getInt("Invalid Choice. Only input 1 or 2.");
        }
}

private static void initArrayByHardCode() {
   // Note please use this set of test data
   //I will use this set of test data to test your code.
   Change change1 = new Change("A", 85);
   Change change2 = new Change("B", 15);
   Change change3 = new Change("C", 100);
   Change change4 = new Change("D", 20);
   Change change5 = new Change("D", 30);
   Change change6 = new Change("E", 75);
   Change change7 = new Change("F", 60);
   Change change8 = new Change("G", 25);
   
   changeArray[0] = change1;
   changeArray[1] = change2;
   changeArray[2] = change3;
   changeArray[3] = change4;
   changeArray[4] = change5;
   changeArray[5] = change6;
   changeArray[6] = change7;
   changeArray[7] = change8;
   
   //Should ensure that change4 and change5 is combine into a object.
   //The method to do that should be be re-used by initArrayByUser()
   
  }

private static void initArrayByUser() {
   //Names are one-word Strings.
   //It should be noted that it is possible to have the same name entered numerous times,
   //But the values for such repetitions could be different.
   //When the name is the same, it would mean the same individual,
   //and your program should add up the coin amounts to obtain a total amount for that individual;
   //this should be performed before computing the change to be given.
   //prompt user for name and age and save the instance in the array
    boolean noMore = false;
    println("Recommendation: Please enter at least 8 records to test the program.");

    for (int i = 0; i < changeArray.length; i++){
    changeArray[i] = new Change();//call the Change class for an array element

    String changeArrayName = getString("\nPlease enter the name of the person: ");//reads user input
    changeArray[i].setName(changeArrayName);

    int iChangeamt = getInt("Please enter the coin value for the person (multiple of 5): ");//reads user input
    changeArray[i].setChangeamt(iChangeamt);
        while (iChangeamt%5 != 0){
            iChangeamt = getInt("Invalid change amount. Enter another change amount for this user. (Must be divisible by 5)\n");
            changeArray[i].setChangeamt(iChangeamt);
            }
    println("Do you have more person to enter?");
    int option = getInt("Input 9 to stop adding. Otherwise, input any other number: ");
        if (option==9){
            break;
            }
        }//end of for loop
    println("Input Complete.");
    sameNameCheck();
  }

private static void sameNameCheck(){
    boolean sameName = false;
    //loop to check if any individuals with the same name
    for (int i = 0; i < changeArray.length; i++){
        Change changeqi = changeArray[i];

            for (int j = 0; j < changeArray.length; j++){
                Change changeqj = changeArray[j];
                if(changeqi != null && changeqj != null){

                if(changeqi.equals(changeqj)){

                changeqi.addCoinChangeAmount(changeqj);
                changeArray[j] = null;
                sameName = true;
                    }

                }
           }  

        }
        if (sameName==true){
                printAllChangeObjects();
            }

}


public static int getInt(String msg){
    return Helper.getInt(msg);
}

public static String getString(String msg){
    return Helper.getString(msg);
}

public static void println(String msg){
    Helper.println(msg);
}

public static void print(String msg){
    Helper.print(msg);
}


}
