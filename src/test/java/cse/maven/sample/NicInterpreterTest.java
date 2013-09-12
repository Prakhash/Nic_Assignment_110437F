package cse.maven.sample;
import static cse.maven.sample.NicProp.Gender;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cse.maven.sample.exception.InvalidNicNumberException;
import static org.testng.Assert.assertEquals;

@Test
public class NicInterpreterTest {

	NicInterpreter nicInterpreter; 
		
	@BeforeClass
	public void setUp() {
		nicInterpreter = new NicInterpreter();
	}

	@Test
	public void createNICTest1() throws InvalidNicNumberException {
		NicProp resultN = nicInterpreter.createNicProp("902032053V");
	    assertEquals(resultN.getGender(),Gender.MALE);
	}
        
        @Test
	public void createNICTest2() throws InvalidNicNumberException {
		NicProp resultN = nicInterpreter.createNicProp("902032053V");
	    assertEquals(resultN.getBirthday().getDayOfMonth(),21);
	}
        
        @Test
        public void createNICTest3() throws InvalidNicNumberException {
		NicProp resultN = nicInterpreter.createNicProp("902032053V");
	    assertEquals(resultN.getBirthday().getMonthOfYear(),7);
	}
        
        @Test
        public void createNICTest4() throws InvalidNicNumberException {
		NicProp resultN = nicInterpreter.createNicProp("907292396v");
	    assertEquals(resultN.getBirthday().getYear(),1990);
	}
	
}
