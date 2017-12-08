DESCRIPTION = "Monark-ANT image"

inherit core-image

IMAGE_FEATURES += "package-management ssh-server-dropbear tools-debug"

# Qt Packages
IMAGE_INSTALL += " \
    qtbase \
    qtbase-plugins \
    liberation-fonts \
    qtdeclarative \
    monarkant \
    rpi-gpio \
    rpio \
    python-pygobject \
    python-dbus \
    buttonreader \
    "
