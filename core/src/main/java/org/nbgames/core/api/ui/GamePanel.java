/*
 * Copyright 2016 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nbgames.core.api.ui;

import java.awt.LayoutManager;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Patrik Karlsson
 */
public abstract class GamePanel extends JPanel {

    public GamePanel() {
        super();
        init();
    }

    public GamePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        init();
    }

    public GamePanel(LayoutManager layout) {
        super(layout);
        init();
    }

    public GamePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        init();
    }

    public void centerInParent() {
        JComponent topPanel = (JComponent) getParent();
        if (topPanel != null && topPanel.getHeight() > 0 && topPanel.getWidth() > 0) {
        }
    }

    private void init() {

        addHierarchyBoundsListener(new HierarchyBoundsListener() {

            @Override
            public void ancestorMoved(HierarchyEvent evt) {
            }

            @Override
            public void ancestorResized(HierarchyEvent evt) {
                centerInParent();
            }
        });
    }

    public abstract void newGame();
}
