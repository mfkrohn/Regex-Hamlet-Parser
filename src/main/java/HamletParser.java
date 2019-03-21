import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private final Pattern HAMLET = Pattern.compile(("Hamlet"),Pattern.CASE_INSENSITIVE);
    private final Pattern HORATIO = Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
    private final String LEON = "Leon";
    private final String TARIQ = "Tariq";
    private Matcher matcher;


    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String changeHoratioToTariq(String tariqString) {
        matcher = HORATIO.matcher(tariqString);
        tariqString = matcher.replaceAll(TARIQ);
        return tariqString;
    }

    public String changeHamletToLeon(String hamletString) {
        matcher = HAMLET.matcher(hamletString);
        hamletString = matcher.replaceAll(LEON);
        return hamletString;
    }

    public boolean findHamlet(String line){
        return HAMLET.matcher(line).find();
    }

    public boolean findHoratio(String line){
        return HORATIO.matcher(line).find();
    }

    public void doTheThing(){
        String newHamlet;
        newHamlet = changeHamletToLeon(hamletData);
        newHamlet = changeHoratioToTariq(newHamlet);
        System.out.println(newHamlet);
    }


}
