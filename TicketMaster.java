import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketMaster {
    private ArrayList<Show> shows;

    public TicketMaster(){
        this.shows = new ArrayList<>();
        loadData();
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
                Show show = null;
                if(otherData.length == 4) {
                    show = new Show(otherData[0], Double.parseDouble(otherData[1]), Integer.parseInt(otherData[2]), otherData[3], city);
                }
                if(otherData.length == 5) {
                    String name = otherData[3] + " " + otherData[4];
                    show = new Show(otherData[0], Double.parseDouble(otherData[1]), Integer.parseInt(otherData[2]), name, city);
                }
                if(otherData.length == 6) {
                    String name = otherData[3] + " " + otherData[4] + " " + otherData[5];
                    show = new Show(otherData[0], Double.parseDouble(otherData[1]), Integer.parseInt(otherData[2]), name, city);
                }
                shows.add(show);
            }
            fscanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Show> sortByPrice(){
        for(int i = 1; i < shows.size(); i++){
            int j = i+1;
            while(j < shows.size() && shows.get(j).getPrice() > shows.get(i).getPrice()){
                shows = swap(shows, j,i);
                j++;
            }
        }
        return shows;
    }
    public ArrayList<Show> sortByPerformer(){
        for(int i = 0; i < shows.size(); i++){
            int minimumIndex = i;
            for(int j = i; j < shows.size(); j++){
                if(shows.get(j).getPerformer().compareTo(shows.get(minimumIndex).getPerformer()) < 0){
                    minimumIndex = j;
                }
            }
            swap(shows, minimumIndex, i);
        }
        return shows;
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
    public void printDivider(){
        System.out.println("Date\t\tPrice\t\tQty\t\tPerformer\t\t\tCity");
        System.out.println("------------------------------------------------------------------");
    }
}
