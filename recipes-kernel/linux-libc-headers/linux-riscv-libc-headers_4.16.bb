require recipes-kernel/linux-libc-headers/linux-libc-headers.inc
BRANCH = "for-linus"
SRCREV = "ab4af60534107c55b00fa462eca0385dcef92384"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/palmer/riscv-linux.git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_patch[depends] = "kern-tools-native:do_populate_sysroot"

DEPENDS += "bison-native flex-native"

PROVIDES = "linux-libc-headers"
