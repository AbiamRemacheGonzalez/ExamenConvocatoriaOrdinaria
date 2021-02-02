package Apps;

import Model.Film;
import View.FilmDisplay;

public class FilmDisplayMock implements FilmDisplay{

    @Override
    public void display(Film film) {
        System.out.println(film.toString());
    }
    
}
