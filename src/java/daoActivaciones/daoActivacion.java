/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoActivaciones;

import city.modelo.Activacion;
import city.modelo.Usuario;
import java.util.Date;

/**
 *
 * @author 
 */
public interface daoActivacion  {
    public Activacion getActivacion(String token) throws Exception ;
    public void activaUsuario( Usuario user) throws Exception;
    public  Date getFechaEc();
}
