DESCRIPTION = "Monark-ANT image"

inherit core-image populate_sdk_qt5
IMAGE_FEATURES += "package-management ssh-server-openssh tools-debug"

# Reduce amount of extra space
IMAGE_ROOTFS_EXTRA_SPACE = "200000"

# System tools
IMAGE_INSTALL += " \
    systemd-analyze \
    openssh-sftp-server \
    avahi-daemon \
    vim \
    network-config-wifi-client \
"

# Packages
IMAGE_INSTALL += " \
    monarkant \
    buttonreader \
"

