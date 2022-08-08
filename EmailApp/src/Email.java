import java.util.Locale;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateMail;
    private String companySuffix =  "b2b.com";

    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;

    }

    private String setDepartment (){
        System.out.print("New worker: " + firstName + " , Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){ return "sales";}
        else if (depChoice ==2){return "dev";}
        else if (depChoice ==3){return "acct";}
        else {return "";}
    }
    private String randomPassword (int length){

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXYZ0123456789!%@:&";
        char [] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() *passwordSet.length());
            password[i]= passwordSet.charAt(rand);
        }
        return new String (password);
    }

    public void setMailBoxCapacity (int capacity) {
        this.mailBoxCapacity =capacity;
    }

    public void setAlternateMail (String altEmail){
        this.alternateMail =altEmail;
    }

    public void changePassword (String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateMail(){
        return alternateMail;
    }
    public String getPassword (){
        return password;
    }

    public String showInfo (){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity;
    }



}
