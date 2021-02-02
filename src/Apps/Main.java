package Apps;

import Control.Command;
import Control.InitCommand;
import Model.Film;
import View.FilmDisplay;
import View.FilmLoader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final Command Null = new Command.Null();
    private final FilmDisplay filmDisplay;
    private final FilmListDisplayMock filmListDisplay;
    private final List<Film> films;
    private final Map<String,Command> commands;
    
    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main() {
        this.filmDisplay = new FilmDisplayMock();
        this.filmListDisplay = new FilmListDisplayMock();
        this.films = new FilmLoaderMock().load();
        InitCommand initCommand = new InitCommand(filmDisplay,filmListDisplay,films);
        initCommand.execute();
        this.commands = initCommand.getCommands();
    }

    private void execute() {
        while(true){
            String in = input();
            if(in.equals("ORDERBY")){
                System.out.println("1. Genre 2.News 3.Most Viewed 4.Most Valued");
                String order = input();
                if(!isAOrder(order)){
                    System.out.println("Seleccione un número para ordenar");
                }else{
                    filmListDisplay.selectedOrderEvent(order);
                    commands.get(in).execute();
                }
            }
            if(in.equals("SELECT")){
                String posOfFilm = input();
                if(!isAFilm(posOfFilm)){
                    System.out.println("Seleccione un número de la lista de péliculas");
                }else{
                    filmListDisplay.selectedFilmEvent(posOfFilm);
                }

            }
        }
    }
    
    public String input(){
        return scanner.next().toUpperCase();
    }

    private boolean isAFilm(String posOfFilm) {
        for (int i = 0; i < posOfFilm.length(); i++) {
           if(!Character.isDigit(posOfFilm.charAt(i))) return false; 
        }
        int finalPos = Integer.parseInt(posOfFilm);
        if(finalPos > 0 && finalPos<films.size()) return true;
        return false;
    }

    private boolean isAOrder(String order) {
        if(order.length()!=1)return false;
        if(!Character.isDigit(order.charAt(0))) return false;
        int finalOrder = Integer.parseInt(order);
        if(finalOrder >= 1 && finalOrder<=4) return true;
        return false;
        
    }
}
