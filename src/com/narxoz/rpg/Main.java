package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for Homework 9 — Chronomancer's Vault: Visitor + Memento.
 *
 * The scaffold prints the banner only; students fill in the vault demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");
        Hero chrona = new Hero("Chrona", 120, 45, 18, 8, 160, new Inventory());
        Hero borin = new Hero("Borin", 150, 20, 20, 12, 90, new Inventory());

        List<Hero> party = new ArrayList<>();
        party.add(chrona);
        party.add(borin);

        System.out.println("[Party] " + chrona);
        System.out.println("[Party] " + borin);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(party);

        System.out.println("\n=== Final Vault Result ===");
        System.out.println(result);
    }
}
