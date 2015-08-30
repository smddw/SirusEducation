package util;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class ReportView {

    Connection connection = null;

    public void initConnection() {

        String HOST = "jdbc:mysql://localhost/reportdb";
        String USERNAME = "root";
        String PASSWORD = "admin";

        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

            ex.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

    // default constructor
    public ReportView() {
    }

    // constructor with String parameter
    public ReportView(String fileName) {
        this(fileName, null);
    }

    // constructor with String & Hashmap parameter
    public ReportView(String fileName, Map hashMap) {

        initConnection();
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            //Fill the report with parameter, connection and the stream reader

            InputStream in = new FileInputStream(fileName);

            JasperPrint jp = JasperFillManager.fillReport(in, hashMap, connection);

            //Viewer for JasperReport
            JRViewer jv = new JRViewer(jp);
            //Insert viewer to a JFrame to make it showable
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            //jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("windows/rlanka/images/RLogo.png")));
            jf.validate();
            jf.setVisible(true);
            jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            jf.setLocation(0, 0);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
//For JPanel

    public JRViewer getJRViewer(InputStream fileName, Map hashMap) {

        initConnection();
        JRViewer jv = null;
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            //Fill the report with parameter, connection and the stream reader
            JasperPrint jp = JasperFillManager.fillReport(fileName, hashMap, connection);

            //Viewer for JasperReport
            jv = new JRViewer(jp);

        } catch (JRException ex) {

            ex.printStackTrace();
        }
        return jv;
    }

    //For JFrame
    public ReportView(InputStream fileName, Map hashMap) {

        initConnection();
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            //Fill the report with parameter, connection and the stream reader
            JasperPrint jp = JasperFillManager.fillReport(fileName, hashMap, connection);

            //Viewer for JasperReport
            JRViewer jv = new JRViewer(jp);
            //Insert viewer to a JFrame to make it showable
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            //  jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("windows/rlanka/images/RLogo.png")));
            jf.validate();
            jf.setVisible(true);
            jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            jf.setLocation(200, 200);
            jf.setSize(800, 600);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (JRException ex) {

            ex.printStackTrace();
        }
    }
}
