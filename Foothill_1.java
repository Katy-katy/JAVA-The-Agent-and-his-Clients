/*  Source program for Assignment_4 for CS 1B
 *  Written by Ekaterina Tcareva, 02/04/2014
 */
public class Foothill
{
   public static void main (String[] args)
   {
      //instantiate two Actors and two Writers
      Actor myActor1 = new Actor("Anna Li", 200000, 12, 'F', 35);
      Actor myActor2 = new Actor("Jhon Gomes", 250000, 16, 'M', 45);
      Writer myWriter1 = new Writer("Olga Pushckina",100000,15, true,
            false, false, "story editor");
      Writer myWriter2 = new Writer("Andrey Pulov",300000,11, true,
            true, true, "executive producer");
      
      //display a few of their data to the screen, individually
      System.out.println("myActor1's name is "+ myActor1.getName() + "\n");
      System.out.println("myActor2's gender is " + myActor2.getGender() + "\n");
      System.out.println("myWriter1's rank is " + myWriter1.getRank() + "\n");
      System.out.println("myWriter2's international is " 
         + myWriter2.getInternational() + "\n");
      
      //instantiate one Agent
      Agent agent1 = new Agent("Piter Pop");
      
      //place some of the Actors and Writers into the Agent's list
      agent1.addClient(myActor1);
      agent1.addClient(myActor2);
      agent1.addClient(myWriter1);
      agent1.addClient(myWriter2);
      
      //Print out the Agent's Clients' names demonstrating both toString---() 
      System.out.println(agent1.toStringClientsShort() + "\n");
      System.out.println(agent1.toStringClientsLong());
      
      //show how much money the Agent is going to get this year
      System.out.println(agent1.getName() + "'s income for this year is $"
         + agent1.getIncome());      
   }
}

//Base Class Client  -----------------------------
class Client
{
   private  String name;
   private  long incomeThisYear;
   private double percentCut;
   private int MIN_NAME_LENGTH = 2;
   private int MAX_NAME_LENGTH = 50;
   private long MIN_INCOME = 0;
   private long MAX_INCOME = 1000000000000L;
   private double MIN_PERCENT_CUT = 0;
   private double MAX_PERCENT_CUT = 99.99;

   //constructor which takes all parameters
   public Client(String name,long incomeThisYear,double percentCut)
   {
      if (!setName(name))
         setName();
      if (!setIncome(incomeThisYear))
         setIncome();
      if (!setPercent(percentCut))
         setPercent();
   }

   //constructor which takes no parameters
   public Client()
   {
      setName();//default value "Undefined"
      setIncome();//default value "0"
      setPercent(); //default value "10"   
   }
   
   //set methods
   public void setName()
   {
      setName("Undefined");//default value
   }
   
   public boolean setName(String name)
   {
      boolean valid = true; // return value
      
      if (!isNameValid(name))
         valid = false;
      else
      {   
         this.name = name;
         valid = true;
      }
      return valid;
   }
   
   public void setIncome()
   {
      setIncome(0);//default value
   }
   
   public boolean setIncome(long incomeThisYear)
   {
      boolean valid = true; // return value
      
      if (!isIncomeValid(incomeThisYear))
         valid = false;
      else
      {   
         this.incomeThisYear = incomeThisYear;
         valid = true;
      }
      return valid;
   }
   
   public void setPercent()
   {
      setPercent(10);//default value
   }
   
   public boolean setPercent(double percentCut)
   {
      boolean valid = true; // return value
      
      if (!isPercentValid(percentCut))
         valid = false;
      else
      {   
         this.percentCut = percentCut;
         valid = true;
      }
      return valid;
   }

   //getters for Client's members 
   public String getName()
   {
      return name;
   }
   
   public double getPercent()
   {
      return percentCut;
   }
   
   public long getIncome()
   {
      return incomeThisYear;
   }
   
   //make a string from all client's data
   public String toString()
   {
      String result;
      result = "name: " + name + "\nincome for these year is $" + incomeThisYear
            + "\ncatting percent is " + percentCut;
      return result;
   }   
   
   //check the length of name and if it consist from letters
   private boolean isNameValid(String name) 
   {
      if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
         return false;      
     
      return true;           
   }
   
   //check the value of income
   private boolean isIncomeValid(long incomeThisYear) 
   {
      if (incomeThisYear < MIN_INCOME || incomeThisYear > MAX_INCOME)
         return false;
      return true; 
   }
   
   // check the value of percent
   private boolean isPercentValid(double percentCut)
   {
      if (percentCut < MIN_PERCENT_CUT || percentCut > MAX_PERCENT_CUT)
         return false;
      return true;   
   }
}

//Writer class is derived from Client class
class Writer extends Client 
{
   // additional member
   private boolean technical;//true if the writer has background in technology   
   private boolean government;//true for background in government/politics
   private boolean international;//true for big travel experience
   private String rank;
   
   public Writer()
   {
      super();
      setTechnical();// add new members
      setGovernment();
      setInternational();
      setRank();
   }
   
   public Writer(String name,long incomeThisYear,double percentCut,
         boolean technical, boolean government, boolean international,
         String rank)
   {
      super(name, incomeThisYear, percentCut);
      
      // add new members
      setTechnical(technical);//we don't test boolean values so we don't          
      setGovernment(government);// need "if" statements for them       
      setInternational(international);         
      if (!setRank(rank))
         setRank();
   }
   
   //setters for Writer's members
   public void setTechnical()
   {
      setTechnical(false);
   }
   
   public void setTechnical(boolean technical)
   {
      this.technical = technical;      
   }
   
   public void setGovernment()
   {
      setGovernment(false);
   }
   
   public void setGovernment(boolean government)
   {
      this.government = government;      
   }
   
   public void setInternational()
   {
      setTechnical(false);
   }
   
   public void setInternational(boolean international)
   {
      this.international = international;      
   }
      
   public void setRank()
   {
      setRank("staff writer");
   }
   
   public boolean setRank(String rank)
   {
      if ( !isRankValide(rank) )
         return false;  // don't change anything, return false      
      this.rank = rank;
      return true;
   }
   
   //getters for Writer's members
   public boolean getTechnical()
   {
      return technical;
   }
   
   public boolean getGovernment()
   {
      return government;
   }
   
   public boolean getInternational()
   {
      return international;
   }
   
   public String getRank()
   {
      return rank;
   }
   
   // validator for rank 
   private boolean isRankValide(String rank)
   {
      String rankLoCase;
      rankLoCase = rank.toLowerCase();
      if ((rankLoCase == "staff writer") || (rankLoCase == "story editor")
            ||(rankLoCase == "co-producer") ||(rankLoCase == "producer") 
            ||(rankLoCase == "co-executive producer") 
            ||(rankLoCase == "executive producer"))
         return true;
      return false;
   }
   
   //make a string from writer's members
   public String toString()
   {
      String writer;
      writer = super.toString() + "\ntechnical: " + technical 
            + "\ngovernment: " + government + "\ninternational: "
            + international + "\nrank: " + rank + "\n";
      return writer;
   }   
}

//Actor class is derived from Client class
class Actor extends Client 
{
   // additional member
   private char gender;   
   private int age;
   private int MIN_AGE = 0;
   private int MAX_AGE = 110;
   
   public Actor()
   {
      super();
      setGender();// add two new members
      setAge();
   }
   public Actor(String name,long incomeThisYear,double percentCut,
         char gender, int age)
   {
      super(name, incomeThisYear, percentCut);
      
      // add two new members
      if ( !setGender(gender) )
         setGender();
      if (!setAge(age))
         setAge();
   }
   
   public void setGender()
   {
      setGender('M');
   }
   public boolean setGender(char gender)
   {      
      if ( !isGenderValide(gender) )
         return false;  // don't change anything, return false      
      this.gender = gender;
      return true;
   }
   
   public void setAge()
   {
      setAge(0);
   }
   
   public boolean setAge(int age)
   {
      if ( !isAgeValide(age) )
         return false;  // don't change anything, return false      
      this.age = age;
      return true;
   }
   
   //getter methods
   public int getAge()
   {
      return age;
   }
   
   public char getGender()
   {
      return gender;
   }
   
   private boolean isGenderValide(char gender)
   {
      if ((gender == 'M') || (gender == 'F') || (gender == 'f')
            || (gender == 'm'))
         return true;
      return false;
   }
   
   private boolean isAgeValide(int age)
   {
      if ((age < MIN_AGE) || (age > MAX_AGE))
         return false;
      return true;
   }
   
   public String toString()
   {
      String actor;
      actor = super.toString() + "\ngender: " + gender + "\nage: " + age
            + "\n";          
      return actor;
   }   
}

//Class Agent  -----------------------------
class Agent
{
   private  String name;
   private Client[] myClients;
   private int numClients; 
   private int MIN_NAME_LENGTH = 2;
   private int MAX_NAME_LENGTH = 50;
   private int MIN_CLIENTS = 0;
   private int MAX_CLIENTS = 100; 

   //constructor which takes a name
   public Agent(String name)
   {
       if (!setName(name))
          setName();
       numClients = 0;
       myClients = new Client[MAX_CLIENTS];    
   }

   //set methods
   public void setName()
   {
      setName("Undefined");//default value
   }
 
   public boolean setName(String name)
   {
      boolean valid = true; // return value
    
      if (!isNameValid(name))
         valid = false;
      else
      {   
         this.name = name;
         valid = true;
      }
      return valid;
   }
  
   //get method
   public String getName()
   {
      return name;
   } 
 
   //check the length of name and if it consist from letters
   private boolean isNameValid(String name) 
   {
      if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
         return false;     
      return true;           
   } 
   
   //put a client into the Agent's list
   public boolean addClient(Client client)
   {
      boolean addClient;    
      myClients[numClients] = client;
      numClients++;
      if (numClients <= MAX_CLIENTS)
         addClient = true;
      else
         addClient = false;
      return addClient;
   }
 
   //remove a client by squeezing him out of the list 
   boolean removeClient(Client client)
   {
      boolean removeClient;
      Client temp;
      for(int k = 0; k < numClients; k++)
         if (myClients[k].getName().equals(client.getName()))            
         {
            temp = myClients[k];
            for(int n = k; n < numClients - 1; n++)
               myClients[n] = myClients[n + 1];
            
            myClients[numClients] = temp;
         }
      
      numClients--; 
      
      if (numClients >= MIN_CLIENTS)
         removeClient = true;
      else
         removeClient = false;
      
      return removeClient;
   }
   
   //returns a list of all this Agent's Clients' names
   public String toStringClientsShort()
   {  
      String result;
      result = this.getName() + "'s Client's name: ";
      for (int k = 0; k < numClients; k++)
         result = result + myClients[k].getName() + " / ";
      
      return result;
   }
   
   //returns  a list of all the Clients, using the Client display method
   String toStringClientsLong()
   {
      String result;
      result = this.getName() + "'s Client's: \n\n";
      for (int k = 0; k < numClients; k++)
         result = result + myClients[k].toString() + "\n";
      
      return result;
   }
   
   //the dollar amount collectible from all Clients so far this year
   public double getIncome()
   {
      double income;
      income = 0;
      for (int k = 0; k < numClients; k++)
         income = income + myClients[k].getIncome() / 100
            * myClients[k].getPercent();
      return income;
   }   
}
/*-----------------------------------------------------------------------------
myActor1's name is Anna Li

myActor2's gender is M

myWriter1's rank is story editor

myWriter2's international is true

Piter Pop's Client's name: Anna Li / Jhon Gomes / Olga Pushckina / Andrey Pulov 
/ 

Piter Pop's Client's: 

name: Anna Li
income for these year is $200000
catting percent is 12.0
gender: F
age: 35

name: Jhon Gomes
income for these year is $250000
catting percent is 16.0
gender: M
age: 45

name: Olga Pushckina
income for these year is $100000
catting percent is 15.0
technical: true
government: false
international: false
rank: story editor

name: Andrey Pulov
income for these year is $300000
catting percent is 11.0
technical: true
government: true
international: true
rank: executive producer


Piter Pop's income for this year is $112000.0
 ----------------------------------------------------------------------------*/
