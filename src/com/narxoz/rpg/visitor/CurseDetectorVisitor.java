package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class CurseDetectorVisitor implements ArtifactVisitor {
    private int cursedCount;

    public int getCursedCount() {
        return cursedCount;
    }

    @Override
    public void visit(Weapon weapon) {
        boolean cursed = weapon.getAttackBonus() >= 15 || weapon.getWeight() > 20;
        printVerdict(weapon.getName(), cursed);
    }

    @Override
    public void visit(Potion potion) {
        boolean cursed = potion.getHealing() < 15;
        printVerdict(potion.getName(), cursed);
    }

    @Override
    public void visit(Scroll scroll) {
        boolean cursed = scroll.getSpellName().toLowerCase().contains("void");
        printVerdict(scroll.getName(), cursed);
    }

    @Override
    public void visit(Ring ring) {
        boolean cursed = ring.getMagicBonus() > 9;
        printVerdict(ring.getName(), cursed);
    }

    @Override
    public void visit(Armor armor) {
        boolean cursed = armor.getDefenseBonus() > 14 && armor.getWeight() > 25;
        printVerdict(armor.getName(), cursed);
    }

    private void printVerdict(String artifactName, boolean cursed) {
        if (cursed) {
            cursedCount++;
            System.out.println("  [Curse] " + artifactName + ": CURSED");
            return;
        }
        System.out.println("  [Curse] " + artifactName + ": clear");
    }
}
