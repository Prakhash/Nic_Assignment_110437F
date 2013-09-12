package cse.maven.sample;
import org.joda.time.DateTime;


public class NicProp {
    public static enum Gender {
        MALE, FEMALE
    };
    private final DateTime birthday;
    private final boolean voter;
    private final Gender gender;
    private final int recordSetNumber;

    public DateTime getBirthday() {
        return birthday;
    }

    public boolean isVoter() {
        return voter;
    }

    public Gender getGender() {
        return gender;
    }

    public int getRecordSetNumber() {
        return recordSetNumber;
    }

    public NicProp(DateTime birthday, Gender gender, boolean voter, int recordSetNumber) {
        this.birthday = birthday;
        this.voter = voter;
        this.gender = gender;
        this.recordSetNumber = recordSetNumber;
    }

   
    public String getData() {
       
       return  "NIC[birthday=Birthday["+"Year="+birthday.getYear()+", Month"+birthday.getMonthOfYear()+", Date"+ birthday.getDayOfMonth() 
               +"],gender="+getGender()+",isVoter="+isVoter()+",recordSetNumber="+getRecordSetNumber()+"]";
               
    }
}
