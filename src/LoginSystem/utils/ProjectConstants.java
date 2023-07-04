package LoginSystem.utils;

import LoginSystem.LoginFrame;

public interface ProjectConstants {
	String TITLE = ConfigReader.getValue("login.title");
	int FHEIGHT = Integer.parseInt(ConfigReader.getValue("login.hiegth"));
	int FWIDTH = Integer.parseInt(ConfigReader.getValue("login.width"));
    int PanelX = 500;
    int PanelY = FHEIGHT - 780;
}
