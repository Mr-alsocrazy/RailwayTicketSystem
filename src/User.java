import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    protected String name;
    protected char sex;
    protected String Aadhaar;
    boolean isLegalName;
    boolean isLegalSex;
    boolean isLegalAadhaar;

    public User(String name, char sex, String Aadhaar) {
        this.name = name;
        this.sex = sex;
        this.Aadhaar = Aadhaar;
        this.isLegalName = NameLegal(this.name);
        this.isLegalSex = SexLegal(this.sex);
        this.isLegalAadhaar = AadhaarLegal(this.Aadhaar);
    }

    boolean NameLegal(String name) {
        String regex = "[a-z|A-Z|_]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    boolean SexLegal(char sex) {
        return sex == 'F' || sex == 'M' || sex == 'O';
    }

    boolean AadhaarLegal(String Aadhaar) {
        if(Aadhaar.length() != 12)
            return false;
        int region = new Integer(Aadhaar.substring(0, 4));
        int caste = new Integer(Aadhaar.substring(4, 8));
        int biocode = new Integer(Aadhaar.substring(8, 11));
        int sexcode = new Integer(Aadhaar.substring(11));
        //System.out.println(region + " " + caste + " " + biocode + " " + sexcode);
        return (region >= 1 && region <= 1237) && (caste >= 20 && caste <= 460) &&
                (biocode >= 0 && biocode <= 100) && (sexcode >= 0 && sexcode <= 2);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAadhaar(String Aadhaar) {
        this.Aadhaar = Aadhaar;
    }

    public String getName() {
        return "Name:" + this.name + "\n";
    }

    public String getSex() {
        return "Sex:" + this.sex + "\n";
    }

    public String getAadhaar() {
        return "Aadhaar:" + this.Aadhaar;
    }

    public String toString() {
        return getName() + getSex() + getAadhaar();
    }
}
