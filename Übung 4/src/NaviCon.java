public class NaviCon implements NaviConInterface {

    private GeoLocationManager geoManager;

    @Override
    public void setGeoLocationManager(GeoLocationManager geoManager) {
        this.geoManager = geoManager;
    }

    @Override
    public Point getCurrentPosition() throws InstantiationException, NullPointerException {
        if (geoManager == null)
            throw new NullPointerException("NeoGeoManager");

        try {
            return geoManager.currentLocation().moved(1, -1);
        } catch (IllegalAccessException e) {
            return this.getCurrentPosition();
        }
    }
}
