package Company.Microsoft.OOD.AdapterDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MacBook {

    public void chargeMacbook(WindowsCharger windowsCharger) {
        MacCharger macCharger = new MacCharger(windowsCharger);
        macCharger.charge();
    }
}
