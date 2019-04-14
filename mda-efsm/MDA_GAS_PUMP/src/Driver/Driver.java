package Driver;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		char gp;
		  Scanner readermain=new Scanner(System.in);  
		  gp = 'a';
		  while (gp !='q') { 
			  
			  
			  System.out.println(" Select Gas Pump: ");  
			  System.out.println("1-Gas Pump 1,2-Gas Pump 2, q-Quit");   
			  System.out.println("enter your choice");
			  gp =(char) readermain.next().charAt(0);			  
			  switch (gp) {  
			  case '1':{
		///////////////////////////////	GAS PUMP 1	///////////////////////////////////////		  
				  GasPump_1 gp1 = new GasPump_1(); 
				  OP op = new OP();	//instantiate OutputProcessor
                  GasPump1Concrete concreteFactory1 = new GasPump1Concrete();	//instantiate correct ConcreteFactory
                  MDA_EFSM mdaEfsm= new MDA_EFSM();
                  DataStore_1 data;
                  data = concreteFactory1.getDataStore1();	//get data of ConcreteFactory
                  gp1.setFactory(concreteFactory1);						//set GasPump1 to use ConcreteFactory1
                  gp1.setData(data);
                  gp1.setMDAEFSM(mdaEfsm);
                  op.setData(data);
                  op.setFactory(concreteFactory1);
                  op.setMDAEFSM(mdaEfsm);
                  
                  
                  S0 s0 = new S0();									//Instantiate all the states of the State Pattern
                  S1 s1 = new S1();
                  S2 s2 = new S2();
                  S3 s3 = new S3();
                  S4 s4 = new S4();
                  S5 s5 = new S5();
                  S6 s6 = new S6();
                  S8 s8 = new S8();
                  start start = new start();
                  
                  
                  s0.setOutputProcessor(op); 				//create connections between the states and IDs
                  s0.setStateid(0);
                  
                  s1.setOutputProcessor(op);
                  s1.setStateid(1);
                  
                  s2.setOutputProcessor(op);
                  s2.setStateid(2);
                  
                  s3.setOutputProcessor(op);
                  s3.setStateid(3);
                  
                  s4.setOutputProcessor(op);
                  s4.setStateid(4);
                  
                  s5.setOutputProcessor(op);
                  s5.setStateid(5);
                  
                  s6.setOutputProcessor(op);
                  s6.setStateid(6);
                  
                  s8.setOutputProcessor(op);
                  s8.setStateid(7);
                  
                  start.setOutputProcessor(op);
                  start.setStateid(8);
                  
                  mdaEfsm.initializeStates(s0, s1, s2, s3, s4, s5, s6, s8, start);	//set all states to MDA
                  
                  op.setData(data);
                  op.setFactory(concreteFactory1);	//set ConcreteFactory1
                  
                  
				  float a;
				float b;
				  char ch;
				  String pin;
				//Menu  
				  System.out.println("\t\t\t\t\tGasPump-1");   
				  System.out.println("\t\tMENU of Operations"); 	  
				  System.out.println("\t\t0. Activate (float a, float b)"); // the gas pump is activated where a is the price of the Regular gas        
				  															// and b is the price of Diesel gas per gallon  
				  System.out.println("\t\t1. Start()");		 //start the transaction 
				  System.out.println("\t\t2. PayCredit()");  // pay for gas by a credit card
				  System.out.println("\t\t3. Reject()");     // credit card is rejected 
				  System.out.println("\t\t4. PayDebit(string p)");   // pay for gas by a debit card, where p is a pin # 
				  System.out.println("\t\t5. Pin(string x)");  // pin # is provided, where x represents the pin #  
				  System.out.println("\t\t6. Cancel()");     // cancel the transaction 
				  System.out.println("\t\t7. Approved()");     // credit card is approved 
				  System.out.println("\t\t8. Diesel()");     // Diesel gas is selected 
				  System.out.println("\t\t9. Regular()");    // Regular gas is selected 
				  System.out.println("\t\ta. StartPump()");  // start pumping gas 
				  System.out.println("\t\tb. PumpGallon()"); // one gallon of gas is disposed
				  System.out.println("\t\tc. StopPump()");   // stop pumping gas 
				  System.out.println("\t\td. FullTank()");   // Tank is full and pump is stopped
				  System.out.println("\t\tq. Quit the program"); 
				  System.out.println("\t\tPlease make a note of these operations");   
				  System.out.println("\t\tGasPump-1 Execution");       
				  Scanner reader1=new Scanner(System.in); 
				  ch = '1';    
				  while (ch !='q'){
					  System.out.println("\n\n ");
					  System.out.println(" Select Operation: ");  
					  System.out.println("0-Activate,1-start,2-PayCredit,3-Reject,4-PayDebit,5-Pin,6-Cancel,");   
					  System.out.println("7-Approved,8-Diesel,9-Regular,a-PumpGallon,b-StartPump,c-StopPump,d-FullTank,q-quit");  
					  System.out.println("enter your choice: ");   
					  ch =(char) reader1.next().charAt(0);   					  
					  
					  switch (ch) {       
					  case '0': { 
						  //Activate()     
						  System.out.println(" Operation:Activate(float,float)"); 
						  System.out.println(" Enter value:");     
						  a = reader1.nextFloat();   
						  System.out.println(" Enter value"); 
						  b = reader1.nextFloat(); 
						  gp1.Activate(a,b);     
						  break;   
				    }  
					  case '1': {
						  //start()
						  System.out.println(" Operation: start()");    
							gp1.start();    
							break;
					  }
					  case '2': {
						//PayCredit   
							System.out.println(" Operation: PayCredit()");    
							gp1.PayCredit();    
							break; 
					  }
					  case '3': { 
							//Reject  
							System.out.println(" Operation: Reject()");  
							gp1.Reject();
							break;   
							}  
						case '4': {
							//PayDebit(string p) 
							System.out.println(" Operation: PayDebit(string p)"); 
							System.out.println(" Enter value parameter p:");     
							  pin = reader1.next();
							gp1.PayDebit(pin); 
							break;  
							}
						case '5': {
							//Pin(string x)
							System.out.println("Operation: Pin(string x)");
							System.out.println("Please Enter the Pin: ");
							String x = reader1.next();
							gp1.Pin(x); 
							break;
							}   
						case '6': {
							//Cancel   
							System.out.println(" Operation: Cancel()"); 
							gp1.Cancel(); 
							break;  
							}
						case '7': { 
							//Approved
							System.out.println(" Operation: Approved()");   
							gp1.Approved();    
							break;     
							}  
						case '8': { 
							//Diesel 
					     System.out.println("Operation: Diesel()");  
					     gp1.Diesel();  
					     break;  
					     }
						case '9': {
							//Regular
							System.out.println(" Operation: Regular()");   
							gp1.Regular();  
							break; 
							}
						case 'a': {  
							//PumpGallon
							System.out.println(" Operation: PumpGallon()");  
							gp1.PumpGallon(); 
							break;  
							}  
						case 'b': { 
							//StartPump 
							System.out.println(" Operation: StartPump()");   
							gp1.StartPump();   
							break; 
							}
						case 'c': { 
							//StopPump
							System.out.println(" Operation: StopPump()"); 
							gp1.StopPump(); 
							break;  
							}
						case 'd': {
							//FullTank  
							System.out.println(" Operation: FullTank()");     
							gp1.FullTank();  
							break; 
							}
						case 'q': 
							System.out.println("Exiting Operations Menu \n\n");
							break;    
				  }// endswitch  
  
					  
				  }
			  
			  //End of Gas Pump 1
			  break;
		
			  }
			  case '2': { 
				  
		///////////////////////////////	GAS PUMP 2	///////////////////////////////////////		  
				  GasPump_2 gp2 = new GasPump_2();
				  
				  OP op = new OP();	//instantiate OutputProcessor
                  GasPump2Concrete concreteFactory2 = new GasPump2Concrete();	//instantiate correct ConcreteFactory
                  MDA_EFSM mdaEfsm= new MDA_EFSM();
                  DataStore_2 data;
                  data = concreteFactory2.getDataStore2();	//get data of ConcreteFactory
                  gp2.setFactory(concreteFactory2);						//set GasPump1 to use ConcreteFactory1
                  gp2.setData(data);
                  gp2.setMDAEFSM(mdaEfsm);
                  op.setData(data);
                  op.setFactory(concreteFactory2);
                  op.setMDAEFSM(mdaEfsm);
                  
                  
                  S0 s0 = new S0();									//Instantiate all the states of the State Pattern
                  S1 s1 = new S1();
                  S2 s2 = new S2();
                  S3 s3 = new S3();
                  S4 s4 = new S4();
                  S5 s5 = new S5();
                  S6 s6 = new S6();
                  S8 s8 = new S8();
                  start start = new start();
                  
                  
                  s0.setOutputProcessor(op); 				//create connections between the states and IDs
                  s0.setStateid(0);
                  
                  s1.setOutputProcessor(op);
                  s1.setStateid(1);
                  
                  s2.setOutputProcessor(op);
                  s2.setStateid(2);
                  
                  s3.setOutputProcessor(op);
                  s3.setStateid(3);
                  
                  s4.setOutputProcessor(op);
                  s4.setStateid(4);
                  
                  s5.setOutputProcessor(op);
                  s5.setStateid(5);
                  
                  s6.setOutputProcessor(op);
                  s6.setStateid(6);
                  
                  s8.setOutputProcessor(op);
                  s8.setStateid(7);
                  
                  start.setOutputProcessor(op);
                  start.setStateid(8);
                  
                  mdaEfsm.initializeStates(s0, s1, s2, s3, s4, s5, s6, s8, start);	//set all states to MDA
                  
                  op.setData(data);
                  op.setFactory(concreteFactory2);	//set ConcreteFactory1
                  
				  
				  
				  float a, b, c;   
				  int c1;   
				  char ch;     
				  //Menu  
				  System.out.println("\t\t\t\t\tGasPump-2");   
				  System.out.println("\t\tMENU of Operations");  
				  System.out.println("\t\t0. Activate(float, float, float)");   
				  System.out.println("\t\t1. PayCash(int)");   
				  System.out.println("\t\t2. PayCredit()");  
				  System.out.println("\t\t3. Approved()");   
				  System.out.println("\t\t4. Reject()");  
				  System.out.println("\t\t5. Cancel()");   
				  System.out.println("\t\t6. Premium()");  
				  System.out.println("\t\t7. Regular()");  
				  System.out.println("\t\t8. Super()"); 
				  System.out.println("\t\t9. StartPump()");
				  System.out.println("\t\ta. PumpLiter()");   
				  System.out.println("\t\tb. Stop()");  
				  System.out.println("\t\tc. Receipt()");  
				  System.out.println("\t\td. NoReceipt()");   
				  System.out.println("\t\tq. Quit the program"); 
				  System.out.println("\t\tPlease make a note of these operations");   
				  System.out.println("\t\tGasPump-2 Execution");       
				  Scanner reader2=new Scanner(System.in);  
				  ch = '1';    
				  while (ch !='q') {   
					  System.out.println("\n\n ");
					  System.out.println(" Select Operation: ");  
					  System.out.println("0-Activate,1-PayCash,2-PayCredit,3-Approved,4-Reject,5-Cancel,6-Premium,");   
					  System.out.println("7-Regular,8-Super,9-StartPump,a-PumpLiter,b-Stop,c-Receipt,d-NoReceipt,q-quit");  
					  System.out.println("enter your choice: ");   
					  ch =(char) reader2.next().charAt(0);   
					  switch (ch) {       
					  case '0': { 
						  //Activate()     
						  System.out.println(" Operation:Activate (float,float,float)"); 
						  System.out.println(" Enter value:");     
						  a = reader2.nextFloat();   
						  System.out.println(" Enter value"); 
					  
				    b = reader2.nextFloat();    
				    System.out.println(" Enter value");
				    c = reader2.nextFloat();      
				    gp2.Activate(a,b,c);     
				    break;   
				    }   
					case '1': { 
						//PayCash    
						System.out.println(" Operation: PayCash(int c)");  
						System.out.println(" Enter value of the parameter cash:");   
						c1 =  reader2.nextInt();    
						gp2.PayCash(c1);   
						break;    
						}      
					case '2': { 
						//PayCredit   
						System.out.println(" Operation: PayCredit()");    
						gp2.PayCredit();    
						break;     
						}  
					case '3': { 
						//Approved  
						System.out.println(" Operation: Approved()");  
						gp2.Approved();
						break;   
						}  
					case '4': {
						//Reject 
						System.out.println(" Operation: Reject()"); 
						gp2.Reject(); 
						break;  
						}
					case '5': {
						//Cancel
						System.out.println("Operation: Cancel()");  
						gp2.Cancel(); 
						break;
						}   
					case '6': {
						//Premium   
						System.out.println(" Operation: Premium()"); 
						gp2.Premium(); 
						break;  
						}
					case '7': { 
						//Regular
						System.out.println(" Operation: Regular()");   
						gp2.Regular();    
						break;     
						}  
					case '8': { //Super 
				     System.out.println("Operation: Super()");  
				     gp2.Super();  
				     break;  
				     }
					case '9': {
						//StartPump
						System.out.println(" Operation: StartPump()");   
						gp2.startPump();  
						break; 
						}
					case 'a': {  
						//PumpLiter
						System.out.println(" Operation: PumpLiter()");  
						gp2.PumpLiter(); 
						break;  
						}  
					case 'b': { 
						//Stop 
						System.out.println(" Operation: Stop()");   
						gp2.Stop();   
						break; 
						}
					case 'c': { 
						//Receipt
						System.out.println(" Operation: Receipt()"); 
						gp2.Receipt(); 
						break;  
						}
					case 'd': {
						//NoReceipt  
						System.out.println(" Operation: NoReceipt()");     
						gp2.NoReceipt();  
						break; 
						}
					case 'q':
						System.out.println("Exiting Operations Menu \n\n");
						break;    
			  }// endswitch  
		} //endwhile    

				  
//End of Gas Pump 2				  
				break;  
				  
			  }
			  
			  
			  case 'q':
				  break;
			  
			  
				  
			  }

		  
		  }
			 
		
		
			 }//main
					

}
