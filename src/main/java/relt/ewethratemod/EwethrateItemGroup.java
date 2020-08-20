package relt.ewethratemod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import relt.ewethratemod.lists.ItemList;

public class EwethrateItemGroup extends ItemGroup
{
    public EwethrateItemGroup()
    {
        super("ewethrate");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(ItemList.ewethrate_shard);
    }
}
