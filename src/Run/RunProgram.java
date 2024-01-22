package Run;
import javax.swing.UIManager;
import javax.swing.UIManager.*;
import View.Login;

/**
 *
 * @author NBN
 */
public class RunProgram {
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        Login login = new Login();
        login.setVisible(true);
    }
}
