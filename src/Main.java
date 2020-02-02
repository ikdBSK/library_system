import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberList ml = new MemberList();
		BookList bl = new BookList();
		Member m1 = Member.createMember(new String[]{"山田","太郎"},
										new String[]{"東京都", "目黒区", "大岡山"},
										null,false,null,ml.member.size());
		ml.member.add(m1);
		Member m2 = Member.createMember(new String[]{"岡田","花子"},
										new String[]{"神奈川県", "横浜市", "緑区"},
										null,false,null,ml.member.size());
		ml.member.add(m2);
		Book b1 = new Book("数学","田中","角川",3,0);
		bl.book.add(b1);
		Book b2 = new Book("国語","鈴木","新潮",1,1);
		bl.book.add(b2);

		boolean workContinue=true;
		while(workContinue){
			System.out.println("業務番号を選択してください。");
			System.out.println("1.会員情報");
			System.out.println("2.書誌情報");
			System.out.println("3.貸し出し業務");
			System.out.println("4.返却業務");
			System.out.println("5.終了");
			System.out.println("6.日付操作(デバッグ用)");

			Scanner scanner = new Scanner(System.in);
			int worknum = scanner.nextInt();

			switch(worknum){
				case 1:
					new MemberManagement(ml);
					break;
				case 2:
					new BookManagement(bl);
					break;
				case 3:
					new RentalManagement(ml,bl);
					break;
				case 4:
					new ReturnManagement(ml,bl);
					break;
				case 5:
					workContinue = false;
					break;
				case 6:
					new Debug(ml,bl);
					break;
				default:
					System.out.println("入力した数値は正しくありません。");
			}
		}
	}

}
