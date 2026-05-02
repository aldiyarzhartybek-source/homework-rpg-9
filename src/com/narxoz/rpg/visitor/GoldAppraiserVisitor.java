package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class GoldAppraiserVisitor implements ArtifactVisitor {
    private int totalValue;

    public int getTotalValue() {
        return totalValue;
    }

    @Override
    public void visit(Weapon weapon) {
        int estimate = weapon.getValue() + weapon.getAttackBonus() * 8;
        totalValue += estimate;
        System.out.println("  [Gold] Weapon " + weapon.getName() + " => " + estimate + "g");
    }

    @Override
    public void visit(Potion potion) {
        int estimate = potion.getValue() + potion.getHealing() * 3;
        totalValue += estimate;
        System.out.println("  [Gold] Potion " + potion.getName() + " => " + estimate + "g");
    }

    @Override
    public void visit(Scroll scroll) {
        int estimate = scroll.getValue() + scroll.getSpellName().length() * 4;
        totalValue += estimate;
        System.out.println("  [Gold] Scroll " + scroll.getName() + " => " + estimate + "g");
    }

    @Override
    public void visit(Ring ring) {
        int estimate = ring.getValue() + ring.getMagicBonus() * 10;
        totalValue += estimate;
        System.out.println("  [Gold] Ring " + ring.getName() + " => " + estimate + "g");
    }

    @Override
    public void visit(Armor armor) {
        int estimate = armor.getValue() + armor.getDefenseBonus() * 7;
        totalValue += estimate;
        System.out.println("  [Gold] Armor " + armor.getName() + " => " + estimate + "g");
    }
}
