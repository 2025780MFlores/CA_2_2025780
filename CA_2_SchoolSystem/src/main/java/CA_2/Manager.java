/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author mf251
 */
public class Manager {
    private ManagerType type;

    public Manager(ManagerType type) {
        this.type = type;
    }

    public ManagerType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Manager Type: " + type;
    }
}
