package su.nsk.comptech.recreation.api.Drawer;
/*
 * Класс, представляющий зону для последующей раскраски
 */

class DrawerArea {
    int startX, startY, width, height;
    DrawerArea(int start_x, int start_y, int _width, int _height) {
        if (start_x < 0 || start_y < 0 || _width <= 0 || _height <= 0)
            throw new RuntimeException("Incorrect usage of su.nsk.comptech.recreation.api.Drawer.DrawerArea constructor: non-positive values are forbidden");
        startX = start_x;
        startY = start_y;
        width = _width;
        height = _height;
    }
}
