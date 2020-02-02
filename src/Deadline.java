import java.util.Calendar;

public class Deadline {
	public static boolean deadlineCheck(Member m) {
		Calendar now = Calendar.getInstance();
		int delayflag = 0;
		if(m.rentalBook == null) {
			return true;
		}else {
			for(int i=0;i < m.rentalNumber;i++) {
				if(diffDays(now.getTimeInMillis()-
							m.rentalBook.get(i).cal.getTimeInMillis()) > m.rentalLimit) {
					delayflag = 1;
					System.out.println(m.name[0] + m.name[1] + ":");
					System.out.println(m.rentalBook.get(i).name);
					System.out.println("貸し出し日時:" + m.rentalBook.get(i).cal.getTime());
					System.out.println("");
				}
			}
			if(delayflag == 0) {
				return true;
			}else {
				return false;
			}
		}
	}

	public static int diffDays(long diffTime) {
		int diffDaysMillis = 1000*60*60*24;
		return (int)(diffTime / diffDaysMillis);
	}
}
