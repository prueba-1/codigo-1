/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 20162
 */
public class arraylistpedidos {
    ArrayList<constructorpedido> zonapedidos= new ArrayList<>();
    ArrayList<constructorcliente> cliente = new ArrayList<>();
    ArrayList<constructorcomida> comidas = new ArrayList<>();
    ArrayList<constructorpedidocomida> zonacomida= new ArrayList<>();
    
    ArrayList<constructorgeneral> constructorgeneral= new ArrayList<>();
    constructorgeneral consgeneral;
    constructorcomida conscomida;
    constructorcliente conscliente;
    constructorpedido conspedido;
    constructorpedidocomida comida;
    File general = new File ("D://pedidofinal.txt");
    File archivo=new File("D://Listacomida.txt");
    File pedidos = new File("D://pedidosRestaurantBellaDurmiente.txt");
    File user = new File("D://usuarios.txt");
    public void agregararchivo(constructorgeneral cge){
        constructorgeneral.add(cge);
    }
    String listar(){
      String cad="";
      for (int i = 0; i < constructorgeneral.size(); i++) {
        cad+=constructorgeneral.get(i).tostring();
      }
      return cad;
    }
     public void leercliente()throws Exception{
        if (user.exists()) {
            user.createNewFile();
            
        }
        BufferedReader br= new BufferedReader(new FileReader(user));
        while (true) {            
            String archivo;
            archivo=br.readLine();
            if (archivo==null)break;
            String clie[]= archivo.split(",");
            cliente.add(new constructorcliente(Integer.parseInt(clie[0]), clie[1], clie[2]));
        }
        br.close();
    }
     
     String agregarcli(constructorpedido cp){  //cp es el dni del contrcutor pedidos 
        
        int j=buscardni(cp);
       if(j>=0){
           zonapedidos.add(cp);
           cp.rellenardatos(cliente.get(j).getNombre());
           cp.rellenardatos(cliente.get(j).getApellido());
           return cliente.get(j).nombre();
       }
       else{
            
            JOptionPane.showMessageDialog(null,"No se encuentra ninguna persona registrada con ese dni");
            
        }  
          return null;
        }
     String agregarapellido(constructorpedido cp){  //cp es el dni del contrcutor pedidos 
        
        int j=buscardni(cp);
       if(j>=0){
           zonapedidos.add(cp);
           cp.rellenardatos(cliente.get(j).getNombre());
           cp.rellenardatos(cliente.get(j).getApellido());
           return cliente.get(j).apellido();
       }
       else{
            
            JOptionPane.showMessageDialog(null,"No se encuentra ninguna persona registrada con ese dni");
            
        }  
          return null;
        }
      public void leercomida() throws Exception {
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        while(true){
            String text;
            text=br.readLine();
            if(text==null)break;
            String arr[]=text.split(",");
            comidas.add(new constructorcomida(Integer.parseInt(arr[0]),arr[1],arr[2]));
        }
        fr.close();
        br.close();
    }
      
      String agregarnombrecomida (constructorpedidocomida cc){
          int j=buscarcodigo(cc);
          if (j>=0) {
              zonacomida.add(cc);
              cc.llenarcomida(comidas.get(j).getComida());
              cc.llenarcomida(comidas .get(j).getPrecio());
              return comidas.get(j).getComida();
          }
          else{
              JOptionPane.showMessageDialog(null, "No se encuentra ninguna comida con ese codigo");
          }
              return null;
      }
      String agregarpreciocomida (constructorpedidocomida cc){
          int j=buscarcodigo(cc);
          if (j>=0) {
              zonacomida.add(cc);
              cc.llenarcomida(comidas.get(j).getComida());
              cc.llenarcomida(comidas .get(j).getPrecio());
              return comidas.get(j).getPrecio();
          }
          else{
              JOptionPane.showMessageDialog(null, "No se encuentra ninguna comida con ese codigo");
          }
              return null;
      }
      private int buscarcodigo(constructorpedidocomida cc) {
          int j=-1;
          for (int i = 0; i < comidas.size(); i++) {
              if (cc.getCodigo()==comidas.get(i).getCodigo()) {
                  j=i;
                  break;
              }
          }
          return j;
    }

     private int buscardni(constructorpedido cp){
        int j=-1;
        for (int i = 0; i <cliente.size(); i++) {
                 if( cp.getDni()==cliente.get(i).getDni()){ 
                    //arr[1] posicion de buscando datos
                    j=i;
                     break;
                 }
        }
       
        return j;
    }
     void leer() throws Exception{
        if(!pedidos.exists()){
            pedidos.createNewFile();
        }
        
        FileReader fr=new FileReader(pedidos);
        BufferedReader br=new BufferedReader(fr);
        
        while(true){
            String text;
            text=br.readLine();
            if(text==null)break;
            String vect[]=text.split(",");
            zonapedidos.add(new constructorpedido(Integer.parseInt(vect[0])));
            
            
        }
        br.close();
        fr.close();
        
    }
    
    void escribir() throws Exception{
    if(!pedidos.exists()){
        pedidos.createNewFile();
    }
    
    FileWriter fw=new FileWriter(pedidos);
    BufferedWriter bw=new BufferedWriter(fw);
    PrintWriter pw=new PrintWriter(bw);
    
    for(int i=0;i<zonapedidos.size();i++){
        pw.println(zonapedidos.get(i).guardar());
    }
    
    pw.close();
    bw.close();
    fw.close();
    }

    
}
