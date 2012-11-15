import junit.framework.*;
import java.text.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class EnglishToIntegerTest {
	
	EnglishToInteger EtI;
	
	@Before
	public void makeTranslator(){
		EtI = new EnglishToInteger();
	}
	
	@Test
	public void testZero()
	{
		assertEquals(0,EtI.Translate("zEro"),0);
		assertEquals(0,EtI.Translate("naughT"));
	}
	@Test
	public void testSingleDigits()
	{
		assertEquals(1,EtI.Translate("one"),0);
		assertEquals(4,EtI.Translate("four"),0);
		assertEquals(7,EtI.Translate("seven"),0);
		assertEquals(9,EtI.Translate("nine"),0);
	}
	
	@Test
	public void testTeens()
	{
		assertEquals(10,EtI.Translate("TEN"),0);
		assertEquals(11,EtI.Translate("EleVen"),0);
		assertEquals(15,EtI.Translate("fifteen"),0);
		assertEquals(18,EtI.Translate("eighteen"),0);
	}
	
	@Test
	public void testLoneTenValues()
	{
		assertEquals(20,EtI.Translate("twenty"),0);
		assertEquals(40,EtI.Translate("forty"),0);
		assertEquals(70,EtI.Translate("seventy"),0);
		assertEquals(80,EtI.Translate("eighty"),0);
	}
	
	@Test
	public void testTenPlusDigit()
	{
		assertEquals(31,EtI.Translate("thirty one"),0);
		assertEquals(58,EtI.Translate("FIFTY EIGHT"),0);
		assertEquals(63,EtI.Translate("SixtY THRee"),0);
		assertEquals(99,EtI.Translate("ninety NINE"),0);
	}
	
	@Test
	public void testHundred()
	{
		assertEquals(100,EtI.Translate("one hundred"),0);
		assertEquals(500,EtI.Translate("five hundred"),0);
		assertEquals(600,EtI.Translate("six hundred"),0);
		assertEquals(900,EtI.Translate("nine hundred"),0);
	}
	
	@Test
	public void testHundredPlusDigit()
	{
		assertEquals(103,EtI.Translate("one hundred three"),0);
		assertEquals(207,EtI.Translate("two hundred seven"),0);
		assertEquals(409,EtI.Translate("four hundred nine"),0);
		assertEquals(708,EtI.Translate("seven hundred eight"),0);
	}
	
	@Test
	public void testHundredPlusTeen()
	{
		assertEquals(111,EtI.Translate("one hundred eleven"),0);
		assertEquals(219,EtI.Translate("two hundred nineteen"),0);
		assertEquals(817,EtI.Translate("eight hundred seventeen"),0);
		assertEquals(912,EtI.Translate("nine hundred twelve"),0);
	}
	
	@Test
	public void testHundredPlusTens()
	{
		assertEquals(126,EtI.Translate("one hundred twenty six"),0);
		assertEquals(376,EtI.Translate("three hundred seventy six"),0);
		assertEquals(999,EtI.Translate("nine hundred ninety nine"),0);
		assertEquals(548,EtI.Translate("five hundred forty eight"),0);
	}
	
	@Test
	public void testThousand()
	{
		assertEquals(1000,EtI.Translate("one thousand"),0);
		assertEquals(4002,EtI.Translate("four thousand two"),0);
		assertEquals(6015,EtI.Translate("six thousand fifteen"),0);
		assertEquals(9040,EtI.Translate("nine thousand forty"),0);
	}
	
	@Test
	public void testTenThousand()
	{
		assertEquals(10419,EtI.Translate("ten thousand four hundred nineteen"),0);
		assertEquals(68904,EtI.Translate("sixty eight thousand nine hundred four"),0);
	}
	
	@Test
	public void testHundredThousand()
	{
		assertEquals(813127,EtI.Translate("eight hundred thirteen thousand one hundred TWENTY SEVEN"),0);
		assertEquals(999999,EtI.Translate("nine hundred ninety nine thousand nine hundred ninety nine"),0);
	}
	
	@Test
	public void testMillion()
	{
		assertEquals(2000000,EtI.Translate("two million"),0);
		assertEquals(4000001,EtI.Translate("four million one"),0);
		assertEquals(8000019,EtI.Translate("eight million nineteen"),0);
		assertEquals(9000085,EtI.Translate("nine million eighty five"),0);
	}
	
	@Test
	public void testMillionPlusThousand()
	{
		assertEquals(3056420,EtI.Translate("three million fifty six thousand four hundred twenty"),0);
		assertEquals(1234567,EtI.Translate("one million two hundred thirty four thousand five hundred sixty seven"),0);
	}
	
	@Test
	public void testTenMillion()
	{
		assertEquals(68900011,EtI.Translate("sixty eight million nine hundred thousand eleven"),0);
		assertEquals(98765432,EtI.Translate("ninety eight million seven hundred sixty five thousand four hundred thirty two"),0);
	}
	
	@Test
	public void testHundredMillion()
	{
		assertEquals(123456789,EtI.Translate("one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine"),0);
		assertEquals(999999999,EtI.Translate("nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine"),0);
	}
	
	@Test
	public void testMinusSubHundred()
	{
		assertEquals(-2,EtI.Translate("negative TWO"),0);
		assertEquals(-16,EtI.Translate("minus sixteen"),0);
		assertEquals(-64,EtI.Translate("negative sixty four"),0);
		assertEquals(-98,EtI.Translate("minus ninety eight"),0);
	}
	
	@Test
	public void testMinusHundred()
	{
		assertEquals(-101,EtI.Translate("negative one hundred one"),0);
		assertEquals(-365,EtI.Translate("minus three hundred sixty five"),0);
		assertEquals(-412,EtI.Translate("negative four hundred twelve"),0);
		assertEquals(-797,EtI.Translate("minus seven hundred ninety seven"),0);
	}
	
	@Test
	public void testMinusThousand()
	{
		assertEquals(-4016,EtI.Translate("negative four thousand sixteen"),0);
		assertEquals(-76540,EtI.Translate("minus seventy six thousand five hundred forty"),0);
		assertEquals(-835000,EtI.Translate("negative eight hundred thirty five thousand"),0);
		assertEquals(-900004,EtI.Translate("minus nine hundred thousand four"),0);
	}
	
	@Test
	public void testMinusMillion()
	{
		assertEquals(-6000000,EtI.Translate("negative six million"),0);
		assertEquals(-15870403,EtI.Translate("minus fifteen million eight hundred seventy thousand four hundred three"),0);
		assertEquals(-507600011,EtI.Translate("negative five hundred seven million six hundred thousand eleven"),0);
		assertEquals(-999999999,EtI.Translate("minus nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine"),0);
	}
}
