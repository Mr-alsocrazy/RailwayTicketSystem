import java.util.Scanner;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Test T = new Test();
        Scanner in = new Scanner(System.in);
        String argStr;
        HashMap<String, String> UserMap = new HashMap<>();
        while(true) {
            argStr = in.nextLine();
            if(argStr.equals("QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            }
            String[] Commands = argStr.split(" ");
            String command = Commands[0];
            if(command.equals("addUser")) {
                if(Commands.length != 4) {
                    System.out.println("Arguments illegal");
                }
                else {
                    String UserName = Commands[1];
                    char UserSex = Commands[2].charAt(0);
                    String UserAadhaar = Commands[3];
                    User user = new User(UserName, UserSex, UserAadhaar);
                    if(!T.isLegal(user)) {}
                    else if(!T.HashSearch(UserMap, UserAadhaar)) {
                        UserMap.put(UserAadhaar, UserName);
                        System.out.println(user.toString());
                    }
                    else {
                        System.out.println("Aadhaar number exist");
                    }
                }
            }
        }
    }

    public boolean HashSearch(HashMap<String, String> UserMap, String Aadhaar) {
        return !UserMap.getOrDefault(Aadhaar, "Not Found").equals("Not Found");
    }

    public boolean isLegal(User user) {
        boolean UserLegal = true;
        if(!user.isLegalName) {
            UserLegal = false;
            System.out.println("Name illegal");
        }
        else if(!user.isLegalSex) {
            UserLegal = false;
            System.out.println("Sex illegal");
        }
        else if(!user.isLegalAadhaar) {
            UserLegal = false;
            System.out.println("Aadhaar number illegal");
        }
        return UserLegal;
    }
}