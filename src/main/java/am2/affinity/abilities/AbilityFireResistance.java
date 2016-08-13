package am2.affinity.abilities;

import am2.api.affinity.AbstractAffinityAbility;
import am2.api.affinity.Affinity;
import am2.extensions.AffinityData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class AbilityFireResistance extends AbstractAffinityAbility {

	public AbilityFireResistance() {
		super(new ResourceLocation("arsmagica2", "fireresistance"));
	}

	@Override
	protected float getMinimumDepth() {
		return 0f;
	}

	@Override
	protected Affinity getAffinity() {
		return Affinity.FIRE;
	}
	
	@Override
	public void applyHurt(EntityPlayer player, LivingHurtEvent event, boolean isAttacker) {
		if (!isAttacker && event.getSource().isFireDamage()) {
			float fireDepth = AffinityData.For(player).getAffinityDepth(Affinity.FIRE);
			float reduction = 1 - (0.6f * fireDepth);
			event.setAmount(event.getAmount() * reduction);
		}
	}
}
