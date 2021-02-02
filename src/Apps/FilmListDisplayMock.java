package Apps;

import Control.Order;
import Model.Film;
import View.FilmListDisplay;
import java.util.List;

public class FilmListDisplayMock implements FilmListDisplay{

    private SelectedFilm selectedFilm;
    private List<Film> films;
    private SelectedOrder selectedOrder;

    @Override
    public void display(List<Film> films) {
        this.films = films;
        int pos = 1;
        for (Film film : films) {
            System.out.println(pos +".\t"+ film.reduceToString());
            pos++;
        }
    }

    @Override
    public void on(SelectedFilm selectedFilm) {
        this.selectedFilm = selectedFilm;
    }
    @Override
    public void on(SelectedOrder selectedOrder){
        this.selectedOrder = selectedOrder;
    }
    public void selectedFilmEvent(String pos){
        selectedFilm.film(films.get(Integer.parseInt(pos)-1));
    }
    public void selectedOrderEvent(String pos){
        int finalpos = Integer.parseInt(pos);
        selectedOrder.order(changeToOrder(finalpos));
    }

    private Order changeToOrder(int finalpos) {
        switch(finalpos){
            case 1:
                return Order.genre;
            case 2:
                return Order.mostvalue;
            case 3:
                return Order.mostviewed;
            case 4:
                return Order.news;
        }
        return Order.genre;
    }
    
}
