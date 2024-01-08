/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author user
 */
public class ComputerBuilder {
    private final Computer computer;

    public ComputerBuilder() {
        computer = new Computer();
    }
    
    public ComputerBuilder withComputerId(int computer_id) {
        computer.setComputer_id(computer_id);
        return this;
    }
     
    public ComputerBuilder withModel(String model) {
        computer.setModel(model);
        return this;
    }

    public ComputerBuilder withProcessor(String processor) {
        computer.setProcessor(processor);
        return this;
    }
    
    public ComputerBuilder withStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }
    public ComputerBuilder withRam(int ram) {
        computer.setRam(ram);
        return this;
    }
    public ComputerBuilder withGraphics(String graphics) {
        computer.setGraphics(graphics);
        return this;
    }
    
    
    public ComputerBuilder withPrice(double price) {
        computer.setPrice(price);
        return this;
    }
    
     public ComputerBuilder withImage(String image) {
        computer.setImage(image);
        return this;
    }
    
    public Computer build() {
        return computer;
    }
}
