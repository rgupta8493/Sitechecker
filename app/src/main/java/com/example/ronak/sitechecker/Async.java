package com.example.ronak.sitechecker;


import android.os.AsyncTask;

import android.widget.Toast;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ronak on 3/8/2015.
 */
public class Async extends AsyncTask< String ,Void ,String > {

    private MainActivity host;
    public Integer count = 0;
    URL url;




    public   Async(MainActivity host) {
        this.host = host;

    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();


     // Toast.makeText(host.getBaseContext(), "site checker", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected String doInBackground(String... urls) {
        BufferedReader reader =null;
        try {

           url = new URL(host.abc);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line.trim() + "\n");
                sb.toString();
                String patt = String.valueOf(host.e2.getText());
                Pattern pattern = Pattern.compile(patt);
                Matcher match = pattern.matcher(line.trim());
                while(match.find()){
                    count = count + 1;
                }




            }


        } catch (Exception e) {

        }finally {
            assert reader != null;
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return String.valueOf((count));



    }



    @Override
      protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        if (count > 0)

            Toast.makeText(host.getBaseContext(), "This site is Interesting , Bookmark it ", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        int n = Integer.parseInt(result);
       try{
           if (n > 0) {
               Toast.makeText(host.getBaseContext() , "This site is of Interest ,Bookmark it", Toast.LENGTH_SHORT).show();
               host.on_result();

           }
           else{
               Toast.makeText(host.getBaseContext() , "This site is not Of Interest , Try Again", Toast.LENGTH_SHORT).show();
           }
       }
       catch(Exception e){

       }


    }


}
