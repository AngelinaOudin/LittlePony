package fr.form.littlePony;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="race")
public class Race {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	private String location;
	private Date date;
	@OneToMany
	private List<Pony> ponies;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the ponies
	 */
	public List<Pony> getPonies() {
		return ponies;
	}
	/**
	 * @param ponies the ponies to set
	 */
	public void setPonies(List<Pony> ponies) {
		this.ponies = ponies;
	}
	
	public Race() {
		// TODO Auto-generated constructor stub
	}
	public Race(String location, Date date) {
		this.location = (location == null) ? 
				"location" : location;
        this.date = (date == null) ? new Date() : date;
	}
}
