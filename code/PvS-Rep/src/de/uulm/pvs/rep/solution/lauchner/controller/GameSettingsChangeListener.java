package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;

/**
 * Listener used to listen for changes in the games-settings.
 *
 * @author Christian van Onzenoodt
 *
 */
public interface GameSettingsChangeListener {

  /**
   * Selected preset has changed.
   * 
   * @param preset - the new preset
   */
  public void presetChanged(PresetDto preset);

  /**
   * Selected player has changed.
   * 
   * @param player - the new player
   */
  public void playerChanged(PlayerDto player);
}
