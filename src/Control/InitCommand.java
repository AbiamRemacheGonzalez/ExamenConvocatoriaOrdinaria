package Control;

import Model.Film;
import View.FilmDisplay;
import View.FilmListDisplay;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitCommand implements Command{
    private final FilmDisplay filmDisplay;
    private final FilmListDisplay filmListDisplay;
    private final List<Film> films;
    private final Map<String,Command> commands = new HashMap<>();

    public InitCommand(FilmDisplay filmDisplay, FilmListDisplay filmListDisplay, List<Film> films) {
        this.filmDisplay = filmDisplay;
        this.filmListDisplay = filmListDisplay;
        this.films = films;
        this.filmListDisplay.on(selectedFilm());
        commands.put("ORDERBY", new OrderByCommand(films,filmListDisplay));
    }
    
    @Override
    public void execute() {
        filmListDisplay.display(films);
    }

    private FilmListDisplay.SelectedFilm selectedFilm() {
        return new FilmListDisplay.SelectedFilm() {
            @Override
            public void film(Film film) {
                filmDisplay.display(film);
            }
        };
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
    
    
}
