
package main;

import model.ModelCsv2;
import view.ViewCsv2;
import controller.ControllerCsv2;


public class Main {

 
    public static void main(String[] args) {
        ModelCsv2 modelBlocBase = new ModelCsv2();
        ViewCsv2 viewBlocBase = new ViewCsv2();
        ControllerCsv2 controllerBlocBase = new ControllerCsv2(modelBlocBase, viewBlocBase);
    }
    
}
