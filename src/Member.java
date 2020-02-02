import java.util.ArrayList;
import java.util.Calendar;

public abstract class Member {

	public static Member createMember(String[] name, String[] address, ArrayList<Book> rentalBook, boolean penalty, Calendar penaltyDate, int id) {
		if(address[2].contains("大岡山")) {
			return new MemberFromOokayama(name,address,rentalBook,penalty,penaltyDate,id);
		}else {
			return new Normal(name,address,rentalBook,penalty,penaltyDate,id);
		}
	}

/*
 * name[]
 * rentalNumber
 * address[]
 * rentalBook
 * rentalMax
 * rentalLimit
 * exist
 * penalty
 * penaltyDate
 * id
 */
	int id;

	/**
	 * @uml.property  name="name"
	 */
	String[] name = new String[2];

	/**
	 * @uml.property  name="rentalNumber"
	 */
	int rentalNumber;


	/**
	 * @uml.property  name="address"
	 */
	String[] address = new String[3];

	/**
	 * @uml.property  name="rentalBook"
	 */
	ArrayList<Book> rentalBook = new ArrayList<Book>();

	/**
	 * @uml.property  name="rentalMax"
	 */
	int rentalMax;

	/**
	 * @uml.property  name="rentalLimit"
	 */
	int rentalLimit;

	/**
	 * @uml.property  name="penalty"
	 */
	boolean penalty;

	/**
	 * @uml.property  name="penaltyDate"
	 */
	Calendar penaltyDate;

	/**
	 * Getter of the property <tt>penaltyDate</tt>
	 * @return  Returns the penaltyDate.
	 * @uml.property  name="penaltyDate"
	 */
	public Calendar getPenaltyDate() {
		return penaltyDate;
	}

		/**
		 * @uml.property  name="exist"
		 */
		boolean exist;
}
