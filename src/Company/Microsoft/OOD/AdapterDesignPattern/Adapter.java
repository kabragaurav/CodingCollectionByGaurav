package Company.Microsoft.OOD.AdapterDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class Adapter {

    WindowsCharger windowsCharger;

    public Adapter(WindowsCharger windowsCharger) {
        this.windowsCharger = windowsCharger;
    }

    public void charge() {
        windowsCharger.charge();
    }

}
