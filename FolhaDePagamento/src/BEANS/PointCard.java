package BEANS;

import java.util.Scanner;

public class PointCard {
	private Integer hourEntry, minuteEntry, exitHour, exitMinute, day, week, month, year;
	
	public PointCard(Integer day, Integer week, Integer month, Integer year) {
		this.day   = day;
		this.week  = week;
		this.month = month;
		this.year  = year;
	}

	public void setHourEntry(Integer hourEntry) {
		this.hourEntry = hourEntry;
	}
	public void setMinuteEntry(Integer minuteEntry) {
		this.minuteEntry = minuteEntry;
	}
	public void setExitHour(Integer exitHour) {
		this.exitHour = exitHour;
	}
	public void setExitMinute(Integer exitMinute) {
		this.exitMinute = exitMinute;
	}

	public Integer getNumberHours() {
		return exitHour - hourEntry;
	}
	public Integer getNumberMinutes() {
		return exitMinute - minuteEntry;
	}
	public Double getDaySalary(Double baseSalary) {
		return ((getNumberHours() * baseSalary) +  (getNumberMinutes() * (baseSalary / 60.00)));
	}
}