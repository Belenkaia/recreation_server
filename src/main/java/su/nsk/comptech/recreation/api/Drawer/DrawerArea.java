package su.nsk.comptech.recreation.api.Drawer;
/*
 * Класс, представляющий зону для последующей раскраски
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class
DrawerArea {
    int startX, startY, width, height, percentage; // TODO: add socketPercenage and divide responsibilities
    String areaName;

    DrawerArea(int start_x, int start_y, int _width, int _height, int _percentage, String _areaName) {
        if (start_x < 0 || start_y < 0 || _width <= 0 || _height <= 0)
            throw new RuntimeException("Incorrect usage of su.nsk.comptech.recreation.api.Drawer.DrawerArea constructor: non-positive values are forbidden");
        startX = start_x;
        startY = start_y;
        width = _width;
        height = _height;
        percentage = _percentage;
        areaName = _areaName;
    }
}
