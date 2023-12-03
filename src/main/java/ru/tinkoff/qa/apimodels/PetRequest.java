package ru.tinkoff.qa.apimodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PetRequest{

	@JsonProperty("photoUrls")
	public List<String> photoUrls;

	@JsonProperty("name")
	public String name;

	@JsonProperty("id")
	public long id;

	@JsonProperty("category")
	public Category category;

	@JsonProperty("tags")
	public List<TagsItem> tags;

	@JsonProperty("status")
	public String status;

	public List<String> getPhotoUrls(){
		return photoUrls;
	}

	public String getName(){
		return name;
	}

	public long getId(){
		return id;
	}

	public Category getCategory(){
		return category;
	}

	public List<TagsItem> getTags(){
		return tags;
	}

	public String getStatus(){
		return status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}