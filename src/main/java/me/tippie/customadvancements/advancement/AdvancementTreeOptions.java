package me.tippie.customadvancements.advancement;

import lombok.Getter;
import me.tippie.customadvancements.advancement.reward.AdvancementReward;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Represents the options of an AdvancementTree
 *
 * @see AdvancementTree
 */
@Getter
public class AdvancementTreeOptions {

	/**
	 * Should advancements where the requirements are met automatically be activated once the requirements are met?
	 */
	private final boolean autoActive;

	/**
	 * Type of reward this tree would grant the user on full completion
	 */
	private final List<AdvancementReward> rewards;

	/**
	 * The location of this tree in the tree GUI
	 */
	private final String guiLocation;


	public AdvancementTreeOptions(final boolean autoActive, final String guiLocation, final List<AdvancementReward> rewards) {
		this.autoActive = autoActive;
		this.rewards = rewards;
		this.guiLocation = guiLocation;
	}

	public void onComplete(final Player player) {
		for (final AdvancementReward reward : rewards) {
			reward.onComplete(player);
		}
	}
}
