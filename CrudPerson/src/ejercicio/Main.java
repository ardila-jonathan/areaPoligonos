
package ejercicio;

import controlador.ControladorPoliza;
import controlador.ControladorPrincipal;
import modelo.ColsultasPoliza;
import modelo.Conexion;
import modelo.Poliza;
import vista.VPoliza;
import vista.VPrincipal;


public class Main {
    
    
    public static void main(String[] args) {
        Poliza pro = new Poliza();
        ColsultasPoliza proC = new ColsultasPoliza();
        VPoliza frmPro = new VPoliza();
        ControladorPoliza ctrlPro = new ControladorPoliza(pro, frmPro, proC);
        VPrincipal frmPri = new VPrincipal();
        ControladorPrincipal ctrlPri = new ControladorPrincipal(frmPri, frmPro);
        ctrlPri.inciar();
        frmPri.setVisible(true);
    }
}
