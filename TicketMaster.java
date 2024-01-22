import java.util.ArrayList;

public class TicketMaster {
    private ArrayList<Show> shows;

    public TicketMaster(ArrayList<Show> shows){
        this.shows = shows;
    }

    public void sortByPrice(){
        for(int i = 1; i < shows.size(); i++){
            int j = i-1;
            while(shows.get(j).getPrice() > shows.get(i).getPrice()){
                shows = swap(j,i);
                j--;
            }
        }
    }
    private ArrayList<Show> swap(ArrayList<Show> shows, int x, int y){
        Show z = shows.get(x);
        shows.set(x, shows.get(y));
        shows.set(y, z);
        return shows;
    }
    public void sortByPerformer(){
        return;
    }
    public ArrayList<Show> searchByCity(String city){

    }
}
