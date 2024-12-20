package Structural_Design_Pattern.Adapter_Pattern;

// older
// Need to be adapted
// (Adaptee)
class MicroUSBCharger {
    public void chargeWithMicroUSB() {
        System.out.println("Charging phone using Micro-USB charger.");
    }
}

//(target)
// which is used by the client now
// new
interface TypeCCharger {
    public void chargeWithCCharger();
}

class MicroUSBToTypeCChargerAdapter implements TypeCCharger {
    private MicroUSBCharger microUSB;

    public MicroUSBToTypeCChargerAdapter(MicroUSBCharger microUSB) {
        this.microUSB = microUSB;
    }

    @Override
    public void chargeWithCCharger() {
        microUSB.chargeWithMicroUSB();
    }
}

//client
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Old Micro-USB Charger
        MicroUSBCharger oldCharger = new MicroUSBCharger();

        // Adapter to use Micro-USB charger with Type-C interface
        TypeCCharger adapter = new MicroUSBToTypeCChargerAdapter(oldCharger);

        // Charging using Type-C port
        adapter.chargeWithCCharger();
    }
}
