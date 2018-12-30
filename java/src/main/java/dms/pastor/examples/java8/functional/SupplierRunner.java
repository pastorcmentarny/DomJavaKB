package dms.pastor.examples.java8.functional;


import dms.pastor.examples.java8.functional.supplier.NotRequiredDefaultImplementation;
import dms.pastor.examples.java8.functional.supplier.NotRequiredInterface;

final class SupplierRunner {

    public String supplierExample() {
        final NotRequiredInterface notRequiredInterface = NotRequiredInterface.create(NotRequiredDefaultImplementation::new);
        return notRequiredInterface.notRequired();
    }
}
