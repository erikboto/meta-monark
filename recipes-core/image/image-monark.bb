DESCRIPTION = "Monark-ANT image"

require recipes-core/image/core-image-qtipi-wifi-client.bb

# Reduce amount of extra space
IMAGE_ROOTFS_EXTRA_SPACE = "200000"

# Packages
IMAGE_INSTALL += " \
    monarkant \
    rpi-gpio \
    rpio \
    python-pygobject \
    python-dbus \
"

# Remove some packages to reduce image size
IMAGE_INSTALL_remove = " \
    qtmultimedia \
    qtwebengine \
    qtsensors \
    qtlocation \
    qt3d \
"
