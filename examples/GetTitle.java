
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
class GetTitle {
    public static void main(String args[]) {
       System.out.println(indexPages());
    }

    public static String indexPages(){
        String url = "https://www.bbc.com";
        String page = getWebContent(url);
        return getTitleOfHtml(page);
    }
    
    private static String getWebContent(String link) {
       try{
           URL url = new URL(link);
           HttpURLConnection connect = (HttpURLConnection) url.openConnection();
           // String encoding = connect.getContentEncoding();
           InputStream input = connect.getInputStream();
           //download webs
           String result = new BufferedReader(new InputStreamReader(input))
                   .lines().collect(Collectors.joining());
           return result;
       }catch(IOException ex){
           System.out.println(ex);
           return "" + ex.getMessage();
       }

   }
}