package movies;

import org.springframework.data.annotation.Id;

public class Movies {
	
	@Id
	private Integer id;
	
	private String MovieName;
	
	private String MovieYear;
	
	private String Url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public String getMovieYear() {
		return MovieYear;
	}

	public void setMovieYear(String movieYear) {
		MovieYear = movieYear;
	}

	public String getUrI() {
		return Url;
	}

	public void setUrI(String urI) {
		Url = urI;
	}
	
}
