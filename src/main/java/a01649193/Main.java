package a01649193;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {


		MagicLevel noobLevel = MagicLevel.NOOB;
		MagicLevel adeptLevel = MagicLevel.ADEPT;
		MagicLevel studentLevel = MagicLevel.STUDENT;
		MagicLevel expertLevel = MagicLevel.EXPERT;
		MagicLevel masterLevel = MagicLevel.MASTER;

		// Erstelle einige Spell-Objekte
		Spell heal1 = new HealingSpell("Heal1", 0, noobLevel, false, true, 10);
		Spell heal2 = new HealingSpell("Heal2", 1, adeptLevel, true, true, 15);
		Spell heal3 = new HealingSpell("Heal3", 2, adeptLevel, true, false, 20);
		Spell heal4 = new HealingSpell("Heal4", 3, masterLevel, false, true, 25);
		Spell heal5 = new HealingSpell("Heal5", 4, expertLevel, false, false, 30);
		Spell heal6 = new HealingSpell("Heal6", 5, masterLevel, true, true, 35);
		Spell heal7 = new HealingSpell("Heal7", 6, studentLevel, false, true, 40);
		Spell heal8 = new HealingSpell("Heal8", 7, expertLevel, true, false, 45);
		Spell heal9 = new HealingSpell("Heal9", 8, masterLevel, false, false, 50);


		// Erstelle einige AttackingSpell-Objekte
		AttackingSpell fireball1 = new AttackingSpell("fireball1", 10, noobLevel, true, false, 10);
		AttackingSpell fireball2 = new AttackingSpell("fireball2", 15, adeptLevel, true, true, 20);
		AttackingSpell fireball3 = new AttackingSpell("fireball3", 20, expertLevel, false, false, 30);
		AttackingSpell fireball4 = new AttackingSpell("fireball4", 25, masterLevel, true, true, 40);
		AttackingSpell fireball5 = new AttackingSpell("fireball5", 30, noobLevel, false, false, 50);
		AttackingSpell fireball6 = new AttackingSpell("fireball6", 35, adeptLevel, true, true, 60);
		AttackingSpell fireball7 = new AttackingSpell("fireball7", 40, expertLevel, false, false, 70);
		AttackingSpell fireball8 = new AttackingSpell("fireball8", 45, masterLevel, true, true, 80);
		AttackingSpell fireball9 = new AttackingSpell("fireball9", 50, noobLevel, false, true, 90);

		// Erstelle einige Tradeable-Objekte

		Potion potion1 = new HealthPotion("potion1", 10, 5, 1, 90);
		Potion potion2 = new HealthPotion("potion2", 10, 5, 1, 120);
		Potion potion3 = new HealthPotion("potion3", 20, 20, 3, 100);
		Potion potion4 = new HealthPotion("potion4", 15, 10, 2, 80);
		Potion potion5 = new HealthPotion("potion5", 25, 15, 3, 50);
		Potion potion6 = new HealthPotion("potion6", 30, 20, 2, 140);
		Potion potion7 = new HealthPotion("potion7", 10, 25, 1, 25);
		Potion potion8 = new HealthPotion("potion8", 40, 30, 3, 100);
		Potion potion9 = new HealthPotion("potion9", 40, 35, 13000, 95);

		// Erstelle ein Set von knownSpells für jeden Wizard
		Set<Spell> knownSpells1 = new HashSet<>();
		knownSpells1.add(heal1);
		knownSpells1.add(heal4);
		knownSpells1.add(heal7);

		Set<Spell> knownSpells2 = new HashSet<>();
		knownSpells2.add(heal2);
		knownSpells2.add(heal5);
		knownSpells2.add(heal8);

		Set<Spell> knownSpells3 = new HashSet<>();
		//knownSpells3.add(heal3);
		//knownSpells3.add(heal6);
		//knownSpells3.add(heal9);

		// Erstelle ein Set von protectedFrom für jeden Wizard
		Set<AttackingSpell> protectedFrom1 = new HashSet<>();
		protectedFrom1.add(fireball1);
		protectedFrom1.add(fireball5);
		protectedFrom1.add(fireball9);

		Set<AttackingSpell> protectedFrom2 = new HashSet<>();
		protectedFrom2.add(fireball2);
		protectedFrom2.add(fireball6);
		protectedFrom2.add(fireball4);

		Set<AttackingSpell> protectedFrom3 = new HashSet<>();
		//protectedFrom3.add(fireball3);
		//protectedFrom3.add(fireball7);
		//protectedFrom3.add(fireball5);
		//protectedFrom3.add(fireball8);

		// Erstelle ein Set von Tradeable-Objekten im Inventar jedes Wizards
		Set<Tradeable> inventory1 = new HashSet<>();
		inventory1.add(potion1);
		inventory1.add(potion4);
		inventory1.add(potion7);
		inventory1.add(potion8);
		inventory1.add(potion6);

		Set<Tradeable> inventory2 = new HashSet<>();
		inventory2.add(potion2);
		inventory2.add(potion3);
		inventory2.add(potion5);
		inventory2.add(potion8);

		Set<Tradeable> inventory3 = new HashSet<>();
		inventory3.add(potion1);
		inventory3.add(potion2);

		Set<Tradeable> inventory3Steal = new HashSet<>();
		inventory3Steal.add(potion3);

		Wizard wizard1 = new Wizard("Gandalf", adeptLevel, 100, 100, 1500, 200, 1000, knownSpells1, protectedFrom1, 13000, inventory1);
		Wizard wizard1Random = new Wizard("Gandalf", adeptLevel, 100, 100, 1500, 200, 1000, knownSpells1, protectedFrom1, 13000, inventory1);
		Wizard wizardSteal1Random = new Wizard("Gandalf", adeptLevel, 100, 100, 1500, 200, 1000, knownSpells1, protectedFrom1, 13000, inventory3);
		Wizard wizard2 = new Wizard("Harry", adeptLevel, 80, 80, 150, 150, 500, knownSpells2, protectedFrom2, 300, inventory2);
		Wizard wizard3 = new Wizard("Merlin", studentLevel, 60, 60, 250, 100, 300, knownSpells3, protectedFrom3, 200, inventory3);
		Wizard wizard3Random = new Wizard("Merlin", studentLevel, 60, 60, 250, 100, 300, knownSpells3, protectedFrom3, 200, inventory3);
		Wizard wizardSteal3Random = new Wizard("Merlin", studentLevel, 60, 60, 250, 100, 300, knownSpells3, protectedFrom3, 200, inventory3Steal);
		Wizard wizardDead = new Wizard("Dead", masterLevel, 100, 0, 1500, 200, 1000, knownSpells1, protectedFrom1, 500, inventory1);

		System.out.println(wizard2.getBestNItems(10));
		Collection<Wizard> wizards = new ArrayList<>();
		wizards.add(wizard1);
		wizards.add(wizard2);
		wizards.add(wizard3);

		// Aufruf der Methode getWizardsPerItem und Ausgabe der Ergebnisse
		try {
			TreeMap<MagicItem, TreeSet<Wizard>> result = Wizard.getWizardsPerItem(wizards);

			for (Map.Entry<MagicItem, TreeSet<Wizard>> entry : result.entrySet()) {
				MagicItem item = entry.getKey();
				TreeSet<Wizard> wizardsWithItem = entry.getValue();

				System.out.println("Item: " + item.getName() + ", Price: " + item.getPrice());
				System.out.println("Wizards:");

				for (Wizard wizard : wizardsWithItem) {
					System.out.println("- " + wizard.getName());
				}

				System.out.println();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("///////////////////////////////////////////////////////////////");
		System.out.println("Zauberer vor der Wut:");
		System.out.println(wizard1);

		// Auslösen der Wut
		wizard1.startRage();

		// Ausgabe des Zauberers während der Wut
		System.out.println("\nZauberer während der Wut:");
		System.out.println(wizard1);

		// Beenden der Wut
		boolean wasRaging = wizard1.endRage();

		// Ausgabe des Zauberers nach der Wut
		System.out.println("\nZauberer nach der Wut:");
		System.out.println(wizard1);

		// Überprüfen, ob der Zauberer vor der Wut in Rage war
		System.out.println("\nWar der Zauberer vor der Wut in Rage? " + wasRaging);

	}

}