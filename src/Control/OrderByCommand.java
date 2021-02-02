package Control;

import Model.Film;
import View.FilmListDisplay;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderByCommand implements Command{
    private Order currentOrder;
    private final List<Film> films;
    private final FilmListDisplay filmDisplay;

    public OrderByCommand(List<Film> films, FilmListDisplay filmDisplay) {
        this.films = films;
        this.filmDisplay = filmDisplay;
        
        filmDisplay.on(selectedOrder());
    }
    
    @Override
    public void execute() {
        filmDisplay.display(films);
    }

    private FilmListDisplay.SelectedOrder selectedOrder() {
        return new FilmListDisplay.SelectedOrder() {
            @Override
            public void order(Order order) {
                if (order == Order.genre){
                    System.out.println("Se ordena por Genero");
                    Collections.sort(films,new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Film f1 = (Film)o1;
                            Film f2 = (Film)o2;
                            return f1.getGenre().compareTo(f2.getGenre());
                        }
                    });
                }
                if (order == Order.news){
                    System.out.println("Se ordena por las más actuales");
                    Collections.sort(films,new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Film f1 = (Film)o1;
                            Film f2 = (Film)o2;
                            return f1.getYear().compareTo(f2.getYear());
                        }
                    });
                }
                if (order == Order.mostviewed){
                    System.out.println("Se ordena por los más vistos");
                    Collections.sort(films,new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Film f1 = (Film)o1;
                            Film f2 = (Film)o2;
                            return f2.getYear().compareTo(f1.getYear());
                        }
                    });
                }
                if (order == Order.mostvalue){
                    System.out.println("Se ordena por los más valorados");
                    Collections.sort(films,new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Film f1 = (Film)o1;
                            Film f2 = (Film)o2;
                            if(f1.getClassification()== f2.getClassification()) return 0;
                            if(f1.getClassification() > f2.getClassification()) return 1;
                            return -1;
                        }
                    });
                }
            }
        };
    }
    
}
