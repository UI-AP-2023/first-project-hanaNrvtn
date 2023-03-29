package model.product;

public class PC extends DigitalEquipment {
    private String CPUModel;
    private int RAMCapacity;

    public PC(String category, String name, int price, int numberOfSupply, double weight, String dimension, String CPUModel, int RAMCapacity) {
        super(category, name, price, numberOfSupply, weight, dimension);
        this.CPUModel = CPUModel;
        this.RAMCapacity = RAMCapacity;
    }

    public String getCPUModel() {
        return CPUModel;
    }

    public void setCPUModel(String CPUModel) {
        this.CPUModel = CPUModel;
    }

    public int getRAMCapacity() {
        return RAMCapacity;
    }

    public void setRAMCapacity(int RAMCapacity) {
        this.RAMCapacity = RAMCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCPU model: " + CPUModel + "\nRAM capacity: " + RAMCapacity;
    }
}