package com.luisz.lj.game.panel;

import com.luisz.lj.game.component.renderer.IRender;
import com.luisz.lj.game.configuration.LPanelConfiguration;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LPanel extends JPanel {
    private final List<IRender> renders = new ArrayList<>();
    public final void addRender(IRender render){
        this.renders.add(render);
    }
    public final boolean removeRender(IRender render){
        return this.renders.remove(render);
    }
    public final boolean contains(IRender render){
        return this.renders.contains(render);
    }

    protected Graphics g;

    public LPanel(LPanelConfiguration configuration){
        this.setPreferredSize(new Dimension(configuration.screenWidth, configuration.screenHeight));
        this.setDoubleBuffered(configuration.doubleBuffered);
        this.setFocusable(configuration.focusable);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        for(int i = 0; i < renders.size(); i++){
            renders.get(i).render();
        }

        g.dispose();
    }
}