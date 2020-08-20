package relt.ewethratemod.lists;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import relt.ewethratemod.EwethrateMod;

public enum ArmourMaterialList implements IArmorMaterial
{
    ewethrate("ewethrate", 400, new int[] {8, 10, 9, 7}, 25, ItemList.ewethrate_shard, "entity.ender_dragon.growl", 0.0f);

    private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
    private String name, equipSound;
    private int durability, enchantability;
    private int[] damageReductionAmount;
    private float toughness;
    private Item repairMaterial;

    ArmourMaterialList(String name, int durability, int[] damageReductionAmount,
                       int enchantability, Item repairMaterial, String equipSound,
                       float toughness)
    {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
        this.equipSound = equipSound;
        this.toughness = toughness;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return max_damage_array[slotIn.getIndex()] * this.durability;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmount[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(this.equipSound));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }

    @Override
    public String getName() {
        return EwethrateMod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }


}
