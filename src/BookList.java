

import java.util.ArrayList;

public class BookList {

	/**
	 * @uml.property name="book"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="shared" inverse="bookList:Book"
	 */
	ArrayList<Book> book = new ArrayList<Book>();

}
