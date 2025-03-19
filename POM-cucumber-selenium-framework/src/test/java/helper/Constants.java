package helper;

public class Constants {

//	set which browser to run on
//	options include :
//	CHROME for Chrome browser
//	FIREFOX for firefox browser

	public final static String browser = "Chrome";

	public final static String userName = "guest";
	public final static String password = "guestpassword";

	public final static String olduser = "1234automation567@gmail.com";
	public final static String oldpass = "Consultant1234@";

	public final static String phoneNumber = "083482922312";
	public final static String cardHolderName = "Automation";

	public final static String addressLine = "test";
	public final static String city = "dublin";

	public final static String country = "ireland";
	public final static String zipcode = "0000";

	public final static String errorMessage = "Transaction could not be processed. Your payment was not authorised therefore we could not complete your booking. Please ensure that the information was correct and try again or use a new payment card.";
	public final static String loginMessage = "Make it simple with myRyanair";

	public final static long explicitWait = 100;
	public final static long impliciteWait = 100;

	public final static String adultFirstNameOne = "John";
	public final static String adultSurNameOne = "Barry";

	public final static String adultFirstNameTwo = "Automation";
	public final static String adultSurNameTwo = "Test";

	public final static String childFirstNameOne = "Harry";
	public final static String childSurNameOne = "Potter";

	public static String getBrowser() {
		return browser;
	}

	public static String getUsername() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static String getloginMessage() {
		return loginMessage;
	}

	public static String getPhoneNumber() {
		return phoneNumber;
	}

	public static String getCardHolderName() {
		return cardHolderName;
	}

	public static String getCity() {
		return city;
	}

	public static String getCountry() {
		return country;
	}

	public static String getAddressLine() {
		return addressLine;
	}

	public static String getZipCode() {
		return zipcode;
	}

	public static String getAdultFirstNameOne() {
		return adultFirstNameOne;
	}

	public static String getAdultSurNameOne() {
		return adultSurNameOne;
	}

	public static String getAdultFirstNameTwo() {
		return adultFirstNameTwo;
	}

	public static String getAdultSurNameTwo() {
		return adultSurNameTwo;
	}

	public static String getChildFirstNameOne() {
		return childFirstNameOne;
	}

	public static String getChildSurNameOne() {
		return childSurNameOne;
	}

	public static long getExplicitwait() {
		return explicitWait;
	}

	public static long getImplicitewait() {
		return impliciteWait;
	}

}
