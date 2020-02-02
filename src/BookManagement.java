import java.util.Scanner;

public class BookManagement {
	/*
	 * 書誌情報
	 */
	public BookManagement(BookList bl) {
		boolean bookContinue=true;
		while(bookContinue) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("書誌情報");
			System.out.println("何を行いますか。");
			System.out.println("1.本の入荷");
			System.out.println("2.本の廃棄");
			System.out.println("3.書籍一覧");
			System.out.println("4.検索");
			System.out.println("5.戻る");
			int worknum = scanner.nextInt();
			switch(worknum) {
				case 1:
					System.out.println("本の入荷");
					bookRegister(bl);
					break;
				case 2:
					System.out.println("本の廃棄");
					bookDispose(bl);
					break;
				case 3:
					System.out.println("書籍一覧(デバッグ用)");
					for(int i=0;i<bl.book.size();i++) {
						if(bl.book.get(i).exist == true) {
							System.out.println(bl.book.get(i).name);
						}
					}
					break;
				case 4:
					System.out.println("検索");
					bookSearch(bl);
					break;
				case 5:
					bookContinue = false;
					break;
				default:
					System.out.println("入力した数値は正しくありません。");
					System.out.println("");
			}
		}
	}

	/*
	 * 本の入荷
	 */
	public void bookRegister(BookList bl) {
		Scanner scanner = new Scanner(System.in);
		int check = 2;
		String name = null;
		String author = null;
		String publisher = null;
		int num = 0;
		while(check == 2) {
			name = bookName();
			author = bookAuthor();
			publisher = bookPublisher();
			num = bookNum();
			System.out.println("入力が正しければ1を、やり直す場合は2を入力してください。");
			System.out.println("題名:" + name);
			System.out.println("著者:" + author);
			System.out.println("出版社:" + publisher);
			System.out.println("入荷数:" + num);
			check = scanner.nextInt();
		}
		Book b = new Book(name,author,publisher,num,bl.book.size());
		bl.book.add(b);
		System.out.println("入荷が完了しました。");
		System.out.println("");
	}

	/*
	 * 本の題名を入力するときに用いる
	 */
	public String bookName() {
		Scanner scanner = new Scanner(System.in);
		String name = null;
		System.out.println("題名を入力してください。");
		name = scanner.next();
		return name;
	}

	/*
	 * 著者名を入力するときに用いる
	 */
	public String bookAuthor() {
		Scanner scanner = new Scanner(System.in);
		String author = null;
		System.out.println("著者名を入力してください。");
		author = scanner.next();
		return author;
	}

	/*
	 * 出版社を入力するときに用いる
	 */
	public String bookPublisher() {
		Scanner scanner = new Scanner(System.in);
		String publisher = null;
		System.out.println("出版社名を入力してください。");
		publisher = scanner.next();
		return publisher;
	}

	public int bookNum() {
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		System.out.println("入荷数を入力してください。");
		num = scanner.nextInt();
		return num;
	}

	/*
	 * 本の廃棄
	 */
	public void bookDispose(BookList bl) {
		Scanner scanner = new Scanner(System.in);
		int id = idManagement(bl);
		boolean workContinue = true;
		if(id >= 0) {
			Book b = bl.book.get(id);
			while(workContinue) {
				System.out.println("廃棄しますか?");
				System.out.println("1.はい");
				System.out.println("2.いいえ");
				switch(scanner.nextInt()) {
					case 1:
						b.exist=false;
						System.out.println("廃棄手続きが完了しました。");
						System.out.println("");
						workContinue = false;
						break;
					case 2:
						workContinue = false;
						System.out.println("");
						break;
					default:
						System.out.println("入力された値は正しい値ではありません。");
						System.out.println("");
				}
			}
		}
	}

	/*
	 * 検索
	 */
	public void bookSearch(BookList bl) {
		Scanner scanner = new Scanner(System.in);
		boolean searchContinue = true;
		while(searchContinue) {
			System.out.println("1.題名から検索");
			System.out.println("2.著者名から検索");
			System.out.println("3.出版社から検索");
			System.out.println("4.戻る");
			int searchNum = scanner.nextInt();
			String keyword=null;
			int result=0;
			switch(searchNum) {
				case 1:
					System.out.println("題名から検索");
					keyword = scanner.next();
					for(int i=0;i<bl.book.size();i++) {
						Book b = bl.book.get(i);
						if(b.exist == true && b.name.contains(keyword)==true) {
							result = result + 1;
							System.out.println(result + ".");
							searchResult(b);
						}
					}
					if(result == 0) {
						System.out.println("該当する書籍は見つかりませんでした。");
						System.out.println("");
					}
					break;
				case 2:
					System.out.println("著者名から検索");
					keyword = scanner.next();
					for(int i=0;i<bl.book.size();i++) {
						Book b = bl.book.get(i);
						if(b.exist == true && b.author.contains(keyword)==true) {
							result = result + 1;
							System.out.println(result + ".");
							searchResult(b);
						}
					}
					if(result == 0) {
						System.out.println("該当する書籍は見つかりませんでした。");
						System.out.println("");
					}
					break;
				case 3:
					System.out.println("出版社から検索");
					keyword = scanner.next();
					for(int i=0;i<bl.book.size();i++) {
						Book b = bl.book.get(i);
						if(b.exist == true && b.publisher.contains(keyword)==true) {
							result = result + 1;
							System.out.println(result);
							searchResult(b);
						}
					}
					if(result == 0) {
						System.out.println("該当する書籍は見つかりませんでした。");
						System.out.println("");
					}
					break;
				case 4:
					searchContinue = false;
					break;
				default:
					System.out.println("入力された値は正しい値ではありません。");
					System.out.println("");
			}
		}
	}

	public void searchResult(Book b) {
		System.out.println("題名:" + b.name);
		System.out.println("著者名:" + b.author);
		System.out.println("出版社:" + b.publisher);
		System.out.println("在庫数:" + b.num);
		System.out.println("");
	}

	/*
	 * id管理
	 */
	public static int idManagement(BookList bl) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("書籍のIDを入力してください。");
		int id = scanner.nextInt();
		if(id < 0){
			System.out.println("入力された値は正しい値ではありません。");
			return -1;
		}else if(bl.book.size()-1 < id || bl.book.get(id).exist == false){
			System.out.println("書籍が存在しません。");
			return -1;
		}else{
			Book b = bl.book.get(id);
			System.out.println("題名:" + b.name);
			System.out.println("著者:" + b.author);
			System.out.println("出版社:" + b.publisher);
			System.out.println("");
			return id;
		}
	}
}
