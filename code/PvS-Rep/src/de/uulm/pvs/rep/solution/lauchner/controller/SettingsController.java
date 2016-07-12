package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class SettingsController implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent event) {

    switch (event.getActionCommand()) {
      case ActionConstants.IMPORT_SETTINGS:
        System.out.println("import");
        break;

      case ActionConstants.EXPORT_SETTINGS:
        System.out.println("export");
        break;

      default:
        break;
    }

  }

}
