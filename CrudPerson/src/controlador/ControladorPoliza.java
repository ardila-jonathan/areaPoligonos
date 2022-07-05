
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ColsultasPoliza;
import modelo.Poliza;
import vista.VPoliza;


public class ControladorPoliza implements ActionListener{
    
    private Poliza pro;
    private VPoliza frmPro;
    private ColsultasPoliza proC;

    public ControladorPoliza(Poliza pro, VPoliza frmPro, ColsultasPoliza proC) {
        this.pro = pro;
        this.frmPro = frmPro;
        this.proC = proC;
        this.frmPro.btn_agregar.addActionListener(this);
        this.frmPro.btn_modificar.addActionListener(this);
        this.frmPro.btn_buscar.addActionListener(this);
        this.frmPro.btn_limpiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON AGREGAR------
        if(e.getSource()==frmPro.btn_agregar){
            pro.setInicioVigencia(frmPro.txt_iVigencia.getText());
            pro.setFinVigencia(frmPro.txt_fVigencia.getText());
            pro.setPersona_tipoDocumento(frmPro.txt_tipo.getText());
            pro.setPersona_numeroDocumento(frmPro.txt_nDoc.getText());
            if(proC.registrar(pro)){
                JOptionPane.showMessageDialog(null, "Poliza agregada");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
                limpiar();
            }
        }//FIN AGREGAR----------
        
        
        //BOTON MODIFICAR------
        if(e.getSource()==frmPro.btn_modificar){
            pro.setNumero(Integer.parseInt(frmPro.txt_numero.getText()));
            pro.setInicioVigencia(frmPro.txt_iVigencia.getText());
            pro.setFinVigencia(frmPro.txt_fVigencia.getText());
            pro.setPersona_tipoDocumento(frmPro.txt_tipo.getText());
            pro.setPersona_numeroDocumento(frmPro.txt_nDoc.getText());
            if(proC.modificar(pro)){
                JOptionPane.showMessageDialog(null, "Poliza modificada");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }//FIN MODIFICAR----------
 
        //BOTON ELIMINAR------
        if(e.getSource()==frmPro.btn_eliminar){
            pro.setNumero(Integer.parseInt(frmPro.txt_numero.getText()));
            if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null, "Poliza eliminada");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }//FIN ELIMINAR----------
  
        //BOTON BUSCAR------
        if(e.getSource()==frmPro.btn_buscar){
            pro.setNumero(Integer.parseInt(frmPro.txt_numero.getText()));
            if(proC.buscar(pro)){
                frmPro.txt_numero.setText(String.valueOf(pro.getNumero()));
                frmPro.txt_iVigencia.setText(pro.getInicioVigencia());
                frmPro.txt_fVigencia.setText(pro.getFinVigencia());
                frmPro.txt_tipo.setText(pro.getPersona_tipoDocumento());
                frmPro.txt_nDoc.setText(pro.getPersona_numeroDocumento());
                
            }else{
                JOptionPane.showMessageDialog(null, "Error al buscar");
                limpiar();
            }
        }//FIN BUSCAR----------
        
        if(e.getSource()==frmPro.btn_limpiar){ 
            limpiar();
        }
        
    }// FIN ACTION-------------------
    
    
    
        public void limpiar(){
            
        frmPro.txt_numero.setText(null);
        frmPro.txt_iVigencia.setText(null);
        frmPro.txt_fVigencia.setText(null);
        frmPro.txt_tipo.setText(null);
        frmPro.txt_nDoc.setText(null);  
        }
    
}
