import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagec extends JFrame {
    private java.awt.Image image;
    JPanel p = new JPanel();
    JDialog dialog;  // Corrected variable name

    public Imagec() {
        JOptionPane Op = new JOptionPane(" ", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, new Icon() {
            @Override
            public void paintIcon(Component component, Graphics graphics, int i, int i1) {}

            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        },
        new Object[]{},
        null);

        // Corrected variable name `dailog` to `dialog`
        dialog = Op.createDialog(new Frame(), "image");
        dialog.setPreferredSize(new Dimension(500, 500));
        dialog.add(p);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Corrected `addWindowListner` to `addWindowListener`
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.pack();
        dialog.setVisible(true);  // Changed from show() to setVisible(true)
        @Override
        public void paint(Graphics g) {
          super.paint(g);
          g.drawImage(image, 0, 0, this);
        }
        
    }

  

    public static void main(String args[]) {
        SwingUtilities.invokeLater(Imagec::new);
        System.out.println("image read successfully");
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working dir: " + workingDir);
    }
}
//https://stackoverflow.com/questions/31482986/creating-a-window-with-java-swing
