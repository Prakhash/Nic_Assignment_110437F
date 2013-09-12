package cse.maven.sample;

import cse.maven.sample.exception.InvalidNicNumberException;
import org.joda.time.DateTime;

public class NicInterpreter {
        public NicProp createNicProp(String nicNumber) throws InvalidNicNumberException{
        try { 
            int year = Integer.parseInt(nicNumber.substring(0, 2)) + 1900;
            NicProp.Gender gender;
            if(year > 2013 || year < 0)
                throw new InvalidNicNumberException("Please re-check the first 2 digits.");
            
            int birthDate = Integer.parseInt(nicNumber.substring(2, 5));
            if(birthDate >= 500) {   //female
                gender = NicProp.Gender.FEMALE;
                birthDate -= 500;
            }
            else
                gender = NicProp.Gender.MALE;
            
            DateTime birthday = new DateTime(year, 1, 1, 0, 0);
            birthday = birthday.plusDays(birthDate - 2);
            
            if(birthday.getYear() > year)  //date field exceeds max limit
                throw new InvalidNicNumberException("Please re-check digits 3 to 5." + birthday.getYear() + " " + birthDate);
            
            DateTime backwards = new DateTime();
            backwards.minusYears(-18);
            //age >= 18 years iff backwards >= birthday
            boolean voter = (backwards.compareTo(birthday) >= 0);

            int recordSet = 0;
            
            return new NicProp(birthday, gender, voter, recordSet);
            
        }
        catch(InvalidNicNumberException ine) {
            throw ine;
        }
        catch(RuntimeException re) {
            throw new InvalidNicNumberException("incorrect Nic Number.");
        }
    }
}
