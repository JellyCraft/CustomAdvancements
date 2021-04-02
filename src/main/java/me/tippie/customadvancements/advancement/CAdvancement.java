package me.tippie.customadvancements.advancement;

import lombok.Getter;
import lombok.val;
import me.tippie.customadvancements.CustomAdvancements;
import me.tippie.customadvancements.advancement.reward.AdvancementReward;
import me.tippie.customadvancements.advancement.types.AdvancementType;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.UUID;

/**
 * Represents an advancement in this plugin
 */
public class CAdvancement {
	/**
	 * The {@link AdvancementType} of this advancement.
	 */
	@Getter private final AdvancementType type;

	/**
	 * The progress required to complete this advancement
	 */
	@Getter private final int maxProgress;

	/**
	 * The label of this advancement
	 */
	@Getter private final String label;

	/**
	 * The rewards when completing this advancement
	 */
	@Getter private final List<AdvancementReward> rewards;

	/**
	 * Creates a new {@link CAdvancement}
	 *
	 * @param type        String of the type of this advancement
	 * @param maxProgress integer of the progress required to complete this advancement
	 * @param label       String of the label of this advancement
	 */
	CAdvancement(final String type, final int maxProgress, final String label, final List<AdvancementReward> rewards) {
		this.type = CustomAdvancements.getAdvancementManager().getAdvancementType(type);
		this.maxProgress = maxProgress;
		this.label = label;
		this.rewards = rewards;
	}

	/**
	 * Executes the completed actions for this advancement
	 *
	 * @param uuid      UUID of player who completed the advancement
	 * @param treeLabel label of the tree this advancement belongs to
	 */
	public void complete(final UUID uuid, final String treeLabel) {
		val player = Bukkit.getPlayer(uuid);
		assert player != null;
		for (final AdvancementReward reward : rewards) {
			reward.onComplete(player);
		}
	}
}
