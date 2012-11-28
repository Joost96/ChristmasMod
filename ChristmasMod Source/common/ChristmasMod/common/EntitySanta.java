package ChristmasMod.common;

import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityMob;
import net.minecraft.src.World;

public class EntitySanta extends EntityMob
{

	public EntitySanta(World par1World) {
		super(par1World);
		this.texture = "/ChristmasMod/Santa.png";
		this.moveSpeed = 0.25F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new EntityAIWander(this, 0.25F));
	}
	protected boolean isAIEnabled()
	{
		return true;
	}
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}

	protected String getHurtSound()
	{
		return "mob.zombie.hurt";
	}

	protected String getDeathSound()
	{
		return "mob.zombie.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.worldObj.playSoundAtEntity(this, "mob.zombie.step", 0.15F, 1.0F);
	}

	@Override
	public int getMaxHealth() {
		return 20;
	}

}
