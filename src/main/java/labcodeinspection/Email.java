package labcodeinspection;
import java.util.Locale;

public class Email {

	final private String m_firstName; 
	final private String m_lastName;
	private String password;
	private String department;
	final private int defaultpasswordLength = 8;
	private String email;
	
	
	@SuppressWarnings("PMD.CommentRequired")
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}
	
	/**
	 * Displays the user's information.
	 * This method prints the user's first name, last name, department, email, and password to the console.
	 */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}
	
	@SuppressWarnings("PMD.CommentRequired")
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
            this.department = "unknown";
            break;
		}
	}

	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}
	
	/**
	 * Generates an email address and password for the user.
	 * The email address is constructed using the user's first name, last name, and department.
	 * The password is generated randomly with a default length.
	 * Both the email address and password are assigned to their respective fields.
	 */
	public void generateEmail() {
		Locale locale = Locale.US;
		this.password = this.randomPassword(this.defaultpasswordLength);
		this.email = this.m_firstName.toLowerCase(locale) + this.m_lastName.toLowerCase(locale) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
