DESCRIPTION = "RISC-V Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "\
    git://github.com/riscv/riscv-linux.git;branch=${BRANCH} \
    file://sections.cfg \
    file://defconfig \
"

LINUX_VERSION ?= "4.15"
LINUX_VERSION_EXTENSION_append = "-riscv"

BRANCH = "riscv-linux-4.15"
SRCREV = "7501d87f7ebf8337ab2efa3fe692612a3b845c6f"

PV = "${LINUX_VERSION}+git${SRCPV}"

DEPENDS_append = " libgcc"

KERNEL_CC_append = " ${TOOLCHAIN_OPTIONS} ${SECURITY_NOPIE_CFLAGS}"
KERNEL_LD_append = " -no-pie"

COMPATIBLE_MACHINE = "(qemuriscv64|riscv64|sifive-unleashed)"

KERNEL_FEATURES_remove = "features/debug/printk.scc"
