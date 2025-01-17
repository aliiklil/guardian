package manager;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import models.ItemType;
import util.CollisionBox;

public class ItemTypeManager {

	public ItemType stick;
	public ItemType dagger;
	public ItemType mace;
	public ItemType ironsword;
	public ItemType goldensword;
	public ItemType mithrilsword;
	public ItemType blacksword;

	public ItemType sabre;
	public ItemType rapier;
	public ItemType mithrilrapier;
	
	public ItemType shortspear;
	public ItemType longspear;
	public ItemType mithrilspear;
	public ItemType goldenspear;

	public ItemType bow;
	public ItemType longbow;
	public ItemType recurvedbow;

	public ItemType arrow;

	
	public ItemType healLightWoundsRune;
	public ItemType icelanceRune;
	public ItemType iceblockRune;
	public ItemType transformIntoWolfRune;
	
	public ItemType healMediumWoundsRune;
	public ItemType fireballRune;
	public ItemType bloodtheftRune;
	public ItemType transformIntoSkeletonRune;
	
	public ItemType healHeavyWoundsRune;
	public ItemType titanspearRune;
	public ItemType firerainRune;
	public ItemType transformIntoOrcWarriorRune;
	
	
	public ItemType healLightWoundsSpell;
	public ItemType titanspearSpell;
	public ItemType iceblockSpell;
	public ItemType transformIntoWolfSpell;
	
	public ItemType healMediumWoundsSpell;
	public ItemType icelanceSpell;
	public ItemType bloodtheftSpell;
	public ItemType transformIntoSkeletonSpell;
	
	public ItemType healHeavyWoundsSpell;
	public ItemType fireballSpell;
	public ItemType firerainSpell;
	public ItemType transformIntoOrcWarriorSpell;
	
	
	public ItemType lightImperialArmor;
	public ItemType mediumImperialArmor;
	public ItemType heavyImperialArmor;

	public ItemType lightRebelArmor;
	public ItemType mediumRebelArmor;
	public ItemType heavyRebelArmor;
	
	public ItemType noviceArmor;
	public ItemType mageArmor;
	public ItemType heavyMageArmor;
	
	public ItemType leatherArmor;
	public ItemType ironArmor;
	public ItemType blackknightArmor;
	public ItemType goldenArmor;
	public ItemType mithrilArmor;
	
	public ItemType skeletonTransformationArmor;
	public ItemType orcTransformationArmor;
	
	

	

	public ItemType smallHpPotion;
	public ItemType mediumHpPotion;
	public ItemType bigHpPotion;

	public ItemType smallManaPotion;
	public ItemType mediumManaPotion;
	public ItemType bigManaPotion;

	public ItemType maxHpBonusPotion;
	public ItemType maxManaBonusPotion;
	public ItemType strengthPotion;
	public ItemType dexterityPotion;
	public ItemType speedPotion;

	public ItemType dragonroot;
	public ItemType goblinweed;
	public ItemType goldtruffle;
	public ItemType wolfnettel;
	
	public ItemType healberry;
	public ItemType healplant;
	public ItemType healroot;
	
	public ItemType manaberry;
	public ItemType manaplant;
	public ItemType manaroot;
	
	public ItemType bread;
	public ItemType carrot;
	public ItemType rawChicken;
	public ItemType cookedChicken;
	public ItemType rawFish;
	public ItemType cookedFish;
	public ItemType rawMeat;
	public ItemType cookedMeat;
	public ItemType rawPork;
	public ItemType cookedPork;
	public ItemType wheat;
	public ItemType apple;
	
	public ItemType bone;
	public ItemType ironBar;
	public ItemType goldenBar;
	public ItemType mithrilBar;
	public ItemType feather;
	public ItemType treasureChest;
	public ItemType goldCrown;
	public ItemType treasure;
	public ItemType multipleSticks;
	public ItemType trophy;
	public ItemType chrystal;
	public ItemType icecube;
	public ItemType wolfHide;
	public ItemType smaragd;
	public ItemType aquamarine;
	public ItemType pitch;
	public ItemType sulfur;
	public ItemType orcTooth;
	public ItemType heart;
	
	public ItemType smallBottle;
	public ItemType mediumBottle;
	public ItemType bigBottle;
	
	public ItemType emptyRune;
	
	public ItemType letter;
	public ItemType note;
	public ItemType redbook;
	public ItemType blackbook;
	public ItemType bluebook;
	
	public ItemType ogusChrystal;
	
	public ItemType gold;
	
	



	public ItemTypeManager() throws SlickException {
		
		
		stick = new ItemType(1, "resources/items/1melee/stick.png", "Stick", 20, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/stick.png");
		stick.setMinStrength(10);
		stick.setDamage(15);
		
		dagger = new ItemType(1, "resources/items/1melee/dagger.png", "Dagger", 50, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/dagger.png");
		dagger.setMinStrength(20);
		dagger.setDamage(25);
		
		mace = new ItemType(1, "resources/items/1melee/mace.png", "Mace", 100, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/mace.png");
		mace.setMinStrength(30);
		mace.setDamage(35);
		
		
		ironsword = new ItemType(1, "resources/items/1melee/ironsword.png", "Iron Sword", 400, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/ironsword.png");
		ironsword.setMinStrength(30);
		ironsword.setDamage(50);
		
		goldensword = new ItemType(1, "resources/items/1melee/goldensword.png", "Golden Sword", 400, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/goldensword.png");
		goldensword.setMinStrength(50);
		goldensword.setDamage(90);
		
		mithrilsword = new ItemType(1, "resources/items/1melee/mithrilsword.png", "Mithril Sword", 400, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/mithrilsword.png");
		mithrilsword.setMinStrength(60);
		mithrilsword.setDamage(110);
		
		blacksword = new ItemType(1, "resources/items/1melee/blacksword.png", "Black Sword", 400, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/blacksword.png");
		blacksword.setMinStrength(75);
		blacksword.setDamage(140);

		
		
		sabre = new ItemType(1, "resources/items/1melee/sabre.png", "Sabre", 200, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/sabre.png");
		sabre.setMinDexterity(20);
		sabre.setDamage(35);
		
		rapier = new ItemType(1, "resources/items/1melee/rapier.png", "Rapier", 400, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/rapier.png");
		rapier.setMinDexterity(40);
		rapier.setDamage(55);
		
		mithrilrapier = new ItemType(1, "resources/items/1melee/mithrilrapier.png", "Mithril Rapier", 500, 1, true, "melee_slay", "resources/player_sprites/weapons/melee_slay/mithrilrapier.png");
		mithrilrapier.setMinDexterity(50);
		mithrilrapier.setDamage(75);
		
		
		shortspear = new ItemType(1, "resources/items/1melee/shortspear.png", "Short Spear", 50, 1, true, "melee_thrust", "resources/player_sprites/weapons/melee_thrust/shortspear.png");
		shortspear.setMinStrength(10);
		shortspear.setDamage(25);
		
		longspear = new ItemType(1, "resources/items/1melee/longspear.png", "Longspear", 200, 1, true, "melee_thrust", "resources/player_sprites/weapons/melee_thrust/longspear.png");
		longspear.setMinStrength(20);
		longspear.setDamage(35);
		
		mithrilspear = new ItemType(1, "resources/items/1melee/mithrilspear.png", "Mithril Spear", 400, 1, true, "melee_thrust", "resources/player_sprites/weapons/melee_thrust/mithrilspear.png");
		mithrilspear.setMinStrength(30);
		mithrilspear.setDamage(65);
		
		goldenspear = new ItemType(1, "resources/items/1melee/goldenspear.png", "Golden Spear", 550, 1, true, "melee_thrust", "resources/player_sprites/weapons/melee_thrust/goldenspear.png");
		goldenspear.setMinStrength(40);
		goldenspear.setDamage(85);
		

		bow = new ItemType(1, "resources/items/2bows/bow.png", "Bow", 50, 2, true, "bow", "resources/player_sprites/weapons/bows/bow.png");
		bow.setMinDexterity(10);
		bow.setDamage(25);
		
		longbow = new ItemType(1, "resources/items/2bows/longbow.png", "Long Bow", 200, 2, true, "bow", "resources/player_sprites/weapons/bows/longbow.png");
		longbow.setMinDexterity(20);
		longbow.setDamage(35);
		
		recurvedbow = new ItemType(1, "resources/items/2bows/recurvedbow.png", "Recurved Bow", 400, 2, true, "bow", "resources/player_sprites/weapons/bows/recurvedbow.png");
		recurvedbow.setMinDexterity(30);
		recurvedbow.setDamage(65);
		

		
		arrow = new ItemType(1, "resources/items/3arrows/arrow.png", "Arrow", 10, 3, false, "arrow", "resources/player_sprites/empty_sprite_sheet.png");

		
		

		
		blackknightArmor = new ItemType(1, "resources/items/4powerful_armor/blackknight_armor.png", "Blackknight Armor", 500, 4, true, "armor", "resources/player_sprites/armor/powerful_armor/blackknight_armor.png");
		blackknightArmor.setProtection(60);
		
		goldenArmor = new ItemType(1, "resources/items/4powerful_armor/golden_armor.png", "Golden Armor", 800, 4, true, "armor", "resources/player_sprites/armor/powerful_armor/golden_armor.png");
		goldenArmor.setProtection(70);
		
		mithrilArmor = new ItemType(1, "resources/items/4powerful_armor/mithril_armor.png", "Mithril Armor", 1200, 4, true, "armor", "resources/player_sprites/armor/powerful_armor/mithril_armor.png");
		mithrilArmor.setProtection(80);
		
		

		

		
		lightImperialArmor = new ItemType(1, "resources/items/5imperial_armor/light_imperial_armor.png", "Light Imperial Armor", 300, 5, true, "armor", "resources/player_sprites/armor/imperial_armor/light_imperial_armor.png");
		lightImperialArmor.setProtection(30);
		
		mediumImperialArmor = new ItemType(1, "resources/items/5imperial_armor/medium_imperial_armor.png", "Medium Imperial Armor", 600, 5, true, "armor", "resources/player_sprites/armor/imperial_armor/medium_imperial_armor.png");
		mediumImperialArmor.setProtection(40);
		
		heavyImperialArmor = new ItemType(1, "resources/items/5imperial_armor/heavy_imperial_armor.png", "Heavy Imperial Armor", 900, 5, true, "armor", "resources/player_sprites/armor/imperial_armor/heavy_imperial_armor.png");
		heavyImperialArmor.setProtection(50);
		

		
		
		lightRebelArmor = new ItemType(1, "resources/items/6rebel_armor/light_rebel_armor.png", "Light Rebel Armor", 300, 6, true, "armor", "resources/player_sprites/armor/rebel_armor/light_rebel_armor.png");
		lightRebelArmor.setProtection(30);
		
		mediumRebelArmor = new ItemType(1, "resources/items/6rebel_armor/medium_rebel_armor.png", "Medium Rebel Armor", 600, 6, true, "armor", "resources/player_sprites/armor/rebel_armor/medium_rebel_armor.png");;
		mediumRebelArmor.setProtection(40);
		
		heavyRebelArmor = new ItemType(1, "resources/items/6rebel_armor/heavy_rebel_armor.png", "Heavy Rebel Armor", 900, 6, true, "armor", "resources/player_sprites/armor/rebel_armor/heavy_rebel_armor.png");
		heavyRebelArmor.setProtection(50);
		
		
		
		noviceArmor = new ItemType(1, "resources/items/7mage_armor/novice_armor.png", "Novice Armor", 300, 7, true, "armor", "resources/player_sprites/armor/mage_armor/novice_armor.png");
		noviceArmor.setProtection(30);
		
		mageArmor = new ItemType(1, "resources/items/7mage_armor/mage_armor.png", "Mage Armor", 600, 7, true, "armor", "resources/player_sprites/armor/mage_armor/mage_armor.png");
		mageArmor.setProtection(35);
		
		heavyMageArmor = new ItemType(1, "resources/items/7mage_armor/heavy_mage_armor.png", "Heavy Mage Armor", 900, 7, true, "armor", "resources/player_sprites/armor/mage_armor/heavy_mage_armor.png");
		heavyMageArmor.setProtection(40);
		
		
		
		leatherArmor = new ItemType(1, "resources/items/8weak_armor/leather_armor.png", "Leather Armor", 200, 8, true, "armor", "resources/player_sprites/armor/weak_armor/leather_armor.png");
		leatherArmor.setProtection(15);
		
		ironArmor = new ItemType(1, "resources/items/8weak_armor/iron_armor.png", "Iron Armor", 250, 8, true, "armor", "resources/player_sprites/armor/weak_armor/iron_armor.png");
		ironArmor.setProtection(25);
		

		
		
		skeletonTransformationArmor = new ItemType(1, "resources/items/9transformation_armor/skeleton_armor.png", "Skeleton Armor", 0, 9, true, "armor", "resources/player_sprites/armor/transformation_armor/skeleton_armor.png");
		skeletonTransformationArmor.setProtection(80);
		
		orcTransformationArmor = new ItemType(1, "resources/items/9transformation_armor/orc_armor.png", "Orc Armor", 0, 9, true, "armor", "resources/player_sprites/armor/transformation_armor/orc_armor.png");
		orcTransformationArmor.setProtection(80);
		
		
		
		
		
		
		
		
		healLightWoundsRune = new ItemType(1, "resources/items/13healrunes/healLightWoundsRune.png", "Heal Light Wounds", 250, 13, true, "rune", "resources/player_sprites/weapons/magic/magicCloud.png");
		healLightWoundsRune.setManaCost(5);
		healLightWoundsRune.setHealthBoost(50);

		icelanceRune = new ItemType(1, "resources/items/10bulletrunes/icelanceRune.png", "Icelance", 250, 10, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		icelanceRune.setManaCost(10);
		icelanceRune.setDamage(20);
		
		iceblockRune = new ItemType(1, "resources/items/11otherrunes/iceblockRune.png", "Iceblock", 250, 11, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		iceblockRune.setManaCost(10);
		
		transformIntoWolfRune = new ItemType(1, "resources/items/12transformrunes/transformIntoWolfRune.png", "Transform Into Wolf", 250, 12, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		transformIntoWolfRune.setManaCost(10);
		transformIntoWolfRune.setEffectDuration(30);


		
		healMediumWoundsRune = new ItemType(1, "resources/items/13healrunes/healMediumWoundsRune.png", "Heal Medium Wounds", 500, 13, true, "rune", "resources/player_sprites/weapons/magic/magicCloud.png");
		healMediumWoundsRune.setManaCost(15);
		healMediumWoundsRune.setHealthBoost(200);
		
		fireballRune = new ItemType(1, "resources/items/10bulletrunes/fireballRune.png", "Fireball", 500, 10, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		fireballRune.setManaCost(20);
		fireballRune.setDamage(50);
		
		bloodtheftRune = new ItemType(1, "resources/items/11otherrunes/bloodtheftRune.png", "Bloodtheft", 500, 11, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		bloodtheftRune.setManaCost(20);
		bloodtheftRune.setDamage(15);
		
		transformIntoSkeletonRune = new ItemType(1, "resources/items/12transformrunes/transformIntoSkeletonRune.png", "Transform Into Skeleton", 500, 12, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		transformIntoSkeletonRune.setManaCost(25);
		transformIntoSkeletonRune.setEffectDuration(30);

		

		healHeavyWoundsRune = new ItemType(1, "resources/items/13healrunes/healHeavyWoundsRune.png", "Heal Heavy Wounds", 750, 13, true, "rune", "resources/player_sprites/weapons/magic/magicCloud.png");
		healHeavyWoundsRune.setManaCost(25);
		healHeavyWoundsRune.setHealthBoost(400);
		
		titanspearRune = new ItemType(1, "resources/items/10bulletrunes/titanspearRune.png", "Titanspear", 750, 10, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		titanspearRune.setManaCost(30);
		titanspearRune.setDamage(100);
		
		firerainRune = new ItemType(1, "resources/items/11otherrunes/firerainRune.png", "Firerain", 750, 11, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		firerainRune.setManaCost(60);
		firerainRune.setDamage(150);
		
		transformIntoOrcWarriorRune = new ItemType(1, "resources/items/12transformrunes/transformIntoOrcWarriorRune.png", "Transform Into Orc Warrior", 750, 12, true, "rune", "resources/player_sprites/empty_sprite_sheet.png");
		transformIntoOrcWarriorRune.setManaCost(75);
		transformIntoOrcWarriorRune.setEffectDuration(30);

		
		
		

		
		healLightWoundsSpell = new ItemType(1, "resources/items/17healspells/healLightWoundsSpell.png", "Heal Light Wounds", 20, 17, true, "spell", "resources/player_sprites/weapons/magic/magicCloud.png");
		healLightWoundsSpell.setManaCost(5);
		healLightWoundsSpell.setHealthBoost(50);
		
		icelanceSpell = new ItemType(1, "resources/items/14bulletspells/icelanceSpell.png", "Icelance", 20, 14, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		icelanceSpell.setManaCost(5);
		icelanceSpell.setDamage(20);
		
		iceblockSpell = new ItemType(1, "resources/items/15otherspells/iceblockSpell.png", "Iceblock", 25, 15, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		iceblockSpell.setManaCost(10);
		
		transformIntoWolfSpell = new ItemType(1, "resources/items/16transformspells/transformIntoWolfSpell.png", "Transform Into Wolf", 30, 16, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		transformIntoWolfSpell.setManaCost(10);
		transformIntoWolfSpell.setEffectDuration(30);
		
		
		healMediumWoundsSpell = new ItemType(1, "resources/items/17healspells/healMediumWoundsSpell.png", "Heal Medium Wounds", 50, 17, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		healMediumWoundsSpell.setManaCost(10);
		healMediumWoundsSpell.setHealthBoost(200);
		
		fireballSpell = new ItemType(1, "resources/items/14bulletspells/fireballSpell.png", "Fireball", 50, 14, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		fireballSpell.setManaCost(10);
		fireballSpell.setDamage(50);
		
		bloodtheftSpell = new ItemType(1, "resources/items/15otherspells/bloodtheftSpell.png", "Bloodtheft", 75, 15, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		bloodtheftSpell.setManaCost(15);
		
		transformIntoSkeletonSpell = new ItemType(1, "resources/items/16transformspells/transformIntoSkeletonSpell.png", "Transform Into Skeleton", 75, 16, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		transformIntoSkeletonSpell.setManaCost(15);
		transformIntoSkeletonSpell.setEffectDuration(30);
		
		
		healHeavyWoundsSpell = new ItemType(1, "resources/items/17healspells/healHeavyWoundsSpell.png", "Heal Heavy Wounds", 100, 17, true, "spell", "resources/player_sprites/weapons/magic/magicCloud.png");
		healHeavyWoundsSpell.setManaCost(15);
		healHeavyWoundsSpell.setHealthBoost(400);

		titanspearSpell = new ItemType(1, "resources/items/14bulletspells/titanspearSpell.png", "Titanspear", 100, 14, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		titanspearSpell.setManaCost(15);
		titanspearSpell.setDamage(100);
		
		firerainSpell = new ItemType(1, "resources/items/15otherspells/firerainSpell.png", "Firerain", 100, 15, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		firerainSpell.setManaCost(20);
		
		transformIntoOrcWarriorSpell = new ItemType(1, "resources/items/16transformspells/transformIntoOrcWarriorSpell.png", "Transform Into Orc Warrior", 150, 16, true, "spell", "resources/player_sprites/empty_sprite_sheet.png");
		transformIntoOrcWarriorSpell.setManaCost(20);
		transformIntoOrcWarriorSpell.setEffectDuration(30);
		
		
		
		
		
		
		
		
		
		
		
		

		smallHpPotion = new ItemType(1, "resources/items/18healing_potions/small_hp_potion.png", "Small HP Potion", 20, 18, false, "hpPotion", "resources/player_sprites/empty_sprite_sheet.png");
		smallHpPotion.setHealthBoost(25);
		
		mediumHpPotion = new ItemType(1, "resources/items/18healing_potions/medium_hp_potion.png", "Medium HP Potion", 30, 18, false, "hpPotion", "resources/player_sprites/empty_sprite_sheet.png");
		mediumHpPotion.setHealthBoost(100);
		
		bigHpPotion = new ItemType(1, "resources/items/18healing_potions/big_hp_potion.png", "Big HP Potion", 40, 18, false, "hpPotion", "resources/player_sprites/empty_sprite_sheet.png");
		bigHpPotion.setHealthBoost(200);
		

		
		smallManaPotion = new ItemType(1, "resources/items/19mana_potions/small_mana_potion.png", "Small Mana Potion", 20, 19, false, "manapotion", "resources/player_sprites/empty_sprite_sheet.png");
		smallManaPotion.setManaBoost(25);
		
		mediumManaPotion = new ItemType(1, "resources/items/19mana_potions/medium_mana_potion.png", "Medium Mana Potionn", 30, 19, false, "manapotion", "resources/player_sprites/empty_sprite_sheet.png");
		mediumManaPotion.setManaBoost(100);
		
		bigManaPotion = new ItemType(1, "resources/items/19mana_potions/big_mana_potion.png", "Big Mana Potion", 40, 19, false, "manapotion", "resources/player_sprites/empty_sprite_sheet.png");
		bigManaPotion.setManaBoost(200);
		

		
		maxHpBonusPotion = new ItemType(1, "resources/items/20special_potions/max_hp_bonus_potion.png", "Max HP Bonus Potion", 250, 20, false, "specialpotion", "resources/player_sprites/empty_sprite_sheet.png");
		maxHpBonusPotion.setMaxHealthBoost(10);
		
		maxManaBonusPotion = new ItemType(1, "resources/items/20special_potions/max_mana_bonus_potion.png", "Max Mana Bonus Potion", 250, 20, false, "specialpotion", "resources/player_sprites/empty_sprite_sheet.png");
		maxManaBonusPotion.setMaxManaBoost(10);
		
		strengthPotion = new ItemType(1, "resources/items/20special_potions/strength_potion.png", "Strength Potion", 300, 20, false, "specialpotion", "resources/player_sprites/empty_sprite_sheet.png");
		strengthPotion.setStrengthBoost(5);
		
		dexterityPotion = new ItemType(1, "resources/items/20special_potions/dexterity_potion.png", "Dexterity Potion", 300, 20, false, "specialpotion", "resources/player_sprites/empty_sprite_sheet.png");
		dexterityPotion.setDexterityBoost(5);
				
		speedPotion = new ItemType(1, "resources/items/20special_potions/speed_potion.png", "Speed Potion", 200, 20, false, "specialpotion", "resources/player_sprites/empty_sprite_sheet.png");
		speedPotion.setEffectDuration(60);
		
		
		dragonroot = new ItemType(1, "resources/items/21plants/dragonroot.png", "Dragonroot", 150, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		dragonroot.setStrengthBoost(1);
		
		goblinweed = new ItemType(1, "resources/items/21plants/goblinweed.png", "Goblinweed", 150, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		goblinweed.setDexterityBoost(1);
				
		goldtruffle = new ItemType(1, "resources/items/21plants/goldtruffle.png", "Goldtruffle", 300, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");

		
		wolfnettel = new ItemType(1, "resources/items/21plants/wolfnettel.png", "Wolfnettel", 100, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		wolfnettel.setEffectDuration(10);
		
		
		healberry = new ItemType(1, "resources/items/21plants/healberry.png", "Healberry", 10, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		healberry.setHealthBoost(10);
		
		healplant = new ItemType(1, "resources/items/21plants/healplant.png", "Healplant", 15, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		healplant.setHealthBoost(20);
		
		healroot = new ItemType(1, "resources/items/21plants/healroot.png", "Healroot", 20, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		healroot.setHealthBoost(30);
		
		
		
		manaberry = new ItemType(1, "resources/items/21plants/manaberry.png", "Manaberry", 25, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		manaberry.setManaBoost(10);
		
		manaplant = new ItemType(1, "resources/items/21plants/manaplant.png", "Manaplant", 30, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		manaplant.setManaBoost(20);
		
		manaroot = new ItemType(1, "resources/items/21plants/manaroot.png", "Manaroot", 35, 21, false, "plant", "resources/player_sprites/empty_sprite_sheet.png");
		manaroot.setManaBoost(30);
		
		
		
		bread = new ItemType(1, "resources/items/22food/bread.png", "Bread", 20, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		bread.setHealthBoost(5);
		
		carrot = new ItemType(1, "resources/items/22food/carrot.png", "Carrot", 6, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		carrot.setHealthBoost(5);
		
		rawChicken = new ItemType(1, "resources/items/22food/raw_chicken.png", "Raw Chicken", 33, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		rawChicken.setHealthBoost(5);
		
		cookedChicken = new ItemType(1, "resources/items/22food/cooked_chicken.png", "Cooked Chicken", 33, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		cookedChicken.setHealthBoost(10);
		
		rawFish = new ItemType(1, "resources/items/22food/raw_fish.png", "Raw Fish", 26, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		rawFish.setHealthBoost(5);
		
		cookedFish = new ItemType(1, "resources/items/22food/cooked_fish.png", "Cooked Fish", 26, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		cookedFish.setHealthBoost(10);
		
		rawMeat = new ItemType(1, "resources/items/22food/raw_meat.png", "Raw Meat", 38, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		rawMeat.setHealthBoost(5);
		
		cookedMeat = new ItemType(1, "resources/items/22food/cooked_meat.png", "Cooked Meat", 38, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		cookedMeat.setHealthBoost(10);
		
		rawPork = new ItemType(1, "resources/items/22food/raw_pork.png", "Raw Pork", 29, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		rawPork.setHealthBoost(5);
		
		cookedPork = new ItemType(1, "resources/items/22food/cooked_pork.png", "Cooked Pork", 29, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		cookedPork.setHealthBoost(10);
		
		wheat = new ItemType(1, "resources/items/22food/wheat.png", "Wheat", 4, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		wheat.setHealthBoost(5);
		
		apple = new ItemType(1, "resources/items/22food/apple.png", "Apple", 5, 22, false, "food", "resources/player_sprites/empty_sprite_sheet.png");
		apple.setHealthBoost(5);
		
		
		
		bone = new ItemType(1, "resources/items/23misc/bone.png", "Bone", 3, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		ironBar = new ItemType(1, "resources/items/23misc/iron_bar.png", "Iron Bar", 160, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		goldenBar = new ItemType(1, "resources/items/23misc/gold_bar.png", "Golden Bar", 250, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		mithrilBar = new ItemType(1, "resources/items/23misc/mithril_bar.png", "Mithril Bar", 350, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		feather = new ItemType(1, "resources/items/23misc/feather.png", "Feather", 3, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		treasureChest = new ItemType(1, "resources/items/23misc/treasure_chest.png", "Treasure Chest", 320, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		goldCrown = new ItemType(1, "resources/items/23misc/gold_crown.png", "Gold Crown", 280, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		treasure = new ItemType(1, "resources/items/23misc/treasure.png", "Treasure", 280, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		multipleSticks = new ItemType(1, "resources/items/23misc/multiple_sticks.png", "Multiple Sticks", 5, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		trophy = new ItemType(1, "resources/items/23misc/trophy.png", "Trophy", 250, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");

		
		chrystal = new ItemType(1, "resources/items/23misc/chrystal.png", "Chrystal", 50, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		icecube = new ItemType(1, "resources/items/23misc/icecube.png", "Icecube", 10, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		wolfHide = new ItemType(1, "resources/items/23misc/wolfHide.png", "Wolf Hide", 40, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		smaragd = new ItemType(1, "resources/items/23misc/smaragd.png", "Smaragd", 80, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		aquamarine = new ItemType(1, "resources/items/23misc/aquamarine.png", "Aquamarine", 80, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		pitch = new ItemType(1, "resources/items/23misc/pitch.png", "Pitch", 20, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		sulfur = new ItemType(1, "resources/items/23misc/sulfur.png", "Sulfur", 10, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		orcTooth = new ItemType(1, "resources/items/23misc/orcTooth.png", "Orc Tooth", 150, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		heart = new ItemType(1, "resources/items/23misc/heart.png", "Heart", 200, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		
		
		smallBottle = new ItemType(1, "resources/items/23misc/small_bottle.png", "Small Bottle", 10, 23, false, "misc", "resources/player_sprites/empty_sprite_sheet.png");
		
		ogusChrystal = new ItemType(1, "resources/items/25quest_items/ogusChrystal.png", "Ogus Chrystal", 10, 25, false, "quest_item", "resources/player_sprites/empty_sprite_sheet.png");
				
		gold = new ItemType(100, "resources/items/26gold/goldcoin.png", "Gold", 1, 26, false, "gold", "resources/player_sprites/empty_sprite_sheet.png");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		stick.setAttackUpCollisionBox(new CollisionBox(0, 0, 80, 29));
		stick.setAttackDownCollisionBox(new CollisionBox(0, 0, 80, 29));
		stick.setAttackLeftCollisionBox(new CollisionBox(0, 0, 20, 36));
		stick.setAttackRightCollisionBox(new CollisionBox(0, 0, 20, 36));
		
		stick.setAttackUpOffsetX(-23);
		stick.setAttackUpOffsetY(-28);
		
		stick.setAttackDownOffsetX(-23);
		stick.setAttackDownOffsetY(+12);
		
		stick.setAttackLeftOffsetX(-19);
		stick.setAttackLeftOffsetY(-16);
		
		stick.setAttackRightOffsetX(+31);
		stick.setAttackRightOffsetY(-16);
		
		
		
		dagger.setAttackUpCollisionBox(new CollisionBox(0, 0, 46, 17));
		dagger.setAttackDownCollisionBox(new CollisionBox(0, 0, 46, 17));
		dagger.setAttackLeftCollisionBox(new CollisionBox(0, 0, 18, 36));
		dagger.setAttackRightCollisionBox(new CollisionBox(0, 0, 18, 36));
		
		dagger.setAttackUpOffsetX(-7);
		dagger.setAttackUpOffsetY(-16);
		
		dagger.setAttackDownOffsetX(-12);
		dagger.setAttackDownOffsetY(+6);
		
		dagger.setAttackLeftOffsetX(-17);
		dagger.setAttackLeftOffsetY(-16);
		
		dagger.setAttackRightOffsetX(+31);
		dagger.setAttackRightOffsetY(-16);
		
		
		
		mace.setAttackUpCollisionBox(new CollisionBox(0, 0, 80, 29));
		mace.setAttackDownCollisionBox(new CollisionBox(0, 0, 80, 29));
		mace.setAttackLeftCollisionBox(new CollisionBox(0, 0, 31, 36));
		mace.setAttackRightCollisionBox(new CollisionBox(0, 0, 31, 36));
		
		mace.setAttackUpOffsetX(-23);
		mace.setAttackUpOffsetY(-28);
		
		mace.setAttackDownOffsetX(-23);
		mace.setAttackDownOffsetY(+12);
		
		mace.setAttackLeftOffsetX(-30);
		mace.setAttackLeftOffsetY(-16);
		
		mace.setAttackRightOffsetX(+31);
		mace.setAttackRightOffsetY(-16);
		
		
		
		ironsword.setAttackUpCollisionBox(new CollisionBox(0, 0, 89, 45));
		ironsword.setAttackDownCollisionBox(new CollisionBox(0, 0, 89, 45));
		ironsword.setAttackLeftCollisionBox(new CollisionBox(0, 0, 68, 36));
		ironsword.setAttackRightCollisionBox(new CollisionBox(0, 0, 68, 36));

		ironsword.setAttackUpOffsetX(-28);
		ironsword.setAttackUpOffsetY(-37);
		
		ironsword.setAttackDownOffsetX(-28);
		ironsword.setAttackDownOffsetY(+12);
		
		ironsword.setAttackLeftOffsetX(-67);
		ironsword.setAttackLeftOffsetY(-16);
		
		ironsword.setAttackRightOffsetX(+31);
		ironsword.setAttackRightOffsetY(-16);

		
		
		goldensword.setAttackUpCollisionBox(new CollisionBox(0, 0, 89, 45));
		goldensword.setAttackDownCollisionBox(new CollisionBox(0, 0, 89, 45));
		goldensword.setAttackLeftCollisionBox(new CollisionBox(0, 0, 68, 36));
		goldensword.setAttackRightCollisionBox(new CollisionBox(0, 0, 68, 36));
		
		goldensword.setAttackUpOffsetX(-28);
		goldensword.setAttackUpOffsetY(-37);
		
		goldensword.setAttackDownOffsetX(-28);
		goldensword.setAttackDownOffsetY(+12);
		
		goldensword.setAttackLeftOffsetX(-67);
		goldensword.setAttackLeftOffsetY(-16);
		
		goldensword.setAttackRightOffsetX(+31);
		goldensword.setAttackRightOffsetY(-16);	
		
		
		
		
		mithrilsword.setAttackUpCollisionBox(new CollisionBox(0, 0, 89, 45));
		mithrilsword.setAttackDownCollisionBox(new CollisionBox(0, 0, 89, 45));
		mithrilsword.setAttackLeftCollisionBox(new CollisionBox(0, 0, 68, 36));
		mithrilsword.setAttackRightCollisionBox(new CollisionBox(0, 0, 68, 36));
		
		mithrilsword.setAttackUpOffsetX(-28);
		mithrilsword.setAttackUpOffsetY(-37);
		
		mithrilsword.setAttackDownOffsetX(-28);
		mithrilsword.setAttackDownOffsetY(+12);
		
		mithrilsword.setAttackLeftOffsetX(-67);
		mithrilsword.setAttackLeftOffsetY(-16);
		
		mithrilsword.setAttackRightOffsetX(+31);
		mithrilsword.setAttackRightOffsetY(-16);	
		
		
		
		
		blacksword.setAttackUpCollisionBox(new CollisionBox(0, 0, 89, 45));
		blacksword.setAttackDownCollisionBox(new CollisionBox(0, 0, 89, 45));
		blacksword.setAttackLeftCollisionBox(new CollisionBox(0, 0, 68, 36));
		blacksword.setAttackRightCollisionBox(new CollisionBox(0, 0, 68, 36));
		
		blacksword.setAttackUpOffsetX(-28);
		blacksword.setAttackUpOffsetY(-37);
		
		blacksword.setAttackDownOffsetX(-28);
		blacksword.setAttackDownOffsetY(+12);
		
		blacksword.setAttackLeftOffsetX(-67);
		blacksword.setAttackLeftOffsetY(-16);
		
		blacksword.setAttackRightOffsetX(+31);
		blacksword.setAttackRightOffsetY(-16);
		
		
		
		
		sabre.setAttackUpCollisionBox(new CollisionBox(0, 0, 85, 29));
		sabre.setAttackDownCollisionBox(new CollisionBox(0, 0, 85, 29));
		sabre.setAttackLeftCollisionBox(new CollisionBox(0, 0, 31, 36));
		sabre.setAttackRightCollisionBox(new CollisionBox(0, 0, 31, 36));
		
		sabre.setAttackUpOffsetX(-23);
		sabre.setAttackUpOffsetY(-32);
		
		sabre.setAttackDownOffsetX(-23);
		sabre.setAttackDownOffsetY(+12);
		
		sabre.setAttackLeftOffsetX(-30);
		sabre.setAttackLeftOffsetY(-16);
		
		sabre.setAttackRightOffsetX(+31);
		sabre.setAttackRightOffsetY(-16);
		
		
		
		
		rapier.setAttackUpCollisionBox(new CollisionBox(0, 0, 89, 45));
		rapier.setAttackDownCollisionBox(new CollisionBox(0, 0, 89, 45));
		rapier.setAttackLeftCollisionBox(new CollisionBox(0, 0, 68, 36));
		rapier.setAttackRightCollisionBox(new CollisionBox(0, 0, 68, 36));
		
		rapier.setAttackUpOffsetX(-28);
		rapier.setAttackUpOffsetY(-37);
		
		rapier.setAttackDownOffsetX(-28);
		rapier.setAttackDownOffsetY(+12);
		
		rapier.setAttackLeftOffsetX(-67);
		rapier.setAttackLeftOffsetY(-16);
		
		rapier.setAttackRightOffsetX(+31);
		rapier.setAttackRightOffsetY(-16);
		
		
		
		
		
		
		mithrilrapier.setAttackUpCollisionBox(new CollisionBox(0, 0, 89, 45));
		mithrilrapier.setAttackDownCollisionBox(new CollisionBox(0, 0, 89, 45));
		mithrilrapier.setAttackLeftCollisionBox(new CollisionBox(0, 0, 68, 36));
		mithrilrapier.setAttackRightCollisionBox(new CollisionBox(0, 0, 68, 36));
		
		mithrilrapier.setAttackUpOffsetX(-28);
		mithrilrapier.setAttackUpOffsetY(-37);
		
		mithrilrapier.setAttackDownOffsetX(-28);
		mithrilrapier.setAttackDownOffsetY(+12);
		
		mithrilrapier.setAttackLeftOffsetX(-67);
		mithrilrapier.setAttackLeftOffsetY(-16);
		
		mithrilrapier.setAttackRightOffsetX(+31);
		mithrilrapier.setAttackRightOffsetY(-16);	

		
		
		shortspear.setAttackUpCollisionBox(new CollisionBox(0, 0, 50, 36));
		shortspear.setAttackDownCollisionBox(new CollisionBox(0, 0, 50, 36));
		shortspear.setAttackLeftCollisionBox(new CollisionBox(0, 0, 20, 5));
		shortspear.setAttackRightCollisionBox(new CollisionBox(0, 0, 20, 5));
		
		shortspear.setAttackUpOffsetX(+20);
		shortspear.setAttackUpOffsetY(-35);
		
		shortspear.setAttackDownOffsetX(+13);
		shortspear.setAttackDownOffsetY(+12);
		
		shortspear.setAttackLeftOffsetX(-19);
		shortspear.setAttackLeftOffsetY(+11);
		
		shortspear.setAttackRightOffsetX(+31);
		shortspear.setAttackRightOffsetY(+11);	
		
		
		
		longspear.setAttackUpCollisionBox(new CollisionBox(0, 0, 50, 73));
		longspear.setAttackDownCollisionBox(new CollisionBox(0, 0, 50, 73));
		longspear.setAttackLeftCollisionBox(new CollisionBox(0, 0, 59, 5));
		longspear.setAttackRightCollisionBox(new CollisionBox(0, 0, 59, 5));
		
		longspear.setAttackUpOffsetX(+22);
		longspear.setAttackUpOffsetY(-72);
		
		longspear.setAttackDownOffsetX(+14);
		longspear.setAttackDownOffsetY(+12);
		
		longspear.setAttackLeftOffsetX(-58);
		longspear.setAttackLeftOffsetY(+11);
		
		longspear.setAttackRightOffsetX(+31);
		longspear.setAttackRightOffsetY(+11);	
		
		
		
		mithrilspear.setAttackUpCollisionBox(new CollisionBox(0, 0, 50, 78));
		mithrilspear.setAttackDownCollisionBox(new CollisionBox(0, 0, 50, 78));
		mithrilspear.setAttackLeftCollisionBox(new CollisionBox(0, 0, 65, 11));
		mithrilspear.setAttackRightCollisionBox(new CollisionBox(0, 0, 65, 11));
		
		mithrilspear.setAttackUpOffsetX(+20);
		mithrilspear.setAttackUpOffsetY(-77);
		
		mithrilspear.setAttackDownOffsetX(+11);
		mithrilspear.setAttackDownOffsetY(+12);
		
		mithrilspear.setAttackLeftOffsetX(-64);
		mithrilspear.setAttackLeftOffsetY(+8);
		
		mithrilspear.setAttackRightOffsetX(+31);
		mithrilspear.setAttackRightOffsetY(+8);	
		
		
		
		goldenspear.setAttackUpCollisionBox(new CollisionBox(0, 0, 50, 78));
		goldenspear.setAttackDownCollisionBox(new CollisionBox(0, 0, 50, 78));
		goldenspear.setAttackLeftCollisionBox(new CollisionBox(0, 0, 65, 19));
		goldenspear.setAttackRightCollisionBox(new CollisionBox(0, 0, 65, 19));
		
		goldenspear.setAttackUpOffsetX(+20);
		goldenspear.setAttackUpOffsetY(-77);
		
		goldenspear.setAttackDownOffsetX(+11);
		goldenspear.setAttackDownOffsetY(+12);
		
		goldenspear.setAttackLeftOffsetX(-64);
		goldenspear.setAttackLeftOffsetY(+8);
		
		goldenspear.setAttackRightOffsetX(+31);
		goldenspear.setAttackRightOffsetY(+8);	
		

		
		

		
		
		
	}

}
