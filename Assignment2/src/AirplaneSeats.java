import java.util.Scanner;

public class AirplaneSeats {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int taken = 0;
        char[][] seats = new char[7][4];	//Initialize seat array
        for (int i = 0; i < 7; i++) {		//Creates values for seats array
            seats[i][0] = 'A';
            seats[i][1] = 'B';
            seats[i][2] = 'C';
            seats[i][3] = 'D';
        }

        String seatNumber;
        System.out.println("You will be selecting seats for this airplane.");
        print(seats);
        System.out.println("\nYou will input the seat selection using the row number and then the seat "
        		+ "letter (EX - 3B)");
        System.out.println("Please enter the seat number or Q to quit.");
        seatNumber = sc.nextLine();
        if (seatNumber.equalsIgnoreCase("q")) {	//If Q is entered, program is ended
            System.out.println("Have a great day.");
            System.exit(0);
        }
        
        while (taken < 28 && seatNumber.length() > 0) {		//Creates loop for seatNumber entries
            int row = seatNumber.charAt(0) - '1';		//Makes sure first value is numbers
            int col = seatNumber.charAt(1) - 'A';		//Makes sure second value is letters
            if (row < 0 || row >= 7 || col < 0 || col >= 4) {	//Makes sure values are within correct range
                System.out.println("\nInvalid input! Please enter the seat number or Q to quit.");
                seatNumber = sc.nextLine();
                if (seatNumber.equalsIgnoreCase("q")) {
                    System.out.println("Have a great day.");
                    System.exit(0);
                }
            } 
            else {
            	if(seats[row][col]=='X') {	//Tells user to enter another seat number
            		System.out.println("\nYou have already choosen this seat.");
            	}
                if (seats[row][col] != 'X') {	//Accepts seat number and adds it in system
                    seats[row][col] = 'X';
                    taken++;
                    System.out.println(" ");
                    print(seats);
                }
                if (taken < 28) {	//Continues loop if the entries are not completely filled
                    System.out.println("\nPlease enter the seat number or Q to quit.");
                    seatNumber = sc.nextLine();
                    if (seatNumber.equalsIgnoreCase("q")) {
                        System.out.println("Have a great day.");
                        System.exit(0);
                    }
                }
            }
            
        }
        sc.close();
    }

    public static void print(char[][] seats) {	//Displays the chart of seats
        for (int i = 0; i < seats.length; i++) {
            System.out.println((i + 1) + " " + seats[i][0] + " " + seats[i][1] + " " + 
        seats[i][2] + " " + seats[i][3]);
        }
    } 
} 
