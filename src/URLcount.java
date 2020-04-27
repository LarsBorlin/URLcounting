import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLcount {

    URLcount()
    {
        URL urlTarget = null;
        try {
            urlTarget = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(urlTarget.openStream()));)
        {
            String inputLine;
            String[] words;
            int[] wordArray = new int[50];
            while ((inputLine = in.readLine()) != null)
            {
                words = inputLine.split(" ");
                for (String w : words)
                {
                    int l = w.length();
                    wordArray[l]++;
                }
            }

            System.out.println("Ordlängd");
            for (int i = 1; i < wordArray.length; i++)
            {
                System.out.println("Antal ord med " + i + " bokstäver: " + wordArray[i]);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        URLcount url = new URLcount();
    }
}
