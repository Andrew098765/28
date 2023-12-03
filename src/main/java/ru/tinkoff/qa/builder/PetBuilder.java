package ru.tinkoff.qa.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tinkoff.qa.apimodels.Category;
import ru.tinkoff.qa.apimodels.PetRequest;
import ru.tinkoff.qa.apimodels.TagsItem;

import java.util.List;

public class PetBuilder {
    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private long id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("tags")
    private List<TagsItem> tags;

    @JsonProperty("status")
    private String status;

    public PetBuilder (int id){
        this.id = id;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTags(List<TagsItem> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PetRequest build(){
        final PetRequest pet = new PetRequest();
        pet.id = this.id;
        pet.category = this.category;
        pet.name = this.name;
        pet.tags = this.tags;
        pet.photoUrls = this.photoUrls;
        pet.status = this.status;
        return pet;
    }
}
