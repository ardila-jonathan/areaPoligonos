
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VPoliza;
import vista.VPrincipal;


public class ControladorPrincipal implements ActionListener {
    
    private VPrincipal frmPri;
    private VPoliza frmPro;

    public ControladorPrincipal(VPrincipal frmPri, VPoliza frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        this.frmPri.menu_poliza.addActionListener(this);
        this.frmPri.menu_salir.addActionListener(this);
        
    }
    
        public void inciar(){
        frmPro.setTitle("Producto");
        frmPri.setTitle("Principal");
        frmPri.setLocationRelativeTo(null);
        frmPro.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frmPri.menu_poliza){
            frmPro.setVisible(true);
            frmPri.dispose();
        }
        
        if(e.getSource()==frmPri.menu_salir){
            System.exit(0);
        }
    }
    
    
}
