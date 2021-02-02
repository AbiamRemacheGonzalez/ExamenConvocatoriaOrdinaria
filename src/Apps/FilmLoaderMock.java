package Apps;

import Model.Actor;
import Model.Film;
import Model.Genre;
import View.FilmLoader;
import java.util.ArrayList;
import java.util.List;

public class FilmLoaderMock implements FilmLoader {

    @Override
    public List<Film> load() {
        List<Film> films = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Film n = new Film("image"+(i+1),"romanceTitle"+(i+1),"200"+i,Genre.Romance,(i+10)%10,60+i);
            for (int j = 0; j < 3; j++) {
                n.addActor(new Actor("Actor"+(j+1)));
            }
            films.add(n);
        }
        for (int i = 0; i < 5; i++) {
            Film n = new Film("image"+(i+1),"horrorTitle"+(i+1),"201"+i,Genre.Horror,(i+10)%10,60+i);
            for (int j = 0; j < 3; j++) {
                n.addActor(new Actor("Actor"+(j+1)));
            }
            films.add(n);
        }
        for (int i = 0; i < 5; i++) {
            Film n = new Film("image"+(i+1),"actioTitle"+(i+1),"202"+i,Genre.Action,(i+10)%10,60+i);
            for (int j = 0; j < 3; j++) {
                n.addActor(new Actor("Actor"+(j+1)));
            }
            films.add(n);
        }
        for (int i = 0; i < 5; i++) {
            Film n = new Film("image"+(i+1),"adventureTitle"+(i+1),"200"+i,Genre.Adventure,(i+10)%10,70+i);
            for (int j = 0; j < 3; j++) {
                n.addActor(new Actor("Actor"+(j+1)));
            }
            films.add(n);
        }
        return films;
    }
    
}
