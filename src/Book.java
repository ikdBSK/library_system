import java.util.Calendar;
import java.util.ArrayList;

public class Book{

	/*
	 * name
	 * author
	 * publisher
	 * num
	 * numMax
	 * cal
	 * rentalMember
	 * id
	 * exist
	 */

	/**
	 * @uml.property  name="name"
	 */
	String name;

	/**
	 * @uml.property  name="author"
	 */
	String author;

	/**
	 * @uml.property  name="publisher"
	 */
	String publisher;

	/**
	 * @uml.property  name="num"
	 */
	int num;

	/**
	 * @uml.property  name="numMax"
	 */
	int numMax;

	/**
	 * @uml.property  name="cal"
	 */
	Calendar cal;

	/**
	 * @uml.property  name="rentalMember"
	 */
	ArrayList<Member> rentalMember = new ArrayList<Member>();

	/**
	 * @uml.property  name="id"
	 */
	int id;

	/**
	 * @uml.property  name="exist"
	 */
	boolean exist;

		/**
		 * 本を新しく追加するときに呼び出す
		 */
		public Book(String name, String author, String publisher, int num,int id){
			this.name = name;
			this.author = author;
			this.publisher = publisher;
			this.num = num;
			this.numMax = num;
			this.exist = true;
			this.id = id;
		}

		/*
		 * 本のディープコピーに用いる
		 */
		public Book(String name, String author, String publisher,int id){
			this.name = name;
			this.author = author;
			this.publisher = publisher;
			this.id = id;
		}

			/**
			 * 廃棄処理
			 */
			public void dispose(){
				this.exist = false;
			}

}
