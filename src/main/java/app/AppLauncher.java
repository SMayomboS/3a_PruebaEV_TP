package app;

import view.MenuPrincipalView;
import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipalView menu = new MenuPrincipalView();
            menu.setVisible(true);
        });
    }
}
