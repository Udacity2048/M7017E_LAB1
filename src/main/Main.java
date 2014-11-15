package main;

//import the code application
import coreApplication.Controller;

//import the gui
import gui.GUI;

//import GStreamer
import org.gstreamer.Gst;

/**
 * The Class instantiate GStreamer framework, the 'Controller' and the 'GUI'.  
 * 
 * @author   Martin
 * @reviewer Baptiste
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //*****************************************************************start
        //Initialize the gstreamer framwork.
        args = Gst.init("AudioCapture", args);
        //*******************************************************************end
        
        
        //*****************************************************************start
        //Instantiate a Controller.
        final Controller controller = new Controller();
        //*******************************************************************end
        
               
        //*****************************************************************start
        //Instantiate a GUI.
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI(controller).setVisible(true);
            }
        });
        //*******************************************************************end
    }
}
