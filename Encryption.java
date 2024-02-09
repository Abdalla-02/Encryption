import java.util.Arrays;
import java.util.Scanner;
public class Encryption{

    public static void main(String[] args){
        String text="";
        try {
                 if (args[0].equals("encrypt")) {
                         if (args[1].startsWith("rot")) {
                             // put all arguments in one text so the methode can handle it
                             for (int i = 2; i < args.length; i++) {
                                    text += args[i] + " ";
                             }
                             System.out.println(rotN(text, Integer.parseInt(args[1], 3, args[1].length(), 10)));

                         } else {   //rot13
                                for (int i = 1; i < args.length; i++) {  // same as line 11
                                     text += args[i] + " ";
                                }
                                System.out.println(rotN(text, 13));
                         }

                } else if (args[0].equals("decrypt")) {
                     // same as line 11
                    for (int i = 1; i < args.length; i++) {
                        text += args[i] + " ";
                    }
                    System.out.println(decryptCall(text));

                }else {
                    System.err.println("Please write (encrypt) or (decrypt) and then the text");
                }
        }catch (Exception e){
                System.err.println("Wrong Input");  //Error handling
        }
    }

    /**
     * it encrypts any text with the given number of letters to be shifted
     * @param text the text which need to be encrypted
     * @param n the number of times the letters shifts
     * @return  an encrypted text
     */
    public static String rotN(String text, int n){
        if (n%26 ==0){
            return text;
        }

        String afterText= "";

        // Hallo Welt! --> [H, a, l, ...,! ]
        char[] charArray = text.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            //spaces or commas or numbers etc. will be outputted without any changes
            if (!Character.isLetter(c)) {
                afterText += c;

            } else if (Character.isUpperCase(c)) {
                //the ascii number of 'A' is 65, so we subtract it to calculate the number of shifting then add it at the end
                afterText += (char) ((c - 65 + n) % 26 + 65);

                //the ascii number of 'a' is 97, so we subtract it to calculate the number of shifting then add it at the end
            } else afterText += (char) ((c - 97 + n) % 26 + 97);

        }
        return afterText;
    }


    /**
     * it calls "decrypt" methode with the needed information from the user
     * @param text the Text which needs to be decrypted
     * @return the decrypted Text
     */
    public static String decryptCall(String text){
        int index =0;

        while(true) {
            System.out.println(decrypt(text,index));
            System.out.println("is that right?\nif yes choose (1) if no write (2).");

            while (true){
                    Scanner input = new Scanner(System.in);
                    if(input.hasNextInt()){     //Error handling
                        int choice = input.nextInt();

                        if (choice == 1) {
                            System.exit(0);

                         } else if (choice == 2 && index < 25) {
                                index++;
                                break;

                            } else if (index >= 25) {
                                System.out.println("\nSorry but I tried all possibilities and I couldn't find a decryption for the text.\nlet's try again I may got it right but you didn't notice it.\n");
                                index =0;
                                break;

                            } else System.err.println("You can only choose (1) for yes or (2) for no");
                    } else {
                        System.err.println("WRONG INPUT");
                    }
                }
        }
    }

    /**
     *it decrypts texts
     * @param text  the Text which needs to be decrypted
     * @param trialNum the number of trials (from 0 to 25)
     * @return the decrypted text
     */
    public static String decrypt(String text, int trialNum){
        if (text.length() == 0){
            return text;
        }
        //all the alphabetic letters sorted from the most used to the least
        char[] commonLetters = {'e','n','i','s','r','a','t','d','h','u','l','c','g','m','o','b','w','f','k','z','p','v','j','y','x','q'};
        char[] textArray = text.toLowerCase().toCharArray();
        Arrays.sort(textArray);
        System.out.println(java.util.Arrays.toString(textArray));

        char popular = textArray[0];
        int count = 1;
        int max = 1;

        // finds the most common letter in the text
        for (int i=1 ; i< textArray.length ; i++){

            if (textArray[i - 1] == textArray[i]){
                count++;

            }  else if (count > max && Character.isLetter(textArray[i-1])){
                     popular = textArray[i-1];
                     max = count;
                     count = 1;

                }  else count = 1;
        }

        //to check if the last letter is the most common because it won't be checked in the loop
        if (count > max){
            popular = textArray[textArray.length-1];
        }

        int _n = Math.abs(popular - commonLetters[trialNum]);
        if(popular> commonLetters[trialNum]){
            _n = 26-_n;
        }

        return rotN( text, _n) ;
    }

}
