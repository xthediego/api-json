/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author lglui
 */
public class api_cliente {
    
    public String get (){
        String salida= " ";
        
        try{
            URL url = new  URL("https://localhost:5001/api/clientes");// Aquí va la url del programa que creamos en visual estudio
            HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
            c_api.setRequestMethod("GET");
            c_api.setRequestProperty("Accept", "application/json");
            if (c_api.getResponseCode()==200){
                InputStreamReader entrada = new InputStreamReader (c_api.getInputStream());//validar esta fase
                BufferedReader lectura = new BufferedReader (entrada); //vañodar esta fase
                salida = lectura.readLine();

            }else{
            salida = "";    
            System.out.println("No se puede conectar a la api : " + c_api.getResponseCode());
            }
            c_api.disconnect();
        }catch(IOException ex){
        System.out.println("Error api:" + ex.getMessage());
    
        }
        return salida;
    } 

    private static class InputStreamReader {

        public InputStreamReader(InputStream inputStream) {
        }
    }

}
