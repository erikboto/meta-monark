DESCRIPTION = "Monark-ANT image"

require recipes-core/image/core-image-qtipi-wifi-client.bb

# Packages
IMAGE_INSTALL += " \
    monarkant \
    rpi-gpio \
    rpio \
    python-pygobject \
    python-dbus \
    "
