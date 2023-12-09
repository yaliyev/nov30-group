package az.developia.nov30.imagehistoryapp.model;

import java.time.LocalDate;

public class ImageModel {
	private Integer id;
	private String path;
	private LocalDate insertDate;
	private Integer timesUsed;

	// CTRL + SHIFT + F Code Format

	public ImageModel() {
		super();
	}

	public ImageModel(String path, LocalDate insertDate, Integer timesUsed) {
		super();
		this.path = path;
		this.insertDate = insertDate;
		this.timesUsed = timesUsed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalDate getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(LocalDate insertDate) {
		this.insertDate = insertDate;
	}

	public Integer getTimesUsed() {
		return timesUsed;
	}

	public void setTimesUsed(Integer timesUsed) {
		this.timesUsed = timesUsed;
	}

	@Override
	public String toString() {
		return "ImageModel [id=" + id + ", path=" + path + ", insertDate=" + insertDate + ", timesUsed=" + timesUsed
				+ "]";
	}
	
	

}
