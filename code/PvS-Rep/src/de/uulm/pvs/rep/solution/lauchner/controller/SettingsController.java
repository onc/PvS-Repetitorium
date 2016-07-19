package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;
import de.uulm.pvs.rep.solution.lauchner.widgets.SettingsWidget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

/**
 * Controller for the settings.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class SettingsController implements ActionListener {

  private SettingsWidget settingsWidget;

  public SettingsController() {
    this.settingsWidget = new SettingsWidget();
  }

  // FIXME: implement
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

  /**
   * TODO documentation.
   * 
   * @param userName - name of the user
   */
  public void updateUi(String userName, List<String> highscores) {
    settingsWidget.setNameField(userName);
  }

  /**
   * TODO documentation.
   * 
   * @return - the name of the user
   */
  public String getUsername() {

    return "";
  }

  public JPanel getSettingsWidget() {
    return settingsWidget;
  }

}
