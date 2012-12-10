package ChristmasMod.common;

import net.minecraft.src.*;

public class EntitySanta extends EntityGolem implements IRangedAttackMob
{

	public EntitySanta(World par1World) {
		super(par1World);
		this.texture = "/ChristmasMod/Santa.png";
		this.moveSpeed = 0.25F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new EntityAIWander(this, 0.25F));
		this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.25F, 20, 10.0F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 16.0F, 0, true, false, IMob.mobSelector));
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
	@Override
	public void attackEntityWithRangedAttack(EntityLiving par1EntityLiving) 
	{
		EntitySnowball var2 = new EntitySnowball(this.worldObj, this);
        double var3 = par1EntityLiving.posX - this.posX;
        double var5 = par1EntityLiving.posY + (double)par1EntityLiving.getEyeHeight() - 1.100000023841858D - var2.posY;
        double var7 = par1EntityLiving.posZ - this.posZ;
        float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
        var2.setThrowableHeading(var3, var5 + (double)var9, var7, 1.6F, 12.0F);
        this.func_85030_a("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var2);
	}

}
