package sample.models;

import java.sql.*;

public class conexion {
    private String usuario="root";
    private String password="";
    private String bd="covid";
    private String servidor="localhost";
public Connection conexion;
    public conexion() {
    try {
conexion= DriverManager.getConnection("jdbc:mysql://"+servidor+":3306/"+bd+"?useUnicode=true&useJDBCCompliantTimeZoneShift=useLegacyDatetimeCode&serverTimeZone=UTC",usuario,password);
        System.out.println("Exito Maximo");
    }catch (Exception e){
        System.out.println("No sirvo"+e.getMessage());
    }
    }
    public ResultSet consultar(String consulta){
        ResultSet resultado=null;
        try {
            Statement st=conexion.createStatement();
            resultado = st.executeQuery(consulta);
        }catch (Exception e){
            System.out.println("Error no jala :C"+e.getMessage());

        }
        return resultado;
    }
    //insertar modificar y eliminalñ
    public void insmodel(String consulta){
        try {
            Statement st=conexion.createStatement();
            st.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
