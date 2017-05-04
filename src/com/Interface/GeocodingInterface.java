package com.Interface;

import com.Position;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public interface GeocodingInterface {

    /**
     * @param position
     *
     * @return True if the positions object was successfully geocoded, otherwise false.
     */
    boolean geocode(Position position);

    /**
     * @param position
     *
     * @return
     */
    boolean reverseGeocode(Position position);

}
