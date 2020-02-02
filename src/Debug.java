import java.util.Calendar;
import java.util.Scanner;

public class Debug {
	public Debug(MemberList ml,BookList bl) {
		Scanner scanner = new Scanner(System.in);
		int id = MemberManagement.idManagement(ml);
		System.out.println("遡る日付を入力");
		int pastDay = scanner.nextInt();
		ml.member.get(0).rentalBook.get(0).cal.set(Calendar.DATE,pastDay);
	}
}
