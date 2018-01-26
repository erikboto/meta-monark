DESCRIPTION = "DBus user session"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://dbus-session@.service"

S = "${WORKDIR}"

DEPENDS = "systemd dbus"

inherit systemd

do_install() {
    install -Dm0644 ${S}/dbus-session@.service ${D}/${systemd_unitdir}/system/dbus-session@.service
}

SYSTEMD_SERVICE_${PN}="dbus-session@.service"
SYSTEMD_AUTO_ENABLE = "disable"
