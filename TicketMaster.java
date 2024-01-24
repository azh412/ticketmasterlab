import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketMaster {
    private ArrayList<Show> shows;

    public TicketMaster(ArrayList<Show> shows){
        this.shows = shows;
    }
    public void loadData(){
        File rawShows = new File("showData.txt");
        try {
            Scanner fscanner = new Scanner(rawShows);
            while (fscanner.hasNextLine()) {
                String line = fscanner.nextLine();
                String[] split_line = line.split(", ");
                String city = split_line[1];
                String[] otherData = split_line[0].split(" ");
                Show show = new Show(otherData[0], otherData[1], otherData[2], otherData[3], city);
                shows.add(show);
            }
            fscanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
    public void sortByPerformer(){
        for(int i = 0; i < shows.size(); i++){
            int minimumIndex = i;
            for(int j = i; j < shows.size(); j++){
                if(shows.get(j) < shows.get(minimumIndex)){
                    minimumIndex = j;
                }
            }
            swap(shows, minimumIndex, i);
        }
    }
    private ArrayList<Show> swap(ArrayList<Show> shows, int x, int y){
        Show z = shows.get(x);
        shows.set(x, shows.get(y));
        shows.set(y, z);
        return shows;
    }
    public ArrayList<Show> searchByCity(String city){
        ArrayList<Show> searchResults = new ArrayList<>();
        for(Show item: shows){
            if(item.getCity().equals(city)){
                searchResults.add(item);
            }
        }
        return searchResults;
    }
}
