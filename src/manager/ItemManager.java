package manager;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import main.Game;
import models.Item;

public class ItemManager {
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<Item> removeList = new ArrayList<Item>();
	
	private ItemTypeManager itemTypeManager = Game.getItemTypeManager();
	
	public ItemManager() throws SlickException {
			
		
		itemList.add(new Item(480, 416, itemTypeManager.stick));
		itemList.add(new Item(480, 416, itemTypeManager.stick));
						
		itemList.add(new Item(480, 416, itemTypeManager.dagger));
		itemList.add(new Item(480, 416, itemTypeManager.mace));
		itemList.add(new Item(480, 416, itemTypeManager.ironsword));
		itemList.add(new Item(480, 416, itemTypeManager.goldensword));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilsword));
		itemList.add(new Item(480, 416, itemTypeManager.blacksword));
		
		itemList.add(new Item(480, 416, itemTypeManager.sabre));
		itemList.add(new Item(480, 416, itemTypeManager.rapier));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilrapier));
		
		itemList.add(new Item(480, 416, itemTypeManager.shortspear));
		itemList.add(new Item(480, 416, itemTypeManager.longspear));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilspear));
		itemList.add(new Item(480, 416, itemTypeManager.goldenspear));
		
		itemList.add(new Item(480, 416, itemTypeManager.bow));
		itemList.add(new Item(480, 416, itemTypeManager.longbow));
		itemList.add(new Item(480, 416, itemTypeManager.recurvedbow));
		
		itemList.add(new Item(480, 416, itemTypeManager.firespell));
		itemList.add(new Item(480, 416, itemTypeManager.firespell));
		itemList.add(new Item(480, 416, itemTypeManager.icespell));
		itemList.add(new Item(480, 416, itemTypeManager.icespell));
		
		itemList.add(new Item(480, 416, itemTypeManager.chainhat));
		itemList.add(new Item(480, 416, itemTypeManager.chainhat));
		itemList.add(new Item(480, 416, itemTypeManager.chainhat));
		itemList.add(new Item(480, 416, itemTypeManager.chainhelmet));
		itemList.add(new Item(480, 416, itemTypeManager.chainhelmet));
		itemList.add(new Item(480, 416, itemTypeManager.clothhood));
		itemList.add(new Item(480, 416, itemTypeManager.goldenhelmet));
		itemList.add(new Item(480, 416, itemTypeManager.leathercap));
		itemList.add(new Item(480, 416, itemTypeManager.ironhelmet));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilhelmet));
		
		itemList.add(new Item(480, 416, itemTypeManager.shirt));
		itemList.add(new Item(480, 416, itemTypeManager.leatherchest));
		itemList.add(new Item(480, 416, itemTypeManager.chainchest));
		itemList.add(new Item(480, 416, itemTypeManager.ironchest));
		itemList.add(new Item(480, 416, itemTypeManager.goldenchest));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilchest));

		itemList.add(new Item(480, 416, itemTypeManager.irongloves));
		itemList.add(new Item(480, 416, itemTypeManager.goldengloves));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilgloves));
		
		itemList.add(new Item(480, 416, itemTypeManager.skirt));
		itemList.add(new Item(480, 416, itemTypeManager.irongreaves));
		itemList.add(new Item(480, 416, itemTypeManager.goldengreaves));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilgreaves));
				
		itemList.add(new Item(480, 416, itemTypeManager.boots));
		itemList.add(new Item(480, 416, itemTypeManager.leatherboots));
		itemList.add(new Item(480, 416, itemTypeManager.ironboots));
		itemList.add(new Item(480, 416, itemTypeManager.goldenboots));
		itemList.add(new Item(480, 416, itemTypeManager.mithrilboots));
		
		
		itemList.add(new Item(480, 416, itemTypeManager.gold));
		itemList.add(new Item(704, 416, itemTypeManager.gold));
		itemList.add(new Item(416, 480, itemTypeManager.gold));

		itemList.add(new Item(544, 544, itemTypeManager.apple));
		itemList.add(new Item(672, 544, itemTypeManager.apple));



		itemList.add(new Item(768, 480, itemTypeManager.arrow));
		itemList.add(new Item(768, 544, itemTypeManager.arrow));
		itemList.add(new Item(768, 608, itemTypeManager.arrow));
	
		itemList.add(new Item(800, 320, itemTypeManager.bone));
		itemList.add(new Item(832, 320, itemTypeManager.bone));
		itemList.add(new Item(864, 640, itemTypeManager.bone));
		itemList.add(new Item(896, 384, itemTypeManager.bone));
		itemList.add(new Item(256, 0, itemTypeManager.multipleSticks));
		itemList.add(new Item(320, 32, itemTypeManager.wheat));
		itemList.add(new Item(364, 32, itemTypeManager.trophy));
		
		itemList.add(new Item(864, 320, itemTypeManager.bread));
		itemList.add(new Item(736, 480, itemTypeManager.carrot));
		itemList.add(new Item(64, 1024, itemTypeManager.rawChicken));
		itemList.add(new Item(32, 1024, itemTypeManager.cookedChicken));
		itemList.add(new Item(1024, 64, itemTypeManager.rawFish));
		itemList.add(new Item(1024, 0, itemTypeManager.cookedFish));
		itemList.add(new Item(1024, 64, itemTypeManager.rawMeat));
		itemList.add(new Item(1024, 0, itemTypeManager.cookedMeat));
		itemList.add(new Item(256, 704, itemTypeManager.rawPork));
		itemList.add(new Item(128, 768, itemTypeManager.cookedPork));
		
		itemList.add(new Item(64, 128, itemTypeManager.ironBar));
		itemList.add(new Item(64, 192, itemTypeManager.goldenBar));
		itemList.add(new Item(64, 192, itemTypeManager.mithrilBar));
		
		itemList.add(new Item(512, 0, itemTypeManager.feather));
		itemList.add(new Item(576, 0, itemTypeManager.treasureChest));
		itemList.add(new Item(512, 96, itemTypeManager.goldCrown));
		itemList.add(new Item(576, 64, itemTypeManager.treasure));
		
		itemList.add(new Item(512, 128, itemTypeManager.smallHpPotion));
		itemList.add(new Item(0, 96, itemTypeManager.mediumHpPotion));
		itemList.add(new Item(320, 32, itemTypeManager.bigHpPotion));
		
		itemList.add(new Item(128, 192, itemTypeManager.smallManaPotion));
		itemList.add(new Item(128, 128, itemTypeManager.mediumManaPotion));
		itemList.add(new Item(128, 96, itemTypeManager.bigManaPotion));
		
		itemList.add(new Item(128, 128, itemTypeManager.maxHpBonusPotion));
		itemList.add(new Item(128, 128, itemTypeManager.maxManaBonusPotion));
		itemList.add(new Item(128, 128, itemTypeManager.strengthPotion));
		itemList.add(new Item(128, 128, itemTypeManager.dexterityPotion));
		itemList.add(new Item(128, 128, itemTypeManager.wisdomPotion));
		itemList.add(new Item(128, 128, itemTypeManager.speedPotion));
		
		
		itemList.add(new Item(0, 0, itemTypeManager.dragonroot));
		itemList.add(new Item(0, 32, itemTypeManager.goblinweed));
		itemList.add(new Item(0, 64, itemTypeManager.godnettel));
		itemList.add(new Item(64, 96, itemTypeManager.goldtruffle));
		itemList.add(new Item(96, 64, itemTypeManager.wolfnettel));
		
		itemList.add(new Item(32, 32, itemTypeManager.healberry));
		itemList.add(new Item(32, 64, itemTypeManager.healplant));
		itemList.add(new Item(32, 96, itemTypeManager.healroot));
		
		itemList.add(new Item(64, 0, itemTypeManager.manaberry));
		itemList.add(new Item(96, 96, itemTypeManager.manaplant));
		itemList.add(new Item(64, 64, itemTypeManager.manaroot));
		
		itemList.add(new Item(64, 0, itemTypeManager.smallBottle));
		itemList.add(new Item(96, 96, itemTypeManager.mediumBottle));
		itemList.add(new Item(64, 64, itemTypeManager.bigBottle));
		
	}
	
	public void update() {
		
		for(Item item : itemList) {
			item.update();
		}
		
		itemList.removeAll(removeList);
		
		removeList.clear();
		
	}

	public void render(Graphics g) {
	
		for(Item item : itemList) {
			item.render(g);
		}
		
	}
	
	public void addItem(Item item) {
		
		itemList.add(item);
		
	}
	
	public void removeItem(Item item) {
		
		removeList.add(item);
		
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
}