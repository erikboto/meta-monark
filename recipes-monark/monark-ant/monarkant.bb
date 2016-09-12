DESCRIPTION = "Monark to ANT bridge"
LICENSE = "GPLv2"
DEPENDS = "qtbase qtserialport"

inherit qmake5 systemd 

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_SERVICE_${PN} = "monarkant.service"

SRC_URI = " \
	git://git@git.unixshell.se/erbo/monark-ant.git;protocol=ssh \
	file://monarkant.service \
	"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=17;md5=yyyy"


S = "${WORKDIR}/git/"

SRCREV = "696785fae5e8b51fb7300dca45915bbf5bc5bb79"

do_install() {
	install -Dm0755 ${B}/Monark-ANT ${D}/usr/bin/Monark-ANT
	install -Dm0644 ${WORKDIR}/monarkant.service ${D}/${systemd_unitdir}/system/monarkant.service
}

FILES_${PN} += " \
	/lib/systemd/ \
	"
