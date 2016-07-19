package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public interface GameSettingsChangeListener {

  public void presetChanged(PresetDto preset, PlayerDto player);
}
