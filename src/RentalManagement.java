import java.util.Scanner;
import java.util.Calendar;

public class RentalManagement{
	public RentalManagement(MemberList ml,BookList bl) {
		System.out.println("貸し出し業務");
		Scanner scanner = new Scanner(System.in);
		Calendar now = Calendar.getInstance();
		int memberID = MemberManagement.idManagement(ml);
		if(memberID >= 0) {
			Member m = ml.member.get(memberID);
			if(m.penalty == true) {
				int availableDay = 7 - Deadline.diffDays(now.getTimeInMillis()-
														m.penaltyDate.getTimeInMillis());
				if(availableDay > 0) {
					System.out.println("只今ご利用できません。 ご利用再開は"
										+ availableDay + "日後からとなります。");
					System.out.println("");
				}else {
					m.penalty = false;
				}
			}
			if(m.rentalNumber >= m.rentalMax) {
				System.out.println("これ以上は借りることができません。");
				System.out.println("");
			//期限を過ぎている場合の処理
			}else if(Deadline.deadlineCheck(m)==false) {
				System.out.println("お貸ししている書籍の中に期限を過ぎているものがあるため、"
									+ "貸し出しを行えません。");
				System.out.println("");
			}else if(m.penalty == false){
				System.out.println("本のIDを入力してください。");
				int bookID = scanner.nextInt();
				Book b = bl.book.get(bookID);
				if(b.num <= 0) {
					System.out.println("この書籍は借りることができません。");
					System.out.println("");
				}else{
					b.num--;
					Book copy = new Book(b.name,b.author,b.publisher,b.id);
					copy.cal = Calendar.getInstance();
					m.rentalBook.add(copy);
					m.rentalNumber++;
					b.rentalMember.add(m);
					System.out.println("貸出処理が完了しました。");
					System.out.println("返却期限は" + m.rentalLimit/7 + "週間です");
					System.out.println("");
				}
			}
		}
	}
}
