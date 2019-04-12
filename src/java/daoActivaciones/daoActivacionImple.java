/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoActivaciones;

import city.modelo.Activacion;
import city.modelo.Usuario;
import city.persistencia.Conexion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author 
 */
public class daoActivacionImple implements daoActivacion, Serializable {
    
     private Session session = null ;
    private Transaction tx;
    private static final Logger LOG = Logger.getLogger(daoActivacionImple.class.getName());
    
    
    

    @Override
    public Activacion getActivacion(String token) throws Exception {
        
        Activacion activacion = new Activacion();
        
        List<Activacion> activaciones  = new ArrayList<Activacion>();
                
         try{
            session = Conexion.getSessionFactory().openSession();
            
             Query<Activacion> query = session.createQuery("from Activacion t where t.tokenActivacion = : tokenActivacion",Activacion.class);
               query.setParameter("tokenActivacion", token);
           
               activaciones = query.list();
           
            
            if( activaciones.size() > 0 ){
                 activacion = activaciones.get(0);
            }else{
                LOG.info("# Activaciones: " + activaciones.size());
                throw new Exception( "NO encontramos ninguna activación con el token propuesto" );
            }    
            
        }catch( Exception ex ){
            LOG.info( ex.getLocalizedMessage());
             throw new Exception( ex.getLocalizedMessage() );
        }finally{
             session.close();
             
             //Conexion.shutdown();
        }
         
         return activacion;
     
    }

    @Override
    public void activaUsuario(Usuario user) throws Exception  {
         
         try{
            session = Conexion.getSessionFactory().openSession();
            

           tx = session.beginTransaction();
           
           //crea el usuario pero le pone por defecto que no esta activo
           if(user.getUsuarioActivo().equals("N")){
               user.setUsuarioActivo("S");
               user.setFechaModificacion( getFechaEc () );
           }else{
              throw new Exception( "¡¡Lo sentimos tu cuenta ya ha sido activada anteriormente!!" );
           }
           
           
            session.update(user);
            
            tx.commit();
    
        }catch( Exception ex ){
            LOG.info("Activa Usuario: " +ex.getLocalizedMessage() );
            
            throw new Exception( ex.getLocalizedMessage() );
           
        }finally{
             session.close();
        }
        
       
    }
    
    public Date getFechaEc(){   
        
     
         Calendar ahora = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
            ahora.add(Calendar.HOUR, -5);
        
        
        return ahora.getTime();
        
      
    }
    
}
