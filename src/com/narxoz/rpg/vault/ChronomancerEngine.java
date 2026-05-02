package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.CurseDetectorVisitor;
import com.narxoz.rpg.visitor.EnchantmentScannerVisitor;
import com.narxoz.rpg.visitor.GoldAppraiserVisitor;
import com.narxoz.rpg.visitor.WeightAuditVisitor;
import java.util.List;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return a placeholder result in the scaffold
     */
    public VaultRunResult runVault(List<Hero> party) {
        if (party == null || party.isEmpty()) {
            System.out.println("[Vault] No heroes entered the vault.");
            return new VaultRunResult(0, 0, 0);
        }

        Hero leader = party.get(0);
        System.out.println("\n=== Chronomancer's Vault ===");
        System.out.println("[Party] Leader: " + leader.getName());

        Inventory vaultInventory = buildVaultInventory();
        leader.setInventory(vaultInventory.copy());
        int artifactsAppraised = vaultInventory.size();

        System.out.println("\n[Phase] Visitor appraisal begins");
        GoldAppraiserVisitor goldAppraiser = new GoldAppraiserVisitor();
        EnchantmentScannerVisitor scanner = new EnchantmentScannerVisitor();
        CurseDetectorVisitor curseDetector = new CurseDetectorVisitor();
        WeightAuditVisitor weightAudit = new WeightAuditVisitor();

        vaultInventory.accept(goldAppraiser);
        System.out.println("  [Gold] total estimate: " + goldAppraiser.getTotalValue() + "g");
        vaultInventory.accept(scanner);
        vaultInventory.accept(curseDetector);
        System.out.println("  [Curse] flagged artifacts: " + curseDetector.getCursedCount());
        vaultInventory.accept(weightAudit);
        System.out.println("  [Weight] total carry: " + weightAudit.getTotalWeight() + "kg");

        System.out.println("\n[Phase] Memento snapshot");
        Caretaker caretaker = new Caretaker();
        caretaker.save(leader.createMemento());
        int mementosCreated = caretaker.size();
        System.out.println("  Saved snapshots: " + caretaker.size());
        System.out.println("  Before trap: " + leader);

        System.out.println("\n[Phase] Vault trap triggers");
        leader.takeDamage(35);
        leader.spendMana(15);
        leader.spendGold(60);
        System.out.println("  After trap: " + leader);

        int restoredCount = 0;
        HeroMemento snapshot = caretaker.undo();
        if (snapshot != null) {
            leader.restoreFromMemento(snapshot);
            restoredCount = 1;
            System.out.println("\n[Phase] Rewind successful");
            System.out.println("  After rewind: " + leader);
        }

        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }

    private Inventory buildVaultInventory() {
        Inventory inventory = new Inventory();
        inventory.addArtifact(new Weapon("Sunfang Blade", 180, 9, 13));
        inventory.addArtifact(new Potion("Ruby Tonic", 60, 2, 45));
        inventory.addArtifact(new Scroll("Scroll of Void Echo", 120, 1, "Void Echo"));
        inventory.addArtifact(new Ring("Chrono Ring", 140, 1, 11));
        inventory.addArtifact(new Armor("Aegis Plate", 200, 27, 16));
        return inventory;
    }
}
