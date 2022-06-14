import java.util.*;
import java.io.*;

class Main {
  // helper method used for array parsing
  public static void addStuff(char[] a, int[] b) {
    for(int i = 0; i<1000; i++) {
      a[i] = (char) b[i];
    }
  }

  // password generating methods
  public static void password(char[] a) throws IOException{
    String g;
    File f;
    String output = "";
    String[] results = new String[125];
    int index = 0;
    boolean hasChars = false;
    boolean hasNumbers = false;
    boolean hasUpper = false;
    boolean hasLower = false;

    for(int i = 0; i<a.length; i++) {
      if(a[i] == '/' || a[i] == '_' || a[i] == '-' || a[i]== '+' || a[i] == '*' || a[i] == ',') {
        hasChars = true;
      }

      if(hasChars == false) {
        if (a[i]=='1' || a[i]=='2' || a[i]=='3' || a[i]=='4' || a[i]=='5' || a[i]=='6' || a[i]=='7' || a[i]=='8' || a[i]=='9' || a[i]=='0') {
          hasNumbers = true;
        }
        if(hasNumbers == false) {
          if (a[i]=='A' || a[i]=='B' || a[i]=='C' || a[i]=='D' || a[i]=='E' || a[i]=='F' || a[i]=='G' || a[i]=='H' || a[i]=='I' || a[i]=='J') {
            hasUpper = true;
          }
          if (a[i]=='a' || a[i]=='b' || a[i]=='c' || a[i]=='d' || a[i]=='e' || a[i]=='f' || a[i]=='g' || a[i]=='h' || a[i]=='i' || a[i]=='j') {
            hasLower = true;
          }
        }
      }
      if((i+1)%8==0) {
        results[index] = output;
        output = "";
        index++;
      }
      output+=a[i];
    }
    // checking what file to print to
    if(hasChars==true) {
      g = "AllCharspw.txt";
    }
    else if(hasNumbers == true) {
      g = "MixedNumpw.txt";
    }
    else if(hasUpper == true && hasLower == true) {
      g = "Mixedpw.txt";
    }
    else if(hasUpper == true) {
      g = "Upperpw.txt";
    }
    else {
      g = "Lowerpw.txt";
    }
    f = new File(g);

    PrintWriter fout = new PrintWriter(f);
    for(int i = 0; i<125; i++) {
      fout.println(results[i]);
    }
    fout.close();
  }
  
  public static void main(String[] args) throws IOException { // modified main method for IOException

    // declaring character an int arrays
    int[] upperInts = new int[1000];
    int[] lowerInts = new int[1000];
    int[] MixedLetInts = new int[1000];
    int[] MixedLetNumInts = new int[1000];
    int[] allCharsInts = new int[1000];

    char[] upper = new char[1000];
    char[] lower = new char[1000];
    char[] mixed = new char[1000];
    char[] mixedNum = new char[1000];
    char[] allChars = new char[1000];

    // printing integers representing lower-case ascii values with a space between each token
    File f = new File("Lower.txt");
    PrintWriter fOut = new PrintWriter(f);
    for(int i = 0; i < lower.length; i++) { 
      fOut.print((int) (Math.random()*26)+97 + " ");
    }
    fOut.close();

    // storing contents in an array
    Scanner f1read = new Scanner(f);
    int index1 = 0;
    while(f1read.hasNext()) {
      lowerInts[index1] = Integer.parseInt(f1read.next());
      index1++;
    }
    System.out.println(index1);
    f1read.close();

    // printing integers representing upper-case ascii values with a space between each token
    File f2 = new File("Upper.txt");
    PrintWriter f2Out = new PrintWriter(f2);
    for(int i = 0; i < 1000; i++) {
      f2Out.print((int) (Math.random()*26)+65 + " ");
    }
    f2Out.close();

    // storing contents in an array
    Scanner f2read = new Scanner(f);
    int index2 = 0;
    while(f2read.hasNext()) {
      upperInts[index2] = Integer.parseInt(f2read.next());
      index2++;
    }
    f2read.close();

    // printing integers representing mixed-case ascii values with a space between each token
    File f3 = new File("Mixed_letters.txt");
    PrintWriter f3Out = new PrintWriter(f3);
    for(int g = 0; g < 1000; g++) {
      if((int) (Math.random()*2) == 0) {
        f3Out.print((int) (Math.random()*26)+65 + " ");
      }
      else {
        f3Out.print((int) (Math.random()*26)+97 + " ");
      }
    }
    f3Out.close();
    
    // storing contents in an array
    Scanner f3read = new Scanner(f3);
    int index3 = 0;
    while(f3read.hasNext()) {
      MixedLetInts[index3] = Integer.parseInt(f3read.next());
      index3++;
    }
    f3read.close();

    // printing integers representing mixed-case ascii values (including numbers) with a space between each token
    File f4 = new File("Mixed_letters_numbers.txt");
    PrintWriter f4Out = new PrintWriter(f4);
    int randomType = 0;
    for(int g = 0; g < 1000; g++) {
      randomType = (int) ((Math.random()*94)+33);
      while(!((randomType>=48 && randomType<=57) || (randomType>=65 && randomType<=90) || (randomType>=97 && randomType<=122))) {
        randomType = (int) ((Math.random()*94)+33);
      }
      f4Out.print(randomType + " ");
     /* if(randomType == 0) {
        f4Out.print((int) ((Math.random()*26)+65) + " ");
      }
      else if(randomType==1) {
        f4Out.print((int) ((Math.random()*26)+97) + " ");
      }
      else {
        f4Out.print((int) ((Math.random()*10)+48) + " ");
      }*/
    }
    f4Out.close();

    // storing contents in an array
    Scanner f4read = new Scanner(f4);
    int index4 = 0;
    while(f4read.hasNext()) {
      MixedLetNumInts[index4] = Integer.parseInt(f4read.next());
      index4++;
    }
    f4read.close();

    // printing integers representing any ascii character (except spaces) with a space between each token
    File f5 = new File("Mixed_chars.txt");
    PrintWriter f5Out = new PrintWriter(f5);
    for(int i = 0; i < 1000; i++) { 
      f5Out.print((int) (Math.random()*94)+33 + " ");
    }
    f5Out.close();

  // storing contents in an array
    Scanner f5read = new Scanner(f5);
    int index5 = 0;
    while(f5read.hasNext()) {
      allCharsInts[index5] = Integer.parseInt(f5read.next());
      index5++;
    }
    f5read.close();

    // helper method
    addStuff(lower, lowerInts);
    addStuff(upper, upperInts);
    addStuff(mixed, MixedLetInts);
    addStuff(mixedNum, MixedLetNumInts);
    addStuff(allChars, allCharsInts);

    // beginning of actual program
    Scanner realInput = new Scanner(System.in);
    System.out.println("Welcome to the password generator!\n\nPlease select which type of password you would like to generate!\n\n1.Lowercase letters\n2.Uppercase letters\n3.Uppercase and Lowercase letters\n4.Uppercase, Lowercase, and Numbers\n5.Uppercase, Lowercase, Numbers and Symbols\n0.Exit\n\nEnter Selection by typing numbers 1,2,3,4,5 or 0 to Exit:");
    boolean isRunning = true;
    int input = 0;
    while(isRunning) {
      System.out.println();
      input = realInput.nextInt();
      if(input == 0) {
        isRunning = false;
      }
      if(input == 1) {
        password(lower);
      }
      if(input == 2) {
        password(upper);
      }
      if(input == 3) {
        password(mixed);
      }
      if(input == 4) {
        password(mixedNum);
      }
      if(input == 5) {
        password(allChars);
      }
      System.out.println("Do you wish to continue?");
    }
  }
}