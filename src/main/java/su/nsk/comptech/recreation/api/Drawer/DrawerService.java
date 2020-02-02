package su.nsk.comptech.recreation.api.Drawer;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 * Используется для раскрашивания заготовленного шаблона этажа
 * в зависимости от загруженности рекреационных зон
 */

public class DrawerService {
    private static String floorToString(final int floor) {
        if (floor != 3 && floor != 4) {
            throw new RuntimeException("Incorrect floor found while loading properties. Expected 3 or 4, received " + floor);
        }
        return floor == 3 ? "third" : "fourth";
    }

    public static void colorizeBuilding(final List<Integer> floors) {
        for (int floor : floors) {
            String floorNumber = floorToString(floor);
            List<DrawerArea> areas = AreaPropertiesLoader.loadProperties(floorNumber);
            colorizeFloor(areas, floorNumber);
        }
    }

    private static void colorizeFloor(List<DrawerArea> areas, final String floorNumber) {
        try {
            File file = new File("pictures/" + floorNumber + "_template.jpg");
            BufferedImage image = ImageIO.read(file);

            for (DrawerArea area: areas) {
                colorizeArea(image, 25, area);
            }

            File output = new File("pictures/" + floorNumber + ".jpg");
            ImageIO.write(image, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void colorizeArea(BufferedImage image, int percentage, DrawerArea area) throws IOException {
        if (percentage < 0 || percentage > 100)
            throw new RuntimeException("wrong percentage");
        File file = new File("pictures/gradient.jpg");
        BufferedImage gradient = ImageIO.read(file);
        int[] arrayColor = new int[area.width];
        for (int i = 0; i < area.width; ++i) {
            arrayColor[i] = Color.RED.getRGB();
            arrayColor[i] = gradient.getRGB(percentage,0);
        }
        image.setRGB(area.startX, area.startY, area.width, area.height, arrayColor, 0, 0);
    }
}
