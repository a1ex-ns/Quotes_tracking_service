package quotes.tracking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String isin;
	private Double bid;
	private Double ask;
	private Date time;
	
	@Override
	public String toString() {
		return id + " " + isin + "  " + bid + " " + ask + " ";
	}
	
	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	public Double getAsk() {
		return ask;
	}

	public void setAsk(Double ask) {
		this.ask = ask;
	}

	public Date getTime() {
		return time;
	}

	public void Date(Date time) {
		this.time = time;
	}
}
