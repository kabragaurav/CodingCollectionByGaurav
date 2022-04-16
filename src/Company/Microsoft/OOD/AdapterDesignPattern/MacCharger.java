package Company.Microsoft.OOD.AdapterDesignPattern;

/**
 * @author gaurav kabra
 * @since 13/Apr/2022
 **/

public class MacCharger {

    WindowsCharger windowsCharger;

    public MacCharger(WindowsCharger windowsCharger) {
        this.windowsCharger = windowsCharger;
    }

    public void charge() {
        windowsCharger.charge();
    }

}
