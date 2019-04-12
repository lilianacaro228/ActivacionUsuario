/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package city.controler;

import city.modelo.Activacion;
import daoActivaciones.daoActivacion;
import daoActivaciones.daoActivacionImple;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author 
 */
@ManagedBean (name="controlActivacion")
@ViewScoped
public class controlActivacion implements Serializable {

    private daoActivacion daoAct;
    private String token;
    private static final Logger LOG = Logger.getLogger(controlActivacion.class.getName());
    
    private String mensaje;
    private String imagen;
    
    
    
    /**
     * Creates a new instance of controlActivacion
     */
    public controlActivacion() {
    }
    
    public void before(ComponentSystemEvent event){
        if (!FacesContext.getCurrentInstance().isPostback()){
            //System.out.println("PreRenderView: view parameters are available here");
            
            
            gestionaActivacion();
            
        }
    }
    
    
    @PostConstruct
    public void init(){
        
        
        // System.out.println("token Init: " + token);
        
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    public void gestionaActivacion(){
        
        
        daoAct = new daoActivacionImple();
        
        //Map<String, String> params =FacesContext.getCurrentInstance().
        //           getExternalContext().getRequestParameterMap();
        //token = params.get("token");
        
        LOG.info("Valor del token: "+ token);
        try{
            
            if( !token.trim().isEmpty()){
                
                Activacion act = daoAct.getActivacion(token);
                
                if( act != null){
                    LOG.info("Activacion!!!!!!!!!!!!!!!!");
                    Date hoy = daoAct.getFechaEc();
                    
                    if( hoy.before( act.getFechaCaducidad() )){
                          daoAct.activaUsuario( act.getUsuario() );
                          mensaje = "¡¡Felicidades!!! acabas de activar tu cuenta. Ahora ya puedes iniciar sesión desde la app en tu teléfono celular.";
                          LOG.info("Felicidades acabas de activar tu cuenta");
                          imagen = "good.png";
                    }else{
                        imagen = "bad.jpg";
                           LOG.info("Lo sentimos tu código de activación ha caducado el:" + act.getFechaCaducidad() );
                           mensaje = "Lo sentimos tu código de activación ha caducado el:" + act.getFechaCaducidad();
                    }
                    
                    
                   
                  
                }else{
                    LOG.info("No se encontró la activación");
                    mensaje = "No se encontró la activación con ese código";
                    imagen = "bad.jpg";
                }
            
                
                
            }else{
                LOG.info( "Token vacio");
                imagen = "bad.jpg";
            }
            
        
        }catch( Exception ex ){
            
            mensaje = ex.getLocalizedMessage();
            LOG.info( ex.getLocalizedMessage() );
            imagen = "bad.jpg";
        }   
    
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
