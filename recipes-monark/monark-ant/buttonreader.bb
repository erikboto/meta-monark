DESCRIPTION = "Monark GPIO Button Reader"
LICENSE = "GPLv2"
inherit systemd 

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_SERVICE_${PN} = "buttonreader.service"

require common.inc
SRC_URI += "file://buttonreader.service"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=17;md5=6d8c6f591a945f049d346ff1cb438f24"

S = "${WORKDIR}/git/"

do_install() {
	install -Dm0755 ${S}/buttonreader/buttonreader.py ${D}/usr/bin/buttonreader.py
	install -Dm0644 ${WORKDIR}/buttonreader.service ${D}/${systemd_unitdir}/system/buttonreader.service
}

FILES_${PN} += " \
	/lib/systemd/ \
"

RDEPENDS_${PN} += "python3-core python3-dbus python3-pyserial python3-pygobject"
