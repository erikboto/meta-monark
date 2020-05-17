DESCRIPTION = "Monark to ANT bridge"
LICENSE = "GPLv2"
DEPENDS = "qtbase qtserialport qtconnectivity libusb-compat"
RDEPENDS_${PN} += "dbus-session"
inherit qmake5 systemd 

include common.inc

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_SERVICE_${PN} = "monarkant.service"

SRC_URI += " \
	file://monarkant.service \
	"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=17;md5=6d8c6f591a945f049d346ff1cb438f24"

S = "${WORKDIR}/git/"
EXTRA_QMAKEVARS_PRE += "-config raspberry-pi"

do_install() {
	install -Dm0755 ${B}/Monark-ANT ${D}/usr/bin/Monark-ANT
	install -Dm0644 ${WORKDIR}/monarkant.service ${D}/${systemd_unitdir}/system/monarkant.service
}

FILES_${PN} += " \
	/lib/systemd/ \
	"
