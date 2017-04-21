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

    boolean geocode(Position position);

    boolean reverseGeocode(Position position);

}
