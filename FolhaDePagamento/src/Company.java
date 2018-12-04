import java.util.Calendar;
import myUtils.MyDate;
import BEANS.Payment;
import java.util.List;
import java.util.ArrayList;

public class Company {

	public static void main(String[] args) {
		List<Payment> payments = new ArrayList();
		Calendar now = Calendar.getInstance();
		MyDate date = new MyDate(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
		System.out.println(date);
		for(int i = 0; i < 30; i++) {
			date.incrementDay();
		}
		System.out.println(date);
		payments.add(new Payment("hourly", 5));
		payments.add(new Payment("commissioned", 15));
		payments.add(new Payment("salaried", 30));

	}

}