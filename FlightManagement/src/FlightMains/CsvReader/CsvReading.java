package FlightMains.CsvReader;

public class CsvReading {
String Flight_no, Dep_Loc,Arr_Loc, Valid_Till,Flight_Time,Flight_Dur,Seat_Avail, Flight_Class,Fare;
	
	public CsvReading(String Flight_no,String Dep_Loc, String Arr_Loc,String Valid_Till, 
				String Flight_Time,String Flight_Dur,String Fare,String Seat_Avail, String Flight_Class) {
		
		this.Flight_no = Flight_no;
		this.Dep_Loc = Dep_Loc;
		this.Arr_Loc = Arr_Loc;
		this.Valid_Till = Valid_Till;
		this.Flight_Time = Flight_Time;
		this.Flight_Dur = Flight_Dur;
		this.Fare = Fare;
		this.Seat_Avail = Seat_Avail;
		this.Flight_Class = Flight_Class;
		
	}
	public String getFlight_no() {
		return Flight_no;
	}

	public void setFlight_no(String flight_no) {
		Flight_no = flight_no;
	}

	public String getDep_Loc() {
		return Dep_Loc;
	}

	public void setDep_Loc(String dep_Loc) {
		Dep_Loc = dep_Loc;
	}

	public String getArr_Loc() {
		return Arr_Loc;
	}

	public void setArr_Loc(String arr_Loc) {
		Arr_Loc = arr_Loc;
	}

	public String getValid_Till() {
		return Valid_Till;
	}

	public void setValid_Till(String valid_Till) {
		Valid_Till = valid_Till;
	}

	public String getFlight_Time() {
		return Flight_Time;
	}

	public void setFlight_Time(String flight_Time) {
		Flight_Time = flight_Time;
	}

	public String getFlight_Dur() {
		return Flight_Dur;
	}

	public void setFlight_Dur(String flight_Dur) {
		Flight_Dur = flight_Dur;
	}

	public String getSeat_Avail() {
		return Seat_Avail;
	}

	public void setSeat_Avail(String seat_Avail) {
		Seat_Avail = seat_Avail;
	}

	public String getFlight_Class() {
		return Flight_Class;
	}

	public void setFlight_Class(String flight_Class) {
		Flight_Class = flight_Class;
	}

	public String getFare() {
		return Fare;
	}

	public void setFare(String fare) {
		Fare = fare;
	}
	
	@Override
	public String toString() {
		
		return Flight_no+" "+Dep_Loc+" "+Arr_Loc+" "+ Valid_Till+" "+Flight_Time+" "+Flight_Dur+" "+Fare+" "+Seat_Avail+" "+Flight_Class;
		
	}
}
