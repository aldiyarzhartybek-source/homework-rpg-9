package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class WeightAuditVisitor implements ArtifactVisitor {
    private int totalWeight;

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.println("  [Weight] Weapon " + weapon.getName() + " -> " + weapon.getWeight() + "kg");
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.println("  [Weight] Potion " + potion.getName() + " -> " + potion.getWeight() + "kg");
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.println("  [Weight] Scroll " + scroll.getName() + " -> " + scroll.getWeight() + "kg");
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.println("  [Weight] Ring " + ring.getName() + " -> " + ring.getWeight() + "kg");
    }

    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        System.out.println("  [Weight] Armor " + armor.getName() + " -> " + armor.getWeight() + "kg");
    }
}
