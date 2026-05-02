package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class EnchantmentScannerVisitor implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) {
        System.out.println("  [Scan] " + weapon.getName() + ": edge resonance +" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("  [Scan] " + potion.getName() + ": alchemy vitality +" + potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("  [Scan] " + scroll.getName() + ": rune sequence <" + scroll.getSpellName() + ">");
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("  [Scan] " + ring.getName() + ": focus aura +" + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("  [Scan] " + armor.getName() + ": ward matrix +" + armor.getDefenseBonus());
    }
}
