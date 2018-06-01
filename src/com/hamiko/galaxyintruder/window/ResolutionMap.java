package com.hamiko.galaxyintruder.window;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class ResolutionMap {

    private Map<Resolution, Dimension> resolutions = new HashMap<>();

    ResolutionMap() {

        resolutions.put(Resolution._270p, new Dimension(480, 270));
        resolutions.put(Resolution._480p, new Dimension(640, 480));
        resolutions.put(Resolution._520p, new Dimension(924, 520));
        resolutions.put(Resolution._720p, new Dimension(1280, 720));
        resolutions.put(Resolution._1080p, new Dimension(1920, 1080));
        resolutions.put(Resolution._2160p, new Dimension(3840, 2160));//TODO buggy

    }

    Dimension getResolution(Resolution res) {
        return resolutions.get(res);
    }

}
