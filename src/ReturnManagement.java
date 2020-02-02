import java.util.Calendar;
import java.util.Scanner;

public class ReturnManagement {
	public ReturnManagement(MemberList ml,BookList bl) {
		System.out.println("返却業務");
		Scanner scanner = new Scanner(System.in);
		int memberID = MemberManagement.idManagement(ml);
		System.out.println("本のIDを入力してください。");
		int bookID = scanner.nextInt();
		Book b = bl.book.get(bookID);
		Calendar now = Calendar.getInstance();
		int rentalMemberID=0;
		int rentalBookID=0;
		if(memberID >= 0) {
			boolean correctPair = false;
			Member m = ml.member.get(memberID);
			for(int i=0;i<b.rentalMember.size();i++) {
				if(b.rentalMember.get(i).id == memberID) {
					rentalMemberID = i;
					break;
				}
			}
			for(int i=0;i<m.rentalNumber;i++) {
				if(m.rentalBook.get(i).id == b.id) {
					correctPair = true;
					rentalBookID = i;
					break;
				}
			}
			if(correctPair == false) {
				System.out.println("この書籍はこの会員に借りられていません。");
				System.out.println("");
			}else if(Deadline.diffDays(now.getTimeInMillis()-
					m.rentalBook.get(rentalBookID).cal.getTimeInMillis()) > m.rentalLimit){
				System.out.println("貸出期間が過ぎています。");
				System.out.println("次回のご利用は一週間後からとなります。");
				m.penaltyDate = Calendar.getInstance();
				m.penalty = true;
				b.num++;
				m.rentalBook.remove(rentalBookID);
				m.rentalNumber--;
				b.rentalMember.remove(rentalMemberID);
				System.out.println("返却処理が完了しました。");
				System.out.println("");
			}else {
				b.num++;
				m.rentalBook.remove(rentalBookID);
				m.rentalNumber--;
				b.rentalMember.remove(rentalMemberID);
				System.out.println("返却処理が完了しました。");
				System.out.println("");
			}
		}
	}
}
