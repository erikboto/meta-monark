DESCRIPTION = "MonarkUI"
LICENSE = "GPLv2"
DEPENDS = "qtbase qtmqtt qtdeclarative qtvirtualkeyboard"
RDEPENDS_${PN} += "monarkant qtvirtualkeyboard-qmlplugins qtquickcontrols2-qmlplugins liberation-fonts"
inherit qmake5 systemd

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_SERVICE_${PN} = "monarkui.service"

SRC_URI += " \
    git://github.com/erikboto/monarkui.git;protocol=https \
    file://monarkui.service \
"

LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=17;md5=6be0950506543566fd019b2b86e571ac"
SRCREV = "825e7406b074eed9baaee5cd57b4c8f9d4294c40"
S = "${WORKDIR}/git/"

do_install_append() {
    install -Dm0644 ${WORKDIR}/monarkui.service ${D}/${systemd_unitdir}/system/monarkui.service
}

FILES_${PN} += " \
    /opt/ \
    /lib/ \
"
