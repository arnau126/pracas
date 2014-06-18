/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.presentation;

import com.pracas.domain.controller.CtrlJugarPartida;
import com.pracas.exception.UserIsNotPlayerException;
import com.pracas.exception.UsernameNotExistsException;
import com.pracas.exception.WrongPasswordException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arkey
 */
public class CtrlPresentation {
    
    private static CtrlJugarPartida cjp;
    
    public CtrlPresentation() {
        cjp = new CtrlJugarPartida();
    }
    
    public void OKPressedAuthenticate(String username, String password) {
        try {
            cjp.authenticate(username, password);
        } catch (UsernameNotExistsException ex) {
            Logger.getLogger(CtrlPresentation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WrongPasswordException ex) {
            Logger.getLogger(CtrlPresentation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserIsNotPlayerException ex) {
            Logger.getLogger(CtrlPresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
