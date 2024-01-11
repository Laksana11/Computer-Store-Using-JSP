/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author laxsana
 */
public class ComputerConfiguration {
    private String cpu;
    private int ram;
    private int storage;
    // Other computer components and properties

    // Constructor (private to enforce creation through the builder)
    private ComputerConfiguration() {}

    // Getters for the properties (omitted for brevity)

    // Nested Builder class
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        // Other computer components and properties in the builder

        public Builder(String cpu) {
            this.cpu = cpu;
        }

        public Builder setRAM(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        // Other methods to set other components and properties

        public ComputerConfiguration build() {
            ComputerConfiguration config = new ComputerConfiguration();
            config.cpu = this.cpu;
            config.ram = this.ram;
            config.storage = this.storage;
            // Set other components and properties in the config object
            return config;
        }
    }
}
