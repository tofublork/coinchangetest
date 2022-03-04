public class Change {

private String name;
private int changeamt;

private int oneDollar;
private int fiftyCent;
private int twentyCent;
private int tenCent;
private int fiveCent;

//default constructor
public Change(){
this.name = "No Name";
this.changeamt = 0;
}

//constructor with parameters
public Change(String name, int changeamt){
this.name = name;
this.changeamt = changeamt;
}

//Getter methods
public String getName(){
    return this.name;
    }

public int getChangeamt(){
    return this.changeamt;
    }


//Setter methods
public void setName(String name){
this.name = name;
}

public void setChangeamt(int changeamt){
this.changeamt = changeamt;
}


public int[] getChange(){
    
    int[] changeToReturn = new int[5];//creates a new array to store integers
    int originalAmt = changeamt;
    oneDollar = changeamt/100;
    changeamt = changeamt%100;
    changeToReturn[0] = oneDollar;//no of 1$ or 100c
    fiftyCent = changeamt/50;
    changeamt = changeamt%50;
    changeToReturn[1] = fiftyCent;//no of 50c
    twentyCent = changeamt/20;
    changeamt = changeamt%20;
    changeToReturn[2] = twentyCent;//no of 20c
    tenCent = changeamt/10;
    changeamt = changeamt%10;
    changeToReturn[3] = tenCent;//no of 10c
    fiveCent = changeamt/5;
    changeamt = changeamt%5;
    changeToReturn[4] = fiveCent;//no of 5c

    return changeToReturn;
}//end of getChange()




public void display(){
    System.out.println("Name: "+name);
    System.out.println("Coin change amount: "+changeamt);
}

public void coinDisplay(){
    System.out.println("Change: ");
    if (oneDollar != 0)
    System.out.println("1 dollar: " + oneDollar);
    if (fiftyCent != 0)
    System.out.println("50 cents: " + fiftyCent);
    if (twentyCent != 0)
    System.out.println("20 cents: " + twentyCent);
    if (tenCent != 0)
    System.out.println("10 cents: " + tenCent);
    if (fiveCent != 0)
    System.out.println("5 cents: " + fiveCent);
}

public boolean equals(Change nxtChange){
//check if 2 elements have the same name (ignore case)
    if (this == nxtChange){
        return false;
        }
    if (nxtChange == null || getName() != nxtChange.getName()){
        return false;
        }
    if (this.getName().equalsIgnoreCase(nxtChange.getName())){
        return true;
    } else {
        return false;
    }
}//end of equals

public void addCoinChangeAmount(Change addChange){
    //this.changeamt = changeamt + coinAmountToAdd;
    //if (this.equals(addChange)) {
        this.changeamt = this.changeamt + addChange.changeamt;
    //}
}//end of addCoinChangeAmount



//equals method - compare if same name
//hint: same name method and addCoinChangeAmount merge together
}
