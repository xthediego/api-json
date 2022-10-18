
package apis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import javax.swing.table.DefaultTableModel; //importante sin esta libreria no podemos usar las tablas

public class api_cliente {
    
    private String get (){
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

    //verificar esta parte bien segundo video
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel ();
    try{
    String encabezado[]= {"id","Nit","Nombres","Apellidos","Direccion","Telefono","Nacimiento"};// definimos el encabezado de la tabla
    tabla.setColumnIdentifiers(encabezado);// en este caso tenemos que colocar el seculum...primero
    String datos[]= new String[7];
    JSONArray arreglo = new JSONArray(get());
    for(int indice = 0; indice< arreglo.length();indice++){
    JSONObject atributo= arreglo.getJSONObject (indice);
    datos [0]= String.valueOf(atributo.getInt("id_cliente"));
    datos [1] = atributo.getString("nit");
    datos [2] = atributo.getString("nombres");
    datos [3] = atributo.getString("apellidos");
    datos [4] = atributo.getString("direccion");
    datos [5] = atributo.getString("telefono");
    datos [3] = atributo.getString("fecha_nacimiento");
    tabla.addRow(datos);
    
    
    
    }
    }catch(Exception ex){
    
     System.out.println("Error tabla:" + ex.getMessage());
    }
    return tabla;
    
   
    }
}
