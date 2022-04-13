package Company.Microsoft.OOD.AdapterDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MacBook {

    public void chargeMacbook(WindowsCharger windowsCharger) {
        Adapter charger = new Adapter(windowsCharger);
        charger.charge();
    }
}