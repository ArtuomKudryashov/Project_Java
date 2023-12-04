package models;



public class Pet {
    private  long id;
    private String name;
    private Category category;
    private String [] photoUrls;
    private Tag [] tags;
    private Status status;

    public Pet( String name, Category category, String[] photoUrls, Tag[] tags, Status status) {
        this.name = name;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public Status getStatus() {
        return status;
    }
}
