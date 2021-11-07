package com.Nagarro.FlightManage.CsvReader;

public class CsvReading {
	
	String flightNo, depLoc,arrLoc, validTill,flightTime,flightDur,fare,seatAvail, flightClass;
	
	public CsvReading(String flightNo, String depLoc, String arrLoc, String validTill, String flightTime,
			String flightDur, String fare, String seatAvail, String flightClass) {
		super();
		this.flightNo = flightNo;
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDur = flightDur;
		this.fare = fare;
		this.seatAvail = seatAvail;
		this.flightClass = flightClass;
	}
	
	public String getFlightNo() {
		return flightNo;
	}


	public String getDepLoc() {
		return depLoc;
	}


	public String getArrLoc() {
		return arrLoc;
	}


	public String getValidTill() {
		return validTill;
	}


	public String getFlightTime() {
		return flightTime;
	}


	public String getFlightDur() {
		return flightDur;
	}


	public String getFare() {
		return fare;
	}


	public String getSeatAvail() {
		return seatAvail;
	}


	public String getFlightClass() {
		return flightClass;
	}


	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}


	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}


	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}


	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}


	public void setFlightDur(String flightDur) {
		this.flightDur = flightDur;
	}


	public void setFare(String fare) {
		this.fare = fare;
	}


	public void setSeatAvail(String seatAvail) {
		this.seatAvail = seatAvail;
	}


	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		
		return flightNo+" "+depLoc+" "+arrLoc+" "+ validTill+" "+flightTime+" "+flightDur+" "+fare+" "+seatAvail+" "+flightClass;
		
	}
}
