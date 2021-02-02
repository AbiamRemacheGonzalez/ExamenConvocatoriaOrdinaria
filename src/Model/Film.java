package Model;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private final String image;
    private final String title;
    private final String year;
    private List<Actor> actors;
    private final Genre genre;
    private final int classification;
    private final int durantionInMinutes;

    public Film(String image, String title, String year, Genre genre, int classification, int durantionInMinutes) {
        this.image = image;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.classification = classification;
        this.durantionInMinutes = durantionInMinutes;
        actors = new ArrayList<>();
    }

    public String reduceToString() {
        return "Film{" + "image=" + image + ", title=" + title + ", durantionInMinutes=" + durantionInMinutes + '}';
    }

    @Override
    public String toString() {
        return "Film{\n" + "\timage=" + image + "\n"+ "\ttitle=" + title + "\n\tyear=" + year + "\n\tactors=" + actors + "\n\tgenre=" + genre + "\n\tclassification=" + classification + "\n\tdurantionInMinutes=" + durantionInMinutes + '}';
    }
    
    
    public void addActor(Actor actor){
        actors.add(actor);
    }
    
    public void removeActor(Actor actor){
        actors.remove(actor);
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getClassification() {
        return classification;
    }

    public int getDurantionInMinutes() {
        return durantionInMinutes;
    }
    
    
}
