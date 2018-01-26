DESCRIPTION = "Monark GPIO Button Reader"
LICENSE = "GPLv2"
RDEPENDS_${PN} = "python python-pygobject"

inherit systemd 

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_SERVICE_${PN} = "buttonreader.service"

SRC_URI = " \
	git://github.com/erikboto/monark-ant.git;protocol=http;branch=daemonize \
	file://buttonreader.service \
	"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=17;md5=6d8c6f591a945f049d346ff1cb438f24"


S = "${WORKDIR}/git/"

SRCREV = "fcbf62affe0dd9ce84ccc3ebec862e8847a2d5a8"

EXTRA_QMAKEVARS_PRE += "-config raspberry-pi"

do_install() {
	install -Dm0755 ${S}/buttonreader/buttonreader.py ${D}/usr/bin/buttonreader.py
	install -Dm0644 ${WORKDIR}/buttonreader.service ${D}/${systemd_unitdir}/system/buttonreader.service
}

FILES_${PN} += " \
	/lib/systemd/ \
	"
