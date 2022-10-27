/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 26, 2022
 */
package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String releaseDate;
	private String rating;

	public Game() {
		super();
	}

	public Game(String name) {
		this.name = name;
	}

	public Game(String name, String releaseDate, String rating) {
		this.name = name;
		this.releaseDate = releaseDate;
		this.rating = rating;
	}

	public Game(int id, String name, String releaseDate, String rating) {
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", releaseDate=" + releaseDate + ", rating=" + rating + "]";
	}

}
