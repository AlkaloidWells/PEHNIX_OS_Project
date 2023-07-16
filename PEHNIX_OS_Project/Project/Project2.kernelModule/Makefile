ifneq ($(KERNELRELEASE),)
    # call from kernel build system
    lifo-objs := mainproc.o
    obj-m   := mainproc.o
else
   KERNELDIR ?= /lib/modules/$(shell uname -r)/build
   PWD       := $(shell pwd)
modules:
	echo $(MAKE) -C $(KERNELDIR) M=$(PWD) LDDINC=$(PWD)KDIR = /usr/src/linux-headers-5.4.0-96-generic/include modules
	$(MAKE) -C $(KERNELDIR) M=$(PWD) LDDINC=$(PWD)/../include modules
endif

clean:  
	rm -rf *.o *~ core .depend *.mod.o .*.cmd *.ko *.mod.c \
	.tmp_versions *.markers *.symvers modules.order

depend .depend dep:
	$(CC) $(CFLAGS) -M *.c > .depend

ifeq (.depend,$(wildcard .depend))
    include .depend
endif

