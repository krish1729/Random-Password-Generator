import java.util.Scanner;

public class randompasswordgenerator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // asking the user to input the number of passwords and the length of passwords
        System.out.print("Enter the number of passwords to be generated : ");
        int total = sc.nextInt();

        System.out.print("Enter the number of characters to be generated for each password :");
        int length = sc.nextInt();


        sc.close();


        String[] randomPasswords = new String[total]; // an array to store the number of passwords required by the user

        for(int i = 0; i<total; i++){    // for loop to iterate for number of passwords
            String randomPassword = "";
            for(int j = 0; j<length; j++){  // inner for loop to iterate length of each password
                randomPassword += randomCharacter(); // each random character is appended to an empty string until the length criteria is satisfied
            }
            randomPasswords[i] = randomPassword; // indexing each password in an array of passwords
        }

        printPasswords(randomPasswords);
    }

    //the possibilities for the password are :
    // 0 - 9, i.e 10 digits,
    // a - z, i.e 26 lowwercase alphabets,
    // A -  Z, i.e 26 uppercase alphabets,
    //so, in total, we have : 10 + 26 + 26 = 62 possible characters in each password

    public static char randomCharacter(){
        // generate a random number that can represent all the 62 possible characters of the password
        int rand = (int)(Math.random() * 62);
        // 0 - 9 : 48 - 57 in ASCII  ---> 1
        // A - Z : 65 - 90 in ASCII  ---> 2
        // a - z : 97 - 122 in ASCII ---> 3


        // The logic behind the if conditionals is to convert the generated random number into an ASCII value, by : 
        // based on 1, 2 and 3 in line 40, 41, 42 , we have to add a particular number to the generated random number to get its corresponding ASCII value
        // so, from 0 - 9, we can add 48 to get ASCII values in the range of 48 - 57
        if(rand<=9){
            int ascii = rand + 48;
            return (char)(ascii);
        } 
        // so, from 10 - 35, we can add 48 to get ASCII values in the range of 65 - 90
        else if(rand<=35){
            int ascii = rand + 55;
            return (char)(ascii);
        }
        // so, from 36 - 62, we can add 48 to get ASCII values in the range of 97 - 122
         else{
            int ascii = rand + 61;
            return (char)(ascii);
        }

    }

    // method th print any array
    public static void printPasswords(String[] arr){

        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}