package com.luisz.lj.game.panel;

import com.luisz.lj.game.configuration.LPanelConfiguration;

import javax.swing.*;
import java.awt.*;

public class LPanel extends JPanel {
    public LPanel(LPanelConfiguration configuration){
        this.setPreferredSize(new Dimension(configuration.screenWidth, configuration.screenHeight));
        this.setDoubleBuffered(configuration.doubleBuffered);
        this.setFocusable(configuration.focusable);
    }
}