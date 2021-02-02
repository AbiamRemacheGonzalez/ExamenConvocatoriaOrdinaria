package View;

import Control.Order;
import Model.Film;
import java.util.List;

public interface FilmListDisplay {
    public void display(List<Film> films);
    public void on(SelectedFilm selectedFilm);
    public void on(SelectedOrder selectedOrder);
    
    public interface SelectedFilm{
        public void film(Film film);
    }
    
    public interface SelectedOrder{
        public void order(Order order);
    }
}
