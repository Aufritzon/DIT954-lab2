package application.view;

import application.model.world.DrawableWorld;

public interface View {
    void repaintView();
    void updateView(DrawableWorld world);
}
