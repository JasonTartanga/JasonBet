package controlador;

import modelo.DAO;
import modelo.DAOImplementacion;
import vista.LoginAndRegister;
import vista.VMain;

/**
 *
 * @author xDoble_Jx
 */
public class JasonBet {

    public static void main(String[] args) {
        DAO dao = new DAOImplementacion();
        VMain vMain = new VMain(dao);
        vMain.setVisible(true);

    }
}
